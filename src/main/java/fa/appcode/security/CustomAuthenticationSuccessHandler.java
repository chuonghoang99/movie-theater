/*
 *
 * @author: ChuongHV1
 * @date: Nov 29, 2021
 */

package fa.appcode.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.config.PageConfig;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private PageConfig pageConfig;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if (authority.getAuthority().equals("ROLE_USER")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/user/dashboard");
				} catch (Exception e) {
					LogUtils.getLogger().info(pageConfig.getNoPermit());

				}
			} else if (authority.getAuthority().equals("ROLE_ADMIN")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/admin/dashboard");
				} catch (Exception e) {

					LogUtils.getLogger().info(pageConfig.getNoPermit());
				}
			} else {			
				LogUtils.getLogger().info(pageConfig.getNoAuthor());
				throw new IllegalStateException();
			}
		});

	}

}
