package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.ScheduleSeat;

public interface ScheduleSeatService {
	List<ScheduleSeat> findByMovieIdAndScheduleId(String movieId, String scheduleId);
}
