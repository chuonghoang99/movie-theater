/*
 *
 * @author: ChuongHV1
 * @date: Nov 27, 2021
 */

package fa.appcode.web.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVo {
    private String employeeId;

    private String accountId;

    private String address;

    private Date dateOfBirth;

    private String email;

    private String fullName;

    private String gender;

    private String identityCard;

    private String image;

    private String password;

    private String phoneNumber;

    private Date registerDate;

    private Integer status;

    private String userName;

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "employeeId='" + employeeId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", image='" + image + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", registerDate=" + registerDate +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }
}
