package fa.appcode.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fa.appcode.common.utils.Constants;
import fa.appcode.config.PageConfig;
import fa.appcode.services.PromotionService;
import fa.appcode.services.StorageService;
import fa.appcode.web.entities.Promotion;

/**
 * @author TruongNguyen
 */
@SpringBootTest
@AutoConfigureMockMvc
class PromotionControllerTest {

	@MockBean
	private PromotionService promotionService;

	@MockBean
	private StorageService storageService;

	@Mock
	private PageConfig pageConfig;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test list promotion controller
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testListPromotion() throws Exception {

		final Integer pageIndexVal = 1;
		final Integer pageSize = 5;
		String searchData = "";

		List<Promotion> list = new ArrayList<>();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Mockito.when(pageConfig.getInitPage()).thenReturn(pageIndexVal);
		Mockito.when(pageConfig.getSizePage()).thenReturn(pageSize);

		Mockito.when(promotionService.searchAll(searchData, pageIndexVal, pageSize)).thenReturn(page);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/list"))
				.andExpect(MockMvcResultMatchers.view().name("promotion/list-promotion"))
				.andExpect(MockMvcResultMatchers.model().attribute("listOfPromotions", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndexVal))
				.andExpect(MockMvcResultMatchers.model().attribute("searchData", searchData));
	}

