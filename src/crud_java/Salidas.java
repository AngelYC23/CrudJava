package crud_java;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Salidas extends javax.swing.JFrame {


    public Salidas() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rCodigo = new javax.swing.JTextField();
        rNombre = new javax.swing.JTextField();
        rCantidad = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/pizzzaaaa.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 200, 200));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REGISTRO DE RETIRO DE PRODUCTOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel1.add(rCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, -1));
        jPanel1.add(rNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));
        jPanel1.add(rCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 140, -1));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código del Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad a Retirar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String codigo = rCodigo.getText();
    String nombre = rNombre.getText();
    int cantidadRetiro = Integer.parseInt(rCantidad.getText());

    // Realiza la resta en la base de datos
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/producto", "root", "miumg2023");
        String sql = "UPDATE producto SET EXISTENCIAS = EXISTENCIAS - ? WHERE CODIGO = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cantidadRetiro);
        pst.setString(2, codigo);
        
        int rowsAffected = pst.executeUpdate();
        
        if (rowsAffected > 0) {
            // Actualización exitosa
            generarPDF(codigo, nombre, cantidadRetiro); // Llama a la función para generar el PDF
            JOptionPane.showMessageDialog(this, "Operación completada con éxito");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el producto con el código especificado");
        }

        con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar la base de datos: " + e.getMessage());
    }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void generarPDF(String codigo, String nombre, int cantidadRetiro) {
    try {
        // Ruta donde se guardará el PDF
        String filePath = System.getProperty("user.home") + "\\Documents\\Reporte de Retiro.pdf";

        // Crear un documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Agregar contenido al PDF
        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph paragraph = new Paragraph("Informe de Retiro de Producto\n\n", font);
        paragraph.add("Código de Producto: " + codigo + "\n");
        paragraph.add("Nombre de Producto: " + nombre + "\n");
        paragraph.add("Cantidad Retirada: " + cantidadRetiro + "\n");

        // Agregar el párrafo al documento
        document.add(paragraph);

        // Cerrar el documento
        document.close();

        JOptionPane.showMessageDialog(this, "Informe PDF generado con éxito");

    } catch (DocumentException | FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Error al generar el informe PDF: " + e.getMessage());
    }
}
    
    
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
            java.util.logging.Logger.getLogger(Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField rCantidad;
    private javax.swing.JTextField rCodigo;
    private javax.swing.JTextField rNombre;
    // End of variables declaration//GEN-END:variables
}
