package fa.appcode.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import fa.appcode.config.PageConfig;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.MovieService;
import fa.appcode.services.ScheduleService;
import fa.appcode.services.ShowDatesService;
import fa.appcode.services.TypeService;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.MoviDateId;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.MovieSchedule;
import fa.appcode.web.entities.MovieScheduleId;
import fa.appcode.web.entities.MovieType;
import fa.appcode.web.entities.MovieTypeId;
import fa.appcode.web.entities.Schedule;
import fa.appcode.web.entities.ShowDates;
import fa.appcode.web.entities.Type;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

	/** The movie service. */
	@MockBean
	MovieService movieService;

	/** The type service. */
	@MockBean
	TypeService typeService;

	/** The schedule service. */
	@MockBean
	ScheduleService scheduleService;

	/** The cinema room service. */
	@MockBean
	CinemaRoomService cinemaRoomService;

	/** The show dates service. */
	@MockBean
	ShowDatesService showDatesService;

	/** The page config. */
	@Autowired
	private PageConfig pageConfig;

	/** The movie controller. */
	@InjectMocks
	MovieController movieController;

	/** The mock mvc. */
	@Autowired
	MockMvc mockMvc;

	/** The movies. */
	static List<Movie> movies = new ArrayList<Movie>();

	/** The types. */
	static List<Type> types = new ArrayList<Type>();

	/** The schedules. */
	static List<Schedule> schedules = new ArrayList<Schedule>();

	/** The cinema rooms. */
	static List<CinemaRoom> cinemaRooms = new ArrayList<CinemaRoom>();

	/** The movie types. */
	static List<MovieType> movieTypes = new ArrayList<MovieType>();

	/** The movie schedules. */
	static List<MovieSchedule> movieSchedules = new ArrayList<MovieSchedule>();

	/** The show dates. */
	static List<ShowDates> showDates = new ArrayList<ShowDates>();

	/** The movie dates. */
	static List<MovieDate> movieDates = new ArrayList<MovieDate>();

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < 5; i++) {
			Movie movie = new Movie();
			movie.setMovieId("Movie" + i);
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
			movies.add(movie);
		}
		for (int i = 0; i < 5; i++) {
			types.add(new Type(i, "Type" + i));
			schedules.add(new Schedule(i, "Schudule" + i));
			cinemaRooms.add(new CinemaRoom(i, "Room " + i));
			showDates.add(new ShowDates(i));
		}

	}


	/**
	 * Test list movie.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testListMovie() throws Exception {
		final Integer pageSize = 5;
		final Integer pageIndex = 1;
		Page<Movie> page = new PageImpl<>(movies);
		Mockito.when(movieService.findAll(pageIndex, pageSize)).thenReturn(page);
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/movie/list").param("pageIndex", "1"))
				.andExpect(MockMvcResultMatchers.view().name("movie/list-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("movies", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex));

	}

	/**
	 * Test search with normal search.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchMovie() throws Exception {
		final Integer pageSize = 5;
		final Integer pageIndex = 1;
		Page<Movie> page = new PageImpl<>(movies);
		Mockito.when(movieService.searchAll("2021-12-11", pageIndex, pageSize)).thenReturn(page);
		mockMvc.perform(
						MockMvcRequestBuilders.get("/admin/movie/search").param("pageIndex", "1").param("searchData", "2021-12-11"))
				.andExpect(MockMvcResultMatchers.view().name("movie/list-table-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("movies", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex));
	}

	/**
	 * Test search with search data = date.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchMovie2() throws Exception {
		final Integer pageSize = 5;
		final Integer pageIndex = 1;
		Page<Movie> page = new PageImpl<>(movies);
		Mockito.when(movieService.searchAll("a", pageIndex, pageSize)).thenReturn(page);
		mockMvc.perform(
						MockMvcRequestBuilders.get("/admin/movie/search").param("pageIndex", "1").param("searchData", "a"))
				.andExpect(MockMvcResultMatchers.view().name("movie/list-table-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("movies", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex));
	}

	/**
	 * Test search with searchData = "".
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSearchMovie3() throws Exception {
		final Integer pageSize = 5;
		final Integer pageIndex = 1;
		Page<Movie> page = new PageImpl<>(movies);
		Mockito.when(movieService.searchAll("a", pageIndex, pageSize)).thenReturn(page);
		Mockito.when(movieService.findAll(pageIndex, pageSize)).thenReturn(page);
		mockMvc.perform(
						MockMvcRequestBuilders.get("/admin/movie/search").param("pageIndex", "1").param("searchData", ""))
				.andExpect(MockMvcResultMatchers.view().name("movie/list-table-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("movies", page.toList()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("numOfPages", page.getTotalPages()))
				.andExpect(MockMvcResultMatchers.model().attribute("currentPage", pageIndex));
	}

	/**
	 * Test show add movie.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testShowAddMovie() throws Exception {
		Mockito.when(typeService.findAll()).thenReturn(types);
		Mockito.when(scheduleService.findAll()).thenReturn(schedules);
		Mockito.when(cinemaRoomService.findAll()).thenReturn(cinemaRooms);
		mockMvc.perform(
						MockMvcRequestBuilders.get("/admin/movie/add-movie").param("pageIndex", "1").param("searchData", "a"))
				.andExpect(MockMvcResultMatchers.view().name("movie/detail-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("types", types))
				.andExpect(MockMvcResultMatchers.model().attribute("schedules", schedules))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRooms", cinemaRooms));
	}
	/**
	 * Test show add movie(edit)
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testShowAddMovie2() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId("movieId");
		movie.setActor("Duy Khanh");
		movie.setDuration((double) 111);
		movie.setDirector("Duy Khanh");
		movie.setContent("aaaa");
		movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
		movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setReleaseDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setMovieNameEnglish("ENG");
		movie.setMovieNameVn("VN");
		movie.setMovieProductCompany("Marvel");
		movie.setCinemaRoom(cinemaRooms.get(0));
		movie.setVersion("2D,3D");
		for (Type type : types) {
			movieTypes.add(new MovieType(new MovieTypeId(movie.getMovieId(),type.getTypeId()), movie,type));

			Mockito.when(typeService.getById(type.getTypeId())).thenReturn(type);
		}
		for (Schedule schedule : schedules) {
			movieSchedules.add(new MovieSchedule(new MovieScheduleId(movie.getMovieId(),schedule.getScheduleId()),movie, schedule));
			Mockito.when(scheduleService.getById(schedule.getScheduleId())).thenReturn(schedule);
		}
		for (ShowDates showDate : showDates) {
			movieDates.add(new MovieDate(new MoviDateId(movie.getMovieId(),showDate.getShowDateId()),movie, showDate));
		}
		movie.setMovieDates(movieDates);
		movie.setMovieTypes(movieTypes);
		movie.setMovieSchedules(movieSchedules);
		List<Integer> typeIds = new ArrayList<Integer>();
		List<Integer> scheludeIds = new ArrayList<Integer>();
		for (MovieType movieType : movie.getMovieTypes()) {
			typeIds.add(movieType.getType().getTypeId());
		}
		for (MovieSchedule movieSchedule : movie.getMovieSchedules()) {
			scheludeIds.add(movieSchedule.getSchedule().getScheduleId());
		}
		Mockito.when(movieService.getById("movieId")).thenReturn(movie);
		Mockito.when(typeService.findAll()).thenReturn(types);
		Mockito.when(scheduleService.findAll()).thenReturn(schedules);
		Mockito.when(cinemaRoomService.findAll()).thenReturn(cinemaRooms);
		mockMvc.perform(
						MockMvcRequestBuilders.get("/admin/movie/add-movie").param("movieId", "movieId"))
				.andExpect(MockMvcResultMatchers.view().name("movie/detail-movie"))
				.andExpect(MockMvcResultMatchers.model().attribute("movie", movie))
				.andExpect(MockMvcResultMatchers.model().attribute("scheduleIdss", scheludeIds))
				.andExpect(MockMvcResultMatchers.model().attribute("typeIdss", typeIds))
				.andExpect(MockMvcResultMatchers.model().attribute("types", types))
				.andExpect(MockMvcResultMatchers.model().attribute("schedules", schedules))
				.andExpect(MockMvcResultMatchers.model().attribute("cinemaRooms", cinemaRooms));
	}

	/**
	 * Test save movie normal case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSaveMovie1() throws Exception {
		Movie movie = new Movie();
		movie.setActor("Duy Khanh");
		movie.setDuration((double) 111);
		movie.setDirector("Duy Khanh");
		movie.setContent("aaaa");
		movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
		movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setReleaseDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setMovieNameEnglish("ENG");
		movie.setMovieNameVn("VN");
		movie.setMovieProductCompany("Marvel");
		movie.setCinemaRoom(cinemaRooms.get(0));
		movie.setVersion("2D,3D");
		StringBuilder typeIdsString = new StringBuilder();
		StringBuilder scheduleIdsString = new StringBuilder();
		String prefix = "";
		for (Type type : types) {
			movieTypes.add(new MovieType(new MovieTypeId(movie.getMovieId(),type.getTypeId()), movie,type));
			typeIdsString.append(prefix);
			typeIdsString.append(",");
			typeIdsString.append(type.getTypeId());
			Mockito.when(typeService.getById(type.getTypeId())).thenReturn(type);
		}
		prefix = "";
		for (Schedule schedule : schedules) {
			movieSchedules.add(new MovieSchedule(new MovieScheduleId(movie.getMovieId(),schedule.getScheduleId()),movie, schedule));
			scheduleIdsString.append(prefix);
			scheduleIdsString.append(",");
			scheduleIdsString.append(schedule.getScheduleId());
			Mockito.when(scheduleService.getById(schedule.getScheduleId())).thenReturn(schedule);
		}
		for (ShowDates showDate : showDates) {
			movieDates.add(new MovieDate(new MoviDateId(movie.getMovieId(),showDate.getShowDateId()),movie, showDate));
		}
		Path path = Paths.get("src/test/resources/Test image01.jpg");
		String name = "Test image01.jpg";
		String originalFileName = "Test image01.jpg";
		String contentType = "image";
		byte[] content = null;
		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
		}
		MultipartFile movieImage = new MockMultipartFile(name, originalFileName, contentType, content);
		movie.setMovieDates(movieDates);
		movie.setMovieTypes(movieTypes);
		movie.setMovieSchedules(movieSchedules);
		Mockito.when(cinemaRoomService.findById("0")).thenReturn(cinemaRooms.get(0));
		Mockito.when(showDatesService.findByFromDateAndToDate(movie.getFromDate(), movie.getToDate()))
				.thenReturn(showDates);
		Mockito.when(movieService.saveMovie(movie)).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.multipart("/admin/movie/save-movie")
						.file((MockMultipartFile) movieImage)
						.param("movieId", "")
						.param("version", movie.getVersion()).param("actor", movie.getActor())
						.param("duration", movie.getDuration().toString()).param("director", movie.getDirector())
						.param("content", movie.getContent()).param("fromDate", "2021-11-11").param("toDate", "2021-12-11")
						.param("movieNameEnglish", movie.getMovieNameEnglish()).param("movieNameVn", movie.getMovieNameVn())
						.param("movieProductCompany", movie.getMovieProductCompany()).param("typeIds", typeIdsString.toString())
						.param("scheduleIds", scheduleIdsString.toString())
						.param("cinemaRoom", movie.getCinemaRoom().getCinemaRoomId().toString()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.messageSuccess").value(pageConfig.getSaveSuccess()));

	}

	/**
	 * Test save with fail validate.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testSaveMovie2() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId("Movie");
		movie.setActor("Duy Khanh");
		movie.setDuration((double) 111);
		movie.setDirector("Duy Khanh");
		movie.setContent("aaaa");
		movie.setFromDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-11-11"));
		movie.setToDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setReleaseDate(new SimpleDateFormat("yyy-MM-dd").parse("2021-12-11"));
		movie.setMovieNameEnglish("ENG");
		movie.setMovieNameVn("VN");
		movie.setMovieProductCompany("Marvel");
		movie.setCinemaRoom(cinemaRooms.get(0));
		StringBuilder typeIdsString = new StringBuilder();
		StringBuilder scheduleIdsString = new StringBuilder();
		String prefix = "";
		for (Type type : types) {
			movieTypes.add(new MovieType(new MovieTypeId(movie.getMovieId(),type.getTypeId()), movie,type));
			typeIdsString.append(prefix);
			typeIdsString.append(",");
			typeIdsString.append(type.getTypeId());
			Mockito.when(typeService.getById(type.getTypeId())).thenReturn(type);
		}
		prefix = "";
		for (Schedule schedule : schedules) {
			movieSchedules.add(new MovieSchedule(new MovieScheduleId(movie.getMovieId(),schedule.getScheduleId()),movie, schedule));
			scheduleIdsString.append(prefix);
			scheduleIdsString.append(",");
			scheduleIdsString.append(schedule.getScheduleId());
			Mockito.when(scheduleService.getById(schedule.getScheduleId())).thenReturn(schedule);
		}
		for (ShowDates showDate : showDates) {
			movieDates.add(new MovieDate(new MoviDateId(movie.getMovieId(),showDate.getShowDateId()),movie, showDate));
		}
		movie.setMovieDates(movieDates);
		movie.setMovieTypes(movieTypes);
		movie.setMovieSchedules(movieSchedules);
		Mockito.when(cinemaRoomService.findById("0")).thenReturn(cinemaRooms.get(0));
		Mockito.when(showDatesService.findByFromDateAndToDate(movie.getFromDate(), movie.getToDate()))
				.thenReturn(showDates);
		Mockito.when(movieService.saveMovie(movie)).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.post("/admin/movie/save-movie")
						.param("movieId", "")
						.param("actor", movie.getActor())
						.param("duration", movie.getDuration().toString())
						.param("director", movie.getDirector()).param("content", movie.getContent())
						.param("fromDate", "2021-11-11").param("toDate", "2021-12-11")
						.param("movieNameEngLish", movie.getMovieNameEnglish()).param("movieNameVn", movie.getMovieNameVn())
						.param("movieProductCompany", movie.getMovieProductCompany()).param("typeIds", typeIdsString.toString())
						.param("scheduleIds", scheduleIdsString.toString())
						.param("cinemaRoom", movie.getCinemaRoom().getCinemaRoomId().toString()))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(jsonPath("$.version").value("Version is required"));

	}

	/**
	 * Test delete success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testDeleteMovie() throws Exception {
		Mockito.when(movieService.deleteMovie("movieId")).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.delete("/admin/movie/delete/movieId"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string("Delete Movie Success"));

	}

	/**
	 * Test delete fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@WithMockUser(roles = "ADMIN", username = "admin")
	void testDeleteMovie2() throws Exception {
		Mockito.when(movieService.deleteMovie("movieId")).thenReturn(false);
		mockMvc.perform(MockMvcRequestBuilders.delete("/admin/movie/delete/movieId"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(content().string("Delete Movie Fail"));

	}

}
