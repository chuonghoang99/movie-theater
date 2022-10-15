/*
 * @author: ChuongHV1
 * @date: Nov 24, 2021
 */
package fa.appcode.web.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "invoice", schema = "movie_theater")
public class Invoice {

	@Id
	@GenericGenerator(name = "sequence_string_id", strategy = "fa.appcode.common.utils.StringGenerator")
	@GeneratedValue(generator = "sequence_string_id")
	@Column(name = "invoice_id", columnDefinition = "VARCHAR(10)")
	private String invoiceId;

	@Column(name = "add_score", columnDefinition = "MONEY")
	private Double addScore;

	@Column(name = "booking_date", columnDefinition = "DATETIME")
	private Date bookingDate;
	
	@Column(name = "movie_name", columnDefinition = "NVARCHAR(255)")
	private String movieName;
	
	@Column(name = "schedule_show", columnDefinition = "DATETIME")
	private Date scheduleShow;
	
	@Column(name = "schedule_show_time", columnDefinition = "NVARCHAR(255)")
	private String scheduleShowTime;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "total_money", columnDefinition = "MONEY")
	private Double totalMoney;
	
	@Column(name = "use_score", columnDefinition = "MONEY")
	private Double useScore;
	
	@Column(name = "seat", columnDefinition = "NVARCHAR(255)")
	private String seat;
	
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<ScheduleSeat> scheduleSeats;

}
