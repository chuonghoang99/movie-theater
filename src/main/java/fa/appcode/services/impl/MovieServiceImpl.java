package fa.appcode.services.impl;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.common.utils.Constants;
import fa.appcode.repositories.MovieRepository;
import fa.appcode.services.MovieService;
import fa.appcode.web.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Page<Movie> searchAll(String searchData, int pageIndex, int pageSize) {
        if (pageIndex <= 0 || pageSize < 0) {
            return null;
        }
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        Page<Movie> movies;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(searchData);
            movies = movieRepository.searchDate(date, pageable);
        } catch (ParseException e) {
            String searchVal;
            if (Constants.DEFAULT_WORD.equals(searchData)) {
                searchVal = "%%";
            } else {
                searchVal = "%" + searchData + "%";
            }
            movies = movieRepository.searchText(searchVal, pageable);
        }
        return movies;
    }

    @Override
    public Page<Movie> findAll(int pageIndex, int pageSize) {
        if (pageIndex >= 0 && pageSize > 0) {
            Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
            Page<Movie> movies;
            movies = movieRepository.findAll(pageable);
            return movies;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean saveMovie(Movie movie) {
        boolean check = false;
        try {
            if (movie != null && movie.getMovieId() == null) {

                movieRepository.save(movie);
                check = true;
            } else {
                if (movie != null) {
                    movieRepository.deleteMovieDate(movie);
                    movieRepository.deleteMovieType(movie);
                    movieRepository.deleteMovieSchedule(movie);
                    movieRepository.save(movie);
                    check = true;
                }
            }

        } catch (Exception exception) {
            LogUtils.getLogger().info(exception.getMessage());

        }
        return check;

    }

    @Override
    public boolean deleteMovie(String movieId) {
        boolean check = false;
        if (movieId != null && movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);
            check = true;
        }

        return check;
    }

    @Override
    public Movie getById(String movieId) {
        if (movieId != null && !Constants.DEFAULT_WORD.equals(movieId)) {
            return movieRepository.getById(movieId);
        } else {
            return null;
        }

    }

}
