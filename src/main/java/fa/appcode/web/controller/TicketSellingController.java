package fa.appcode.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.appcode.common.utils.Constants;
import fa.appcode.config.MessageConfig;
import fa.appcode.config.PageConfig;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.InvoiceService;
import fa.appcode.services.MemberService;
import fa.appcode.services.MovieService;
import fa.appcode.services.ScheduleSeatService;
import fa.appcode.services.SeatService;
import fa.appcode.services.ShowtimesService;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Member;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.ScheduleSeat;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.vo.ConfirmTicketVo;
import fa.appcode.web.vo.PageVo;

/**
 * The Class TicketSellingController.
 */
@Controller
@RequestMapping("/admin")
public class TicketSellingController {
		
	@Autowired
	private ShowtimesService showtimesService;
	
	@Autowired
	private CinemaRoomService cinemaRoomService;
	
	@Autowired
	private ScheduleSeatService scheduleSeatService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private MessageConfig messageConfig;
	
	@Autowired
	private PageConfig pageConfig;

	/**
	 * Showtimes controller.
	 *
	 * @param modelMap the model map
	 * @param dateSelecting the date selecting
	 * @param pageIndex the page index
	 * @return the string
	 */
	@GetMapping("/showtimes")
	public String showtimes(ModelMap modelMap, @RequestParam(required = false) String dateSelecting,
			@RequestParam(required = false) Integer pageIndex) {

		List<LocalDate> listDates = showtimesService.getShowDateList(LocalDate.now().toString());
		
		modelMap.addAttribute("listDates", listDates);
		
		PageVo<MovieDate> pages = showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime());
		
		if(dateSelecting == null || Constants.DEFAULT_WORD.equals(dateSelecting)) {
			dateSelecting = LocalDate.now().toString();
		}
		
		modelMap.addAttribute("dateSelecting", dateSelecting);
		
		if(pages != null) {
			modelMap.addAttribute("pageIndex", pages.getPageIndex());
			modelMap.addAttribute("movieDates", pages.getContent());
			modelMap.addAttribute("totalPages", pages.getTotalPage());
		}else {
			modelMap.addAttribute("movieDates", null);
		}
		
		return "ticket-selling/showtimes";
	}
	
	
	/**
	 * Show selecting seat controller.
	 *
	 * @param modelMap the model map
	 * @param movieId the movie id
	 * @param scheduleId the schedule id
	 * @return view name "ticket-selling/selecting-seat".
	 */
	@GetMapping("/selecting-seat")
	public String showSelectingSeat(ModelMap modelMap, 
			@RequestParam String movieId, @RequestParam String scheduleId) {
		
		List<ScheduleSeat> scheduleSeats = scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId);
		CinemaRoom cinemaRoom = cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats);		
		modelMap.addAttribute("cinemaRoom", cinemaRoom);	
		return "ticket-selling/selecting-seat";
	}
	
	/**
	 * Show confirm ticket controller.
	 *
	 * @param modelMap the model map
	 * @param listSelectedSeat the list selected seat
	 * @param movieId the movie id
	 * @return view name "ticket-selling/confirm-ticket".
	 */
	@GetMapping("/confirm-ticket")
	public String showConfirmTicket(ModelMap modelMap, @RequestParam String[] listSelectedSeat,
			@RequestParam String movieId) {
		Movie movie = movieService.getById(movieId);
		List<Seat> seats = seatService.findAllBySeatId(listSelectedSeat);
		
		modelMap.addAttribute("movie", movie);
		modelMap.addAttribute("seats", seats);
		
		return "ticket-selling/confirm-ticket";
	}
	
	/**
	 * Check member.
	 *
	 * @param memberInfor the member infor
	 * @return the response entity
	 */
	@GetMapping("/confirm-ticket/{memberInfor}")
	public ResponseEntity<Member> checkMember(@PathVariable String memberInfor){
		Member member = memberService.findByMemberIdOrIdendityCard(memberInfor);
		
		ResponseEntity<Member> responseEntity = null;
		if(member != null) {
			responseEntity = new ResponseEntity<Member>(member, HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<Member>(member, HttpStatus.BAD_REQUEST);
		}	
		return responseEntity;
	}
	
	/**
	 * Confirm booking.
	 *
	 * @param confirmTicketVo the confirm ticket vo
	 * @return the response entity
	 */
	@PostMapping("/confirm-ticket-booking")
	public ResponseEntity<String> confirmBooking(@RequestBody ConfirmTicketVo confirmTicketVo) {
		if(invoiceService.save(confirmTicketVo)) {
			return ResponseEntity.status(HttpStatus.OK).body(messageConfig.getSaveTicketSuccess());
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(messageConfig.getSaveTicketFailed());
	}
	
}
