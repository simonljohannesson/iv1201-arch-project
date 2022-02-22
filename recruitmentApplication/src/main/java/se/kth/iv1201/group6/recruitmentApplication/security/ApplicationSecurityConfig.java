package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import se.kth.iv1201.group6.recruitmentApplication.auth.ApplicationUserDetailService;

import java.util.Arrays;
import java.util.Collections;

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
                .cors().configurationSource(corsConfigurationSource()).and()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()            // verify all requests
                    .antMatchers("/index.html", "/login", "/").permitAll() // allow anyone to access '/index.html'
                    .antMatchers(HttpMethod.POST, "/users/applicants").anonymous()
                    .anyRequest().authenticated()
                .and()
                .httpBasic(); // use http basic authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // authentication
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setMaxAge(3600L);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowedHeaders(Collections.singletonList("*")); // before was "*"
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        configuration.setAllowCredentials(true);
        return source;
    }

}
