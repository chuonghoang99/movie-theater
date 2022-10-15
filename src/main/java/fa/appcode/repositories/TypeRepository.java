package fa.appcode.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Type;
@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Integer> {
	
}
