/*
 * @author: ChuongHV1
 * @date: Nov 24, 2021
 */
package fa.appcode.web.entities;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "account", schema = "movie_theater")
public class Account {

    @Id
    @GenericGenerator(name = "sequence_string_id", strategy = "fa.appcode.common.utils.StringGenerator")
    @GeneratedValue(generator = "sequence_string_id")
    @Column(name = "account_id", columnDefinition = "VARCHAR(10)")
    private String accountId;

    @Column(name = "address")
    @NotEmpty(message = "{account.address.empty}")
    private String address;

    @Column(name = "date_of_birth", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd" , timezone="UTC")
    private Date dateOfBirth;

    @Column(name = "email")
    @NotEmpty(message = "{account.email.empty}")
    private String email;

    @Column(name = "full_name")
    @NotEmpty(message = "{account.fullName.empty}")
    private String fullName;

    @Column(name = "gender")
    @NotEmpty(message = "{account.gender.empty}")
    @Pattern(regexp = "M|F", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String gender;

    @Column(name = "identity_card",unique = true)
    @NotEmpty(message = "{account.identityCard.empty}")
    private String identityCard;

    @Column(name = "image")
    private String image;

    @Column(name = "password")
    @NotEmpty(message = "{account.password.empty}")
    private String password;

    @Column(name = "phone_number")
    @NotEmpty(message = "{account.phoneNumber.empty}")
    private String phoneNumber;

    @Column(name = "register_date", columnDefinition = "DATETIME")
    private Date registerDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "username", unique = true, nullable = false)
    @NotEmpty(message = "{account.userName.empty}")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "account")
    @JsonBackReference // no query on api
    private Set<Invoice> invoices;

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", email="
                + email + ", fullName=" + fullName + ", gender=" + gender + ", identityCard=" + identityCard
                + ", image=" + image + ", password=" + password + ", phoneNumber=" + phoneNumber + ", registerDate="
                + registerDate + ", status=" + status + ", userName=" + userName + "]";
    }

    public Account(String accountId, String address, Date dateOfBirth, String email, String fullName, String gender, String identityCard, String image, String password, String phoneNumber, Date registerDate, Integer status, String userName) {
        this.accountId = accountId;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.identityCard = identityCard;
        this.image = image;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.status = status;
        this.userName = userName;
    }

	public Account(String accountId, @NotEmpty(message = "{account.fullName.empty}") String fullName,
			@NotEmpty(message = "{account.identityCard.empty}") String identityCard) {
		super();
		this.accountId = accountId;
		this.fullName = fullName;
		this.identityCard = identityCard;
	}
    
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId.equals(account.accountId)
                && address.equals(account.address)
                && Objects.equals(email, account.email)
                && Objects.equals(fullName, account.fullName)
                && Objects.equals(gender, account.gender)
                && Objects.equals(identityCard, account.identityCard)
                && Objects.equals(image, account.image)
                && Objects.equals(phoneNumber, account.phoneNumber)

                && Objects.equals(status, account.status)
                && Objects.equals(userName, account.userName)
                && Objects.equals(roles, account.roles)
                && Objects.equals(invoices, account.invoices);
    }

}
