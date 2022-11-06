package com.example.material_design;

public class Catalogo {
    private String producto;
    private String descrpcion;

    public Catalogo(String producto, String descripcion) {
        this.producto = producto;
        this.descrpcion= descripcion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }
}
