/*
 * @author: ChuongHV1
 * @date: Nov 26, 2021
 */
package fa.appcode.web.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import fa.appcode.common.utils.Constants;
import fa.appcode.services.ShowtimesService;
import fa.appcode.web.entities.MovieDate;
import fa.appcode.web.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.appcode.services.AccountService;
import fa.appcode.web.entities.Account;

@Controller
@RequestMapping("/")
public class InitController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ShowtimesService showtimesService;

	@GetMapping("403")
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = loginedUser.getUsername();
			model.addAttribute("userInfo", userInfo);
			String message = "Hi " + principal.getName() + ", " //
					+ "You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403";
	}

	@GetMapping("login")
	public String showLogin() {
		return "login";
	}

	@GetMapping("logout")
	public String logout() {
		return "login";
	}

	@GetMapping("user/dashboard")
	public String showUserDashboard(Model model, Principal principal) {
//		List<LocalDate> listDates = showtimesService.getShowDateList(LocalDate.now().toString());
//
//		model.addAttribute("listDates", listDates);
//
//		PageVo<MovieDate> pages = showtimesService.findMovieTimeByDate(dateSelecting, 1, pageConfig.getMaxPageShowTime());
//
//		if(dateSelecting == null || Constants.DEFAULT_WORD.equals(dateSelecting)) {
//			dateSelecting = LocalDate.now().toString();
//		}

		User account = (User) ((Authentication) principal).getPrincipal();
		Account accountLogin = accountService.findAccountByUserName(account.getUsername());
		model.addAttribute("accountLogin", accountLogin);
		return "user-dashboard";
	}

	@GetMapping("admin/dashboard")
	public String showAdminDashboard(Model model, Principal principal) {
		User account = (User) ((Authentication) principal).getPrincipal();
		Account accountLogin = accountService.findAccountByUserName(account.getUsername());
		model.addAttribute("accountLogin", accountLogin);

		return "admin-dashboard";
	}

	@GetMapping("welcome")
	public String showWelocme(Model model, Principal principal) {
		return "welcome";
	}

}
