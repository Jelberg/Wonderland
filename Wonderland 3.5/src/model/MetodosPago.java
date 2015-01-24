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
public class MetodosPago {

    private String NumTarjCredito;
    private String MarcaComercial;
    private String FecVencimiento;
    private String Codigo;
    private String cambio;
    private String Seudonimo;

    public MetodosPago(String NumTarjCredito, String MarcaComercial, String FecVencimiento, String Codigo, String cambio) {
        this.NumTarjCredito = NumTarjCredito;
        this.MarcaComercial = MarcaComercial;
        this.FecVencimiento = FecVencimiento;
        this.Codigo = Codigo;
        this.cambio = cambio;
    }

    public MetodosPago(String Seudonimo) {
        this.Seudonimo = Seudonimo;
    }

    public String getSeudonimo() {
        return Seudonimo;
    }

    public void setSeudonimo(String Seudonimo) {
        this.Seudonimo = Seudonimo;
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

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

}
