/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellness;

import Administrador.*;
import java.awt.Color;
import java.sql.*;
import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author danig
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String user = "root";
    String password = "password";
    String usuarioSISTEMA;
    public static String usuarioIngresado;
    char[] clave;
    Hashtable<String, String> tabla;
    HashTable hash = new HashTable(100);

    public Login() {
        this.tabla = new Hashtable();
        this.hash = new HashTable(100);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Wellness Mentality");
        setRegisters();
    }

    public void setRegisters() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/prueba1", user, password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM infoclientes");
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                tabla.put(result.getString("Correo"), result.getString("Contraseña"));
                hash.set(result.getString("Correo"), result.getString("Contraseña"));
            }
            //con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnAbrirRegistro = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 102));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WellnessMentality");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 740, 80));

        jPanel3.setBackground(new java.awt.Color(153, 0, 102));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inicia sesión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 70));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        txtCorreo.setToolTipText("Ingresa tu correo electronico");
        txtCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 340, -1));

        txtContraseña.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtContraseña.setToolTipText("Ingresa tu contraseña");
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 340, -1));

        btnAbrirRegistro.setBackground(new java.awt.Color(153, 0, 102));
        btnAbrirRegistro.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        btnAbrirRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirRegistro.setText("No tienes cuenta? Crea una al instante");
        btnAbrirRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAbrirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrirRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        btnAdmin.setBackground(new java.awt.Color(153, 0, 102));
        btnAdmin.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmin.setText("Ingresar como admin.");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 170, 20));

        btnLogin1.setBackground(new java.awt.Color(153, 0, 102));
        btnLogin1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setText("Ingresar");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnAbrirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirRegistroActionPerformed
        Registro interRegistro = new Registro();
        interRegistro.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnAbrirRegistroActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        LoginAdmin loginAdmin = new LoginAdmin();
        loginAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed

        try {
            String usuarioIngresado = txtCorreo.getText().trim();
            String newpassword = new String(txtContraseña.getPassword());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/prueba1", user, password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM infoclientes WHERE Correo = ?");

            pst.setString(1, usuarioIngresado);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (newpassword.equals(hash.get(usuarioIngresado))) {
                    Main interMain = new Main();
                    interMain.jLabel1.setText("BIENVENIDO " + rs.getString("Nombre"));
                    this.setVisible(false);
                    interMain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos erroneos");
                }

            }
            //System.out.println(tabla.get(user));
        } catch (SQLException e ) {
            System.out.println(e);
        }

        /*try {
            String usuarioIngresado = txtCorreo.getText().trim();
            char[] contraseñaIngresada = txtContraseña.getPassword();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/wellness", user, password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM infoclientes WHERE Correo = ?");

            pst.setString(1, usuarioIngresado);
            if (!txtCorreo.getText().equals("") && !(txtContraseña.getPassword().length == 0)) {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    usuarioSISTEMA = rs.getString("Correo");
                    clave = rs.getString("Password").toCharArray();

                    if (usuarioIngresado.equals(usuarioSISTEMA) && Arrays.equals(contraseñaIngresada, clave)) {
                        Main interMain = new Main();
                        interMain.jLabel1.setText("BIENVENIDO " + rs.getString("Nombre"));
                        this.setVisible(false);
                        
                        interMain.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos, vuelve a intentar");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }*/
    }//GEN-LAST:event_btnLogin1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirRegistro;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}