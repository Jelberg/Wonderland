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

/**
 *
 * @author Jessica
 */
public class RenderLista extends JLabel implements ListCellRenderer {

    private Productos prod;

    public RenderLista(Productos prod) {
        this.prod = prod;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        String RutaImagenes = ControladorProductos.buscaImagen(prod);
        ImageIcon icon = new ImageIcon(RutaImagenes);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon ImagenProducto = new ImageIcon(newImg);

        String valor = value.toString();
        if (!valor.equals("")) {
            setText(valor);
            setIcon(ImagenProducto);
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
