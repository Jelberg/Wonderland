/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import jsockets.util.UtilFunctions;
import model.Productos;
import model.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Jessica
 */
public class ControladorProductos {

    public static void guardaFoto(JLabel jFotito, JFileChooser jFileChooser2, FileNameExtensionFilter filtro, String code) {
        BasicConfigurator.configure();
        jFileChooser2 = new JFileChooser();
        jFileChooser2.setFileFilter(filtro);
        jFotito.setText("");
        int option = jFileChooser2.showOpenDialog(null);
        byte[] Producto;
        String RutaImagenes = "src\\ImagenesProductos";
        String ImagenProduc = code;

        if (option == JFileChooser.APPROVE_OPTION) {
            String file = jFileChooser2.getSelectedFile().getPath();
            String dir = jFileChooser2.getSelectedFile().toString();
            jFotito.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(227, 284, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            jFotito.setIcon(newIcon);
            jFotito.setSize(227, 284);

            Producto = UtilFunctions.fileToByteArray(file); //Convierto la imagen en byte array desde la ruta

            try {
                Logger log = Logger.getLogger("Informacion");
                log.info("Se Guardo");
                UtilFunctions.createFileFromByteArray(Producto, RutaImagenes, ImagenProduc, "jpg", true);
            } catch (Exception e) {
                System.out.println("Error, no se guardo");
            }

        }
    }

    public static String producirSerial() {
        int numero;
        Random numale = new Random();
        numale.setSeed(new Date().getTime());
        numero = numale.nextInt(2000);
        String st = Integer.toString(numero);
        return st;
    }

    public static Productos obtenerDatosPro(String Nombre, String Precio, String Cantidad, String Serial, Usuario usuario) {
        InventarioXML regPro = new InventarioXML();
        Productos productos = new Productos(Nombre, "", Precio, Cantidad, "", Serial, usuario.getSeudonimo());
        regPro.agregarProducto(productos);
        return productos;
    }

    public static void mostrarImagenProducto(Productos pro, JLabel foto, String numero, int horizontal, int vertical) {
        String code = pro.getSerial() + numero;
        foto.setText("");
        String RutaImagenes = "src\\imagenesProductos\\" + code + ".jpg";
        ImageIcon icon = new ImageIcon(RutaImagenes);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(horizontal, vertical, java.awt.Image.SCALE_SMOOTH);
        ImageIcon ImagenProducto = new ImageIcon(newImg);
        foto.setIcon(ImagenProducto);
    }

    public static Productos objetoProducto(Productos pro) {
        return pro;
    }

    public static String buscaImagen(Productos producto) {
        String serial = producto.getSerial();
        String ruta = "src\\imagenesProductos\\" + serial + "1" + ".jpg";
        return ruta;
    }

    public static void llenaLista(InventarioXML pro, JList lista, DefaultListModel modelo) {
        ArrayList<Productos> Lista = pro.inventario();
        for (Productos prod : Lista) {
            Productos produc = pro.buscarObj(prod);
            modelo.addElement(produc);
            lista.setModel(modelo);
            lista.setCellRenderer(new RenderLista(prod));
        }
    }

    public static void llenaListaCarrito(CarritoXML pro, InventarioXML regPro, JList lista, DefaultListModel modelo, Usuario usu) {
        ArrayList<Productos> Lista = pro.carrito();
        for (Productos prod : Lista) {
            if (prod.getNombre().equals(usu.getSeudonimo())) {
                Productos produc = regPro.buscarProductoSerial(prod.getSerial());;
                modelo.addElement(produc);
                lista.setModel(modelo);
                lista.setCellRenderer(new RenderLista(prod));
            }
        }
    }

    public static void eliminaDelCarrito(DefaultListModel modelo1, int index, CarritoXML car, Usuario usu) {
        Productos objProducto = (Productos) modelo1.getElementAt(index);
        car.borrarCarrito(objProducto, usu);
        JOptionPane.showMessageDialog(null, "Producto eliminado del carrito", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void llenaTablaInventario(JTable tablaInventario, InventarioXML DatUsu, DefaultTableModel dtm) {
        ArrayList<Productos> Lista = DatUsu.inventario();
        for (Productos est : Lista) {
            String[] row = {est.getNombre(), est.getCategoria(), est.getMonto(), est.getProveedor(),
                est.getCantidad(), est.getSerial()};
            dtm.addRow(row);
        }
        tablaInventario.setModel(dtm);
    }

    public static void llenaListaCat(DefaultListModel dtm, String[] categorias, JList lista) {
        for (String cat : categorias) {
            dtm.addElement(cat);
            lista.setModel(dtm);
        }
    }

    public static String subTotal(String cantidad, String precio) {
        String total;
        Double cant, prec, monto;
        cant = Double.parseDouble(cantidad);
        prec = Double.parseDouble(precio);
        monto = cant * prec;
        total = Double.toString(monto);
        return total;
    }

    public static String precioIVA(String total) {
        Double monto, iva;
        monto = Double.parseDouble(total);
        iva = 0.125 * monto + monto;
        total = Double.toString(iva);
        return total;
    }

    public static void restaInventario(InventarioXML DatPro,Productos producto, String serial, String cantidadRestante) {
        int cantidad, restante, resultado;
        String total;
        producto = DatPro.buscarProductoSerial(serial);
        cantidad = Integer.parseInt(producto.getCantidad());
        restante = Integer.parseInt(cantidadRestante);
        resultado = cantidad - restante;
        total = Integer.toString(resultado);
        producto.setCantidad(total);
        DatPro.actualizarProducto(producto);
    }

}
