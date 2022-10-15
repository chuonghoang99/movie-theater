package fa.appcode.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.common.utils.Constants;
import fa.appcode.common.utils.DateUtils;
import fa.appcode.config.PageConfig;
import fa.appcode.repositories.ShowtimesRepository;
import fa.appcode.services.ShowtimesService;
import fa.appcode.specification.ShowDateSpecification;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.ShowDates;
import fa.appcode.web.vo.PageVo;

/**
 * The Class ShowtimesServiceImpl.
 */
@Service
public class ShowtimesServiceImpl implements ShowtimesService {

	@Autowired
	private ShowtimesRepository showTimesRepository;

	@Autowired
	private ShowDateSpecification showDateSpecification;

	@Autowired
	PageConfig pageConfig;

	/**
	 * Gets the show date list with current date.
	 *
	 * @param date the date
	 * @return the show date list from current date to next 6 days.
	 */
	@Override
	public List<LocalDate> getShowDateList(String date) {
		LocalDate startDate = null;
		if (date == null || Constants.DEFAULT_WORD.equals(date)) {
			startDate = LocalDate.now();
		} else {
			startDate = LocalDate.parse(date);
		}
		return startDate.datesUntil(startDate.plusDays(6)).collect(Collectors.toList());
	}

	/**
	 * Find movie time by selected date.
	 *
	 * @param date the date
	 * @param pageIndex the page index
	 * @param pageSize the page size
	 * @return the page vo
	 */
	@Override
	public PageVo<MovieDate> findMovieTimeByDate(String date, Integer pageIndex, Integer pageSize) {

		if (pageIndex == null) {
			pageIndex = pageConfig.getInitPage();
		}

		List<ShowDates> showDates = null;

		if (date == null || Constants.DEFAULT_WORD.equals(date)) {
			date = LocalDate.now().toString();
		}
		showDates = showTimesRepository
				.findAll(showDateSpecification.getListByDate(DateUtils.convertToDate(LocalDate.parse(date))));

		showDates = showDates.stream().distinct().collect(Collectors.toList());

		if (showDates.size() == 0) {
			return null;
		}

		List<MovieDate> movieDates = new ArrayList<MovieDate>();

		for (ShowDates showDate : showDates) {
			movieDates.addAll(showDate.getMovieDates());
		}

		PageVo<MovieDate> pages = new PageVo<MovieDate>();

		pages.setTotalPage(movieDates.size() % pageSize == 0 ? (movieDates.size() / pageSize)
				: (movieDates.size() / pageSize + 1));

		pages.setPageIndex(pageIndex);
		movieDates = movieDates.stream().skip((long) (pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
		pages.setContent(movieDates);
		return pages;
	}

	@Override
	public List<MovieDate> findAllMovieNextWeek() {
		return null;
	}

}
