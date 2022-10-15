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

import fa.appcode.repositories.CinemaRoomRepository;
import fa.appcode.services.impl.CinemaRoomServiceImpl;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.ScheduleSeat;
import fa.appcode.web.entities.Seat;

@SpringBootTest
class CinemaRoomServiceTest {

	@InjectMocks
	private CinemaRoomServiceImpl cinemaRoomService;
	
	@Mock
	private CinemaRoomRepository cinemaRoomRepository;
	
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
	 * TC1: Case Normal (MovieId: 1)
	 */
	@Test
	void testFindByMovieIdTC1() {
		String movieId = "1";
		CinemaRoom cinemaRoom = new CinemaRoom(1, "Room 1", 60);
		Mockito.when(cinemaRoomRepository.findRoomByMovieId(movieId)).thenReturn(cinemaRoom);
		assertEquals(cinemaRoom, cinemaRoomService.findByMovieId(movieId));
	}
	
	/**
	 * TC2: Case Abnormal (MovieId: "")
	 */
	@Test
	void testFindByMovieIdTC2() {
		String movieId = "";
		assertEquals(null, cinemaRoomService.findByMovieId(movieId));
	}
	
	/**
	 * TC3: Case Abnormal (MovieId: null)
	 */
	@Test
	void testFindByMovieIdTC3() {
		String movieId = null;
		assertEquals(null, cinemaRoomService.findByMovieId(movieId));
	}

	/**
	 * TC1: Normal case (CinemaRoom: Not null, ScheduleSeats: Not null)
	 */
	@Test
	void testSeatSoldsHanlderTC1() {
		List<Seat> seats = new ArrayList<Seat>();
		for (int i = 0; i < 60; i++) {
			seats.add(new Seat(i + 1, 0));
		}
		CinemaRoom cinemaRoom = new CinemaRoom(1, "Room 1", 60, seats);
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		scheduleSeats.add(new ScheduleSeat("1", 1, 1));
		
		CinemaRoom cinemaRoomActual = cinemaRoomService.seatSoldsHanlder(cinemaRoom, scheduleSeats);
		
		assertEquals(1, cinemaRoomActual.getSeats().get(0).getStatus());
	}
	
	/**
	 * TC2: Abnormal case (CinemaRoom: Not null, ScheduleSeats: null)
	 */
	@Test
	void testSeatSoldsHanlderTC2() {
		List<Seat> seats = new ArrayList<Seat>();
		for (int i = 0; i < 60; i++) {
			seats.add(new Seat(i + 1, 0));
		}
		CinemaRoom cinemaRoom = new CinemaRoom(1, "Room 1", 60, seats);
		
		List<ScheduleSeat> scheduleSeats = null;
		
		CinemaRoom cinemaRoomActual = cinemaRoomService.seatSoldsHanlder(cinemaRoom, scheduleSeats);
		
		assertEquals(cinemaRoom, cinemaRoomActual);
	}
	
	/**
	 * TC3: Abnormal case (CinemaRoom: null, ScheduleSeats: Not null)
	 */
	@Test
	void testSeatSoldsHanlderTC3() {
		CinemaRoom cinemaRoom = null;
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		scheduleSeats.add(new ScheduleSeat("1", 1, 1));
		
		CinemaRoom cinemaRoomActual = cinemaRoomService.seatSoldsHanlder(cinemaRoom, scheduleSeats);
		
		assertEquals(null, cinemaRoomActual);
	}


}
