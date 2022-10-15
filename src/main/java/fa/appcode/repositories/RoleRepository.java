/*
 *
 * @author: ChuongHV1
 * @date: Nov 29, 2021
 */

package fa.appcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.appcode.web.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

	@Query("SELECT r FROM Account a JOIN a.roles r WHERE a.accountId = :accountId")
	List<Roles> findRolesByAccountId(@Param("accountId") String accountId);

}
