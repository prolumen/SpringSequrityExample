package com.softserve.itacademy.dp_153.security;

import com.softserve.itacademy.dp_153.service.TokenAuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.IOException;

public class StatelessAuthFilter extends GenericFilterBean {
    private final TokenAuthService tokenAuthService;

    public StatelessAuthFilter(@NotNull TokenAuthService tokenAuthService) {
        this.tokenAuthService = tokenAuthService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthService.getAuthentication((HttpServletRequest) servletRequest).orElse(null));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
