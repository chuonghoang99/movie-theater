/*
 *
 * @author: ChuongHV1
 * @date: Nov 30, 2021
 */

package fa.appcode.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.repositories.AccountRepository;
import fa.appcode.services.AccountService;
import fa.appcode.web.entities.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account findAccountByUserName(String userName) {
		return accountRepository.findByUserName(userName);

	}

	@Override
	public Account findAccountByAccountId(String id){
		return accountRepository.findByAccountId(id);
	}

	@Override
	public Account findAccountByIdentityCard(String identityCard) {
		return accountRepository.findByIdentityCard(identityCard);
	}


}
