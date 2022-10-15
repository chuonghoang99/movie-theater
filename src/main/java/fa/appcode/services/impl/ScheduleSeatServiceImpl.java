package fa.appcode.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.common.utils.LibraryCustomize;
import fa.appcode.repositories.ScheduleSeatRepository;
import fa.appcode.services.ScheduleSeatService;
import fa.appcode.web.entities.ScheduleSeat;

/**
 * The Class ScheduleSeatServiceImpl.
 */
@Service
public class ScheduleSeatServiceImpl implements ScheduleSeatService {

	@Autowired
	private ScheduleSeatRepository scheduleSeatRepository;
	
	/**
	 * Find list scheduleSeat by movie id and schedule id.
	 *
	 * @param movieId the movie id
	 * @param scheduleId the schedule id
	 * @return the list scheduleSeat
	 */
	@Override
	public List<ScheduleSeat> findByMovieIdAndScheduleId(String movieId, String scheduleId) {
		if(!LibraryCustomize.isNumber(scheduleId)) {
			return null;
		}
		return scheduleSeatRepository.findByMovieIdAndScheduleId(movieId, Integer.parseInt(scheduleId));
	}

}
