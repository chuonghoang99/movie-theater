package fa.appcode.api.client.movie.get;

import fa.appcode.api.client.movie.get.resource.MovieListGetResponse;
import fa.appcode.api.client.movie.get.service.GetMovieService;
import fa.appcode.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMovieController {
    @Autowired
   private GetMovieService getMovieService;

    @GetMapping("/movie/get_all")
    public MovieListGetResponse getAllMovie(){
        return new MovieListGetResponse();
    }




}
