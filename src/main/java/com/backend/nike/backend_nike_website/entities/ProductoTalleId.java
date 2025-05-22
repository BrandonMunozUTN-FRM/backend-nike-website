package com.backend.nike.backend_nike_website.entities;

import java.io.Serializable;

public class ProductoTalleId implements Serializable {

    private Integer idTalle;
    private Integer idProducto;

    public ProductoTalleId() {
    }

    public ProductoTalleId(Integer idTalle, Integer idProducto) {
        this.idTalle = idTalle;
        this.idProducto = idProducto;
    }

    // Getters and Setters
    public Integer getIdTalle() {
        return idTalle;
    }

    public void setIdTalle(Integer idTalle) {
        this.idTalle = idTalle;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductoTalleId that = (ProductoTalleId) o;

        if (!idTalle.equals(that.idTalle)) {
            return false;
        }
        return idProducto.equals(that.idProducto);
    }

    @Override
    public int hashCode() {
        int result = idTalle.hashCode();
        result = 31 * result + idProducto.hashCode();
        return result;
    }
}
