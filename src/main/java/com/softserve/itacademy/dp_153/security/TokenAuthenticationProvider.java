package com.softserve.itacademy.dp_153.security;

import com.softserve.itacademy.dp_153.dao.TokensDao;
import com.softserve.itacademy.dp_153.models.authentification.Role;
import com.softserve.itacademy.dp_153.models.authentification.State;
import com.softserve.itacademy.dp_153.models.authentification.Token;
import com.softserve.itacademy.dp_153.models.authentification.UserDetailsImpl;
import com.softserve.itacademy.dp_153.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private TokensDao tokensDao;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;
        Optional<Token> tokenCandidate = tokensDao.findOneByValue(tokenAuthentication.getName());

        if (tokenCandidate.isPresent()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getUser().getUsername());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else {
            User userNotFound = new User();
            userNotFound.setState(State.DISACTIVE);
            userNotFound.setRole(Role.NOT_FOUND);
            UserDetails userDetails = new UserDetailsImpl(userNotFound);
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(false);
            return tokenAuthentication;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
