package com.softserve.itacademy.dp_153.service;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class TokenHandlerTest {

    @Test
    public void generateToken() {
        TokenHandler tokenHandler = new TokenHandler();
        String token = tokenHandler.generateAccessToken(new Integer(1), LocalDateTime.now().plusDays(14));
        System.out.println(token);

        Optional<Integer> optional = tokenHandler.extractUserId(token);
        System.out.println(optional.get().toString());

//        Assert.assertEquals(token, "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwiZXhwIjoxNTUwODMzOTgyfQ.OfKwc3JAGrPvUEgAvMMh0lkllQ9GlpQTJGncWbgS57CLfcJD96eLNoG0P1uB9Hgy0To28W5M1GKNNiMP3waVdg");
    }
}
