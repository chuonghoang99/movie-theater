package fa.appcode.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.ShowDates;
@Repository
@Transactional
public interface ShowDatesRepository extends JpaRepository<ShowDates, Integer> {
	@Query("SELECT s FROM ShowDates s WHERE s.showDate BETWEEN :fromDate AND :toDate ")
	List<ShowDates> findByFromDateAndToDate(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);

}
