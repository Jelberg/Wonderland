/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;

/**
 *
 * @author Jessica
 */
public class ControladorMetodos {

    static public void agregarMetodo(String seudonimo, String tarjetatxt, String marcatxt, String codigotxt, String fecha, MetodosXML DatCli) {
        Usuario cli = new Usuario("", "", "", "", "", "", seudonimo, "", "", "", tarjetatxt, marcatxt, fecha, codigotxt);
        DatCli.agregarUsuario(cli);
    }
}
