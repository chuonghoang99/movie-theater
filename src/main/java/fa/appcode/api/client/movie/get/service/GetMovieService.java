package fa.appcode.api.client.movie.get.service;

import fa.appcode.common.response.GenericResponse;
import fa.appcode.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GetMovieService {

    @Autowired
    private MovieRepository movieRepository;


    public GenericResponse getMovie() {
        return new GenericResponse(HttpStatus.ACCEPTED.value());
    }
}
