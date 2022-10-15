package fa.appcode.web.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "movie_date", schema = "movie_theater")
public class MovieDate  {
	@EmbeddedId
	private MoviDateId movieDateId;

	@MapsId(value = "movieId")
	@ManyToOne
	private Movie movie;

	@MapsId(value = "showDateId")
	@ManyToOne
	private ShowDates showDates;

	@Override
	public int hashCode() {
		return Objects.hash(movie, showDates);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDate other = (MovieDate) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(showDates, other.showDates);
	}

  public MovieDate(Movie movie, ShowDates showDates) {
    super();
    this.movie = movie;
    this.showDates = showDates;
  }
	
}
