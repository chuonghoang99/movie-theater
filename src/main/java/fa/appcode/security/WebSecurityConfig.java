package fa.appcode.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fa.appcode.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationSuccessHandler loginSuccessHandler;

	@Autowired
	private CustomAuthenticationFailureHandler loginFailureHandler;

	@Autowired
	private CustomLogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	// @Autowired - not work
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// // Setting Service to find User in the database.
	// // And Setting PassswordEncoder
	// auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	// }
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/user/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");

		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests()
			.and()//
				.formLogin()//
					.loginProcessingUrl("/j_spring_security_check") // Submit URL
					.loginPage("/login")//
					.successHandler(loginSuccessHandler)//
					.failureHandler(loginFailureHandler)//
					.usernameParameter("username")//
					.passwordParameter("password")//
					.permitAll() //
			.and()//
				.logout()//
					.logoutSuccessHandler(logoutSuccessHandler)//
					.permitAll();
				

		//	super.configure(http); 

	}

}