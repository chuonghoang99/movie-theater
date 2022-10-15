package fa.appcode.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ticket",schema = "movie_theater")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Integer ticketId;
	
	@Column(name = "price", columnDefinition = "MONEY")
	private Double price;
	
	@Column(name = "ticket_type")
	private Integer ticketType;

	public Ticket(Double price, Integer ticketType) {
		super();
		this.price = price;
		this.ticketType = ticketType;
	}
}

