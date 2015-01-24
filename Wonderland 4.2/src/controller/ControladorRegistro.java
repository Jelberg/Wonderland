/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.util.GregorianCalendar;
import model.Usuario;

/**
 *
 * @author Jessica
 */
public class ControladorRegistro {
     
    static public String convierteFecNac(JComboBox ComboBoxDia,JComboBox ComboBoxMes,JComboBox ComboBoxAnnio) {
        String dia, mes, año, fecha;
        dia = String.valueOf(ComboBoxDia.getSelectedItem());
        mes = String.valueOf(ComboBoxMes.getSelectedItem());
        año = String.valueOf(ComboBoxAnnio.getSelectedItem());
        fecha = dia + "/" + mes + "/" + año;
        return fecha;
    }

     static public String convierteCedula(JTextField cedulatxt, JComboBox cedulaCombo) {
        String cedula;
        cedula = String.valueOf(cedulaCombo.getSelectedItem());
        cedula = cedula + cedulatxt.getText();
        return cedula;
    }

    static public String convierteCorreo(JTextField emailtxt, JComboBox ComboBoxCorreo) {
        String correo;
        correo = String.valueOf(ComboBoxCorreo.getSelectedItem());
        correo = emailtxt.getText() + correo;
        return correo;
    }

    static public String Fecha() {
        String total, day, month, year, total1;
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        mes = mes + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        day = String.valueOf(dia);
        month = String.valueOf(mes);
        year = String.valueOf(año);
        total = day + "/" + month + "/" + year;
        return total;
    }

    static public void obtenerDatos(String nombre, String apellido, String cedula, String correo, String Direccion,
            String clave, String seudonimo, String fecreg, String fecnac, String rol) {
        boolean resultado = true;
        UsuarioXML DatCli = new UsuarioXML();
        Usuario cli = new Usuario(nombre, apellido, cedula, correo, Direccion, clave, seudonimo, fecreg, fecnac, rol, "", "", "", "");
        DatCli.agregarUsuario(cli);
    }

}
