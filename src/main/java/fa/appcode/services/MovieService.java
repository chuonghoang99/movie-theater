package fa.appcode.services;

import org.springframework.data.domain.Page;

import fa.appcode.web.entities.Movie;

public interface MovieService {
	Page<Movie> searchAll(String searchData, int pageIndex, int pageSize);
	Page<Movie> findAll(int pageIndex,int pageSize);
	boolean saveMovie(Movie movie);
	boolean deleteMovie(String movieId);
	Movie getById(String movieId);
}
