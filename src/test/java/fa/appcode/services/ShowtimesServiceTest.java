package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fa.appcode.common.utils.DateUtils;
import fa.appcode.config.PageConfig;
import fa.appcode.repositories.ShowtimesRepository;
import fa.appcode.services.impl.ShowtimesServiceImpl;
import fa.appcode.specification.ShowDateSpecification;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.MovieSchedule;
import fa.appcode.web.entities.Schedule;
import fa.appcode.web.entities.ShowDates;
import fa.appcode.web.vo.PageVo;

@SpringBootTest
class ShowtimesServiceTest {
	
	@InjectMocks
	private ShowtimesServiceImpl showtimesService;
	
	@Mock
	private ShowtimesRepository showtimesRepository;
	
	@Mock
	private ShowDateSpecification showDateSpecification;
	
	@Mock
	private PageConfig pageConfig;
	
	private static List<ShowDates> listShowDate = null;
	private static MovieDate movieDate1 = null;
	private static MovieDate movieDate2 = null;		
	private static MovieDate movieDate3 = null;		

	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
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

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * TC1: Case Normal (Date: Current date)
	 */
	@Test
	void testgetShowDateListTC1() {
		String dateSelecting = LocalDate.now().toString();
		assertEquals(6, showtimesService.getShowDateList(dateSelecting).size());
	}
	
	/**
	 * TC2: Case Abnormal (Date: null)
	 */
	@Test
	void testgetShowDateListTC2() {
		String dateSelecting = null;
		assertEquals(6, showtimesService.getShowDateList(dateSelecting).size());
	}
	
	/**
	 * TC3: Case Abnormal (Date: "")
	 */
	@Test
	void testgetShowDateListTC3() {
		String dateSelecting = "";
		assertEquals(6, showtimesService.getShowDateList(dateSelecting).size());
	}
	
	/**
	 * TC01: Case Normal (Selecting date: current date, page index: 1)
	 */
	@Test
	void testFindBySelectedDateTC1() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(listShowDate);
		
		List<MovieDate> movieDateExpected = new ArrayList<MovieDate>();
		movieDateExpected.add(movieDate1);
		movieDateExpected.add(movieDate2);
		PageVo<MovieDate> pageVoExpected = new PageVo<MovieDate>(1, 2, movieDateExpected);
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate(LocalDate.now() + "", 1, 2);
		
		assertEquals(pageVoExpected.getContent().size(), pageVoActual.getContent().size());	
	}
	
	/**
	 * TC02: Case Abnormal (Selecting date: "", page index: 1)
	 */
	@Test
	void testFindBySelectedDateTC2() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(listShowDate);
		
		List<MovieDate> movieDateExpected = new ArrayList<MovieDate>();
		movieDateExpected.add(movieDate1);
		movieDateExpected.add(movieDate2);
		PageVo<MovieDate> pageVoExpected = new PageVo<MovieDate>(1, 2, movieDateExpected);
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate("", 1, 2);
		
		assertEquals(pageVoExpected.getContent().size(), pageVoActual.getContent().size());	
	}
	
	/**
	 * TC03: Case Abnormal (Selecting date: null, page index: 1)
	 */
	@Test
	void testFindBySelectedDateTC3() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(listShowDate);
		
		List<MovieDate> movieDateExpected = new ArrayList<MovieDate>();
		movieDateExpected.add(movieDate1);
		movieDateExpected.add(movieDate2);
		PageVo<MovieDate> pageVoExpected = new PageVo<MovieDate>(1, 2, movieDateExpected);
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate(null, 1, 2);
		
		assertEquals(pageVoExpected.getContent().size(), pageVoActual.getContent().size());	
	}
	
	/**
	 * TC04: Case Normal (Selecting date: now, page index: 2)
	 */
	@Test
	void testFindBySelectedDateTC4() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(listShowDate);
		
		List<MovieDate> movieDateExpected = new ArrayList<MovieDate>();
		movieDateExpected.add(movieDate3);
		PageVo<MovieDate> pageVoExpected = new PageVo<MovieDate>(2, 2, movieDateExpected);
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate(LocalDate.now() + "", 2, 2);
		
		for (int i = 0; i < pageVoExpected.getContent().size(); i++) {
			assertEquals(pageVoExpected.getContent().get(i), (pageVoActual.getContent().get(i)));
		}
	}
	
	/**
	 * TC05: Case Abnormal (page index > total page)
	 */
	@Test
	void testFindBySelectedDateTC5() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(listShowDate);
		
		List<MovieDate> movieDateExpected = new ArrayList<MovieDate>();
		PageVo<MovieDate> pageVoExpected = new PageVo<MovieDate>(1, 2, movieDateExpected);
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate(LocalDate.now() + "", 3, 2);
		assertEquals(pageVoExpected.getContent().size(), pageVoActual.getContent().size());	
	}
	
	/**
	 * TC06: Case Abnormal (List Showdates empty)
	 */
	
	@Test
	void testFindBySelectedDateTC6() {
		Mockito.when(showtimesRepository.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.now()))))
		.thenReturn(new ArrayList<ShowDates>());	
		
		PageVo<MovieDate> pageVoActual = showtimesService.findMovieTimeByDate(LocalDate.now() + "", 1, 2);	
		assertEquals(null, pageVoActual);	
	}
	
}
