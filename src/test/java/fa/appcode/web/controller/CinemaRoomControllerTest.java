package fa.appcode.web.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fa.appcode.config.PageConfig;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.SeatService;
import fa.appcode.web.controller.CinemaRoomController;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.vo.SeatVo;

/**
 * @author ThangNT26
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CinemaRoomControllerTest {
    @MockBean
    private CinemaRoomService cinemaRoomService;

    @MockBean
    private SeatService seatService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CinemaRoomController cinemaRoomController;

    @Autowired
    private PageConfig pageConfig;

    // Test showListRoom method without search key
    @Test
    @WithUserDetails
    void testShowListRoom1() throws Exception {
        // Input mock
        final Integer pageSize = 5;
        final Integer pageIndex = 1;

        // Output mock

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

        Page<CinemaRoom> page = new PageImpl<CinemaRoom>(listRoom);

        Mockito.when(cinemaRoomService.findAll(pageIndex, pageSize)).thenReturn(page);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/list-room").param("pageIndex", "1"))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/list-room"))
                .andExpect(MockMvcResultMatchers.model().attribute("roomRecords", listRoom.size()))
                .andExpect(MockMvcResultMatchers.model().attribute("cinemaRooms", listRoom))
                .andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex))
                .andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()));
    }

    // Test showListRoom method with search key
    @WithUserDetails
    @Test
    void testShowListRoom2() throws Exception {
        // Input mock
        final Integer pageSize = 5;
        final Integer pageIndex = 1;

        // Output mock

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

        Page<CinemaRoom> page = new PageImpl<CinemaRoom>(listRoom);

        Mockito.when(cinemaRoomService.findAllBySearchKey("Room", pageIndex, pageSize)).thenReturn(page);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/room/list-room").param("pageIndex", "1").param("searchField", "Room"))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/list-room"))
                .andExpect(MockMvcResultMatchers.model().attribute("roomName", "Room"))
                .andExpect(MockMvcResultMatchers.model().attribute("roomRecords", listRoom.size()))
                .andExpect(MockMvcResultMatchers.model().attribute("cinemaRooms", listRoom))
                .andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex))
                .andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()));
    }

    // Test showListRoom method with search key and pageIndex
    @WithUserDetails
    @Test
    void testShowListRoom3() throws Exception {
        // Input mock
        final Integer pageSize = 5;
        final Integer pageIndex = 1;

        // Output mock

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

        Page<CinemaRoom> page = new PageImpl<CinemaRoom>(listRoom);

        Mockito.when(cinemaRoomService.findAll(pageIndex, pageSize)).thenReturn(page);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/list-room"))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/list-room"))
                .andExpect(MockMvcResultMatchers.model().attribute("roomRecords", listRoom.size()))
                .andExpect(MockMvcResultMatchers.model().attribute("cinemaRooms", listRoom))
                .andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex))
                .andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()));
    }

    // Test showAddRoom method successfully
    @WithUserDetails
    @Test
    void testShowAddRoom() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/room/add-room"))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/add-room"));
    }

    // Test getRoomImageUrl method successfully
    @WithUserDetails
    @Test
    void testShowImageInToolTip1() throws Exception {
        CinemaRoom roomFound = new CinemaRoom(2, "Room 1", 50,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg");
        Mockito.when(cinemaRoomService.findById("2")).thenReturn(roomFound);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/room-image").param("roomId", "2"))
                .andExpect(MockMvcResultMatchers.content().string(
                        containsString("/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg")));
    }

    // Test getRoomImageUrl method unsuccessfully, roomId is not correct
    @WithUserDetails
    @Test
    void testShowImageInToolTip2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/room/room-image").param("roomId", "2120122")).andExpect(
                MockMvcResultMatchers.content().string(containsString("RoomId is incorrect, please try again")));
    }

    // Test addRoomProcess method: save room and create seat successfully with all
    // field but image

    @WithUserDetails
    @Test
    @Transactional
    void testAddRoomProcess1() throws Exception {
        // Prepare data of room seats
        // Output mock
        // 48 seat of the room
        List<Seat> listSeat = new ArrayList<>();
        CinemaRoom cinemaRoom = new CinemaRoom(3010, "Room test ok so 01010101", 48,
                "/resources/img/room/GKpGDNb_ingame_image.jpg");
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
        Mockito.when(cinemaRoomService.saveCinemaRoom(cinemaRoom)).thenReturn(cinemaRoom);

        byte[] bytes = null;
        MockMultipartFile file = new MockMultipartFile("roomImage", "test.txt", "text/plain", bytes);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/room/room-saving").file(file)
                        .param("roomName", cinemaRoom.getCinemaRoomName())
                        .param("seatQuantity", cinemaRoom.getSeatQuantity() + ""))
                .andExpect(jsonPath("$.methodMessage").value(pageConfig.getAddRoomOk()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Test addRoomProcess method: save room and create seat unsuccessfully because
    // room name is existed

    @WithUserDetails
    @Test
    @Transactional
    void testAddRoomProcess2() throws Exception {
        CinemaRoom savingRoom = new CinemaRoom("Room 1", 48,
                "/resources/img/room/246542006_282464760393611_5264616230431044546_n.jpg");

        Mockito.when(cinemaRoomService.checkExistedRoomName(savingRoom.getCinemaRoomName())).thenReturn(true);
        MockMultipartFile file = new MockMultipartFile("roomImage", "test.txt", "text/plain",
                "Test content add room".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.multipart("/room/room-saving").file(file)
                        .param("roomName", savingRoom.getCinemaRoomName())
                        .param("seatQuantity", savingRoom.getSeatQuantity() + ""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.methodMessage").value(pageConfig.getAddRoomNotOk()))
                .andExpect(jsonPath("$.roomNameMessage").value(pageConfig.getRoomNameExisted()));
    }

    // Test addRoomProcess method: save room and create seat successfully with all
    // field

    @WithUserDetails
    @Test
    @Transactional
    void testAddRoomProcess3() throws Exception {

        // Prepare data of room seats
        // Output mock
        // 48 seat of the room
        List<Seat> listSeat = new ArrayList<>();
        CinemaRoom cinemaRoom = new CinemaRoom(3010, "Room test ok so 01010101", 48,
                "/resources/img/room/GKpGDNb_ingame_image.jpg");
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
        Mockito.when(cinemaRoomService.saveCinemaRoom(cinemaRoom)).thenReturn(cinemaRoom);
        MockMultipartFile file = new MockMultipartFile("roomImage", "test.txt", "text/plain",
                "Test room saving content".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.multipart("/room/room-saving").file(file)
                        .param("roomName", cinemaRoom.getCinemaRoomName())
                        .param("seatQuantity", cinemaRoom.getSeatQuantity() + ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.methodMessage").value(pageConfig.getAddRoomOk()));
    }

    // Test addRoomProcess method: save room and create seat unsuccessfully blank
    // roomName

    @WithUserDetails
    @Test
    @Transactional
    void testAddRoomProcess4() throws Exception {
        CinemaRoom savingRoom = new CinemaRoom("", 48, "/resources/img/room/Test image01.jpg");
        MockMultipartFile file = new MockMultipartFile("roomImage", "test.txt", "text/plain",
                "Test content add room".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.multipart("/room/room-saving").file(file)
                        .param("roomName", savingRoom.getCinemaRoomName())
                        .param("seatQuantity", savingRoom.getSeatQuantity() + ""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.methodMessage").value(pageConfig.getAddRoomNotOk()))
                .andExpect(jsonPath("$.roomNameMessage").value(pageConfig.getRoomNameBlank()));
    }

    // Test method get seat deatail successfully

    @WithUserDetails
    @Test
    void testGetSeatDetail1() throws Exception {
        // Input mock
        final String roomId = "3010";

        // Output mock
        // 48 seat of the room
        List<Seat> listSeat = new ArrayList<>();
        CinemaRoom cinemaRoom = new CinemaRoom(3010, "Room test ok so 01010101", 48,
                "/resources/img/room/GKpGDNb_ingame_image.jpg");
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

        Mockito.when(cinemaRoomService.findById(roomId)).thenReturn(cinemaRoom);
        Mockito.when(seatService.findAllByCinemaRoomCinemaRoomId(Integer.parseInt(roomId))).thenReturn(listSeat);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/seat-detail").param("roomId", roomId))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/seat-detail"))
                .andExpect(MockMvcResultMatchers.model().attribute("roomName", cinemaRoom.getCinemaRoomName()))
                .andExpect(MockMvcResultMatchers.model().attribute("listRoomSeat", listSeat));
    }

    // Test method get seat deatail unsuccessfully, roomId is not existed

    @WithUserDetails
    @Test
    void testGetSeatDetail2() throws Exception {
        // Input mock
        final String roomId = "2039182";

        Mockito.when(cinemaRoomService.findById(roomId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/seat-detail").param("roomId", roomId))
                .andExpect(MockMvcResultMatchers.view().name("cinema-room/seat-detail"))
                .andExpect(MockMvcResultMatchers.model().attribute("msg", pageConfig.getRoomIdNotValid()))
                .andExpect(MockMvcResultMatchers.model().attribute("seatFoundCount", pageConfig.getZeroSeatFound()));
    }

    // Test method update list seat of cinema room successfully

    @WithUserDetails
    @Test
    @Transactional
    void testUpdateListSeat1() throws Exception {
        // Input mock
        // A list of seat with JSON type
        // 48 seat of the room
        List<SeatVo> listSeatVo = new ArrayList<>();

        SeatVo seat1 = new SeatVo(2409, 0, (double) 70000);
        SeatVo seat2 = new SeatVo(2410, 1, (double) 140000);
        SeatVo seat3 = new SeatVo(2411, 0, (double) 70000);
        SeatVo seat4 = new SeatVo(2412, 0, (double) 70000);
        SeatVo seat5 = new SeatVo(2413, 0, (double) 70000);

        listSeatVo.add(seat1);
        listSeatVo.add(seat2);
        listSeatVo.add(seat3);
        listSeatVo.add(seat4);
        listSeatVo.add(seat5);

        Mockito.when(seatService.updateSeat(seat1)).thenReturn(true);
        Mockito.when(seatService.updateSeat(seat2)).thenReturn(true);
        Mockito.when(seatService.updateSeat(seat3)).thenReturn(true);
        Mockito.when(seatService.updateSeat(seat4)).thenReturn(true);
        Mockito.when(seatService.updateSeat(seat5)).thenReturn(true);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String listSeatParam = objectWriter.writeValueAsString(listSeatVo);
        mockMvc.perform(MockMvcRequestBuilders.post("/room/save-room-detail").content(listSeatParam)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(containsString(pageConfig.getUpdateListSeatOk())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Test method update list seat of cinema room unsuccessfully
    //
    @WithUserDetails
    @Test
    @Transactional
    void testUpdateListSeat2() throws Exception {
        // Input mock
        // A list of seat with JSON type
        // 48 seat of the room
        List<SeatVo> listSeatVo = new ArrayList<>();

        SeatVo seat1 = new SeatVo(201012023, 0, (double) 70000);

        listSeatVo.add(seat1);
        Mockito.when(seatService.updateSeat(seat1)).thenReturn(false);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String listSeatParam = objectWriter.writeValueAsString(listSeatVo);
        mockMvc.perform(MockMvcRequestBuilders.post("/room/save-room-detail").content(listSeatParam)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(containsString(pageConfig.getUpdateListSeatNotOk())))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
