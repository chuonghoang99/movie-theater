package fa.appcode.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import fa.appcode.common.logging.LogUtils;
import fa.appcode.common.utils.ConvertUtils;
import fa.appcode.common.utils.FileUploadUtils;
import fa.appcode.config.PageConfig;
import fa.appcode.exceptions.CinemaRoomException;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.ImagesStorageService;
import fa.appcode.services.SeatService;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.vo.SeatVo;

/**
 * @class Cinema Room Controller class
 */
@Controller
@RequestMapping("room")
public class CinemaRoomController {

	@Autowired
	private CinemaRoomService cinemaRoomService;

	@Autowired
	private SeatService seatService;

	@Autowired
	private PageConfig pageConfig;

	@Autowired
	ImagesStorageService imageService;

	/*
	 * @param: searchField: String, roomName: String, roomName: String, pageIndex:
	 * String
	 * 
	 * @description: This method will handle showing Cinema Room list
	 * 
	 * @return cinema-room/list-room view
	 */
	@GetMapping("/list-room")
	public String showListRoom(@RequestParam(name = "searchField", required = false) String roomName,
			@RequestParam(required = false) String pageIndex, Model model) throws Exception {

		int pageIndexVal = pageConfig.getInitPage();
		int pageSize = pageConfig.getSizePage();

		if (pageIndex != null) {
			pageIndexVal = Integer.parseInt(pageIndex);
		}

		Page<CinemaRoom> roomPage;
		List<CinemaRoom> listCinemaRoom = null;

		if (roomName == null || roomName.equals("")) {
			roomPage = cinemaRoomService.findAll(pageIndexVal, pageSize);
			listCinemaRoom = roomPage.toList();
		} else {
			roomPage = cinemaRoomService.findAllBySearchKey(roomName, pageIndexVal, pageSize);
			listCinemaRoom = roomPage.toList();
			model.addAttribute("roomName", roomName);
		}
		model.addAttribute("roomRecords", listCinemaRoom.size());
		model.addAttribute("cinemaRooms", listCinemaRoom);
		model.addAttribute("currentPage", pageIndexVal);
		model.addAttribute("numOfPages", roomPage.getTotalPages());
		return "cinema-room/list-room";
	}

	/*
	 * @param: roomId: String
	 * 
	 * @description: This method will handle room image url getting process
	 * 
	 * @return String
	 */
	@GetMapping("/room-image")
	@ResponseBody
	public String showImageInToolTip(@RequestParam(name = "roomId") String roomId, Model model) {
		String roomImgUrl = pageConfig.getRoomIdNotValid();
		CinemaRoom cinemaRoom = cinemaRoomService.findById(roomId);
		if (cinemaRoom != null) {
			roomImgUrl = cinemaRoom.getImage();
		}
		return roomImgUrl;
	}

	/*
	 * @param: none
	 * 
	 * @description: This method will handle Add new room view showing process
	 * 
	 * @return cinema-room/add-room view
	 */
	@GetMapping("/add-room")
	public String showAddRoom(Model model) {
		List<Integer> listSeatQuantity = pageConfig.getListSeatQuantity();
		model.addAttribute("listSeatQuantity", listSeatQuantity);
		return "cinema-room/add-room";
	}

	/*
	 * @param: roomName: String, seatQuantity: String, roomImage: MultipartFile
	 * 
	 * @description: This method will handle adding CinemaRoom, Seat process then
	 * return message in JSON type
	 * 
	 * @return Map<String, String>
	 */
	@PostMapping(value = "/room-saving", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> addRoomProcess(
			@RequestParam(name = "roomImage", required = false) MultipartFile roomImage,
			@RequestParam(name = "roomName") String roomName, @RequestParam(name = "seatQuantity") String seatQuantity)
			throws IOException, CinemaRoomException {
		LogUtils.getLogger().info("In room saving post method");
		Map<String, String> mapNotification = new HashMap<>();
		// If roomName is not blank, continue to check
		// Create a CinemaRoom object to save
		CinemaRoom savingRoom = new CinemaRoom();
		savingRoom.setCinemaRoomName(roomName);
		savingRoom.setSeatQuantity(ConvertUtils.convertStrToInt(seatQuantity));
		// If roomName is blank, return
		LogUtils.getLogger().info("max seat col " + pageConfig.getMaxSeatColumn());
		// Save the image if got in RequestParam, then use setImage() to set Image Url
		// to saving CinemaRoom
		if (!roomImage.isEmpty()) {
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(roomImage.getOriginalFilename()));
			String uploadDir = pageConfig.getRoomImageUploadPath();
			FileUploadUtils.saveFile(uploadDir, fileName, roomImage);
			savingRoom.setImage(pageConfig.getRoomImageLoadPath() + fileName);
		}
		if (roomName.isBlank()) {
			mapNotification.put("roomNameMessage", pageConfig.getRoomNameBlank());
		} else if (cinemaRoomService.checkExistedRoomName(savingRoom.getCinemaRoomName()) == false) {
			generateSeatForNewRoom(savingRoom, pageConfig);
			// If room name is not existed, CinemaRoom info will be saved
			cinemaRoomService.saveCinemaRoom(savingRoom);
			mapNotification.put("methodMessage", pageConfig.getAddRoomOk());
			return new ResponseEntity<>(mapNotification, HttpStatus.OK);
		} else {
			// If room name is existed, CinemaRoom info will not be saved
			mapNotification.put("roomNameMessage", pageConfig.getRoomNameExisted());
		}
		mapNotification.put("methodMessage", pageConfig.getAddRoomNotOk());
		return new ResponseEntity<>(mapNotification, HttpStatus.BAD_REQUEST);
	}

