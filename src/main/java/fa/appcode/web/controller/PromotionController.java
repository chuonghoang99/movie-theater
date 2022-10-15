package fa.appcode.web.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.common.utils.Constants;
import fa.appcode.config.MessageConfig;
import fa.appcode.config.PageConfig;
import fa.appcode.services.PromotionService;
import fa.appcode.services.StorageService;
import fa.appcode.web.entities.Promotion;
import fa.appcode.web.vo.PromotionVo;

/**
 * @author
 */
@RestController
@RequestMapping("/admin/promotion/")
public class PromotionController {

	@Autowired
	private PageConfig pageConfig;

	@Autowired
	private MessageConfig messageConfig;

	@Autowired
	private PromotionService promotionService;

	@Autowired
	private StorageService storageService;

	/**
	 * Controller when user first click promotion management
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("list")
	public ModelAndView listPromotion(Model model) {

		final int pageIndexVal = pageConfig.getInitPage();
		final int pageSize = pageConfig.getSizePage();
		final String searchData = Constants.DEFAULT_WORD;

		Page<Promotion> page = promotionService.searchAll(Constants.DEFAULT_WORD, pageIndexVal, pageSize);

		LogUtils.getLogger().info(page);

		/*
		 * Set attribute
		 */
		model.addAttribute("listOfPromotions", page.toList());
		model.addAttribute("numOfPages", page.getTotalPages());
		model.addAttribute("currentPage", pageIndexVal);
		model.addAttribute("searchData", searchData);

		return new ModelAndView("promotion/list-promotion");
	}

	/**
	 * Controller when user search, paging, change page size in screen promotion
	 * list
	 *
	 * @param model
	 * @param searchData
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping("search")
	public ModelAndView searchPromotion(Model model,
			@RequestParam(defaultValue = Constants.DEFAULT_WORD, name = "searchDataPromotion") String searchData,
			@RequestParam(name = "pageIndexPromotion", required = false) String pageIndex,
			@RequestParam(name = "pageSizePromotion", defaultValue = Constants.PAGE_SIZE_STRING) Integer pageSize) {
		LogUtils.getLogger().info(searchData);

		int pageIndexVal = pageConfig.getInitPage();

		if (pageIndex != null) {
			pageIndexVal = Integer.parseInt(pageIndex);
		}

		Page<Promotion> page = promotionService.searchAll(searchData, pageIndexVal, pageSize);

		model.addAttribute("listOfPromotions", page.toList());
		model.addAttribute("numOfPages", page.getTotalPages());
		model.addAttribute("currentPage", pageIndexVal);

		return new ModelAndView("promotion/list-table-promotion");
	}

	/**
	 * Controller show form promotion detail
	 *
	 * @param model
	 * @param promotionId
	 * @return
	 */
	@GetMapping("showPromotionForm")
	public ModelAndView showPromotionForm(Model model,
			@RequestParam(name = "promotionId", required = false) Integer promotionId) {

		/*
		 * If request has promotion id
		 */
		if (promotionId != null) {
			Promotion promotion = promotionService.getById(promotionId);
			model.addAttribute("promotion", promotion);
		}

		return new ModelAndView("promotion/detail-promotion");
	}

	/**
	 * Controller save/edit a promotion
	 * 
	 * @param promotionVo
	 * @param result
	 * @return
	 */
	@PostMapping("save")
	@ResponseBody
	public ResponseEntity<Map<String, String>> savePromotion(@Valid PromotionVo promotionVo, BindingResult result) {

		LogUtils.getLogger().info(promotionVo);

		boolean check = true;
		Map<String, String> message = new HashMap<>();

		/*
		 * Validate a promotion
		 */
		if (result.hasErrors()) {
			check = false;
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				message.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}

		/*
		 * Check start time and end time
		 */
		if (promotionVo.getStartTime() != null && promotionVo.getEndTime() != null
				&& promotionVo.getEndTime().compareTo(promotionVo.getStartTime()) < 0) {
			check = false;
			message.put("startTime", messageConfig.getStartTimeInvalid());
			message.put("endTime", messageConfig.getEndTimeInvalid());
		}

		/*
		 * Check title exist
		 */
		if (promotionService.checkTitleExist(promotionVo.getPromotionId(), promotionVo.getTitle())) {
			check = false;
			message.put("title", messageConfig.getTitlePromotionExisted());
		}
		/*
		 * Handle return
		 */
		if (!check) {
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {

			/*
			 * Get promotion from promotionVo
			 */
			Promotion promotion = null;
			try {
				promotion = promotionVo.getPromotionFromVo();
			} catch (ParseException e) {
				message.put("messageFailed", messageConfig.getSavePromotionFailed());
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}

			/*
			 * Save file image if it exists
			 */
			MultipartFile file = promotionVo.getFile();

			if (file != null && !file.isEmpty()) {
				try {
					LogUtils.getLogger().info("file existe");
					String fileName = storageService.storeFile(file, Constants.SRC_PROMOTION_IMAGE);
					LogUtils.getLogger().info("file name: " + fileName);
					promotion.setImage(Constants.SRC_PROMOTION_IMAGE_2 + fileName);
					LogUtils.getLogger().info(promotion);
				} catch (Exception e) {
					message.put("messageFailed", e.getMessage());
					return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
				}

			}

			/*
			 * Save a promotion into database
			 */
			LogUtils.getLogger().info(promotion);
			if (promotionService.saveOrUpdate(promotion)) {
				message.put("messageSuccess", messageConfig.getSavePromotionSuccess());
				return new ResponseEntity<>(message, HttpStatus.OK);
			} else {
				message.put("messageFailed", messageConfig.getSavePromotionFailed());
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
		}

	}

	/**
	 * Controller delete a promotion
	 *
	 * @param promotionId
	 * @return
	 */
	@DeleteMapping("delete/{promotionId}")
	public ResponseEntity<String> delete(@PathVariable(name = "promotionId") String promotionId) {
		try {
			final Integer idValue = Integer.parseInt(promotionId);

			if (promotionService.deletePromotionById(idValue)) {
				return new ResponseEntity<>(messageConfig.getDeletePromotionSuccess(), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(messageConfig.getDeletePromotionFailed(), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(messageConfig.getDeletePromotionFailed(), HttpStatus.BAD_REQUEST);
		}
	}

}
