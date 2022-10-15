/*
 * @author: ChuongHV1
 * @date: Nov 24, 2021
 */
package fa.appcode.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "employee", schema = "movie_theater")
//@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Employee {

	@Id
	@GenericGenerator(name = "sequence_string_id", strategy = "fa.appcode.common.utils.StringGenerator")
	@GeneratedValue(generator = "sequence_string_id")
	@Column(name = "employee_id", columnDefinition = "VARCHAR(10)")
	private String employeeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId='" + employeeId + '\'' +
				", account=" + account.toString()+
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(employeeId, employee.employeeId);
	}


}
