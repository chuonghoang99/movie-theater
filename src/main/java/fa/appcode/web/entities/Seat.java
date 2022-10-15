package fa.appcode.web.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "seat",schema = "movie_theater")
public class Seat {
	@Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    
    @Column(name = "seat_column", columnDefinition = "VARCHAR(255)")
    private String seatColumn;
    
    @Column(name = "seat_row")
    private Integer seatRow;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "seat_type")
    private Integer seatType;
    
    @Column(name = "seat_price")
    private Double price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "cinema_room_id", referencedColumnName = "cinema_room_id")
    private CinemaRoom cinemaRoom;

	public Seat(Integer seatId, Integer status) {
		super();
		this.seatId = seatId;
		this.status = status;
	}
}
