package com.softserve.itacademy.dp_153.util.dto;

import com.softserve.itacademy.dp_153.models.authentification.Token;
import org.springframework.stereotype.Component;

public class TokenDto {
    private String value;

    public TokenDto(String value) {
        this.value = value;
    }

    public static TokenDto from(Token token) {
        return new TokenDto(token.getValue());
    }

    public String getValue() {
        return value;
    }
}
