package com.pratyush.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	 @Override
	    public void configure(WebSecurity security) 
	    {
	        security
	            .ignoring()
	            .antMatchers("/user/loginUser");
	        
	        security
	        	.ignoring()
	            .antMatchers("/user/userSignUp");
	        
	        security
	        	.ignoring()
	        	.antMatchers("/user/verifybalance/**");
	    }


}
