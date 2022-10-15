/*
 *
 * @author: ChuongHV1
 * @date: Nov 30, 2021
 */

package fa.appcode.services;

import fa.appcode.web.entities.Account;

public interface AccountService {

	Account findAccountByUserName(String userName);

	Account findAccountByAccountId(String accountId);

	Account findAccountByIdentityCard(String identityCard);




	
	

}
