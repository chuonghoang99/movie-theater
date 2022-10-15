package fa.appcode.services;

import fa.appcode.exceptions.CinemaRoomException;
import fa.appcode.repositories.CinemaRoomRepository;
import fa.appcode.services.impl.CinemaRoomServiceImpl;
import fa.appcode.web.entities.CinemaRoom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author
 */
@SpringBootTest
public class CinemaRoomServiceTest2 {

    @Mock
    private CinemaRoomRepository roomRepository;

    @InjectMocks
    private CinemaRoomServiceImpl cinemaRoomService;

//	// Test find all method, which the output is 5 records in a page
//	@Test
//	void testFindAll() {
//		final int pageIndex = 1;
//		final int pageSize = 5;
//		final Sort sort = Sort.by("cinemaRoomName");
//		List<CinemaRoom> listRoom = new ArrayList<>();
//		listRoom.add(new CinemaRoom(2, "Room 1", 50,
//				"/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg"));
//		listRoom.add(new CinemaRoom(3, "Room 2", 50,
//				"/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg"));
//		listRoom.add(new CinemaRoom(4, "Room 3", 60,
//				"https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));
//		listRoom.add(new CinemaRoom(5, "Room 4", 50,
//				"https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));
//		listRoom.add(new CinemaRoom(6, "Room 5", 60,
//				"https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));
//
//		Page<CinemaRoom> expectedPage = new PageImpl<>(listRoom);
//
//		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);
//
//		Mockito.when(roomRepository.findAll(pageable)).thenReturn(expectedPage);
//
//		Page<CinemaRoom> actualPage = cinemaRoomService.findAll(pageIndex, pageSize);
//
//		assertEquals(expectedPage, actualPage);
//	}

    // Test check existed cinema room name, output is not existed

    @Test

    @Transactional
    void testCheckExistedRoomName2() {
        Mockito.when(roomRepository.findRoomByCinemaRoomName("Room test check existed")).thenReturn(null);
        assertEquals(false, cinemaRoomService.checkExistedRoomName("Room test check existed"));

    }


    // Test find all method with search key, which the output is 5 records
    @Test
    void testFindAllWithSearchKey1() throws Exception {
        final int pageIndex = 1;
        final int pageSize = 5;
        final Sort sort = Sort.by("cinemaRoomName");
        List<CinemaRoom> listRoom = new ArrayList<>();
        listRoom.add(new CinemaRoom(2, "Room 1", 50,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg"));
        listRoom.add(new CinemaRoom(3, "Room 2", 50,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg"));
        listRoom.add(new CinemaRoom(4, "Room 3", 60,
                "https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));
        listRoom.add(new CinemaRoom(5, "Room 4", 50,
                "https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));
        listRoom.add(new CinemaRoom(6, "Room 5", 60,
                "https://i.pinimg.com/474x/c1/3c/11/c13c11ec72e83fc8521893d53ec35623.jpg"));

        Page<CinemaRoom> expectedPage = new PageImpl<>(listRoom);

        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);

        Mockito.when(roomRepository.findAllByCinemaRoomNameContaining("R", pageable)).thenReturn(expectedPage);

        Page<CinemaRoom> actualPage = cinemaRoomService.findAllBySearchKey("R", pageIndex, pageSize);

        assertEquals(expectedPage, actualPage);
    }

    // Test find all method with search key, which the output is 0 records
    @Test
    void testFindAllWithSearchKey2() throws Exception {
        final int pageIndex = 1;
        final int pageSize = 5;
        final Sort sort = Sort.by("cinemaRoomName");
        List<CinemaRoom> listRoom = new ArrayList<>();

        Page<CinemaRoom> expectedPage = new PageImpl<>(listRoom);

        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);

        Mockito.when(roomRepository.findAllByCinemaRoomNameContaining("Room 10", pageable)).thenReturn(expectedPage);

        Page<CinemaRoom> actualPage = cinemaRoomService.findAllBySearchKey("Room 10", pageIndex, pageSize);

        assertEquals(expectedPage, actualPage);
    }

    // Test find cinema room with id, output is 1 records
    @Test
    void testFindById1() {
        CinemaRoom expectedRoom = new CinemaRoom(2, "Room 1", 50,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg");

        Mockito.when(roomRepository.findById(2)).thenReturn(Optional.of(expectedRoom));

        CinemaRoom actualRoom = cinemaRoomService.findById("2");

        assertEquals(expectedRoom, actualRoom);

    }

    // Test find cinema room with id, output is null
//	@Test
//	void testFindById2() {
//		Optional<CinemaRoom> cinemaRoom = null;
//		Mockito.when(roomRepository.findById(10000)).thenReturn(cinemaRoom);
//
//		CinemaRoom actualRoom = cinemaRoomService.findById("10000");
//
//		assertNull(actualRoom);
//	}

    // Test save cinemaRoom successfully
    @Test
    @Transactional
    void testSaveRoom1() throws CinemaRoomException {
        CinemaRoom expectedRoom = new CinemaRoom("Room test save 01", 54, "img of test room 01");

        // Check room name existing before save CinemaRoom
        assertFalse(cinemaRoomService.checkExistedRoomName(expectedRoom.getCinemaRoomName()));
        Mockito.when(roomRepository.save(expectedRoom)).thenReturn(expectedRoom);
        Mockito.when(roomRepository.findRoomByCinemaRoomName(expectedRoom.getCinemaRoomName())).thenReturn(null);

        CinemaRoom actualRoom = cinemaRoomService.saveCinemaRoom(expectedRoom);

        assertEquals(expectedRoom, actualRoom);
    }

    // Test save cinemaRoom successfully with id = update
    @Test
    @Transactional
    void testSaveRoom2() throws CinemaRoomException {
        CinemaRoom expectedRoom = new CinemaRoom(2, "Room test save 01", 54, "img of test room 01");

        // Check room name existing before save CinemaRoom
        assertFalse(cinemaRoomService.checkExistedRoomName(expectedRoom.getCinemaRoomName()));
        Mockito.when(roomRepository.save(expectedRoom)).thenReturn(expectedRoom);
        Mockito.when(roomRepository.findRoomByCinemaRoomName(expectedRoom.getCinemaRoomName())).thenReturn(null);

        CinemaRoom actualRoom = cinemaRoomService.saveCinemaRoom(expectedRoom);

        assertEquals(expectedRoom, actualRoom);
    }

    // Test save cinemaRoom unsuccessfully with cinemaRoom is null
    @Test
    @Transactional
    void testSaveRoom3() throws CinemaRoomException {
        CinemaRoom expectedRoom = null;
        CinemaRoom actualRoom = cinemaRoomService.saveCinemaRoom(expectedRoom);
        assertEquals(expectedRoom, actualRoom);
    }

    // Test check existed cinema room name, output is existed
    @Test
    @Transactional
    void testCheckExistedRoomName() {
        CinemaRoom existedExpectRoom = new CinemaRoom(2, "Room 1", 50,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg");
        Mockito.when(roomRepository.findRoomByCinemaRoomName(existedExpectRoom.getCinemaRoomName()))
                .thenReturn(existedExpectRoom);

        assertEquals(true, cinemaRoomService.checkExistedRoomName(existedExpectRoom.getCinemaRoomName()));
    }

}
