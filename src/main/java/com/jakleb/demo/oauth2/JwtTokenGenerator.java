package com.jakleb.demo.oauth2;

import java.util.Date;

import com.jakleb.demo.entities.User;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenGenerator {
    
    @Value("${jwt.key}")
    private String JWT_KEY;
    private static final String ROLE = "role";

    public String generateToken(User user){
        
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                    .setSubject(user.getEmail())
                    .claim(ROLE, user.getRole())
                    .setIssuedAt(new Date(currentTimeMillis + 200000))
                    .signWith(SignatureAlgorithm.HS512, JWT_KEY.getBytes())
                    .compact();
    }
}
