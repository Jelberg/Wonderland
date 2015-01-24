/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Jessica
 */
public class Productos {
        
    private String Nombre;
    private String Descripcion;
    private String Monto;
    private String Cantidad;
    private String Categoria;
    private String Serial;
    private String proveedor;


    public Productos(String Nombre, String Descripcion, String Monto, String Cantidad, String Categoria, String Serial, String proveedor) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Monto = Monto;
        this.Cantidad = Cantidad;
        this.Categoria = Categoria;
        this.Serial = Serial;
        this.proveedor= proveedor;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + "         Precio:" + Monto + "          Categoria:" + Categoria  ;
    }

   

}
