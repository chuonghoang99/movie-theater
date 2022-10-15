package fa.appcode.web.entities;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "schedule",schema = "movie_theater")
public class Schedule {
	@Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;
    
    @Column(name = "schedule_time", columnDefinition = "VARCHAR(255)")
    private String scheduleTime;
    
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private Set<MovieSchedule> movieSchedules;

	@Override
	public int hashCode() {
		return Objects.hash(scheduleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(scheduleId, other.scheduleId);
	}

	public Schedule(Integer scheduleId, String scheduleTime) {
		super();
		this.scheduleId = scheduleId;
		this.scheduleTime = scheduleTime;
	}
}
