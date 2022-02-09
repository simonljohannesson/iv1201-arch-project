package se.kth.iv1201.group6.recruitmentApplication.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationUserDetails implements UserDetails {

    final private String username;
    final private String password;
    final private boolean isAccountNonExpired = true;
    final private boolean isAccountNonLocked = true;
    final private boolean isCredentialsNonExpired = true;
    final private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public ApplicationUserDetails(User user){
        username = user.getUsername();
        password = user.getPassword();
        isEnabled = user.isEnabled();
        authorities = Arrays.stream(user.getRoles().split(","))
                        .map((String role) -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toList());
    }

    public ApplicationUserDetails(
            String username,
            String password,
            boolean enabled,
            Set<? extends GrantedAuthority> authorities
    ) {
//        this.id = id;
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


}
