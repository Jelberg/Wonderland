/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Validar {

    ButtonGroup SeleccionarBusqueda;
    JRadioButton nombre, categoria;
    // Validar es una Clase Utilitaria solo contiene métodos no es empleada para almacenar datos

    // Validar es una Clase Utilitaria solo contiene métodos no es empleada para almacenar datos
    public Validar(ButtonGroup SeleccionarBusqueda, JRadioButton nombre, JRadioButton categoria) {
        this.SeleccionarBusqueda = SeleccionarBusqueda;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public static int validarVacio(JTextField campo, String mensaje) {
        if (campo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, mensaje, "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int validaPasswordVacio(JPasswordField password, String mensaje) {
        String contraseña = new String(password.getPassword());
        if (contraseña == "") {
            JOptionPane.showMessageDialog(null, mensaje, "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int validarFecha(JDateChooser fecha, String mensaje) {
        if (fecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, mensaje, "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int cantidadMinima(JTextField cantidad, String mensaje, int instruccion) {
        if (instruccion == 3) {
            if (Integer.parseInt(cantidad.getText()) < 15) {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            } else {
                return 1;
            }
        } else if (Integer.parseInt(cantidad.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "La cantidad tiene que ser mayor o igual a 1", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int validarComboBox(JComboBox combo, String mensaje) {

        if (String.valueOf(combo.getSelectedItem()) == "") {
            JOptionPane.showMessageDialog(null, mensaje, "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int validarEntero(String numero, String mensaje) {
        try {
            int numero1 = Integer.parseInt(numero);
            return 1;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, mensaje, "Tipo De Dato No es un Entero", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public static int validarTextArea(JTextArea campo, String mensaje) {
        if (campo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public void SeleccionarBusqueda() {
        SeleccionarBusqueda.add(nombre);
        SeleccionarBusqueda.add(categoria);

    }

    public static int validarRango(float numero, String mensaje) {
        if (numero < 0 || numero > 10000) {
            JOptionPane.showMessageDialog(null, mensaje, "Valor no valido", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    public static int validarReal(String numero, String mensaje) {
        try {
            float numero1 = Float.parseFloat(numero);
            return validarRango(numero1, "Valor Invalido");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, mensaje, "Tipo De Dato No es un Real", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }
}
