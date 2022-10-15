/*
 *
 * @author: ChuongHV1
 * @date: Dec 3, 2021
 */

package fa.appcode.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import fa.appcode.common.logging.LogUtils;


@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (authentication != null && authentication.getDetails() != null) {
			try {
				request.getSession().invalidate();
				LogUtils.getLogger().info("Logout Successfully !!");

			} catch (Exception e) {
				LogUtils.getLogger().info("Login fail !!");
			}
		}
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("/login");

	}
}
