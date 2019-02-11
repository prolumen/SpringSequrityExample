package com.softserve.itacademy.dp_153.service;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Component
public class TokenHandler {
    private final SecretKey secretKey;

    public TokenHandler() {
        String jwtKey = "jwtKey64Test";
        byte[] decodedKey = BaseEncoding.base64().decode(jwtKey);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    }

    public Optional<Integer> extractUserId(@NotNull String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return Optional
                    .ofNullable(body.getId())
                    .map(Integer::new);
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public String generateAccessToken(@NonNull Integer id, @NonNull LocalDateTime expires) {
        return Jwts.builder()
                .setId(id.toString())
                .setExpiration(Date.from(expires.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
