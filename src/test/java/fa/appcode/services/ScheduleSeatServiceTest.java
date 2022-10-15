package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fa.appcode.repositories.ScheduleSeatRepository;
import fa.appcode.services.impl.ScheduleSeatServiceImpl;
import fa.appcode.web.entities.ScheduleSeat;

@SpringBootTest
class ScheduleSeatServiceTest {

	@InjectMocks
	private ScheduleSeatServiceImpl scheduleSeatService;
	
	@Mock
	private ScheduleSeatRepository scheduleSeatRepository;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	 * TC1: Normal case: (MovieId: 1, ScheduleId: 1)
	 */
	@Test
	void testFindByMovieIdAndScheduleIdTC1() {
		final String movieId = "1";
		final Integer scheduleId = 1;
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		ScheduleSeat scheduleSeat1 = new ScheduleSeat(movieId, scheduleId, 1, 0, 0);
		ScheduleSeat scheduleSeat2 = new ScheduleSeat(movieId, scheduleId, 1, 0, 0);
		ScheduleSeat scheduleSeat3 = new ScheduleSeat(movieId, scheduleId, 1, 0, 0);
		scheduleSeats.add(scheduleSeat1);
		scheduleSeats.add(scheduleSeat2);
		scheduleSeats.add(scheduleSeat3);
		
		Mockito.when(scheduleSeatRepository.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		assertEquals(scheduleSeats.size(), scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId + "").size());
	}
	
	/**
	 * TC2: Normal case: (MovieId: "", ScheduleId: 1)
	 */
	@Test
	void testFindByMovieIdAndScheduleIdTC2() {
		final String movieId = "";
		final Integer scheduleId = 1;
		
		Mockito.when(scheduleSeatRepository.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(null);
		assertEquals(null, scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId + ""));
	}
	
	/**
	 * TC3: Normal case: (MovieId: 1, ScheduleId: null)
	 */
	@Test
	void testFindByMovieIdAndScheduleIdTC3() {
		final String movieId = "1";
		final Integer scheduleId = null;	
		assertEquals(null, scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId + ""));
	}
	
	/**
	 * TC4: Normal case: (MovieId: 1, ScheduleId: 0)
	 */
	@Test
	void testFindByMovieIdAndScheduleIdTC4() {
		final String movieId = "1";
		final Integer scheduleId = 0;
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		
		Mockito.when(scheduleSeatRepository.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		assertEquals(scheduleSeats.size(), scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId + "").size());
	}
	
	/**
	 * TC5: Normal case: (MovieId: null, ScheduleId: 1)
	 */
	@Test
	void testFindByMovieIdAndScheduleIdTC5() {
		final String movieId = null;
		final Integer scheduleId = 1;
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		
		Mockito.when(scheduleSeatRepository.findByMovieIdAndScheduleId(movieId, scheduleId)).thenReturn(scheduleSeats);
		assertEquals(scheduleSeats.size(), scheduleSeatService.findByMovieIdAndScheduleId(movieId, scheduleId + "").size());
	}

}
