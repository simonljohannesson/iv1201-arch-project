package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.kth.iv1201.group6.recruitmentApplication.auth.MyUserDetailService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(2) // need?
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    MyUserDetailService myUserDetailService;

    @Autowired
    MyUserDetailService userDetailsService;

    @Autowired
    public ApplicationSecurityConfig(
            PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // authorization
        http
                .csrf().disable()
//                .cors().disable()
                .authorizeRequests()
                    .antMatchers("/hello", "/index.html", "/persons/**").permitAll()
//                    .antMatchers("/hello_auth_rec").hasRole(ApplicationUserRole.RECRUITER.name())
//                    .antMatchers("/hello_auth_app").hasRole(ApplicationUserRole.APPLICANT.name())
                    .anyRequest().authenticated()
                .and()
//                .formLogin();
                .httpBasic();
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("applicant")
//                .password(passwordEncoder.encode("pass"))
////                .authorities(ApplicationUserRole.APPLICANT.getGrantedAuthorities()) // ROLE_APPLICANT 'ROLE_APPLICANT'
//                .roles(ApplicationUserRole.APPLICANT.name())
////                .roles("APPLICANT")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("recruiter")
//                .password(passwordEncoder.encode("pass"))
////                .authorities(ApplicationUserRole.RECRUITER.getGrantedAuthorities()) // ROLE_RECRUITER
//                .roles(ApplicationUserRole.RECRUITER.name())
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // authentication
//        auth.authenticationProvider(daoAuthenticationProvider());
        auth.userDetailsService(userDetailsService);
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }

}
