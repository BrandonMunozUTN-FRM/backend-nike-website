package com.backend.nike.backend_nike_website.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    String token; // token JWT que se devuelve al cliente
    UserDetails usuario;
}
