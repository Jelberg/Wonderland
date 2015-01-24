/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import org.apache.log4j.Logger;

/**
 *
 * @author Jessica
 */
public class ControladorMetodos {

    static public void agregarMetodo(String seudonimo, String tarjetatxt, String marcatxt, String codigotxt, String fecha, MetodosXML DatCli) {
        Usuario cli = new Usuario("", "", "", "", "", "", seudonimo, "", "", "", tarjetatxt, marcatxt, fecha, codigotxt);
        DatCli.agregarUsuario(cli);
    }

    public static void llenaTablaMetodos(JTable tablaMetodos, MetodosXML DatMet, Usuario usuario, DefaultTableModel dtm) {
        ArrayList<Usuario> Lista = DatMet.todosLosMetodos();
        for (Usuario est : Lista) {
            if (est.getSeudonimo().equals(usuario.getSeudonimo())) {
                String[] row = {est.getNumTarjCredito(), est.getFecVencimiento(), est.getMarcaComercial(), est.getCodigo()};
                dtm.addRow(row);
            }
        }
        tablaMetodos.setModel(dtm);
    }
}
