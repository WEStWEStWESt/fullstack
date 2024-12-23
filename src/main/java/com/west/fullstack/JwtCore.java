package com.west.fullstack;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtCore {
    @Value("${fullstack.app.secret}")
    private String secret;
    @Value("${fullstack.app.lifetime}")
    private int lifetime;

    //  difference  !!!!!! new Date(System.currentTimeMillis() + lifetime))
    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + lifetime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNameFromJwt(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token)
                .getBody().toString();
    }
}
