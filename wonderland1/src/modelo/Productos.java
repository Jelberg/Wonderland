/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Jessica
 */
public class Productos {
    
    private String Nombre;
    private String Descripcion;
    private int Monto;
    private int Cantidad;
    private String Categoria;
    private boolean Foto;

    public Productos(String Nombre, String Descripcion, int Monto, int Cantidad, String Categoria, boolean Foto) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Monto = Monto;
        this.Cantidad = Cantidad;
        this.Categoria = Categoria;
        this.Foto = Foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public boolean isFoto() {
        return Foto;
    }

    public void setFoto(boolean Foto) {
        this.Foto = Foto;
    }

  
}
