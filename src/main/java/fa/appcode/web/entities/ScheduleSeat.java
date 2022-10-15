package fa.appcode.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "schedule_seat",schema = "movie_theater")
public class ScheduleSeat {
	
	@Id
	@Column(name = "schedule_seat_id", columnDefinition = "NVARCHAR(10)")
	@GenericGenerator(name = "sequence_string_id", strategy = "fa.appcode.common.utils.StringGenerator")
	@GeneratedValue(generator = "sequence_string_id")
	private String scheduleSeatId;
	
	@Column(name = "movie_id")
	private String movieId;
	
	@Column(name = "schedule_id")
	private Integer scheduleId;
	
	@Column(name = "seat_id")
	private Integer seatId;
	
    @Column(name = "seat_column", columnDefinition = "VARCHAR(255)")
    private String seatColumn;
    
    @Column(name = "seat_row")
    private Integer seatRow;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "seat_type")
    private Integer seatType;
    
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private Invoice invoice;

	public ScheduleSeat(String movieId, Integer scheduleId, Integer seatId, Integer status, Integer seatType) {
		super();
		this.movieId = movieId;
		this.scheduleId = scheduleId;
		this.seatId = seatId;
		this.status = status;
		this.seatType = seatType;
	}

	public ScheduleSeat(String scheduleSeatId, Integer seatId, Integer status) {
		super();
		this.scheduleSeatId = scheduleSeatId;
		this.seatId = seatId;
		this.status = status;
	}
}
