/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InventarioXML;
import model.Productos;
import model.Usuario;

/**
 *
 * @author Jessica
 */
public class PerfilUsuario extends javax.swing.JFrame {

    InventarioXML DatPro = new InventarioXML();
    Usuario usuario;

    /**
     * Creates new form PerfilUsuario
     */
    public PerfilUsuario() {
        initComponents();

    }

    public PerfilUsuario(Usuario usu) {
        initComponents();
        usuario = usu;
        LabelUsuario.setText(usuario.getSeudonimo());
        LabelSeudonimo.setText(usuario.getSeudonimo() + " !");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        producto = new javax.swing.JTextField();
        LabelVolver = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        LabelBuscar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelSeudonimo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LabelCantSolicitudes = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        LabelCarrito = new javax.swing.JLabel();
        carritotxt = new javax.swing.JTextField();
        comprastxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        LabelDatos = new javax.swing.JLabel();
        LabelCuenta = new javax.swing.JLabel();
        LabelMetodos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 102));
        jLabel25.setText("Wonderland");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 40));

        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        jPanel4.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 350, 40));

        LabelVolver.setForeground(new java.awt.Color(102, 102, 102));
        LabelVolver.setText("Volver");
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        jPanel4.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, 30));

        LabelUsuario.setForeground(new java.awt.Color(102, 102, 102));
        LabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/perfil.png"))); // NOI18N
        LabelUsuario.setText("Usuario");
        jPanel4.add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        LabelBuscar.setForeground(new java.awt.Color(102, 102, 102));
        LabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/buscar.png"))); // NOI18N
        LabelBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelBuscarMouseClicked(evt);
            }
        });
        jPanel4.add(LabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 50, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(180, 40, 0, 0);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(190, 200, 30, 0);

        LabelSeudonimo.setBackground(new java.awt.Color(255, 153, 51));
        LabelSeudonimo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelSeudonimo.setForeground(new java.awt.Color(102, 102, 102));
        LabelSeudonimo.setText("Usuario ");
        jPanel2.add(LabelSeudonimo);
        LabelSeudonimo.setBounds(420, 30, 260, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText(" Bienvenido :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(260, 30, 160, 29);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/solicitudes.png"))); // NOI18N
        jLabel3.setText("Solicitudes");

        LabelCantSolicitudes.setForeground(new java.awt.Color(51, 51, 51));
        LabelCantSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        LabelCantSolicitudes.setText("Respuesta de solicitudes Pendientes");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        jLabel7.setText("Pedir Solicitud de Cambio de rol");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCantSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelCantSolicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(470, 300, 360, 170);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/compra.png"))); // NOI18N
        jLabel12.setText("Operaciones");

        LabelCarrito.setForeground(new java.awt.Color(51, 51, 51));
        LabelCarrito.setText("Carrito");
        LabelCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelCarritoMouseClicked(evt);
            }
        });

        carritotxt.setBackground(new java.awt.Color(153, 153, 153));
        carritotxt.setForeground(new java.awt.Color(255, 255, 255));
        carritotxt.setText("0");
        carritotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carritotxtActionPerformed(evt);
            }
        });

        comprastxt.setBackground(new java.awt.Color(153, 153, 153));
        comprastxt.setForeground(new java.awt.Color(255, 255, 255));
        comprastxt.setText("0");
        comprastxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprastxtActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Compras");

        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        jLabel9.setText("Ver Facturas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(carritotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comprastxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carritotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comprastxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addGap(148, 148, 148))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(170, 90, 290, 380);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/solicitudes.png"))); // NOI18N
        jLabel11.setText("Configuracion");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 162, -1));

        LabelDatos.setForeground(new java.awt.Color(51, 51, 51));
        LabelDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        LabelDatos.setText("Datos personales");
        LabelDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelDatosMouseClicked(evt);
            }
        });
        jPanel5.add(LabelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 30));

        LabelCuenta.setForeground(new java.awt.Color(51, 51, 51));
        LabelCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        LabelCuenta.setText("Datos de Cuenta");
        LabelCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelCuentaMouseClicked(evt);
            }
        });
        jPanel5.add(LabelCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 140, 30));

        LabelMetodos.setForeground(new java.awt.Color(51, 51, 51));
        LabelMetodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSistema/check2.png"))); // NOI18N
        LabelMetodos.setText("Metodos de págo");
        LabelMetodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelMetodosMouseClicked(evt);
            }
        });
        jPanel5.add(LabelMetodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 140, 30));

        jPanel2.add(jPanel5);
        jPanel5.setBounds(470, 90, 360, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productoActionPerformed

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        Principal control2 = new Principal(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelVolverMouseClicked

    private void carritotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carritotxtActionPerformed

    private void comprastxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprastxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprastxtActionPerformed

    private void LabelDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosMouseClicked
        // TODO add your handling code here:
        DatosPersonales control2 = new DatosPersonales(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelDatosMouseClicked

    private void LabelCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCuentaMouseClicked
        // TODO add your handling code here:
        DatosCuenta control2 = new DatosCuenta(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelCuentaMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        CambioUsuario control2 = new CambioUsuario(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void LabelCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCarritoMouseClicked
        // TODO add your handling code here:
        DatosCarrito control2 = new DatosCarrito(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelCarritoMouseClicked

    private void LabelBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelBuscarMouseClicked
        // TODO add your handling code here:
        Productos est = DatPro.buscarProducto(producto.getText().toUpperCase());
        if (est != null) {
            ListaBusqueda control2 = new ListaBusqueda(est, usuario);
            control2.setLocationRelativeTo(null);
            control2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LabelBuscarMouseClicked

    private void LabelMetodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelMetodosMouseClicked
        Metodos control2 = new Metodos(usuario);
        control2.setLocationRelativeTo(null);
        control2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelMetodosMouseClicked

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
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBuscar;
    private javax.swing.JLabel LabelCantSolicitudes;
    private javax.swing.JLabel LabelCarrito;
    private javax.swing.JLabel LabelCuenta;
    private javax.swing.JLabel LabelDatos;
    private javax.swing.JLabel LabelMetodos;
    private javax.swing.JLabel LabelSeudonimo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JTextField carritotxt;
    private javax.swing.JTextField comprastxt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField producto;
    // End of variables declaration//GEN-END:variables
}
