package fa.appcode.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.ScheduleSeat;

@Repository("scheduleSeatRepository")
@Transactional
public interface ScheduleSeatRepository extends JpaRepository<ScheduleSeat, String>{
	
	List<ScheduleSeat> findByMovieIdAndScheduleId(String movieId, Integer scheduleId);
}

