/*
 *
 * @author: ChuongHV1
 * @date: Nov 27, 2021
 */

package fa.appcode.repositories;

import fa.appcode.web.entities.Employee;
import fa.appcode.web.vo.EmployeeVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository("employeeRepository")
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT new fa.appcode.web.vo.EmployeeVo"
            + "(e.employeeId, a.accountId, a.address, a.dateOfBirth, a.email, a.fullName, a.gender, a.identityCard, a.image, a.password, a.phoneNumber,a.registerDate, a.status, a.userName  ) "
            + "FROM Employee e JOIN e.account a")
    Page<EmployeeVo> findAllEmployee(Pageable pageable);

    @Query("SELECT new fa.appcode.web.vo.EmployeeVo"
            + "(e.employeeId, a.accountId, a.address, a.dateOfBirth, a.email, a.fullName, a.gender, a.identityCard, a.image, a.password, a.phoneNumber,a.registerDate, a.status, a.userName  ) "
            + "FROM Employee e JOIN e.account a " + "WHERE a.address LIKE %:dataSearch% "
            + "OR a.fullName LIKE %:dataSearch% " + "OR a.email LIKE %:dataSearch% "
            + "OR a.userName LIKE %:dataSearch% " + "OR a.dateOfBirth LIKE %:dataSearch% "
            + "OR a.registerDate LIKE %:dataSearch% " + "OR a.gender LIKE %:dataSearch% "
            + "OR a.phoneNumber LIKE %:dataSearch% " + "OR a.identityCard LIKE %:dataSearch% ")
    Page<EmployeeVo> findAllEmployee(@Param("dataSearch") String dataSearch, Pageable pageable);


    @Query("SELECT new fa.appcode.web.vo.EmployeeVo"
            + "(e.employeeId, a.accountId, a.address, a.dateOfBirth, a.email, a.fullName, a.gender, a.identityCard, a.image, a.password, a.phoneNumber,a.registerDate, a.status, a.userName  ) "
            + "FROM Employee e JOIN e.account a "
            + "WHERE a.dateOfBirth =:dateSearch "
            + "OR a.registerDate =:dateSearch")
    Page<EmployeeVo> findAllEmployee(@Param("dateSearch") Date dateSearch, Pageable pageable);
}
