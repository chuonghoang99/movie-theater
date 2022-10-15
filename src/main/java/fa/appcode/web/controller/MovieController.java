package fa.appcode.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fa.appcode.common.utils.Constants;
import fa.appcode.config.PageConfig;
import fa.appcode.repositories.MovieRepository;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.services.MovieService;
import fa.appcode.services.ScheduleService;
import fa.appcode.services.ShowDatesService;
import fa.appcode.services.StorageService;
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

@Controller
@RequestMapping("/admin/movie")
@PropertySources(@PropertySource({ "classpath:messages.properties", "classpath:webConfig.properties" }))
public class MovieController {

	@Autowired
	private PageConfig pageConfig;

	@Autowired
	MovieService movieServices;
	@Autowired
	CinemaRoomService cinemaRoomService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	TypeService typeService;
	@Autowired
	ShowDatesService showDatesService;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	private StorageService storageService;
	@GetMapping("/list")
	public String listMovie(Model model, @RequestParam(value = "pageIndex", required = false) String pageIndex) {

		int pageIndexVal = pageConfig.getInitPage();
		if (pageIndex != null) {
			pageIndexVal = Integer.parseInt(pageIndex);
		}
		Page<Movie> page;
		page = movieServices.findAll(pageIndexVal, pageConfig.getSizePage());

		model.addAttribute("movies", page.toList());
		model.addAttribute("numOfPages", page.getTotalPages());
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("currentPage", pageIndexVal);

		return "movie/list-movie";
	}

	@GetMapping("/search")
	public String searchMovie(Model model, @RequestParam(value = "pageIndex", required = false) String pageIndex,
							  @RequestParam(defaultValue = Constants.DEFAULT_WORD, name = "searchData") String searchData) {
		int pageIndexVal = pageConfig.getInitPage();

		if (pageIndex != null) {
			pageIndexVal = Integer.parseInt(pageIndex);
		}

		Page<Movie> page;
		if (Constants.DEFAULT_WORD.equals(searchData)) {
			page = movieServices.findAll(pageIndexVal, pageConfig.getSizePage());
		} else {
			page = movieServices.searchAll(searchData, pageIndexVal, pageConfig.getSizePage());
		}

		model.addAttribute("movies", page.toList());
		model.addAttribute("numOfPages", page.getTotalPages());
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("currentPage", pageIndexVal);

		return "movie/list-table-movie";
	}

	/**
	 * Show detail movie screen
	 *
	 */
	@GetMapping("/add-movie")
	public String showMovieDetail(@RequestParam(name = "movieId", required = false) String movieId, Model model) {
		if (movieId != null) {
			Movie movie = movieServices.getById(movieId);
			List<Integer> typeIds = new ArrayList<Integer>();
			List<Integer> scheludeIds = new ArrayList<Integer>();
			for (MovieType movieType : movie.getMovieTypes()) {
				typeIds.add(movieType.getType().getTypeId());
			}
			for (MovieSchedule movieSchedule : movie.getMovieSchedules()) {
				scheludeIds.add(movieSchedule.getSchedule().getScheduleId());
			}
			model.addAttribute("movie", movie);
			model.addAttribute("scheduleIdss", scheludeIds);
			model.addAttribute("typeIdss", typeIds);
		}
		List<Type> types = typeService.findAll();
		List<Schedule> schedules = scheduleService.findAll();
		List<CinemaRoom> cinemaRooms = cinemaRoomService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("schedules", schedules);
		model.addAttribute("cinemaRooms", cinemaRooms);
		return "movie/detail-movie";
	}

