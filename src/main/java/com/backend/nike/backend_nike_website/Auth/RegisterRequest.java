package com.backend.nike.backend_nike_website.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String usuario;
    String password;
    String name;
    String lastName;
    String email;
    String rol;
}
