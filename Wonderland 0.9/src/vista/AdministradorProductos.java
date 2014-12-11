package vista;

import controlador.CategoriaXML;
import controlador.InventarioXML;
import controlador.UsuarioXML;
import controlador.Validar;
import java.awt.Image;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jsockets.util.UtilFunctions;
import modelo.Productos;
import modelo.Usuario;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import vista.ListInventario;

import javax.swing.filechooser.FileNameExtensionFilter;
import jsockets.util.UtilFunctions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Jessica
 */
public class AdministradorProductos extends javax.swing.JFrame {

    String cat = "";
    String tegoria="";
    String codigo = "";
    int contador;
    int cantidadCategorias = 0;
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo1 = new DefaultListModel();
    DefaultListModel modelo2 = new DefaultListModel();
    DefaultListModel modeloLista = new DefaultListModel();
    private JLabel mensaje;
    InventarioXML regPro = new InventarioXML();
    UsuarioXML regUsu = new UsuarioXML();
    Productos produc;
    CategoriaXML regCat = new CategoriaXML();
    Usuario usu ;
    int modifica = 0;

    /**
     * Creates new form AdministradorProductos
     */
    public AdministradorProductos() {
        initComponents();
        infoCodigotxt.setEnabled(false);

    }

    public AdministradorProductos(Usuario usuario) {
        initComponents();
        
        nombreusu.setText(usuario.getNombre());
        apellidousu.setText(usuario.getApellido());
        seudonimousu.setText(usuario.getSeudonimo());
        registrousu.setText(usuario.getFReg());
        claveusu.setText(usuario.getClave());
        cedulausu.setText(usuario.getCedula());
        rolusu.setText(usuario.getRol());
        rolusu.setEnabled(false);
        infoCodigotxt.setEnabled(false);

        llenaLista();
        usu = usuario;
        
        String RutaImagenes = "src\\ImagenesUsuarios\\" + this.usu.getSeudonimo() + ".jpg";
     
     ImageIcon icon = new ImageIcon(RutaImagenes);
     Image img = icon.getImage();
     Image newImg = img.getScaledInstance(225, 360, java.awt.Image.SCALE_SMOOTH);
     ImageIcon ImagenProducto = new ImageIcon(newImg);
     this.jFotito.setIcon(ImagenProducto);
    }

    public void llenaLista() {
        ArrayList<Productos> Lista = regPro.inventario();
        for (Productos pro : Lista) {
            if (Integer.parseInt(pro.getCantidad()) <= 6) {
                Productos produc = regPro.buscarProductoSerial(pro.getSerial());
                modelo1.addElement(produc);
                listaReposicion.setModel(modelo1);
            }
        }
    }

    public void borrarCategoriasXML() {
        ArrayList<Productos> Lista = regPro.inventario();
        for (Productos pro : Lista) {
            if (pro.getSerial().equals(codigo)) {
                regCat.borrarCategoria(pro);
            }
        }
    }

    private void limpiar() {
        nomProtxt.setText("");
        descripciontxt.setText("");
        preciotxt.setText("");
        newCategoriatxt.setText("");
    }

    private void agregaAlxml(int numero) {
        int cont = 0;
        String texto = "";
        int cantidad = cantidadCategorias;
        System.out.println(cantidad);
        while (cantidad > 0) {
            while (cat.charAt(cont) != '_') {
                texto = texto + cat.charAt(cont);
                cont++;
            }
            Productos prod = new Productos("", "", "", "", texto, Integer.toString(numero));
            regCat.agregarCategoria(prod);
            cont++;
            cantidad--;
            texto = "";
        }

    }

    private void eliminarString(int indice) {
        int cont = 0;
        int posicion = 0;
        int tamTexto = 0;
        int anterior = 0;
        String texto = "";

        if (indice == 0) {
            while (cat.charAt(posicion) != '_') {
                posicion++;
            }
            cat = (cat.substring(posicion + 1, cat.length()));
        } else {
            while (cont <= indice) {
                while (cat.charAt(posicion) != '_') {
                    texto = texto + cat.charAt(posicion);
                    tamTexto++;
                    posicion++;
                }
                cont++;
                if (cont <= indice) {
                    anterior = tamTexto;
                }
                posicion++;
                tamTexto++;
            }
            cat = cat.substring(0, anterior + 1) + cat.substring(tamTexto, cat.length());

        }
        cantidadCategorias--;
    }

    private void buscarCategoriaxml(int po) { // ES PARA AGREGAR A LA LISTA DE CATEGORIAS
        ArrayList<Productos> Lista = regCat.todaslasCategorias();
        for (Productos pro : Lista) {
            if (Integer.parseInt(pro.getSerial()) == po) {
                modelo2.addElement(pro.getCategoria());

            }
        }
    }

