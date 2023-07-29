package com.example.assignmentwebshopproject.security.auth.isauthenticated;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors()
                .and().csrf().disable()
                .formLogin().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
