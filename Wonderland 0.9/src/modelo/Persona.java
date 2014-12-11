/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author essteeli
 */
public class Persona {
private String Nombre;
private String Apellido;
private String Cedula;
private String Correo;
private String Direccion;
private String Clave;
private String Seudonimo;
private String FReg;
private String FNac;
private String Rol;
private String DireccionFoto;

    public Persona(String Nombre, String Apellido, String Cedula, String Correo, String Direccion, String Clave, String Seudonimo, String FReg, String FNac, String Rol
                    ,String DireccionFoto) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Clave = Clave;
        this.Seudonimo = Seudonimo;
        this.FReg = FReg;
        this.FNac = FNac;
        this.Rol = Rol;
        this.DireccionFoto= DireccionFoto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getSeudonimo() {
        return Seudonimo;
    }

    public void setSeudonimo(String Seudonimo) {
        this.Seudonimo = Seudonimo;
    }

    public String getFReg() {
        return FReg;
    }

    public void setFReg(String FReg) {
        this.FReg = FReg;
    }

    public String getFNac() {
        return FNac;
    }

    public void setFNac(String FNac) {
        this.FNac = FNac;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getDireccionFoto() {
        return DireccionFoto;
    }

    public void setDireccionFoto(String DireccionFoto) {
        this.DireccionFoto = DireccionFoto;
    }




}
