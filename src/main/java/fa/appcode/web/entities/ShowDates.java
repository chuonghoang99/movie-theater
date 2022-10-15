package fa.appcode.web.entities;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "show_dates", schema = "movie_theater")
public class ShowDates {
	@Id
	@Column(name = "show_date_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showDateId;

	@Column(name = "show_date",  columnDefinition = "DATETIME")
	private Date showDate;

	@Column(name = "date_name", columnDefinition = "NVARCHAR(255)")
	private String dateName;
	
	@OneToMany(mappedBy = "showDates")
	Set<MovieDate> movieDates;

	@Override
	public int hashCode() {
		return Objects.hash(showDateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowDates other = (ShowDates) obj;
		return Objects.equals(showDateId, other.showDateId);
	}

	public ShowDates(Integer showDateId, Date showDate, String dateName) {
		super();
		this.showDateId = showDateId;
		this.showDate = showDate;
		this.dateName = dateName;
	}
	public ShowDates(Integer showDateId) {
    super();
    this.showDateId = showDateId;
  }
}
