package fa.appcode.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.vo.PageVo;

public interface ShowtimesService {
	List<LocalDate> getShowDateList(String date);
	
	PageVo<MovieDate> findMovieTimeByDate(String date, Integer pageIndex, Integer pageSize);

	List<MovieDate> findAllMovieNextWeek();


}
