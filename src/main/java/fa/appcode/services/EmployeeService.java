/*
 *
 * @author: ChuongHV1
 * @date: Nov 27, 2021
 */

package fa.appcode.services;

import java.util.Optional;

import org.springframework.data.domain.Page;

import fa.appcode.web.entities.Employee;
import fa.appcode.web.vo.EmployeeVo;

public interface EmployeeService {

	Page<EmployeeVo> findAllEmployee(int pageIndex, int pageSize);

	Page<EmployeeVo> findAllEmployee(int pageIndex, int pageSize, String dataSearch);

	boolean save(Employee employee);

	Optional<Employee> findById(String id);

	boolean deleteById(String id);

}
