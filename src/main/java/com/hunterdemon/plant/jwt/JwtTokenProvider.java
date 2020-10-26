package com.hunterdemon.plant.jwt;

import com.hunterdemon.plant.detail.UserDatail;
import com.hunterdemon.plant.service.UserDetailsServiceImpl;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenProvider {
    public final String JWT_SECRET = "Hunter195";

    public final long JWT_EXPIRATION = 604800000L;

    public String generateToken(UserDatail userDatail){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(userDatail.getID()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }
    public Long getUserIDFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJwt(token)
                .getBody();
        return Long.getLong(claims.getSubject());
    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            throw ex;
        } catch (ExpiredJwtException ex) {
            throw ex;
        } catch (UnsupportedJwtException ex) {
            throw ex;
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }
}
