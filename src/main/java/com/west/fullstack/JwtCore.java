package com.west.fullstack;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class JwtCore {
    @Value("${fullstack.app.secret}")
    private String secret;
    @Value("${fullstack.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + lifetime))
                .signWith(getKey(), Jwts.SIG.HS512)
                .compact();
    }

    private SecretKey getKey() {
        return hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String getNameFromJwt(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token)
                .getPayload().toString();
    }
}
