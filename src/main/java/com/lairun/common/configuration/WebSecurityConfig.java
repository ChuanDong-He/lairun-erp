package com.lairun.common.configuration;

import com.alibaba.fastjson.JSONObject;
import com.lairun.common.utils.ResultUtil;
import com.lairun.sys.user.domain.UserInfoDetail;
import com.lairun.sys.user.service.UserInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserInfoDetailService userInfoDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
				.successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler()).permitAll().and()
				.httpBasic().and().exceptionHandling().accessDeniedHandler(new WebAccessDeniedHandler())
				.authenticationEntryPoint(new WebAuthenticationEntryPoint());
		//http.authorizeRequests().accessDecisionManager(accessDecisionManager());
		http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O filterSecurityInterceptor) {
				filterSecurityInterceptor.setSecurityMetadataSource(new DefaultFilterInvocationSecurityMetadataSource(new LinkedHashMap<>()));
				return filterSecurityInterceptor;
			}
		});
		http.csrf().disable();
		//http.authorizeRequests().withObjectPostProcessor()

	}

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/**"); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userInfoDetailService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return WebPasswordEncoder.getInstance();
	}

	static final class WebPasswordEncoder implements PasswordEncoder {

		@Override
		public String encode(CharSequence rawPassword) {
			return rawPassword.toString();
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return rawPassword.toString().equals(encodedPassword);
		}

		public static PasswordEncoder getInstance() {
			return INSTANCE;
		}

		private static final PasswordEncoder INSTANCE = new WebPasswordEncoder();

		private WebPasswordEncoder() {
		}

	}

	static class LoginSuccessHandler implements AuthenticationSuccessHandler {
		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			UserInfoDetail userInfoDetail = (UserInfoDetail) authentication.getPrincipal();
			out.write(JSONObject.toJSONString(ResultUtil.success(userInfoDetail.compareToUserInfo())));
			out.flush();
			out.close();
		}
	}

	static class LoginFailureHandler implements AuthenticationFailureHandler {
		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(JSONObject.toJSONString(ResultUtil.failure("用户名或密码错误")));
			out.flush();
			out.close();
		}
	}
}
