package fa.appcode.web.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class MovieTypeId implements Serializable {
  private static final long serialVersionUID = 1L;
  @Column(name = "movie_id")
	private String movieId;
	@Column(name = "type_id")
	private Integer typeId;
	@Override
	public int hashCode() {
		return Objects.hash(movieId, typeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieTypeId other = (MovieTypeId) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(typeId, other.typeId);
	}
}
