/*
 *
 * @author: ChuongHV1
 * @date: Nov 28, 2021
 */

package fa.appcode.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.appcode.web.entities.Account;
	
@Repository("accountRepository")
@Transactional
public interface AccountRepository extends JpaRepository<Account, String> {

	Account findByUserName(String userName);

	Account findByAccountId(String accountId);

	Account findByIdentityCard(String identityCard);

	Account findAccountByUserNameAndPassword(String username, String password);


	
}
