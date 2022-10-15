package fa.appcode.web.controller;




import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fa.appcode.config.MessageConfig;
import fa.appcode.config.PageConfig;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.InvoiceService;
import fa.appcode.services.MemberService;
import fa.appcode.services.MovieService;
import fa.appcode.services.ScheduleSeatService;
import fa.appcode.services.SeatService;
import fa.appcode.services.ShowtimesService;
import fa.appcode.web.entities.Account;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Member;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.MovieSchedule;
import fa.appcode.web.entities.Schedule;
import fa.appcode.web.entities.ScheduleSeat;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.entities.ShowDates;
import fa.appcode.web.vo.ConfirmTicketVo;
import fa.appcode.web.vo.PageVo;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username="admin",roles={"ADMIN"})
class TicketSellingControllerTest {

	@MockBean
	private ShowtimesService showtimesService;

	@MockBean
	private CinemaRoomService cinemaRoomService;

	@MockBean
	private ScheduleSeatService scheduleSeatService;

	@MockBean
	private MemberService memberService;

	@MockBean
	private InvoiceService invoiceService;

	@MockBean
	private MovieService movieService;

	@MockBean
	private SeatService seatService;

	@Autowired
	private MessageConfig messageConfig;

	@Autowired
	private PageConfig pageConfig;

	@Autowired
	private MockMvc mockMvc;

	private static List<ShowDates> listShowDate = null;

	private static MovieDate movieDate1 = null;

	private static MovieDate movieDate2 = null;

	private static MovieDate movieDate3 = null;

	private static List<LocalDate> listDates = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		LocalDate startDate = LocalDate.now();
		listDates = startDate.datesUntil(startDate.plusDays(6)).collect(Collectors.toList());

		CinemaRoom cinemaRoom = new CinemaRoom();
		ShowDates showDates = new ShowDates(1,
				Date.from(LocalDate.of(2021, 12, 06).atStartOfDay(ZoneId.systemDefault()).toInstant()), "2021/12/06");

		Movie movie1 = new Movie("1", "actor 1", "movie 1", cinemaRoom);
		Movie movie2 = new Movie("2", "actor 2", "movie 2", cinemaRoom);
		Movie movie3 = new Movie("3", "actor 3", "movie 3", cinemaRoom);

		movieDate1 = new MovieDate(movie1, showDates);
		movieDate2 = new MovieDate(movie2, showDates);
		movieDate3 = new MovieDate(movie3, showDates);

		Schedule schedule1 = new Schedule(1, "08:00");
		Schedule schedule2 = new Schedule(2, "09:00");

		MovieSchedule movieSchedule1 = new MovieSchedule(movie1, schedule1);
		MovieSchedule movieSchedule2 = new MovieSchedule(movie1, schedule2);
		MovieSchedule movieSchedule3 = new MovieSchedule(movie2, schedule1);
		MovieSchedule movieSchedule4 = new MovieSchedule(movie3, schedule1);

		List<MovieSchedule> movieSchedules1 = new ArrayList<MovieSchedule>();
		movieSchedules1.add(movieSchedule1);
		movieSchedules1.add(movieSchedule2);
		movie1.setMovieSchedules(movieSchedules1);

		List<MovieSchedule> movieSchedules2 = new ArrayList<MovieSchedule>();
		movieSchedules2.add(movieSchedule3);
		movie2.setMovieSchedules(movieSchedules2);

		List<MovieSchedule> movieSchedules3 = new ArrayList<MovieSchedule>();
		movieSchedules2.add(movieSchedule4);
		movie2.setMovieSchedules(movieSchedules3);

		Set<MovieDate> movieDates = new HashSet<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		movieDates.add(movieDate3);

		showDates.setMovieDates(movieDates);

