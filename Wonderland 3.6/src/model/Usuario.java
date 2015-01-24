/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


public class Usuario extends Persona {
private String NumTarjCredito;
private String MarcaComercial;
private String FecVencimiento;
private String Codigo;


     public Usuario(String Nombre, String Apellido, String Cedula,String Correo,String Direccion,String Clave , String Seudonimo,String FReg,String FNac,String Rol, String NumTarjCredito, String MarcaComercial, String FecVencimiento, String Codigo) {
         super (Nombre, Apellido, Cedula,Correo,Direccion, Clave,Seudonimo,FReg,FNac,Rol);        
        this.NumTarjCredito = NumTarjCredito;
        this.MarcaComercial = MarcaComercial;
        this.FecVencimiento = FecVencimiento;
        this.Codigo = Codigo;
        
        
    }

    public String getNumTarjCredito() {
        return NumTarjCredito;
    }

    public void setNumTarjCredito(String NumTarjCredito) {
        this.NumTarjCredito = NumTarjCredito;
    }

    public String getMarcaComercial() {
        return MarcaComercial;
    }

    public void setMarcaComercial(String MarcaComercial) {
        this.MarcaComercial = MarcaComercial;
    }

    public String getFecVencimiento() {
        return FecVencimiento;
    }

    public void setFecVencimiento(String FecVencimiento) {
        this.FecVencimiento = FecVencimiento;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    

}
