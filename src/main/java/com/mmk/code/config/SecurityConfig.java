package com.mmk.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers()
		.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
		.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "X-Requested-With,Content-Type"))
		.frameOptions().sameOrigin()
		.and()
		.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login?logout").logoutUrl("/logout").permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
