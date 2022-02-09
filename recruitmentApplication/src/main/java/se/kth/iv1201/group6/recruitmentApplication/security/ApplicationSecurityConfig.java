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
import se.kth.iv1201.group6.recruitmentApplication.auth.ApplicationUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(2) // need?
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(
            PasswordEncoder passwordEncoder,
            ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .cors().disable()
                .authorizeRequests()
                    .antMatchers("/hello", "/index.html").permitAll()
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
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

}
