package fa.appcode.specification;

import java.util.Date;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.entities.MovieSchedule;
import fa.appcode.web.entities.Schedule;
import fa.appcode.web.entities.ShowDates;

@Component
public class ShowDateSpecification {
	public Specification<ShowDates> getListByDate(Date date) {
		return (root, query, builder) -> {
			Join<ShowDates, MovieDate> joinMovieDate = root.join("movieDates", JoinType.INNER);
			Join<MovieDate, Movie> joinShowDate = joinMovieDate.join("movie", JoinType.INNER);
			Join<Movie, MovieSchedule> joinMovieSchedule = joinShowDate.join("movieSchedules", JoinType.INNER);
			@SuppressWarnings("unused")
			Join<MovieSchedule, Schedule> joinSchedule = joinMovieSchedule.join("schedule", JoinType.INNER);
			return builder.equal(root.get("showDate"), date);
		};
	}
}
