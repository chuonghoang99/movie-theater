package fa.appcode.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Schedule;
@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}
