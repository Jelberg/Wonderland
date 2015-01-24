/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.*;
import model.Productos;
import java.util.ArrayList;

/**
 *
 * @author Jessica
 */
public class RenderLista extends JLabel implements ListCellRenderer {

   
    private ArrayList <ImageIcon> RutaAlterna;

    public RenderLista(ArrayList<ImageIcon> RutaAlterna) {
        this.RutaAlterna = RutaAlterna;
    }

   
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        String valor = value.toString();
  
        if (!valor.equals("")) {
            setText(valor);
            setIcon(RutaAlterna.get(index));
        }
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;

    }

}
