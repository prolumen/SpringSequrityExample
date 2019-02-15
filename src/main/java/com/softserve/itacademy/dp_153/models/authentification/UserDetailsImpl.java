package com.softserve.itacademy.dp_153.models.authentification;

import com.softserve.itacademy.dp_153.models.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = user.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getState().equals(State.ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getState().equals(State.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getState().equals(State.ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.ACTIVE);
    }

    public User getUser() {
        return user;
    }
}
