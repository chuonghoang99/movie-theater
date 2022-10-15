package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Seat;
import fa.appcode.web.vo.SeatVo;

public interface SeatService {
	
	List<Seat> findAllBySeatId(String[] seatIds);

	public boolean updateSeat(SeatVo updateSeat);

	public List<Seat> findAllByCinemaRoomCinemaRoomId(Integer cinemaRoomId);
}
