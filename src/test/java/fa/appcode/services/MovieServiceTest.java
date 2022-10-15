package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.repositories.MovieRepository;
import fa.appcode.services.impl.MovieServiceImpl;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieType;
import fa.appcode.web.entities.MovieTypeId;
import fa.appcode.web.entities.Type;

/**
 * The Class MovieServiceTest.
 */
@SpringBootTest
class MovieServiceTest {

  /** The movie repository. */
  @Mock
  MovieRepository movieRepository;

  /** The movie service. */
  @InjectMocks
  MovieServiceImpl movieService;

  /** The movies. */
  static List<Movie> movies = new ArrayList<Movie>();
  static List<MovieType> movieTypes = new ArrayList<MovieType>();
  static List<Type> types = new ArrayList<Type>();

  @BeforeAll
  private static void setUpBeforeClass() throws Exception {
    for (int i = 0; i < 5; i++) {
      Movie movie = new Movie();
      movie.setMovieId("Movie" + i);
      movie.setActor("Duy Khanh");
      movie.setDuration((double) 111);
      movie.setDirector("Duy Khanh");
      movie.setContent("aaaa");
      movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
      movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
      movie.setReleaseDate(
          new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
      movie.setLargeImage("a.png");
      movie.setMovieNameEnglish("ENG");
      movie.setMovieNameVn("VN");
      movie.setMovieProductCompany("Marvel");
      movies.add(movie);
      types.add(new Type(i, "Type" + i));
    }
  }

  /**
   * Tear down after class.
   *
   * @throws Exception the exception
   */
  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  /**
   * Test search with date.
   *
   * @throws ParseException the parse exception
   */
  @Test
  void testSearchAllDate() throws ParseException {
    final int pageIndex = 1;
    final int pageSize = 5;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Date date = format.parse("11/11/2021");
    Page<Movie> page = new PageImpl<>(movies);
    Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
    Mockito.when(movieRepository.searchDate(date, pageable)).thenReturn(page);
    Page<Movie> actual = movieService.searchAll("11/11/2021", pageIndex,
        pageSize);
    LogUtils.getLogger().info(actual);
    assertEquals(page, actual);
  }

  /**
   * Test search all with text.
   *
   * @throws ParseException the parse exception
   */
  @Test
  void testSearchAllText() throws ParseException {
    // Init: Test input
    final int pageIndex = 1;
    final int pageSize = 5;
    Page<Movie> page = new PageImpl<>(movies);
    Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
    Mockito.when(movieRepository.searchText("%a%", pageable)).thenReturn(page);
    Page<Movie> actual = movieService.searchAll("a", pageIndex, pageSize);
    LogUtils.getLogger().info(actual);
    assertEquals(page, actual);
  }

  /**
   * Test find all normal case.
   *
   * @throws ParseException the parse exception
   */
  @Test
  void testFindAll() throws ParseException {
    final int pageIndex = 1;
    final int pageSize = 5;
    Page<Movie> page = new PageImpl<>(movies);
    Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
    Mockito.when(movieRepository.findAll(pageable)).thenReturn(page);
    Page<Movie> actual = movieService.findAll(pageIndex, pageSize);
    assertEquals(page, actual);

  }

  /**
   * Test find all with searchData = "".
   *
   */
  @Test
  void testSearchAll3() {
    // Init: Test input
    final int pageIndex = 1;
    final int pageSize = 5;
    Page<Movie> page = new PageImpl<>(movies);
    String searchData = "";
    Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
    Mockito.when(movieRepository.searchText("%%", pageable)).thenReturn(page);
    Page<Movie> actual = movieService.searchAll(searchData, pageIndex,
        pageSize);
    assertEquals(page, actual);

  }

  /**
   * Test save movie normal case
   *
   * @throws ParseException the parse exception
   */
  @Test
  void testSave() throws ParseException {
    Movie movie = new Movie();
    movie.setMovieId("Movie");
    movie.setActor("Duy Khanh");
    movie.setDuration((double) 111);
    movie.setDirector("Duy Khanh");
    movie.setContent("aaaa");
    movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
    movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
    movie.setReleaseDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
    movie.setLargeImage("a.png");
    movie.setMovieNameEnglish("ENG");
    movie.setMovieNameVn("VN");
    movie.setMovieProductCompany("Marvel");
    Mockito.when(movieRepository.save(movie)).thenReturn(movie);
    boolean actual = movieService.saveMovie(movie);
    assertTrue(actual);

  }

  /**
   * Test save null movie
   *
   * 
   */
  @Test
  void testSave2() {
    Movie movie = null;
    Mockito.when(movieRepository.save(movie)).thenReturn(movie);
    boolean actual = movieService.saveMovie(movie);
    assertFalse(actual);

  }
  /**
   *  Abnormal case: fail constraint;
   */
  @Test
  void testSave3() throws ParseException {
    Movie movie = new Movie();
    movie.setMovieId("Movie");
    movie.setActor("Duy Khanh");
    movie.setDuration((double) 111);
    movie.setDirector("Duy Khanh");
    movie.setContent("aaaa");
    movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
    movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
    movie.setReleaseDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
    movie.setLargeImage("a.png");
    movie.setMovieNameEnglish("ENG");
    movie.setMovieNameVn("VN");
    movie.setMovieProductCompany("Marvel");
    for (Type type : types) {
      movieTypes.add(new MovieType(new MovieTypeId(movie.getMovieId(),type.getTypeId()), movie,type));
    }
    movie.setMovieTypes(movieTypes);
    Mockito.when(movieRepository.deleteMovieDate(movie)).thenReturn(5);
    Mockito.when(movieRepository.deleteMovieSchedule(movie)).thenReturn(5);
    Mockito.when(movieRepository.deleteMovieType(movie)).thenReturn(5);
    Mockito.when(movieRepository.save(movie)).thenThrow(ConstraintViolationException.class);
    Mockito.when(movieRepository.findMovieTypeByMovie(movie)).thenReturn(movieTypes);
    assertFalse(movieService.saveMovie(movie));
    assertEquals(movieTypes, movieRepository.findMovieTypeByMovie(movie));
  }

  /**
   * Test delete with exist id
   */
  @Test
  void testDelete() {
    Mockito.when(movieRepository.existsById("0")).thenReturn(true);
    boolean actual = movieService.deleteMovie("0");
    assertTrue(actual);

  }

  /**
   * Test delete with not exist id
   */
  @Test
  void testDelete2() {
    Mockito.when(movieRepository.existsById("0")).thenReturn(false);
    boolean actual = movieService.deleteMovie("0");
    assertFalse(actual);

  }

}
