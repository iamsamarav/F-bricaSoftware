package com.avanade.avabank.avabank.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt-secret}")
    private String jwtSecret;
//            = System.getenv("JWT_SECRET");

    private Long jwtExpirationMiliseg = 90000000L;

    public String generateToken(String username, String role, String nome) {
        SecretKey secreKeySpec = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        Map<String, Object> claims = new HashMap<>();
        
        claims.put("role", role);
        claims.put("nome", nome);
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtExpirationMiliseg))
                .signWith(secreKeySpec)
                .addClaims(claims)
                .compact();
    }

    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true;
            }
        }
        return false;
    }

    public String getUserName(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token).getBody();
    }

}
