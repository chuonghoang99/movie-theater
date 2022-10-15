package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fa.appcode.repositories.SeatRepository;
import fa.appcode.services.impl.SeatServiceImpl;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.vo.SeatVo;

/**
 * @author ThangNT26
 *
 */
@SpringBootTest
public class SeatServiceTest {
	@Mock
	private SeatRepository seatRepository;

	@InjectMocks
	private SeatServiceImpl seatService;

	// Test method update seat successfully
	@Test
	@Transactional
	void testUpdateSeat1() {
		// Create test data: a seatVo contains info of updating seat
		SeatVo seatVo1 = new SeatVo(2409, 0, (double) 70000);
		Mockito.doNothing().when(seatRepository).updateSeatTypeAndPrice(seatVo1.getSeatId(), seatVo1.getSeatType(),
				seatVo1.getSeatPrice());

		assertEquals(true, seatService.updateSeat(seatVo1));
	}

	// Test method update seat unsuccessfully, seatVo update is null
	@Test
	@Transactional
	void testUpdateSeat2() {
		// Create test data: a null seatVo
		SeatVo seatVo1 = null;
		assertEquals(false, seatService.updateSeat(seatVo1));
	}

	// Test method get all seat with cinemaRoomId successfully
	@Test
	void testGetAllSeat1() {
		// Create cinemaRoomId field
		// 48 seat of the room
		List<Seat> listSeat = new ArrayList<>();
		CinemaRoom cinemaRoom = new CinemaRoom(3010, "Room test ok so 01010101", 48, "/resources/img/room/GKpGDNb_ingame_image.jpg");
		Seat seat1 = new Seat(2409, "A", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat2 = new Seat(2410, "B", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat3 = new Seat(2411, "C", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat4 = new Seat(2412, "D", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat5 = new Seat(2413, "E", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat6 = new Seat(2414, "F", 1, 0, 0, (double) 70000, cinemaRoom);
		Seat seat7 = new Seat(2415, "A", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat8 = new Seat(2416, "B", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat9 = new Seat(2417, "C", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat10 = new Seat(2418, "D", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat11 = new Seat(2419, "E", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat12 = new Seat(2420, "F", 2, 0, 0, (double) 70000, cinemaRoom);
		Seat seat13 = new Seat(2421, "A", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat14 = new Seat(2422, "B", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat15 = new Seat(2423, "C", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat16 = new Seat(2424, "D", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat17 = new Seat(2425, "E", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat18 = new Seat(2426, "F", 3, 0, 0, (double) 70000, cinemaRoom);
		Seat seat19 = new Seat(2427, "A", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat20 = new Seat(2428, "B", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat21 = new Seat(2429, "C", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat22 = new Seat(2430, "D", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat23 = new Seat(2431, "E", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat24 = new Seat(2432, "F", 4, 0, 0, (double) 70000, cinemaRoom);
		Seat seat25 = new Seat(2433, "A", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat26 = new Seat(2434, "B", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat27 = new Seat(2435, "C", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat28 = new Seat(2436, "D", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat29 = new Seat(2437, "E", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat30 = new Seat(2438, "F", 5, 0, 0, (double) 70000, cinemaRoom);
		Seat seat31 = new Seat(2439, "A", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat32 = new Seat(2440, "B", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat33 = new Seat(2441, "C", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat34 = new Seat(2442, "D", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat35 = new Seat(2443, "E", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat36 = new Seat(2444, "F", 6, 0, 0, (double) 70000, cinemaRoom);
		Seat seat37 = new Seat(2445, "A", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat38 = new Seat(2446, "B", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat39 = new Seat(2447, "C", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat40 = new Seat(2448, "D", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat41 = new Seat(2449, "E", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat42 = new Seat(2450, "F", 7, 0, 0, (double) 70000, cinemaRoom);
		Seat seat43 = new Seat(2451, "A", 8, 0, 0, (double) 70000, cinemaRoom);
		Seat seat44 = new Seat(2452, "B", 8, 0, 0, (double) 70000, cinemaRoom);
		Seat seat45 = new Seat(2453, "C", 8, 0, 0, (double) 70000, cinemaRoom);
		Seat seat46 = new Seat(2454, "D", 8, 0, 0, (double) 70000, cinemaRoom);
		Seat seat47 = new Seat(2455, "E", 8, 0, 0, (double) 70000, cinemaRoom);
		Seat seat48 = new Seat(2456, "F", 8, 0, 0, (double) 70000, cinemaRoom);
		listSeat.add(seat1);
		listSeat.add(seat2);
		listSeat.add(seat3);
		listSeat.add(seat4);
		listSeat.add(seat5);
		listSeat.add(seat6);
		listSeat.add(seat7);
		listSeat.add(seat8);
		listSeat.add(seat9);
		listSeat.add(seat10);
		listSeat.add(seat11);
		listSeat.add(seat12);
		listSeat.add(seat13);
		listSeat.add(seat14);
		listSeat.add(seat15);
		listSeat.add(seat16);
		listSeat.add(seat17);
		listSeat.add(seat18);
		listSeat.add(seat19);
		listSeat.add(seat20);
		listSeat.add(seat21);
		listSeat.add(seat22);
		listSeat.add(seat23);
		listSeat.add(seat24);
		listSeat.add(seat25);
		listSeat.add(seat26);
		listSeat.add(seat27);
		listSeat.add(seat28);
		listSeat.add(seat29);
		listSeat.add(seat30);
		listSeat.add(seat31);
		listSeat.add(seat32);
		listSeat.add(seat33);
		listSeat.add(seat34);
		listSeat.add(seat35);
		listSeat.add(seat36);
		listSeat.add(seat37);
		listSeat.add(seat38);
		listSeat.add(seat39);
		listSeat.add(seat40);
		listSeat.add(seat41);
		listSeat.add(seat42);
		listSeat.add(seat43);
		listSeat.add(seat44);
		listSeat.add(seat45);
		listSeat.add(seat46);
		listSeat.add(seat47);
		listSeat.add(seat48);

		cinemaRoom.setSeats(listSeat);
		Mockito.when(seatRepository.findAllByCinemaRoomCinemaRoomId(cinemaRoom.getCinemaRoomId())).thenReturn(listSeat);

		List<Seat> actualListFound = seatService.findAllByCinemaRoomCinemaRoomId(cinemaRoom.getCinemaRoomId());

		assertEquals(listSeat, actualListFound);
	}

}
