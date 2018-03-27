package com.phm.community.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.phm.community.util.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// jdbc를 통한 사용자 인증 설정
		// auth.jdbcAuthentication().dataSource(securityDataSource);
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// security 인코딩 설정 
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		http.headers()
			.frameOptions().sameOrigin();
		
		http.csrf().disable();
		
		// 1. 사용자 인증이 된 요청에 대해서만 요청을 허용 (authorizeRequests())
		// 2. 모든 요청에 대해서 USER라는 role이 있는 경우를 허용
		// 3. 폼 로그인 허용
		// 4. 모든 로그아웃 허용
		// 5. 예외 발생시 denied page 설정
		http.authorizeRequests()
//			.antMatchers("/login").hasRole("EMPLOYEE")
//			.antMatchers("/dashboard/**").hasRole("ADMIN")
			.and()
				.formLogin() // 폼 로그인 
					.loginPage("/login") // 로그인 페이지 
					.loginProcessingUrl("/authenticate")
					.permitAll()
					.successHandler(successHandler())
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denined");
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
