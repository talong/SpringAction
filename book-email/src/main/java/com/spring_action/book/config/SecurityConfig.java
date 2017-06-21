package com.spring_action.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity  //启用SpringMVC安全功能
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() //启用内存用户存储
		.withUser("user").password("password")
		.roles("USER").and()
		.withUser("admin").password("password")
		.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/spitters/me")
		.authenticated().antMatchers(HttpMethod.POST, "/spittles")
		.authenticated().anyRequest().permitAll()
		.and().requiresChannel().antMatchers("/spitter.form") //重定向到HTTPS
		.requiresSecure(); 
	}


	
}
