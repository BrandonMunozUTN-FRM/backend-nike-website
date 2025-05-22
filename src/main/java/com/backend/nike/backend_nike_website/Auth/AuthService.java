package com.backend.nike.backend_nike_website.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.nike.backend_nike_website.Jwt.JwtService;
import com.backend.nike.backend_nike_website.entities.Usuario;
import com.backend.nike.backend_nike_website.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword())
        );
        UserDetails usuario = usuarioRepository.findByUsuario(request.getUsuario()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .usuario(request.getUsuario())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Usuario.UsuarioRole.CLIENT)
                .build();

        usuarioRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
