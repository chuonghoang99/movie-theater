package fa.appcode.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.ShowDates;

@Repository()
public interface ShowtimesRepository extends JpaRepository<ShowDates, Integer>, JpaSpecificationExecutor<ShowDates> {
	Page<ShowDates> findAll(Specification<ShowDates> specification, Pageable pageable);


	
}
