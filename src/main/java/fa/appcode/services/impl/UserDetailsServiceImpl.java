/*
 *
 * @author: ChuongHV1
 * @date: Nov 28, 2021
 */

package fa.appcode.services.impl;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.repositories.AccountRepository;
import fa.appcode.repositories.RoleRepository;
import fa.appcode.web.entities.Account;
import fa.appcode.web.entities.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUserName(username);
        if (account == null) {
            LogUtils.getLogger().info("Exception user");
            throw new UsernameNotFoundException("Not found username !!!");

        }
        List<Roles> roles = roleRepository.findRolesByAccountId(account.getAccountId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for (Roles role : roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            grantList.add(authority);
        }

        if (account.getStatus() == 0) {
            return new User(account.getUserName(), account.getPassword(), true, true, true, false, grantList);
        } else {
            return new User(account.getUserName(), account.getPassword(), grantList);
        }


    }

}
