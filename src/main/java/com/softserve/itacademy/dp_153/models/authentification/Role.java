package com.softserve.itacademy.dp_153.models.authentification;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, NOT_FOUND;

    @Override
    public String getAuthority() {
        return name();
    }
}