		listShowDate = new ArrayList<ShowDates>();
		listShowDate.add(showDates);
		listShowDate.add(showDates);
		listShowDate.add(showDates);
		listShowDate.add(showDates);
	}

	/**
	 * TC1: Normal case (pageIndex = null, dateSelecting = null, maxPage = 20)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC1() throws Exception {
		Integer pageIndex = null;
		String dateSelecting = null;
		Integer maxPage = 20;


		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDates);

		List<MovieDate> movieDates = new ArrayList<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		PageVo<MovieDate> pageVo = new PageVo<MovieDate>(1, maxPage, movieDates);

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes"))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDates))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("pageIndex", pageVo.getPageIndex()))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", pageVo.getContent()))
				.andExpect(MockMvcResultMatchers.model().attribute("totalPages", pageVo.getTotalPage()))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}

	/**
	 * TC2: Abnormal case (pageIndex = null, dateSelecting = "", maxPage = 20)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC2() throws Exception {
		Integer pageIndex = null;
		String dateSelecting = "";
		Integer maxPage = 20;


		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDates);

		List<MovieDate> movieDates = new ArrayList<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		PageVo<MovieDate> pageVo = new PageVo<MovieDate>(1, maxPage, movieDates);

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes").param("dateSelecting", dateSelecting))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDates))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("pageIndex", pageVo.getPageIndex()))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", pageVo.getContent()))
				.andExpect(MockMvcResultMatchers.model().attribute("totalPages", pageVo.getTotalPage()))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}

	/**
	 * TC3: Abnormal case (pageIndex = null, dateSelecting = "LocalDate.now +"" ", maxPage = 20)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC3() throws Exception {
		Integer pageIndex = null;
		String dateSelecting = LocalDate.now() +"";
		Integer maxPage = 20;


		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDates);

		List<MovieDate> movieDates = new ArrayList<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		PageVo<MovieDate> pageVo = new PageVo<MovieDate>(1, maxPage, movieDates);

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes").param("dateSelecting", dateSelecting))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDates))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("pageIndex", pageVo.getPageIndex()))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", pageVo.getContent()))
				.andExpect(MockMvcResultMatchers.model().attribute("totalPages", pageVo.getTotalPage()))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}

	/**
	 * TC4: Abnormal case (pageIndex = 1, dateSelecting = Current date, maxPage = 20)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC4() throws Exception {
		Integer pageIndex = 1;
		String dateSelecting = LocalDate.now().toString();
		Integer maxPage = 20;


		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDates);

		List<MovieDate> movieDates = new ArrayList<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		PageVo<MovieDate> pageVo = new PageVo<MovieDate>(1, maxPage, movieDates);

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes").param("dateSelecting", dateSelecting)
						.param("pageIndex", String.valueOf(pageIndex)))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDates))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("pageIndex", pageVo.getPageIndex()))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", pageVo.getContent()))
				.andExpect(MockMvcResultMatchers.model().attribute("totalPages", pageVo.getTotalPage()))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}

	/**
	 * TC5: Abnormal case (pageIndex = 2, dateSelecting = Current date, maxPage = 20)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC5() throws Exception {
		Integer pageIndex = 2;
		String dateSelecting = LocalDate.now().toString();
		Integer maxPage = 20;


		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDates);

		List<MovieDate> movieDates = new ArrayList<MovieDate>();
		movieDates.add(movieDate1);
		movieDates.add(movieDate2);
		PageVo<MovieDate> pageVo = new PageVo<MovieDate>(2, maxPage, movieDates);

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes")
						.param("dateSelecting", dateSelecting)
						.param("pageIndex", String.valueOf(pageIndex)))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDates))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("pageIndex", pageVo.getPageIndex()))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", pageVo.getContent()))
				.andExpect(MockMvcResultMatchers.model().attribute("totalPages", pageVo.getTotalPage()))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}

	/**
	 * TC6: Normal case (pageIndex = null, dateSelecting = null)
	 * listDates = null)
	 * @throws Exception
	 */
	@Test
	void testShowtimesTC6() throws Exception {
		Integer pageIndex = 2;
		String dateSelecting = LocalDate.now().toString();

		List<LocalDate> listDatess = null;
		Mockito.when(showtimesService.getShowDateList(LocalDate.now().toString())).thenReturn(listDatess);

		List<MovieDate> movieDates = null;
		PageVo<MovieDate> pageVo = null;

		Mockito.when(showtimesService.findMovieTimeByDate(dateSelecting, pageIndex, pageConfig.getMaxPageShowTime())).thenReturn(pageVo);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/showtimes"))
				.andExpect(MockMvcResultMatchers.model().attribute("listDates", listDatess))
				.andExpect(MockMvcResultMatchers.model().attribute("dateSelecting", LocalDate.now()+""))
				.andExpect(MockMvcResultMatchers.model().attribute("movieDates", movieDates))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/showtimes"));
	}


	/**
	 * TC1: Case Normal (MovieId: "1", ScheduleId: 1)
	 * @throws Exception
	 */
	@Test
	void testShowSelectingSeatTC1() throws Exception {
		String movieId = "1";
		String scheduleId = "1";
		List<Seat> seats = new ArrayList<Seat>();
		for (int i = 0; i < 60; i++) {
			seats.add(new Seat(i, 0));
		}
		CinemaRoom cinemaRoom = new CinemaRoom(1, "Room 1", 60, seats);
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		scheduleSeats.add(new ScheduleSeat(movieId, Integer.parseInt(scheduleId), 1, 1, 0));
		scheduleSeats.add(new ScheduleSeat(movieId, Integer.parseInt(scheduleId), 2, 1, 0));
		scheduleSeats.add(new ScheduleSeat(movieId, Integer.parseInt(scheduleId), 3, 1, 0));
		scheduleSeats.add(new ScheduleSeat(movieId, Integer.parseInt(scheduleId), 4, 1, 0));
		scheduleSeats.add(new ScheduleSeat(movieId, Integer.parseInt(scheduleId), 5, 1, 0));

		CinemaRoom cinemaRoomExpected = cinemaRoom;
		cinemaRoomExpected.getSeats().get(1).setStatus(1);
		cinemaRoomExpected.getSeats().get(2).setStatus(1);
		cinemaRoomExpected.getSeats().get(3).setStatus(1);
		cinemaRoomExpected.getSeats().get(4).setStatus(1);
		cinemaRoomExpected.getSeats().get(5).setStatus(1);

		Mockito.when(scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		Mockito.when(cinemaRoomService.findByMovieId(movieId)).thenReturn(cinemaRoom);
		Mockito.when(cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats)).thenReturn(cinemaRoomExpected);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/selecting-seat").param("movieId", movieId)
						.param("scheduleId", scheduleId))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRoom", cinemaRoomExpected))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/selecting-seat"));
	}


	/**
	 * TC2: Case Abnormal (MovieId: "", ScheduleId: 1)
	 * @throws Exception
	 */
	@Test
	void testShowSelectingSeatTC2() throws Exception {
		String movieId = "";
		String scheduleId = "1";
		CinemaRoom cinemaRoom = null;
		List<ScheduleSeat> scheduleSeats = null;

		Mockito.when(scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		Mockito.when(cinemaRoomService.findByMovieId(movieId)).thenReturn(cinemaRoom);
		Mockito.when(cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats)).thenReturn(cinemaRoom);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/selecting-seat").param("movieId", movieId)
						.param("scheduleId", scheduleId))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRoom", cinemaRoom))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/selecting-seat"));
	}

	/**
	 * TC3: Case Normal (MovieId: "1", ScheduleId: "")
	 * @throws Exception
	 */
	@Test
	void testShowSelectingSeatTC3() throws Exception {
		String movieId = "1";
		String scheduleId = "";
		CinemaRoom cinemaRoom = new CinemaRoom(1, "Room 1", 60, null);
		List<ScheduleSeat> scheduleSeats = null;

		Mockito.when(scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		Mockito.when(cinemaRoomService.findByMovieId(movieId)).thenReturn(cinemaRoom);
		Mockito.when(cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats)).thenReturn(cinemaRoom);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/selecting-seat").param("movieId", movieId)
						.param("scheduleId", scheduleId))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRoom", cinemaRoom))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/selecting-seat"));
	}


	/**
	 * TC4: Case Abnormal (MovieId: "", ScheduleId: "")
	 * @throws Exception
	 */
	@Test
	void testShowSelectingSeatTC4() throws Exception {
		String movieId = "";
		String scheduleId = "";
		CinemaRoom cinemaRoom = null;
		List<ScheduleSeat> scheduleSeats = null;

		Mockito.when(scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		Mockito.when(cinemaRoomService.findByMovieId(movieId)).thenReturn(cinemaRoom);
		Mockito.when(cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats)).thenReturn(cinemaRoom);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/selecting-seat").param("movieId", movieId)
						.param("scheduleId", scheduleId))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRoom", cinemaRoom))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/selecting-seat"));
	}

	/**
	 * TC5: Case Abnormal (MovieId: null, ScheduleId: null)
	 * @throws Exception
	 */
	@Test
	void testShowSelectingSeatTC5() throws Exception {
		String movieId = null;
		String scheduleId = null;
		CinemaRoom cinemaRoom = null;
		List<ScheduleSeat> scheduleSeats = null;

		Mockito.when(scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		Mockito.when(cinemaRoomService.findByMovieId(movieId)).thenReturn(cinemaRoom);
		Mockito.when(cinemaRoomService.seatSoldsHanlder(cinemaRoomService.findByMovieId(movieId), scheduleSeats)).thenReturn(cinemaRoom);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/selecting-seat").param("movieId", String.valueOf(movieId))
						.param("scheduleId", String.valueOf(scheduleId)))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRoom", cinemaRoom))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/selecting-seat"));
	}

	/**
	 * TC1: Case Normal (movieId = "m1", listSelectedSeat = "1", "2", "3")
	 * @throws Exception
	 */
	@Test
	void testShowConfirmTicketTC1() throws Exception {
		String movieId = "m1";
		String[] listSelectedSeat = {"1", "2", "3"};

		Movie movie = new Movie("m1", "actor1", "movie vn", null);
		List<Seat> seats = new ArrayList<Seat>();
		seats.add(new Seat(1, 0));
		seats.add(new Seat(2, 0));
		seats.add(new Seat(3, 1));

		Mockito.when(movieService.getById(movieId)).thenReturn(movie);
		Mockito.when(seatService.findAllBySeatId(listSelectedSeat)).thenReturn(seats);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket")
						.param("listSelectedSeat", listSelectedSeat)
						.param("movieId", movieId))
				.andExpect(MockMvcResultMatchers.model().attribute("movie", movie))
				.andExpect(MockMvcResultMatchers.model().attribute("seats", seats))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/confirm-ticket"));
	}

	/**
	 * TC2: Case Normal (movieId = "", listSelectedSeat = "")
	 * @throws Exception
	 */
	@Test
	void testShowConfirmTicketTC2() throws Exception {
		String movieId = "";
		String[] listSelectedSeat = {""};

		Movie movie = null;
		List<Seat> seats = new ArrayList<Seat>();

		Mockito.when(movieService.getById(movieId)).thenReturn(movie);
		Mockito.when(seatService.findAllBySeatId(listSelectedSeat)).thenReturn(seats);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket")
						.param("listSelectedSeat", listSelectedSeat)
						.param("movieId", movieId))
				.andExpect(MockMvcResultMatchers.model().attribute("movie", movie))
				.andExpect(MockMvcResultMatchers.model().attribute("seats", seats))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/confirm-ticket"));
	}

	/**
	 * TC3: Case Normal (movieId = "m1", listSelectedSeat = "")
	 * @throws Exception
	 */
	@Test
	void testShowConfirmTicketTC3() throws Exception {
		String movieId = "m1";
		String[] listSelectedSeat = {""};

		Movie movie = new Movie("m1", "actor1", "movie vn", null);
		List<Seat> seats = new ArrayList<Seat>();

		Mockito.when(movieService.getById(movieId)).thenReturn(movie);
		Mockito.when(seatService.findAllBySeatId(listSelectedSeat)).thenReturn(seats);

		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket")
						.param("listSelectedSeat", listSelectedSeat)
						.param("movieId", movieId))
				.andExpect(MockMvcResultMatchers.model().attribute("movie", movie))
				.andExpect(MockMvcResultMatchers.model().attribute("seats", seats))
				.andExpect(MockMvcResultMatchers.view().name("ticket-selling/confirm-ticket"));
	}

	/**
	 * TC1: Case Normal (memberInfor = "123")
	 *
	 */
	@Test
	void testCheckMemberTC1() throws Exception {

		String memberInformation = "123";

		Account account = new Account("ac123", "account1", "123");
		Member member = new Member("m123", 15000.0, account);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonExpect = objectWriter.writeValueAsString(member);

		Mockito.when(memberService.findByMemberIdOrIdendityCard(memberInformation)).thenReturn(member);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket/"+ memberInformation))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andExpect(MockMvcResultMatchers.content().json(jsonExpect));
	}

	/**
	 * TC2: Case Abnormal (memberInfor = "")
	 *
	 */
	@Test
	void testCheckMemberTC2() throws Exception {

		String memberInfor = "";

		Member member = null;

		Mockito.when(memberService.findByMemberIdOrIdendityCard(memberInfor)).thenReturn(member);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket/"+ memberInfor))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
	}

	/**
	 * TC3: Case Abnormal (memberInfor = null)
	 *
	 */
	@Test
	void testCheckMemberTC3() throws Exception {

		String memberInfor = null;

		Member member = null;

		Mockito.when(memberService.findByMemberIdOrIdendityCard(memberInfor)).thenReturn(member);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/confirm-ticket/"+ memberInfor))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
	}

	/**
	 * TC1: Case Normal: Save success
	 *
	 */
	@Test
	void testConfirmBookingTC1() throws Exception {
		ConfirmTicketVo confirmTicketVo = new ConfirmTicketVo();
		String[] idSeatSelectings = {"1", "2", "3"};
		confirmTicketVo.setDateSelecting("2021-12-20");
		confirmTicketVo.setIdSeatSelecting(idSeatSelectings);
		confirmTicketVo.setMemberId("m123");
		confirmTicketVo.setMovieId("1");
		confirmTicketVo.setScheduleId(1);
		confirmTicketVo.setTimeSelecting("15:00");
		confirmTicketVo.setTotalPrice(30000.0);
		confirmTicketVo.setUseScore(20000.0);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		Mockito.when(invoiceService.save(confirmTicketVo)).thenReturn(true);

		String jsonExpect = objectWriter.writeValueAsString(confirmTicketVo);

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/confirm-ticket-booking")
						.content(jsonExpect).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andExpect(MockMvcResultMatchers.content().string(messageConfig.getSaveTicketSuccess()));
	}

	/**
	 * TC2: Case Normal: Save failed
	 *
	 */
	@Test
	void testConfirmBookingTC2() throws Exception {
		ConfirmTicketVo confirmTicketVo = new ConfirmTicketVo();
		String[] idSeatSelectings = {"1", "2", "3"};
		confirmTicketVo.setDateSelecting("2021-12-20");
		confirmTicketVo.setIdSeatSelecting(idSeatSelectings);
		confirmTicketVo.setMemberId("m123");
		confirmTicketVo.setMovieId("1");
		confirmTicketVo.setScheduleId(1);
		confirmTicketVo.setTimeSelecting("15:00");
		confirmTicketVo.setTotalPrice(30000.0);
		confirmTicketVo.setUseScore(20000.0);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		Mockito.when(invoiceService.save(confirmTicketVo)).thenReturn(false);

		String jsonExpect = objectWriter.writeValueAsString(confirmTicketVo);

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/confirm-ticket-booking")
						.content(jsonExpect).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()))
				.andExpect(MockMvcResultMatchers.content().string(messageConfig.getSaveTicketFailed()));
	}

	/**
	 * TC3: Case Normal: idSeatSelectings = null
	 *
	 */
	@Test
	void testConfirmBookingTC3() throws Exception {
		ConfirmTicketVo confirmTicketVo = new ConfirmTicketVo();
		String[] idSeatSelectings = null;
		confirmTicketVo.setDateSelecting("2021-12-20");
		confirmTicketVo.setIdSeatSelecting(idSeatSelectings);
		confirmTicketVo.setMemberId("m123");
		confirmTicketVo.setMovieId("1");
		confirmTicketVo.setScheduleId(1);
		confirmTicketVo.setTimeSelecting("15:00");
		confirmTicketVo.setTotalPrice(30000.0);
		confirmTicketVo.setUseScore(20000.0);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		Mockito.when(invoiceService.save(confirmTicketVo)).thenReturn(false);
		String jsonExpect = objectWriter.writeValueAsString(confirmTicketVo);

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/confirm-ticket-booking")
						.content(jsonExpect).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()))
				.andExpect(MockMvcResultMatchers.content().string(messageConfig.getSaveTicketFailed()));
	}

	/**
	 * TC4: Case Normal: MemberId = null
	 *
	 */
	@Test
	void testConfirmBookingTC4() throws Exception {
		ConfirmTicketVo confirmTicketVo = new ConfirmTicketVo();
		String[] idSeatSelectings = {"1", "2", "3"};
		confirmTicketVo.setDateSelecting("2021-12-20");
		confirmTicketVo.setIdSeatSelecting(idSeatSelectings);
		confirmTicketVo.setMemberId(null);
		confirmTicketVo.setMovieId("1");
		confirmTicketVo.setScheduleId(1);
		confirmTicketVo.setTimeSelecting("15:00");
		confirmTicketVo.setTotalPrice(30000.0);
		confirmTicketVo.setUseScore(20000.0);

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Mockito.when(invoiceService.save(confirmTicketVo)).thenReturn(false);

		String jsonExpect = objectWriter.writeValueAsString(confirmTicketVo);

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/confirm-ticket-booking")
						.content(jsonExpect).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.FORBIDDEN.value()))
				.andExpect(MockMvcResultMatchers.content().string(messageConfig.getSaveTicketFailed()));
	}
}
