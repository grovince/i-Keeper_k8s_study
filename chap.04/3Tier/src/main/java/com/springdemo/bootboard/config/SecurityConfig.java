package com.springdemo.bootboard.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.springdemo.bootboard.security.SpringBoardNoOpPasswordEncoder;
import com.springdemo.bootboard.security.SpringBoardUserDetailsService;

import lombok.Data;

@Configuration
@EnableWebSecurity
@Data
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("userDetailService")
	private SpringBoardUserDetailsService userDetailService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	// thymeleaf 에서 security 태그를 사용하기 위해 필요한 bean 설정
	@Bean
	public SpringSecurityDialect springSecurityDialect(){
	    return new SpringSecurityDialect();
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SpringBoardNoOpPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	.authorizeRequests()
//				.antMatchers("/").permitAll()
//				.antMatchers("/home").permitAll()
//				.antMatchers("/account/**").permitAll()
//				.antMatchers("/css/**").permitAll()
//				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/board/**").authenticated()
				.antMatchers("/mail/**").authenticated()
				.anyRequest().permitAll()
			.and()
				.formLogin().loginPage("/account/login").defaultSuccessUrl("/home")
			.and()
				.logout().logoutSuccessUrl("/home")
			.and()
				.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService);		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT * FROM tbl_users WHERE user_name = ?")
			.authoritiesByUsernameQuery("SELECT user_name, role_name FROM tbl_users_roles WHERE user_name = ?")
			.passwordEncoder(passwordEncoder());
	}
}
