package fa.appcode.web.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class MoviDateId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "movie_id")
	private String movieId;
	@Column(name = "show_date_id")
	private Integer showDateId;
	@Override
	public int hashCode() {
		return Objects.hash(movieId, showDateId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoviDateId other = (MoviDateId) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(showDateId, other.showDateId);
	}
}
