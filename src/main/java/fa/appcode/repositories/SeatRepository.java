package fa.appcode.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Seat;

@Repository
@Transactional
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	
	List<Seat> findAllBySeatIdIn(List<Integer> seatIds);

	List<Seat> findAllByCinemaRoomCinemaRoomId(int roomId);

	@Modifying
	@Query("UPDATE Seat s SET s.seatType = :seatType, s.price = :price WHERE s.seatId = :seatId")
	void updateSeatTypeAndPrice(int seatId, int seatType, double price);
}
