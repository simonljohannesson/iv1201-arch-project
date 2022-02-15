package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * This class configures how the passwords should be handled by spring-security
 */
@Configuration
public class PasswordConfig {
    /**
     * Bean that overrides spring security default settings to handle password hashes.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        String idForEncode = "bcrypt";
        PasswordEncoder defaultEncoder = new BCryptPasswordEncoder();

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, defaultEncoder);
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());

        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        // password without an {id} prefix will be handled by default encoder
        passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

        return passwordEncoder;

    }
}
