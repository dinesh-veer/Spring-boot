package com.springBoot.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	// Authentication : set user/password details and mention the role
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        	.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
            .withUser("user").password("pass").roles("USER")
            .and()
            .withUser("admin").password("pass").roles("USER", "ADMIN");
    }

    // Authorization : mention which role can access which URL
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
            .antMatchers("/userlogin").hasRole("USER")
            .antMatchers("/adminlogin").hasRole("ADMIN")
            .and()
            .csrf().disable().headers().frameOptions().disable();
    }
}
