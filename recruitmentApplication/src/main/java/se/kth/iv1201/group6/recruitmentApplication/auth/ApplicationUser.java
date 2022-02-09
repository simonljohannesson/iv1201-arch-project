package se.kth.iv1201.group6.recruitmentApplication.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ApplicationUser implements UserDetails {
    final private String username;
    final private String password;
    final private boolean isAccountNonExpired;
    final private boolean isAccountNonLocked;
    final private boolean isCredentialsNonExpired;
    final private boolean isEnabled;
    private Set<? extends GrantedAuthority> authorities;

    public ApplicationUser(
            String username,
            String password,
            boolean accountNonExpired,
            boolean accountNonLocked,
            boolean credentialsNonExpired,
            boolean enabled,
            Set<? extends GrantedAuthority> authorities
    ) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = accountNonExpired;
        this.isAccountNonLocked = accountNonLocked;
        this.isCredentialsNonExpired = credentialsNonExpired;
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