	@DeleteMapping("delete/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable(name = "movieId") String movieId) {
		if (movieServices.deleteMovie(movieId)) {
			return new ResponseEntity<String>(pageConfig.getDeleteMovieSuccess(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(pageConfig.getDeleteMovieFail(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Save movie.
	 *
	 */
	@ResponseBody
	@PostMapping("/save-movie")
	public ResponseEntity<Map<String, String>> saveMovie(@Valid Movie movie, BindingResult result,
														 @RequestParam String cinemaRoom, @RequestParam List<Integer> typeIds,
														 @RequestParam List<Integer> scheduleIds,
														 @RequestParam(name = "movieImage", required = false) MultipartFile movieImage) throws IOException {
		if (result.hasErrors() || (typeIds.size() == 0) || (scheduleIds.size() == 0)
				|| (movie.getFromDate().after(movie.getToDate()))) {

			Map<String, String> errortList = new HashMap<>();

			if (typeIds.size() == 0) {
				errortList.put("types", pageConfig.getEmtyType());
			}
			if (scheduleIds.size() == 0) {
				errortList.put("schedules", pageConfig.getScheduleEmpty());
			}
			if ((movie.getFromDate() != null && movie.getToDate() != null)
					&& (movie.getFromDate().after(movie.getToDate()))) {
				errortList.put("toDate", pageConfig.getDateNotCorrect());
			}
			if (result.hasErrors()) {
				List<FieldError> fieldErrors = result.getFieldErrors();
				for (FieldError fieldError : fieldErrors) {

					errortList.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
			}

			return new ResponseEntity<Map<String, String>>(errortList, HttpStatus.BAD_REQUEST);

		} else {
			Map<String, String> messageToDisplay = new HashMap<String, String>();
			if (Constants.DEFAULT_WORD.equals(movie.getMovieId())) {
				movie.setReleaseDate(movie.getFromDate());
				movie.setMovieId(null);
			}
			else {
				movie.setReleaseDate(movieServices.getById(movie.getMovieId()).getReleaseDate());
			}
			if (movieImage != null && !movieImage.isEmpty()) {
				try {
					storageService.storeFile(movieImage, Constants.MOVIE_SRC_IMG);
					movie.setLargeImage(Constants.MOVIE_SRC_IMG_2 + movieImage.getOriginalFilename());
				} catch (Exception exception) {
					messageToDisplay.put("messageFailed", exception.getMessage());
					return new ResponseEntity<>(messageToDisplay, HttpStatus.BAD_REQUEST);
				}
			}
			CinemaRoom cinemaRoomtoSave = cinemaRoomService.findById(cinemaRoom);
			List<MovieType> movieTypes = new ArrayList<MovieType>();
			List<MovieSchedule> movieSchedules = new ArrayList<MovieSchedule>();
			List<ShowDates> showDates = showDatesService.findByFromDateAndToDate(movie.getFromDate(),
					movie.getToDate());
			List<MovieDate> movieDates = new ArrayList<MovieDate>();
			for (ShowDates showDate : showDates) {
				movieDates.add(new MovieDate(new MoviDateId(movie.getMovieId(), showDate.getShowDateId()), movie, showDate));
			}
			movie.setMovieDates(movieDates);

			for (Integer typeId : typeIds) {
				movieTypes.add(new MovieType(new MovieTypeId(movie.getMovieId(), typeId), movie, typeService.getById(typeId)));
			}
			for (Integer scheduleId : scheduleIds) {
				movieSchedules.add(new MovieSchedule(new MovieScheduleId(movie.getMovieId(), scheduleId), movie, scheduleService.getById(scheduleId)));
			}
			movie.setCinemaRoom(cinemaRoomtoSave);
			movie.setMovieTypes(movieTypes);
			movie.setMovieSchedules(movieSchedules);
			if (movieServices.saveMovie(movie)) {
				messageToDisplay.put("messageSuccess", pageConfig.getSaveSuccess());
				return new ResponseEntity<Map<String, String>>(messageToDisplay, HttpStatus.OK);

			} else {
				messageToDisplay.put("messageFail", pageConfig.getSaveFail());
				return new ResponseEntity<Map<String, String>>(messageToDisplay, HttpStatus.BAD_REQUEST);

			}

		}
	}
}
