package components;

import com.crud.swing.Button;
import com.crud.swing.MyPasswordField;
import com.crud.swing.MyTextField;
import crud_java.Formulario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    
    private void initRegister(){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Crea tu Cuenta");
        label.setFont(new Font ("sansserif", 1, 30));
        label.setForeground(new Color(252,194,0));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/images/icon/user.png")));
        txtUser.setHint("Nombre");
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/images/icon/mail.png")));
        txtEmail.setHint("Correo");
        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/images/icon/pass.png")));
        txtPass.setHint("Contraseña");
        register.add(txtPass, "w 60%");
        Button cmd=new Button();
        cmd.setBackground(new Color(252,194,0));
        cmd.setForeground(new Color (250,250,250));
        cmd.setText("REGISTRARSE");
        register.add(cmd,"w 40%, h 40");
    }
    
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Inicia Sesión");
        label.setFont(new Font ("sansserif", 1, 30));
        label.setForeground(new Color(252,194,0));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/images/icon/mail.png")));
        txtEmail.setHint("Correo");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/images/icon/pass.png")));
        txtPass.setHint("Contraseña");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("¿Olvidaste tu Contraseña?");
        cmdForget.setForeground(new Color(100,100,100));
        cmdForget.setFont(new Font ("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor (Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd=new Button();
        cmd.setBackground(new Color(252,194,0));
        cmd.setForeground(new Color (250,250,250));
        cmd.setText("INICIAR SESIÓN");
        login.add(cmd,"w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String correoIngresado = txtEmail.getText();
        String contraseñaIngresada = new String(txtPass.getPassword());

        // Validar las credenciales
        String correoValido = "angelyos@gmail.com";
        String contraseñaValida = "programacionII";

        if (correoIngresado.equals(correoValido) && contraseñaIngresada.equals(contraseñaValida)) {
            // Credenciales válidas, permitir el acceso al siguiente JFrame
            JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(login);
            thisFrame.dispose();
            Formulario c = new Formulario();
            c.setVisible(true);
        } else {
            // Credenciales incorrectas, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Error de Credenciales", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    });
    }
    
    
    public void showRegister (boolean show){
        if (show){
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
