package com.pratyush.orderservice.config;

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
	            .antMatchers("/order/giftlist/**");
	    }
}