package crud_java;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Formulario extends javax.swing.JFrame {
    
    private String selectedID;
    private String selectedCodigo;
    private String selectedNombre;
    private String selectedEstado;
    private String selectedPrecio;
    private String selectedDescripcion;
    private String selectedExistencias;
    
    public Formulario() {
        initComponents();
        // Llena la tabla con datos al iniciar el JFrame
        llenarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tBuscar = new javax.swing.JTextField();
        tCodigo = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tPrecio = new javax.swing.JTextField();
        tDescripcion = new javax.swing.JTextField();
        tExistencias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btLista = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnGenerarPDF = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnRegistrarRetiro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(252, 194, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Inventario de Productos");
        jLabel7.setMaximumSize(new java.awt.Dimension(120, 14));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 510, 40));

        btEliminar.setBackground(new java.awt.Color(255, 51, 0));
        btEliminar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btEliminar.setForeground(new java.awt.Color(255, 0, 0));
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/Delete.png"))); // NOI18N
        btEliminar.setBorder(null);
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 40, 40));

        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 800, 230));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 40, 40));

        tBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(tBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 180, 30));
        jPanel1.add(tCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, 30));
        jPanel1.add(tNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 30));
        jPanel1.add(tEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Existencias");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, -1));
        jPanel1.add(tPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 130, 30));
        jPanel1.add(tDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 240, 30));
        jPanel1.add(tExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/Guardar.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 40, 40));

        btLista.setBackground(new java.awt.Color(51, 255, 51));
        btLista.setForeground(new java.awt.Color(51, 255, 51));
        btLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/Listar.jpg"))); // NOI18N
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });
        jPanel1.add(btLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 40, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Código");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, -1));

        jPanel3.setBackground(new java.awt.Color(252, 194, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(204, 255, 204));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/Modificar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 360, 250));

        btnGenerarPDF.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/PDF.png"))); // NOI18N
        btnGenerarPDF.setToolTipText("");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 40, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/pizzzaaaa.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 200, 200));

        btnRegistrarRetiro.setText("Registrar Retiro");
        btnRegistrarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarRetiroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla() {
        DefaultTableModel md = new DefaultTableModel();
        ResultSet rs = metodo.ListarTabla("select * from producto");
        md.setColumnIdentifiers(new Object[]{"ID", "CODIGO", "NOMBRE", "ESTADO", "PRECIO", "DESCRIPCION", "EXISTENCIAS"});

        try {

            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("ID"), rs.getInt("CODIGO"), rs.getString("NOMBRE"), rs.getString("ESTADO"), rs.getFloat("PRECIO"), rs.getString("DESCRIPCION"), rs.getInt("EXISTENCIAS")});
            }

            tablaLista.setModel(md);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Productos x = new Productos ();
        x.setCodigo(Integer.parseInt(tCodigo.getText()));
        x.setNombre(tNombre.getText());
        x.setEstado(tEstado.getText());
        x.setPrecio(Float.parseFloat(tPrecio.getText()));
        x.setDescripcion(tDescripcion.getText());
        x.setExistencias(Integer.parseInt(tExistencias.getText()));
        
        if (metodo.Insertar(x)){
            
            JOptionPane.showMessageDialog(null, "Producto Registrado");
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Error al Registrar");
            
        }
        
        tCodigo.setText("");
        tNombre.setText("");
        tEstado.setText("");
        tPrecio.setText("");
        tDescripcion.setText("");
        tExistencias.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int fila=tablaLista.getSelectedRowCount();
        
        if (fila<1){
        JOptionPane.showMessageDialog(null, "Seleccione un Registro");
        
        }
        else{
            if (metodo.Eliminar(tablaLista.getValueAt(tablaLista.getSelectedRow(),0).toString())){
                
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                
            }
            
        }
        tCodigo.setText("");
        tNombre.setText("");
        tEstado.setText("");
        tPrecio.setText("");
        tDescripcion.setText("");
        tExistencias.setText("");
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        
        DefaultTableModel md = new DefaultTableModel();
        ResultSet rs = metodo.ListarTabla("select * from producto");
        md.setColumnIdentifiers(new Object[]{"ID","CODIGO","NOMBRE","ESTADO","PRECIO","DESCRIPCION","EXISTENCIAS"});
        
        try {
            
            while (rs.next()){
                
                md.addRow(new Object[]{rs.getInt("ID"),rs.getInt("CODIGO"),rs.getString("NOMBRE"),rs.getString("ESTADO"),rs.getFloat("PRECIO"),rs.getString("DESCRIPCION"),rs.getInt("EXISTENCIAS")});
                tablaLista.setModel(md);
            }
            
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        
    }//GEN-LAST:event_btListaActionPerformed

    private void tBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscarActionPerformed
        // TODO addour dling code here:
    }//GEN-LAST:event_tBuscarActionPerformed

    public void buscar (String buscar){
        
        metodo p = new metodo();
    
    DefaultTableModel modelo=p.Buscar(buscar);
    tablaLista.setModel(modelo);
    
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        buscar(tBuscar.getText());
        
        tBuscar.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListaMouseClicked
       int selectedRow = tablaLista.getSelectedRow();
    if (selectedRow >= 0) {
        selectedID = tablaLista.getValueAt(selectedRow, 0).toString();
        selectedCodigo = tablaLista.getValueAt(selectedRow, 1).toString();
        selectedNombre = tablaLista.getValueAt(selectedRow, 2).toString();
        selectedEstado = tablaLista.getValueAt(selectedRow, 3).toString();
        selectedPrecio = tablaLista.getValueAt(selectedRow, 4).toString();
        selectedDescripcion = tablaLista.getValueAt(selectedRow, 5).toString();
        selectedExistencias = tablaLista.getValueAt(selectedRow, 6).toString();

        // Mostrar los valores en los cuadros de texto
        tCodigo.setText(selectedCodigo);
        tNombre.setText(selectedNombre);
        tEstado.setText(selectedEstado);
        tPrecio.setText(selectedPrecio);
        tDescripcion.setText(selectedDescripcion);
        tExistencias.setText(selectedExistencias);
    }
    }//GEN-LAST:event_tablaListaMouseClicked

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        try {
        // Ruta del archivo PDF en el Escritorio
        String desktopPath = System.getProperty("user.home") + "\\Documents\\ReporteInventario.pdf";

        // Crear un documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(desktopPath));
        document.open();

        // Agregar título centrado
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Reporte del Inventario de Productos", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Espacio en blanco después del título
        document.add(new Paragraph("\n"));

        // Ajustar el tamaño de las columnas de la tabla
        PdfPTable table = new PdfPTable(7); // 7 columnas para tus datos
        float[] columnWidths = {1f, 1f, 2.5f, 1f, 1f, 3f, 1.5f}; // Ancho relativo de las columnas
        table.setWidths(columnWidths);
        table.setWidthPercentage(95); // Porcentaje del ancho de página ocupado por la tabla
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        // Agregar encabezados de tabla
        table.addCell("ID");
        table.addCell("Código");
        table.addCell("Nombre");
        table.addCell("Estado");
        table.addCell("Precio");
        table.addCell("Descripción");
        table.addCell("Existencias");

        // Obtener datos de la base de datos y agregarlos a la tabla
        ResultSet rs = metodo.ListarTabla("SELECT * FROM producto");
        while (rs.next()) {
            table.addCell(rs.getString("ID"));
            table.addCell(rs.getString("CODIGO"));
            table.addCell(rs.getString("NOMBRE"));
            table.addCell(rs.getString("ESTADO"));
            table.addCell(rs.getString("PRECIO"));
            table.addCell(rs.getString("DESCRIPCION"));
            table.addCell(rs.getString("EXISTENCIAS"));
        }

        // Agregar la tabla al documento
        document.add(table);

        // Cerrar el documento
        document.close();

        JOptionPane.showMessageDialog(this, "PDF generado exitosamente");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
        if (selectedID != null) {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/producto", "root", "miumg2023");
            String sql = "UPDATE producto SET CODIGO = ?, NOMBRE = ?, ESTADO = ?, PRECIO = ?, DESCRIPCION = ?, EXISTENCIAS = ? WHERE ID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, tCodigo.getText());
            pst.setString(2, tNombre.getText());
            pst.setString(3, tEstado.getText());
            pst.setString(4, tPrecio.getText());
            pst.setString(5, tDescripcion.getText());
            pst.setString(6, tExistencias.getText());
            pst.setString(7, selectedID);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Registro sin Encontrar");
            }

            // Limpia las variables de instancia después de la modificación
            selectedID = null;

            cn.close();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro para modificar.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al modificar los datos: " + e.getMessage());
    }
        tCodigo.setText("");
        tNombre.setText("");
        tEstado.setText("");
        tPrecio.setText("");
        tDescripcion.setText("");
        tExistencias.setText("");
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarRetiroActionPerformed
        Salidas salidasFrame = new Salidas();
        salidasFrame.setVisible(true);
    }//GEN-LAST:event_btnRegistrarRetiroActionPerformed
    
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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrarRetiro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBuscar;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tDescripcion;
    private javax.swing.JTextField tEstado;
    private javax.swing.JTextField tExistencias;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tPrecio;
    private javax.swing.JTable tablaLista;
    // End of variables declaration//GEN-END:variables
}
