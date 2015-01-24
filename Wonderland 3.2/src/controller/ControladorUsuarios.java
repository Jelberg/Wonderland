/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Jessica
 */
public class ControladorUsuarios {

    UsuarioXML DatUsuario = new UsuarioXML();

    public static int buscaUsuario(JTextField seudonimotxt, JPasswordField password) {
        UsuarioXML DatUsuario = new UsuarioXML();

        Usuario usuario = DatUsuario.buscarPersona(seudonimotxt.getText());
        if (usuario != null) {
            String contraseña = new String(password.getPassword());

            if (usuario.getClave().equals(contraseña)) {
                if ("Usuario".equals(usuario.getRol())) {
                    PerfilUsuario control2 = new PerfilUsuario(usuario);
                    control2.setLocationRelativeTo(null);
                    control2.setVisible(true);
                }
                if ("Administrador de Productos".equals(usuario.getRol())) {
                    PerfilAdmProductos control2 = new PerfilAdmProductos(usuario);
                    control2.setLocationRelativeTo(null);
                    control2.setVisible(true);
                }
                if ("Administrador de Usuarios".equals(usuario.getRol())) {
                    PerfilAdmUsuarios control2 = new PerfilAdmUsuarios(usuario);
                    control2.setLocationRelativeTo(null);
                    control2.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }

    public static void volverPerfil(Usuario usuario) {
        if ("Usuario".equals(usuario.getRol())) {
            PerfilUsuario control2 = new PerfilUsuario(usuario);
            control2.setLocationRelativeTo(null);
            control2.setVisible(true);
        }
        if ("Administrador de Productos".equals(usuario.getRol())) {
            PerfilAdmProductos control2 = new PerfilAdmProductos(usuario);
            control2.setLocationRelativeTo(null);
            control2.setVisible(true);
        }
        if ("Administrador de Usuarios".equals(usuario.getRol())) {
            PerfilAdmUsuarios control2 = new PerfilAdmUsuarios(usuario);
            control2.setLocationRelativeTo(null);
            control2.setVisible(true);
        }
    }

    public static void muestraDatosCuenta(JTextField seudonimotxt, JTextField clavetxt, JTextField fecregtxt, JTextField roltxt, Usuario usuario) {
        seudonimotxt.setText(usuario.getSeudonimo());
        clavetxt.setText(usuario.getClave());
        fecregtxt.setText(usuario.getFReg());
        roltxt.setText(usuario.getRol());
        roltxt.setEnabled(false);
        fecregtxt.setEnabled(false);
        clavetxt.setEnabled(false);
        seudonimotxt.setEnabled(false);
    }

    public static void muestraDatosPersonales(JTextField nombretxt, JTextField apellidotxt, JTextField documentotxt, JTextField correotxt, JTextField direcciontxt, JTextField fecnactxt, Usuario usuario) {
        nombretxt.setText(usuario.getNombre());
        apellidotxt.setText(usuario.getApellido());
        documentotxt.setText(usuario.getCedula());
        correotxt.setText(usuario.getCorreo());
        fecnactxt.setText(usuario.getFNac());
        direcciontxt.setText(usuario.getDireccion());
        nombretxt.setEnabled(false);
        apellidotxt.setEnabled(false);
        documentotxt.setEnabled(false);
        correotxt.setEnabled(false);
        direcciontxt.setEnabled(false);
        fecnactxt.setEnabled(false);
    }

    public static int camposVaciosDatPersonales(JTextField nombretxt, JTextField apellidotxt, String documentotxt, String correotxt, JTextField direcciontxt) {
        if ("".equals(nombretxt.getText()) || "".equals(direcciontxt.getText()) || "".equals(apellidotxt.getText()) || "".equals(documentotxt) || "".equals(correotxt)) {
            JOptionPane.showMessageDialog(null, "TIENE CAMPOS VACIOS", "Error:", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            nombretxt.setEnabled(false);
            apellidotxt.setEnabled(false);
            direcciontxt.setEnabled(false);
            return 1;
        }
    }

    public static void Llenalista(DefaultListModel modelo, JList List, RolXML DatRol) {
        ArrayList<Usuario> Lista = DatRol.todosUsuarioRol();
        for (Usuario pro : Lista) {
            Usuario usu = DatRol.buscarUsuarioRol(pro);
            modelo.addElement(usu);
            List.setModel(modelo);
        }
    }

    public static void llenaTabla(JTable tablaUsuario, UsuarioXML DatUsu, DefaultTableModel dtm) {
        ArrayList<Usuario> Lista = DatUsu.todosLosUsuarios();
        for (Usuario est : Lista) {
            String[] row = {est.getSeudonimo(), est.getNombre(), est.getApellido(), est.getRol(),
                est.getFReg(), est.getCedula()};
            dtm.addRow(row);
        }
        tablaUsuario.setModel(dtm);
    }

}
