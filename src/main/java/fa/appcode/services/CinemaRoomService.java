package fa.appcode.services;

import java.util.List;

import org.springframework.data.domain.Page;

import fa.appcode.exceptions.CinemaRoomException;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.ScheduleSeat;

public interface CinemaRoomService {
	Page<CinemaRoom> findAll(int pageIndex, int pageSize) throws Exception;
	
	Page<CinemaRoom> findAllBySearchKey(String roomName, int pageIndex, int pageSize) throws Exception;
	
	CinemaRoom findById(String roomId);
	
	CinemaRoom findByMovieId(String movieId);
	
	CinemaRoom seatSoldsHanlder(CinemaRoom cinemaRoom, List<ScheduleSeat> scheduleSeats);
	
	List<CinemaRoom> findAll();

	CinemaRoom saveCinemaRoom(CinemaRoom cinemaRoom) throws CinemaRoomException;

	boolean checkExistedRoomName(String roomName);
}
