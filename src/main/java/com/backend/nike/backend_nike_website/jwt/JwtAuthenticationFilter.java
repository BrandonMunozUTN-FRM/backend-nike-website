package com.backend.nike.backend_nike_website.jwt;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    // Método principal que se ejecuta en cada petición para validar el JWT
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Obtenemos el token JWT del header Authorization
        final String token = getTokenFromRequest(request);
        final String usuario;

        // Si no hay token, dejamos pasar la petición sin autenticación
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extraemos el usuario del token
        usuario = jwtService.getUsernameFromToken(token);

        System.out.println("Usuario extraído del token: " + usuario);

        // Si el usuario no está autenticado aún y el token es válido, autenticamos
        if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(usuario);
            if (jwtService.isTokenValid(token, userDetails)) {
                // Creamos el token de autenticación para Spring Security
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Guardamos la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // Continuamos con el siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }

    // Extrae el token JWT del header Authorization si existe y empieza con "Bearer "
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }
}
