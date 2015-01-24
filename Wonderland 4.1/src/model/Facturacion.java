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
public class Facturacion {
private String comprador;
private String cantidadpro;
private String nombre;
private String proveedor;
private String precio;
private String total;
private String codigo;
private String ci;

    public Facturacion(String comprador, String cantidadpro, String nombre, String proveedor, String precio, String total, String codigo, String ci) {
        this.comprador = comprador;
        this.cantidadpro = cantidadpro;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.total = total;
        this.codigo = codigo;
        this.ci = ci;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getCantidadpro() {
        return cantidadpro;
    }

    public void setCantidadpro(String cantidadpro) {
        this.cantidadpro = cantidadpro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

   

}
