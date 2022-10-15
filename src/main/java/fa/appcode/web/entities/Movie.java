package fa.appcode.web.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "movie", schema = "movie_theater")
public class Movie {
	@Id
	@Column(name = "movie_id", columnDefinition = "NVARCHAR(10)")
	@GenericGenerator(name = "sequence_string_id", strategy = "fa.appcode.common.utils.StringGenerator")
	@GeneratedValue(generator = "sequence_string_id")
	private String movieId;

	@Column(name = "actor", columnDefinition = "NVARCHAR(255)")
	@NotEmpty(message = "{movie.actor.empty}")
	private String actor;

	@Column(name = "content", columnDefinition = "NVARCHAR(1000)")
	@NotEmpty(message = "{movie.content.empty}")
	private String content;

	@Column(name = "director", columnDefinition = "NVARCHAR(255)")
	@NotEmpty(message = "{movie.director.empty}")
	private String director;

	@Column(name = "duration")
	@NotNull(message = "{movie.duration.empty}")
	private Double duration;

	@Column(name = "from_date", columnDefinition = "DATETIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "{movie.fromDate.empty}")
	private Date fromDate;

	@Column(name = "movie_product_company", columnDefinition = "NVARCHAR(255)")
	@NotEmpty(message = "{movie.productionCompany.empty}")
	private String movieProductCompany;

	@Column(name = "to_date", columnDefinition = "DATETIME")
	@NotNull(message = "{movie.toDate.empty}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;

	@Column(name = "release_date", columnDefinition = "DATETIME")
	private Date releaseDate;

	@Column(name = "version", columnDefinition = "NVARCHAR(255)")
	@NotEmpty(message = "{movie.version.empty}")
	private String version;

	@Column(name = "movie_name_english", columnDefinition = "VARCHAR(255)")
	@NotEmpty(message = "{movie.nameENG.empty}")
	private String movieNameEnglish;

	@Column(name = "movie_name_vn", columnDefinition = "NVARCHAR(255)")
	@NotEmpty(message = "{movie.nameVN.empty}")
	private String movieNameVn;

	@Column(name = "large_image", columnDefinition = "VARCHAR(255)")
	private String largeImage;

	@Column(name = "small_image", columnDefinition = "VARCHAR(255)")
	private String smallImage;

	@ManyToOne
	@JoinColumn(name = "cinema_room_id", referencedColumnName = "cinema_room_id")
	private CinemaRoom cinemaRoom;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieDate> movieDates;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<MovieSchedule> movieSchedules;

	@OneToMany(mappedBy = "movie",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovieType> movieTypes;

	@Override
	public int hashCode() {
		return Objects.hash(movieId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(movieId, other.movieId);
	}

  public Movie(String movieId,
      @NotEmpty(message = "{movie.actor.empty}") String actor,
      @NotEmpty(message = "{movie.nameVN.empty}") String movieNameVn,
      CinemaRoom cinemaRoom) {
    super();
    this.movieId = movieId;
    this.actor = actor;
    this.movieNameVn = movieNameVn;
    this.cinemaRoom = cinemaRoom;
  }
}
