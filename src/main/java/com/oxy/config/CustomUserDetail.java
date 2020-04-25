package com.oxy.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;
    private boolean isActive;

    public CustomUserDetail(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isActive = user.isActive();
        this.roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
    }

    public CustomUserDetail() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }
}
