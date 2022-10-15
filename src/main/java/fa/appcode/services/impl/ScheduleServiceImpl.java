package fa.appcode.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.repositories.ScheduleRepository;
import fa.appcode.services.ScheduleService;
import fa.appcode.web.entities.Schedule;
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
		}

	@Override
	public Schedule getById(Integer scheduleId) {
		return scheduleRepository.getById(scheduleId);
		}

}