	/**
	 * Test search promotion search promotion with text
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchPromotion1() throws Exception {
		final Integer pageIndexVal = 1;
		final Integer pageSize = 5;
		String searchData = "p";

		List<Promotion> list = new ArrayList<>();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Mockito.when(pageConfig.getInitPage()).thenReturn(pageIndexVal);

		Mockito.when(promotionService.searchAll(searchData, pageIndexVal, pageSize)).thenReturn(page);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/search").param("searchDataPromotion", searchData)
				.param("pageSizePromotion", pageSize.toString()))
				.andExpect(MockMvcResultMatchers.view().name("promotion/list-table-promotion"))
				.andExpect(MockMvcResultMatchers.model().attribute("listOfPromotions", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndexVal));
	}

	/**
	 * Test search promotion search promotion when change page size
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchPromotion2() throws Exception {
		final Integer pageIndexVal = 1;
		final Integer pageSize = 7;
		String searchData = "p";

		List<Promotion> list = new ArrayList<>();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Mockito.when(pageConfig.getInitPage()).thenReturn(pageIndexVal);

		Mockito.when(promotionService.searchAll(searchData, pageIndexVal, pageSize)).thenReturn(page);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/search").param("searchDataPromotion", searchData)
				.param("pageSizePromotion", pageSize.toString()))
				.andExpect(MockMvcResultMatchers.view().name("promotion/list-table-promotion"))
				.andExpect(MockMvcResultMatchers.model().attribute("listOfPromotions", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndexVal));
	}

	/**
	 * Test search promotion search promotion when change page index
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchPromotion3() throws Exception {
		final Integer pageIndexVal = 3;
		final Integer pageSize = 5;
		String searchData = "p";

		List<Promotion> list = new ArrayList<>();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));

		Page<Promotion> page = new PageImpl<>(list);

		Mockito.when(pageConfig.getInitPage()).thenReturn(pageIndexVal);

		Mockito.when(promotionService.searchAll(searchData, pageIndexVal, pageSize)).thenReturn(page);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/search").param("searchDataPromotion", searchData)
				.param("pageIndexPromotion", pageIndexVal.toString()).param("pageSizePromotion", pageSize.toString()))
				.andExpect(MockMvcResultMatchers.view().name("promotion/list-table-promotion"))
				.andExpect(MockMvcResultMatchers.model().attribute("listOfPromotions", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndexVal));
	}

	/**
	 * Test show form promotion when click add button
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testShowPromotionForm1() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/showPromotionForm"))
				.andExpect(MockMvcResultMatchers.view().name("promotion/detail-promotion"));
	}

	/**
	 * Test show form promotion when click edit icon
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testShowPromotionForm2() throws Exception {

		Promotion promotion = new Promotion(1, "promotion 1");

		Mockito.when(promotionService.getById(1)).thenReturn(promotion);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/promotion/showPromotionForm").param("promotionId", "1"))
				.andExpect(MockMvcResultMatchers.view().name("promotion/detail-promotion"))
				.andExpect(MockMvcResultMatchers.model().attribute("promotion", promotion));
	}

	/**
	 * Test save promotion in valid
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave1() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.post("/admin/promotion/save").param("title", "").param("startTime", "2021-12-31")
						.param("endTime", "2021-12-31").param("discountLevel", "8888").param("detail", "test"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.title").value("Title is required"));
	}

	/**
	 * Test save promotion has start time after end time
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave2() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/promotion/save").param("title", "title test")
				.param("startTime", "2021-12-31").param("endTime", "2021-12-01").param("discountLevel", "8888")
				.param("detail", "test")).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.startTime").value("Start time must before end time"))
				.andExpect(jsonPath("$.endTime").value("End time must after start time"));
	}

	/**
	 * Test save promotion with title exist
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave3() throws Exception {

		Integer promotionId = 1;
		String title = "title";

		Mockito.when(promotionService.checkTitleExist(promotionId, title)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/promotion/save")
				.param("promotionId", promotionId.toString()).param("title", title).param("startTime", "2021-12-31")
				.param("endTime", "2021-12-01").param("discountLevel", "8888").param("detail", "test"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.title").value("Title existed"));
	}

	/**
	 * Test add a promotion success
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave4() throws Exception {

		MockMultipartFile file = new MockMultipartFile("data", "filename.jpg", "text/plain", "some xml".getBytes());

		Integer promotionId = 0;
		String title = "title";
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2021 14:00");
		Integer discountLevel = 10000;
		String detail = "promotion test";

		Promotion promotion = new Promotion(promotionId, detail, discountLevel, date, null, date, title);

		Mockito.when(promotionService.checkTitleExist(promotionId, title)).thenReturn(false);

		promotion.setImage(Constants.SRC_PROMOTION_IMAGE_2 + file.getOriginalFilename());
		Mockito.when(promotionService.saveOrUpdate(promotion)).thenReturn(true);
		Mockito.when(storageService.storeFile(file, Constants.SRC_PROMOTION_IMAGE)).thenReturn("filename");

		mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/promotion/save").file("file", file.getBytes())
				.param("promotionId", promotionId.toString()).param("title", title)
				.param("startTime", "2021-12-01T14:00").param("endTime", "2021-12-01T14:00")
				.param("discountLevel", String.valueOf(discountLevel)).param("detail", detail))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.messageSuccess").value("Successfully save"));
	}

	/**
	 * Test update a promotion success
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave5() throws Exception {

		MockMultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());

		Integer promotionId = 1;
		String title = "title";
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2021 14:00");
		String image = "/resources/img/promotion/Untitled2.png";
		Integer discountLevel = 10000;
		String detail = "promotion test update";

		Promotion promotion = new Promotion(promotionId, detail, discountLevel, date, image, date, title);

		Mockito.when(promotionService.checkTitleExist(promotionId, title)).thenReturn(false);

		promotion.setImage(Constants.SRC_PROMOTION_IMAGE_2 + file.getOriginalFilename());
		Mockito.when(promotionService.saveOrUpdate(promotion)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/promotion/save").file(file)
				.param("promotionId", promotionId.toString()).param("title", title)
				.param("startTime", "2021-12-01T14:00").param("endTime", "2021-12-01T14:00")
				.param("discountLevel", String.valueOf(discountLevel)).param("detail", detail)
				.param("image", "/resources/img/promotion/Untitled2.png"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.messageSuccess").value("Successfully save"));
	}

	/**
	 * Test save a promotion failed
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSave6() throws Exception {

		MockMultipartFile file = new MockMultipartFile("test", "filename.png", "image", "some xml".getBytes());

		Integer promotionId = 1;
		String title = "title";
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("01/12/2021 14:00");
		Integer discountLevel = 10000;
		String detail = "promotion test update";

		Promotion promotion = new Promotion(promotionId, detail, discountLevel, date, null, date, title);

		Mockito.when(promotionService.checkTitleExist(promotionId, title)).thenReturn(false);

		promotion.setImage(Constants.SRC_PROMOTION_IMAGE_2 + file.getOriginalFilename());
		Mockito.when(promotionService.saveOrUpdate(promotion)).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/promotion/save").file(file)
				.param("promotionId", promotionId.toString()).param("title", title)
				.param("startTime", "2021-12-01T14:00").param("endTime", "2021-12-01T14:00")
				.param("discountLevel", String.valueOf(discountLevel)).param("detail", detail))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.messageFailed").value("Unsuccessfully save"));
	}

	/**
	 * Test method delete with promotion id is not a number
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testDelete1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/admin/promotion/delete/abc"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andExpect(content().string("Delete failed"));
	}

	/**
	 * Test method delete a promotion failed
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testDelete2() throws Exception {

		Integer promotionId = 1;

		Mockito.when(promotionService.deletePromotionById(promotionId)).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.delete("/admin/promotion/delete/" + promotionId))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andExpect(content().string("Delete failed"));
	}

	/**
	 * Test method delete a promotion success
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testDelete3() throws Exception {

		Integer promotionId = 1;

		Mockito.when(promotionService.deletePromotionById(promotionId)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.delete("/admin/promotion/delete/" + promotionId))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().string("Delete success"));
	}
}
