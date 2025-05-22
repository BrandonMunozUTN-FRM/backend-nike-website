package com.backend.nike.backend_nike_website.entities;

import java.io.Serializable;

public class ProductoDescuentoId implements Serializable {

    private Integer idDescuento;
    private Integer idProducto;

    public ProductoDescuentoId() {
    }

    public ProductoDescuentoId(Integer idDescuento, Integer idProducto) {
        this.idDescuento = idDescuento;
        this.idProducto = idProducto;
    }

    // Getters and Setters
    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
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

        ProductoDescuentoId that = (ProductoDescuentoId) o;

        if (!idDescuento.equals(that.idDescuento)) {
            return false;
        }
        return idProducto.equals(that.idProducto);
    }

    @Override
    public int hashCode() {
        int result = idDescuento.hashCode();
        result = 31 * result + idProducto.hashCode();
        return result;
    }
}
