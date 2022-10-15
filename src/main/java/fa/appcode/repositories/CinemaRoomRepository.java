package fa.appcode.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.appcode.web.entities.CinemaRoom;

@Repository("cinemaRoomRepository")
@Transactional
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer>{
	Page<CinemaRoom> findAllByCinemaRoomNameContaining(String roomName, Pageable pageable);
	
	@Query("SELECT c FROM CinemaRoom c WHERE c.cinemaRoomId IN (SELECT m.cinemaRoom.cinemaRoomId FROM "
			+ "Movie m WHERE m.movieId = ?1)")
	CinemaRoom findRoomByMovieId(String movieId);

	CinemaRoom findRoomByCinemaRoomName(String roomName);
}
