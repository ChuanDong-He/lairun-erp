package com.lairun.common.configuration;

import com.alibaba.fastjson.JSONObject;
import com.lairun.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-11
 */

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().usernameParameter("userName")
				.successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler()).and()
				.httpBasic().and().exceptionHandling().accessDeniedHandler(new WebAccessDeniedHandler())
				.authenticationEntryPoint(new WebAuthenticationEntryPoint());
		//http.authorizeRequests().accessDecisionManager(accessDecisionManager());
		/*http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O filterSecurityInterceptor) {
				filterSecurityInterceptor.setSecurityMetadataSource(new DefaultFilterInvocationSecurityMetadataSource(new LinkedHashMap<>()));
				return filterSecurityInterceptor;
			}
		});*/
		http.csrf().disable();
		//http.authorizeRequests().withObjectPostProcessor()

	}

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/**"); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return WebPasswordEncoder.getInstance();
	}

	static final class WebPasswordEncoder implements PasswordEncoder {
		private static final PasswordEncoder INSTANCE = new WebPasswordEncoder();

		public static PasswordEncoder getInstance() {
			return INSTANCE;
		}

		@Override
		public String encode(CharSequence rawPassword) {
			return rawPassword.toString();
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return rawPassword.toString().equals(encodedPassword);
		}

	}

	static class LoginSuccessHandler implements AuthenticationSuccessHandler {
		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws IOException, ServletException {
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			PrintWriter out = response.getWriter();
			out.write(JSONObject.toJSONString(ResultUtil.success("登录成功", null)));
			out.flush();
			out.close();
		}
	}

	static class LoginFailureHandler implements AuthenticationFailureHandler {
		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter out = response.getWriter();
			out.write(JSONObject.toJSONString(ResultUtil.failure("401", "用户名或密码错误")));
			out.flush();
			out.close();
		}
	}
}
