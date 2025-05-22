package com.backend.nike.backend_nike_website.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDireccionId implements Serializable {

    // ID del usuario
    private Integer usuarioId;

    // ID de la dirección
    private Integer direccionId;

    // Compara si dos objetos son iguales, considerando ambos IDs
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsuariosDireccionId that = (UsuariosDireccionId) o;

        if (!usuarioId.equals(that.usuarioId)) {
            return false;
        }
        return direccionId.equals(that.direccionId);
    }

    // Genera un código hash basado en ambos IDs para uso en colecciones
    @Override
    public int hashCode() {
        int result = usuarioId.hashCode();
        result = 31 * result + direccionId.hashCode();
        return result;
    }
}