    private void jList1ValueChanged(int index) {
        //int index = listaProductos.getSelectedIndex();
        Productos objProducto = (Productos) modeloLista.getElementAt(index);

        infoNombretxt.setText(objProducto.getNombre());
        infoDescripciontxt.setText(objProducto.getDescripcion());
        infoPreciotxt.setText(objProducto.getMonto());
        infoCantidadtxt.setText(objProducto.getCantidad());

        infoCodigotxt.setText(objProducto.getSerial());
        codigo = objProducto.getSerial();
        buscarCategoriaxml(Integer.parseInt(objProducto.getSerial()));
        produc = objProducto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        nombreusu = new javax.swing.JTextField();
        apellidousu = new javax.swing.JTextField();
        cedulausu = new javax.swing.JTextField();
        registrousu = new javax.swing.JTextField();
        seudonimousu = new javax.swing.JTextField();
        claveusu = new javax.swing.JTextField();
        rolusu = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jFoto = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jFotito = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomProtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        descripciontxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboCantidad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        preciotxt = new javax.swing.JTextField();
        ImagenB = new javax.swing.JButton();
        newCategoriatxt = new javax.swing.JTextField();
        botonAgregarCategoria = new javax.swing.JButton();
        botonGuardarPro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        botonEliminarCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buscarProductotxt = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botonVerInventario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList();
        botonMostrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        infoDescripciontxt = new javax.swing.JTextField();
        infoPreciotxt = new javax.swing.JTextField();
        infoCantidadtxt = new javax.swing.JTextField();
        infoCodigotxt = new javax.swing.JTextField();
        infoNombretxt = new javax.swing.JTextField();
        botonModificacion = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaReposicion = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Personal"));

        nombreusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreusuActionPerformed(evt);
            }
        });

        apellidousu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidousuActionPerformed(evt);
            }
        });

        cedulausu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulausuActionPerformed(evt);
            }
        });

        registrousu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrousuActionPerformed(evt);
            }
        });

        seudonimousu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seudonimousuActionPerformed(evt);
            }
        });

        claveusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveusuActionPerformed(evt);
            }
        });

        rolusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolusuActionPerformed(evt);
            }
        });

        jLabel21.setText("Nombre");

        jLabel20.setText("Apellido");

        jLabel15.setText("Cedula");

        jLabel16.setText("Nombre de Usuario");

        jLabel19.setText("Clave");

        jLabel17.setText("Fecha de Registro");

        jLabel18.setText("Rol");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(nombreusu, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apellidousu)
                            .addComponent(cedulausu)
                            .addComponent(seudonimousu)
                            .addComponent(claveusu)
                            .addComponent(registrousu)
                            .addComponent(rolusu, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreusu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(apellidousu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedulausu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seudonimousu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addComponent(claveusu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19))
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrousu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rolusu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabel14.setText("Imagen de Perfil");

        jFoto.setText("Cambiar foto");
        jFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFotoActionPerformed(evt);
            }
        });

        jButton8.setText("Guardar Cambios");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("Eliminar Cuenta");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFotito, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(154, 154, 154))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jFotito, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Datos Personales", jPanel8);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Nombre del Producto");

        jLabel2.setText("Descripcion");

        descripciontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripciontxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Nueva Categoria");

        jLabel4.setText("Cantidad");

        jComboCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" }));
        jComboCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCantidadActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio de Venta");

        preciotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciotxtActionPerformed(evt);
            }
        });

        ImagenB.setText("foto");
        ImagenB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenBActionPerformed(evt);
            }
        });

        botonAgregarCategoria.setText("Agregar a lista");
        botonAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCategoriaActionPerformed(evt);
            }
        });

        botonGuardarPro.setText("Guardar Producto ");
        botonGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarProActionPerformed(evt);
            }
        });

        jLabel7.setText("Todas las Categorias");

        botonEliminarCategoria.setText("Eliminar Categoria");
        botonEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCategoriaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaCategorias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(624, 624, 624)
                        .addComponent(botonGuardarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(ImagenB, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripciontxt)
                            .addComponent(nomProtxt)
                            .addComponent(jComboCantidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preciotxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(newCategoriatxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonEliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(88, 88, 88))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ImagenB, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descripciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(newCategoriatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(preciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addComponent(botonGuardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(84, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        jTabbedPane1.addTab("Agregar", jPanel3);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setText("Nombre del producto");

        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonVerInventario.setText("Ver Inventario");
        botonVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerInventarioActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listaProductos);

        botonMostrar.setText("Mostrar Datos");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        jLabel8.setText("Descripcion:");

        jLabel9.setText("Nombre:");

        jLabel10.setText("Cantidad:");

        jLabel11.setText("Precio:");

        jLabel12.setText("Codigo:");

        botonModificacion.setText("Guardar Modificacion");
        botonModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificacionActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Producto");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton4.setText("Cambiar Imagen");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoPreciotxt)
                    .addComponent(infoDescripciontxt, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(infoNombretxt)
                    .addComponent(infoCodigotxt)
                    .addComponent(infoCantidadtxt))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(infoNombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(infoDescripciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(infoCodigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(infoPreciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(infoCantidadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(77, 77, 77))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonVerInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(botonMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(buscarProductotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(botonBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarProductotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar", jPanel2);

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane4.setViewportView(listaReposicion);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lista para reponer", jPanel10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descripciontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripciontxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripciontxtActionPerformed

    private void preciotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciotxtActionPerformed

    private void jComboCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCantidadActionPerformed

    private void botonGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarProActionPerformed
        int numero;
        Random numale = new Random();
        numale.setSeed(new Date().getTime());
        numero = numale.nextInt(2000);
        if (Validar.validarVacio(nomProtxt,"Debe indicar el Nombre del Producto ")==1 && Validar.validarVacio(descripciontxt,"Debe indicar la descripcion del producto ") == 1 )
        {
        agregaAlxml(numero);
        String cantidad = String.valueOf(jComboCantidad.getSelectedItem());
        Productos produc = new Productos(nomProtxt.getText().toUpperCase(), descripciontxt.getText().toUpperCase(), preciotxt.getText(), cantidad, "", Integer.toString(numero));
        regPro.agregarProducto(produc);
        cat = "";
        cantidadCategorias = 0;
        limpiar();
        }
        else JOptionPane.showMessageDialog(null, "Debe llenar todos los campos ", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonGuardarProActionPerformed


    private void botonAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCategoriaActionPerformed
        String categoria = newCategoriatxt.getText().toUpperCase();
        cantidadCategorias = cantidadCategorias + 1;
        cat = cat + categoria + "_";
        modelo.addElement(categoria);
        listaCategorias.setModel(modelo);
        newCategoriatxt.setText("");

    }//GEN-LAST:event_botonAgregarCategoriaActionPerformed

    private void ImagenBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenBActionPerformed
        BasicConfigurator.configure();
        jFileChooser2= new JFileChooser();
        jFileChooser2.setFileFilter(filtro);
        int option = jFileChooser2.showOpenDialog(this);
        byte [] Producto;
        String RutaImagenes = "src\\ImagenesUsuarios";
        String ImagenProduc = nomProtxt.getText();

        if (option == JFileChooser.APPROVE_OPTION)
        {
            String file = jFileChooser2.getSelectedFile().getPath();
            String dir = jFileChooser2.getSelectedFile().toString();
            jFotito.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(225, 360, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            jFotito.setIcon(newIcon);
            jFotito.setSize(225, 360);
                        
            Producto=UtilFunctions.fileToByteArray(file); //Convierto la imagen en byte array desde la ruta
            
            
            try
            {
                Logger log = Logger.getLogger("Informacion");
                log.info("Se Guardo");
                UtilFunctions.createFileFromByteArray(Producto, RutaImagenes, ImagenProduc, "jpg", true);
            }
            catch (Exception e){
                System.out.println("Error, no se guardo");
            }            
            
    }
    }//GEN-LAST:event_ImagenBActionPerformed

    private void botonEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCategoriaActionPerformed
        // TODO add your handling code here:
        int indice;
        indice = listaCategorias.getSelectedIndex();
        eliminarString(indice);
        if (indice >= 0) {
            modelo.removeElementAt(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un indice", "Error", JOptionPane.ERROR_MESSAGE);
            mensaje.setText("NO se selecciono ningun elemento");
        }
    }//GEN-LAST:event_botonEliminarCategoriaActionPerformed

    private void botonVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerInventarioActionPerformed
        // TODO add your handling code here:
        ListInventario control = new ListInventario(regPro, usu);
        control.setLocationRelativeTo(null);
        control.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVerInventarioActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        // TODO add your handling code here:
        modifica = 0;
        Productos pro = regPro.buscarProducto(buscarProductotxt.getText());
        modeloLista.addElement(pro);
        listaProductos.setModel(modeloLista);
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        // TODO add your handling code here:
        jList1ValueChanged(listaProductos.getSelectedIndex());
    }//GEN-LAST:event_botonMostrarActionPerformed

    public void reemplazaCategorias() {
        int index = 0;
            Productos objProducto =  (Productos) modelo2.getElementAt(index);
            String categoria = objectToString(objProducto); 
            System.out.println(categoria);
            Productos pro = new Productos("","","","",categoria,codigo);
            regCat.agregarCategoria(pro);
            index++;
      
    }

    private void botonModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificacionActionPerformed
        // TODO add your handling code here:
        produc.setNombre(infoNombretxt.getText());
        produc.setDescripcion(infoDescripciontxt.getText());
        produc.setMonto(infoPreciotxt.getText());
        produc.setCantidad(infoCantidadtxt.getText());
        regPro.actualizarProducto(produc);
       // borrarCategoriasXML(); // BORRA TODOS LOS DATOS DEL XML DE CATEGORIAS DEL PRODUCTO ESPECIFICO
       //reemplazaCategorias();// reecribe las categorias o las reemplaza
        codigo="";
        llenaLista();
    }//GEN-LAST:event_botonModificacionActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        borrarCategoriasXML();
        regPro.borrarProducto(produc.getNombre());
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void nombreusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreusuActionPerformed

    private void apellidousuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidousuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidousuActionPerformed

    private void cedulausuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulausuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulausuActionPerformed

    private void registrousuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrousuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrousuActionPerformed

    private void seudonimousuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seudonimousuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seudonimousuActionPerformed

    private void claveusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_claveusuActionPerformed

    private void rolusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rolusuActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        usu.setApellido(apellidousu.getText());
        usu.setCedula(cedulausu.getText());
        usu.setNombre(nombreusu.getText());
        usu.setSeudonimo(seudonimousu.getText());
        usu.setRol(rolusu.getText());
        usu.setFReg(registrousu.getText());
        regUsu.actualizarUsuario(usu);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFotoActionPerformed
BasicConfigurator.configure();
        jFileChooser2= new JFileChooser();
        jFileChooser2.setFileFilter(filtro);
        int option = jFileChooser2.showOpenDialog(this);
        byte [] Producto;
        String RutaImagenes = "src\\Imagenes";
        String ImagenProduc = nombreusu.getText();

        if (option == JFileChooser.APPROVE_OPTION)
        {
            String file = jFileChooser2.getSelectedFile().getPath();
            String dir = jFileChooser2.getSelectedFile().toString();
            jFoto.setIcon(new ImageIcon(file));
            ImageIcon icon = new ImageIcon(file);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(225, 360, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            jFoto.setIcon(newIcon);
            jFoto.setSize(225, 360);
                        
            Producto=UtilFunctions.fileToByteArray(file); //Convierto la imagen en byte array desde la ruta
            
            
            try
            {
                Logger log = Logger.getLogger("Informacion");
                log.info("Se Guardo");
                UtilFunctions.createFileFromByteArray(Producto, RutaImagenes, ImagenProduc, "jpg", true);
            }
            catch (Exception e){
                System.out.println("Error, no se guardo");
            }            
            
        }      
    }//GEN-LAST:event_jFotoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministradorProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImagenB;
    private javax.swing.JTextField apellidousu;
    private javax.swing.JButton botonAgregarCategoria;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarCategoria;
    private javax.swing.JButton botonGuardarPro;
    private javax.swing.JButton botonModificacion;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonVerInventario;
    private javax.swing.JTextField buscarProductotxt;
    private javax.swing.JTextField cedulausu;
    private javax.swing.JTextField claveusu;
    private javax.swing.JTextField descripciontxt;
    private javax.swing.JTextField infoCantidadtxt;
    private javax.swing.JTextField infoCodigotxt;
    private javax.swing.JTextField infoDescripciontxt;
    private javax.swing.JTextField infoNombretxt;
    private javax.swing.JTextField infoPreciotxt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboCantidad;
    private javax.swing.JLabel jFotito;
    private javax.swing.JButton jFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList listaCategorias;
    private javax.swing.JList listaProductos;
    private javax.swing.JList listaReposicion;
    private javax.swing.JTextField newCategoriatxt;
    private javax.swing.JTextField nomProtxt;
    private javax.swing.JTextField nombreusu;
    private javax.swing.JTextField preciotxt;
    private javax.swing.JTextField registrousu;
    private javax.swing.JTextField rolusu;
    private javax.swing.JTextField seudonimousu;
    // End of variables declaration//GEN-END:variables

    private String objectToString(Productos objProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String objectToString(Object objProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private javax.swing.JFileChooser jFileChooser2;
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen","jpg");
 

}
