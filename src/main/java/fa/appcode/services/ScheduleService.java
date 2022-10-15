package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Schedule;

public interface ScheduleService {
	List<Schedule> findAll();
	Schedule getById(Integer scheduleId);
}
