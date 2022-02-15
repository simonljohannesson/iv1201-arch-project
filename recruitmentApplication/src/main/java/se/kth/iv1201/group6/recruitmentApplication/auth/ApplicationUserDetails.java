package se.kth.iv1201.group6.recruitmentApplication.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * The class is used for authentication and authorization by Spring-Security.
 */
public class ApplicationUserDetails implements UserDetails {

    private long id;
    final private String username;
    final private String password;
    final private boolean isAccountNonExpired = true;
    final private boolean isAccountNonLocked = true;
    final private boolean isCredentialsNonExpired = true;
    final private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public ApplicationUserDetails(ApplicationUser user){
        this.id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        isEnabled = user.isEnabled();

        int role = user.getRole();

        // determine authorization role connected to user
        switch (role) {
            case 1 -> authorities = List.of(new SimpleGrantedAuthority("ROLE_RECRUITER"));
            case 2 -> authorities = List.of(new SimpleGrantedAuthority("ROLE_APPLICANT"));
            default -> authorities = List.of(); // TODO: log and throw error?
        }

    }

    public ApplicationUserDetails(
                                String username,
                                String password,
                                boolean enabled,
                                Set<? extends GrantedAuthority> authorities
    ) {
        this.username = username;
        this.password = password;
        this.isEnabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public long getId() {
        return id;
    }
}
