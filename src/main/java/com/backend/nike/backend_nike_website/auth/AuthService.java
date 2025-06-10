package com.backend.nike.backend_nike_website.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.nike.backend_nike_website.jwt.JwtService;
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
        // intenta autenticar con usuario y contraseña
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword())
        );
        // busca el usuario en la base de datos
        UserDetails usuario = usuarioRepository.findByUsuario(request.getUsuario()).orElseThrow();
        // genera un token JWT para el usuario autenticado
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        // crea un nuevo usuario con los datos recibidos y contraseña encriptada
        Usuario usuario = Usuario.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .usuario(request.getUsuario())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Usuario.UsuarioRole.valueOf(request.getRol())) // asigna rol por defecto
                .build();

        // guarda el usuario en la base de datos
        usuarioRepository.save(usuario);
        // genera un token JWT para el usuario registrado
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
