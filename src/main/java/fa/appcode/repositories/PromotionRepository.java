package fa.appcode.repositories;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Promotion;

/**
 * @author TruongNguyen
 */
@Repository
@Transactional
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	@Query("SELECT p FROM Promotion p WHERE p.endTime >= GETDATE() AND " + "(p.detail LIKE :searchData "
			+ "OR p.title LIKE :searchData " + "OR p.discountLevel LIKE :searchData "
			+ "OR function('convert',varchar, p.endTime, 103) LIKE :searchData "
			+ "OR function('convert',varchar, p.startTime, 103) LIKE :searchData) " + "ORDER BY p.endTime desc ")
	Page<Promotion> searchText(@Param("searchData") String searchData, Pageable pageable);

	@Query("SELECT p FROM Promotion p WHERE p.startTime <= :searchData AND p.endTime >= :searchData ORDER BY p.endTime desc ")
	Page<Promotion> searchDate(@Param("searchData") Date searchData, Pageable pageable);

	Promotion findByTitle(String title);

	@Query("SELECT p FROM Promotion p WHERE p.promotionId <> :promotionId AND p.title = :title")
	Promotion checkByIdAndTitle(Integer promotionId, String title);
}