	/*
	 * @param: roomId
	 * 
	 * @description: This method will handle room seat view showing process
	 * 
	 * @return view: seat-detail
	 */

	@GetMapping("/seat-detail")
	public String roomSeatDetail(@RequestParam(name = "roomId") String roomId, Model model) {
		LogUtils.getLogger().info("In room seat getting method");
		LogUtils.getLogger().info("roomId got: " + roomId);
		List<Seat> listRoomSeat = null;
		CinemaRoom cinemaRoom = cinemaRoomService.findById(roomId);
		if (cinemaRoom == null) {
			model.addAttribute("msg", pageConfig.getRoomIdNotValid());
			model.addAttribute("seatFoundCount", pageConfig.getZeroSeatFound());
		} else {
			listRoomSeat = seatService.findAllByCinemaRoomCinemaRoomId(cinemaRoom.getCinemaRoomId());
			LogUtils.getLogger().info("Number of seat found: " + listRoomSeat.size());
			model.addAttribute("roomName", cinemaRoom.getCinemaRoomName());
			model.addAttribute("listRoomSeat", listRoomSeat);
		}
		return "cinema-room/seat-detail";
	}

	/*
	 * @RequestBody: listSeatSaving: list of SeatVo
	 * 
	 * @description: This method will handle room seat view showing process
	 * 
	 * @return view: seat-detail
	 */
	@PostMapping("/save-room-detail")
	@ResponseBody
	public ResponseEntity<String> saveSeatDetail(@RequestBody ArrayList<SeatVo> listSeatSaving) {
		LogUtils.getLogger().info("In room seat updating method");
		LogUtils.getLogger().info("Seat count got: " + listSeatSaving.size());
		Set<Boolean> listResult = new HashSet<Boolean>();
		listSeatSaving.forEach(seat -> listResult.add(seatService.updateSeat(seat)));
		if (!listResult.contains(false)) {
			return new ResponseEntity<String>(pageConfig.getUpdateListSeatOk(), HttpStatus.OK);
		}
		return new ResponseEntity<String>(pageConfig.getUpdateListSeatNotOk(), HttpStatus.BAD_REQUEST);

	}

	public static CinemaRoom generateSeatForNewRoom(CinemaRoom savingRoom, PageConfig pageConfig) {
		double normalSeatPrice = Double.parseDouble(pageConfig.getNormalSeatPrice());
		// Create seat and set to saving CinemaRoom
		List<Seat> listRoomSeat = new ArrayList<Seat>();
		Seat seatOfRoom = null;
		int colCount = pageConfig.getMaxSeatColumn();
		for (int i = 1; i <= savingRoom.getSeatQuantity(); i++) {
			int seatRow = (int) (i / 6.01 + 1);
			colCount--;
			if (colCount == 0) {
				colCount = pageConfig.getMaxSeatColumn();
			}
			// Leave the seat id null
			// Seat price has been read from webconfig.properties
			seatOfRoom = new Seat(null, pageConfig.getListSeatColumn().get(pageConfig.getMaxSeatColumn() - colCount),
					seatRow, 0, 0, normalSeatPrice, savingRoom);
			listRoomSeat.add(seatOfRoom);
		}
		savingRoom.setSeats(listRoomSeat);
		return savingRoom;
	}
}
