package fa.appcode.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieType;
@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	@Query("SELECT m FROM Movie m WHERE m.movieNameEnglish LIKE :searchData "
			+ "OR m.movieNameVn LIKE :searchData "
			+ "OR function('convert',varchar, m.releaseDate, 103) LIKE :searchData "
			+ "OR m.movieProductCompany LIKE :searchData "
			+ "OR m.duration LIKE :searchData "
			+ "OR m.version LIKE :searchData ")
	Page<Movie> searchText(@Param("searchData") String searchData, Pageable pageable);
	
	@Query("SELECT m FROM Movie m WHERE m.releaseDate = :searchData")
	Page<Movie> searchDate(@Param("searchData") Date searchData, Pageable pageable);
	@Query("DELETE FROM MovieDate m WHERE m.movie= :movie")
	@Modifying
	int deleteMovieDate(@Param("movie") Movie movie);
	@Modifying
	@Query("DELETE FROM MovieType m WHERE m.movie= :movie")
	int deleteMovieType(@Param("movie") Movie movie);
	@Modifying
	@Query(value="DELETE FROM MovieSchedule m WHERE m.movie= :movie")
	int deleteMovieSchedule(@Param("movie") Movie movie);
	@Query("FROM MovieType m WHERE m.movie= :movie")
	List<MovieType> findMovieTypeByMovie(@Param("movie") Movie movie);
}
