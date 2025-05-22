package com.backend.nike.backend_nike_website.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    // Clave secreta usada para firmar los tokens JWT
    private static final String SECRET_KEY = "1A2B3C4D5E6F708192837465A1B2C3D4E5F60718293A4B5C6D7E8F9012345678";

    // Genera un token JWT para un usuario, sin claims extras
    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    // Genera un token JWT con claims extras y el usuario
    private String getToken(Map<String, Object> extraClaims, UserDetails usuario) {
        return Jwts
                .builder()
                .setClaims(extraClaims) // Agrega claims extra si hay
                .setSubject(usuario.getUsername()) // Usuario (subject) del token
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de creación
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
                .signWith(getKey(), SignatureAlgorithm.HS256) // Firma con la clave secreta y algoritmo HS256
                .compact();
    }

    // Obtiene la clave secreta en formato que usa JWT para firmar/verificar
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Extrae todos los claims de un token JWT
    private Claims getClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey()) // Usa la clave para verificar
                .build()
                .parseClaimsJws(token) // Parsea el token y extrae los claims
                .getBody();
    }

    // Obtiene un claim específico del token usando una función que extrae ese claim
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    // Obtiene el nombre de usuario (subject) del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // Valida que el token sea para el usuario dado y que no esté expirado
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String usuario = getUsernameFromToken(token);
        return (usuario.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Obtiene la fecha de expiración del token
    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    // Verifica si el token ya expiró
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
