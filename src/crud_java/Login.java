
package crud_java;

import components.PanelCover;
import components.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Login extends javax.swing.JFrame {

    public MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize=30;
    private final double coverSize=40;
    private final double loginSize=60;
    private final DecimalFormat df = new DecimalFormat ("##0.###");
    
    public Login() {
        initComponents();
        init();
    }

    private void init (){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover ();
        loginAndRegister=new PanelLoginAndRegister();
        TimingTarget target;
        target = new TimingTargetAdapter(){
            @Override
            public void timingEvent (float fraction){
                double fractionCover;
                double fractionLogin;
                double size=coverSize;
                if(fraction<=0.5f){
                    size+= fraction * addSize;
                }else{
                    size+= addSize - fraction * addSize;
                }
                if(isLogin){
                    fractionCover=1f-fraction;
                    fractionLogin=fraction;
                    if (fraction >=0.5f){
                        cover.registerRight(fractionCover*100);
                    }else{
                        cover.loginRight(fractionLogin*100);
                    }
                }else{
                    fractionCover=fraction;
                    fractionLogin=1f-fraction;
                    if (fraction <=0.5f){
                        cover.registerLeft(fraction * 100);
                    }else{
                        cover.loginLeft((1f-fraction)*100);
                    }
                }
                if(fraction>=0.5f){
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover=Double.valueOf(df.format(fractionCover));
                fractionLogin=Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width "+size+"%, pos"+fractionCover+"al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width "+loginSize+"%, pos"+fractionLogin+"al 0 n 100%");
                bg.revalidate();
            } 
            @Override
            public void end (){
                isLogin = !isLogin;
            }  
        };
        Animator animator= new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.add(cover, "width "+coverSize+"%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width "+loginSize+"%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ae){
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        bg = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
