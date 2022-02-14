package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.*;
import se.kth.iv1201.group6.recruitmentApplication.auth.ApplicationUserDetailService;

/**
 * Configuration class for spring security.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserDetailService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception { // authorization
        http
                .csrf().disable()               //disable csrf protection
                .authorizeRequests()            // verify all requests
                    .antMatchers("/index.html").permitAll() // allow anyone to access '/index.html'
                    .anyRequest().authenticated()
                .and()
                .httpBasic();                   // use http basic authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // authentication
        auth.userDetailsService(userDetailsService);
    }
}
