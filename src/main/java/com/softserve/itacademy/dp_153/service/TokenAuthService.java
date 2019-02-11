package com.softserve.itacademy.dp_153.service;

import com.softserve.itacademy.dp_153.security.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import java.util.Optional;

@Component
public class TokenAuthService {
    private static final String AUTH_HEADER_NAME = "X-Auth-Token";
    @Autowired
    private UserService userService;
    @Autowired
    private TokenHandler tokenHandler;

    public Optional<Authentication> getAuthentication(@NotNull HttpServletRequest request) {

        return Optional
                .ofNullable(request.getHeader(AUTH_HEADER_NAME))
                .flatMap(tokenHandler::extractUserId)
                .flatMap(userService::findById)
                .map(UserAuthentication::new);

    }
}

