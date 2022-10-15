package fa.appcode.web.entities;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "movie_type",schema = "movie_theater")
public class MovieType {
	@EmbeddedId
	private MovieTypeId movieTypeId;

	@MapsId(value = "movieId")
	@ManyToOne
	private Movie movie;
	@MapsId(value = "typeId")
	@ManyToOne
	private Type type;

	@Override
	public int hashCode() {
		return Objects.hash(movie, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieType other = (MovieType) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(type, other.type);
	}

  public MovieType(Movie movie, Type type) {
    super();
    this.movie = movie;
    this.type = type;
  }

}
