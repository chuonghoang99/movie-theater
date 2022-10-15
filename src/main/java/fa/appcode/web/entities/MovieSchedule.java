package fa.appcode.web.entities;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "movie_schedule",schema = "movie_theater")
public class MovieSchedule  {
	@EmbeddedId
	private MovieScheduleId movieScheduleId;
	@MapsId(value = "movieId")
	@ManyToOne
	private Movie movie;
	@MapsId(value = "scheduleId")
	@ManyToOne
	private Schedule schedule;

	@Override
	public int hashCode() {
		return Objects.hash(movie, schedule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieSchedule other = (MovieSchedule) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(schedule, other.schedule);
	}

  public MovieSchedule(Movie movie, Schedule schedule) {
    super();
    this.movie = movie;
    this.schedule = schedule;
  }
	
}
