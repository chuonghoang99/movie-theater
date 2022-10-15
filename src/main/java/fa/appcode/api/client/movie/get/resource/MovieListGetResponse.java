package fa.appcode.api.client.movie.get.resource;

import java.io.Serializable;
import java.util.List;

public class MovieListGetResponse implements Serializable {
    public List<MovieList> movieList;

    public static class MovieList implements Serializable {
        public Integer movieId;
        public String movieName;
    }
}
