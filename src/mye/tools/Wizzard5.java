/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class Wizzard5 extends AbstractWin {
    public JLabel lb_img_step;
    /**
     * Creates new form Wizzard4
     */
    public Wizzard5() {
        initComponents();
                                        //图片
        ImageIcon imgWizzard = new ImageIcon(getClass().getResource("/mye/tools/src/02.png"));//背景图片
        JLabel lb_img_wizzard = new JLabel(imgWizzard);
        lb_img_wizzard.setBounds(0,0,imgWizzard.getIconWidth(),imgWizzard.getIconHeight());
        panel_wizzard_img.add(lb_img_wizzard);
                
        ImageIcon imgHome3 = new ImageIcon(getClass().getResource("/mye/tools/src/home3.png"));//背景图片
        JLabel lb_img_Home3 = new JLabel(imgHome3);
        lb_img_Home3.setBounds(0,0,imgHome3.getIconWidth(),imgHome3.getIconHeight());
        jPanel1.add(lb_img_Home3);   
        
        this.getContentPane().setBackground(Color.white);
        initI18N();
    }
    public void initI18N(){
        baseInitI18N();
        if(lb_img_step!=null){
            panel_step_img.remove(lb_img_step);
        }
        ImageIcon imgStep = new ImageIcon(getClass().getResource(ResourceUtil.getResource("img_setup3")));//背景图片
        lb_img_step = new JLabel(imgStep);
        lb_img_step.setBounds(0,0,imgStep.getIconWidth(),imgStep.getIconHeight());
        panel_step_img.add(lb_img_step);
        
        ResourceUtil resUtil = new ResourceUtil();
        String wizard = resUtil.getResource("wizzard");
        String wizard5_title1 = resUtil.getResource("wizard5_title1");
        
        lb_wizard.setText(wizard);
        lb_title1.setText(wizard5_title1);

        
        lb_wizard.setFont(resUtil.getFontDialog12());
        lb_title1.setFont(resUtil.getFont());
        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_done"))));

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btn_done = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lb_title1 = new javax.swing.JLabel();
        panel_top = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_minwindow = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lb_wizard = new javax.swing.JLabel();
        panel_wizzard_img = new javax.swing.JPanel();
        panel_step_img = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(735, 440));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Done.png"))); // NOI18N
        btn_done.setBorder(null);
        btn_done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_doneMouseExited(evt);
            }
        });
        btn_done.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_doneMouseMoved(evt);
            }
        });
        btn_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doneActionPerformed(evt);
            }
        });
        jPanel3.add(btn_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(332, 226));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 229));

        lb_title1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title1.setText("Now your MyE Smart Home Gateway is ready to go!");
        jPanel3.add(lb_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 530, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 76, 551, 350));

        panel_top.setOpaque(false);
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/x.png"))); // NOI18N
        btn_close.setBorder(null);
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });
        btn_close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_closeMouseMoved(evt);
            }
        });
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        panel_top.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 26, 19));

        btn_minwindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/-.png"))); // NOI18N
        btn_minwindow.setBorder(null);
        btn_minwindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_minwindowMouseExited(evt);
            }
        });
        btn_minwindow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_minwindowMouseMoved(evt);
            }
        });
        btn_minwindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minwindowActionPerformed(evt);
            }
        });
        panel_top.add(btn_minwindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 26, 19));

        getContentPane().add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 735, 45));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_wizard.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        lb_wizard.setText("Wizard");
        jPanel4.add(lb_wizard, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 0, -1, -1));

        panel_wizzard_img.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout panel_wizzard_imgLayout = new javax.swing.GroupLayout(panel_wizzard_img);
        panel_wizzard_img.setLayout(panel_wizzard_imgLayout);
        panel_wizzard_imgLayout.setHorizontalGroup(
            panel_wizzard_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel_wizzard_imgLayout.setVerticalGroup(
            panel_wizzard_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        jPanel4.add(panel_wizzard_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 25, -1, -1));

        panel_step_img.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout panel_step_imgLayout = new javax.swing.GroupLayout(panel_step_img);
        panel_step_img.setLayout(panel_step_imgLayout);
        panel_step_imgLayout.setHorizontalGroup(
            panel_step_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        panel_step_imgLayout.setVerticalGroup(
            panel_step_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jPanel4.add(panel_step_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 130, 270));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-735)/2, (screenSize.height-440)/2, 735, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doneActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_btn_doneActionPerformed

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/x.png"))); // NOI18N
        btn_close.setBorder(null);
        btn_close.setBorderPainted(false);
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_closeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseMoved
        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/x2.png"))); // NOI18N
        btn_close.setBorder(null);
        btn_close.setBorderPainted(false);
    }//GEN-LAST:event_btn_closeMouseMoved

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_minwindowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minwindowMouseExited
        btn_minwindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/-.png"))); // NOI18N
        btn_minwindow.setBorder(null);
        btn_minwindow.setBorderPainted(false);
    }//GEN-LAST:event_btn_minwindowMouseExited

    private void btn_minwindowMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minwindowMouseMoved
        btn_minwindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/-2.png"))); // NOI18N
        btn_minwindow.setBorder(null);
        btn_minwindow.setBorderPainted(false);
    }//GEN-LAST:event_btn_minwindowMouseMoved

    private void btn_minwindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minwindowActionPerformed
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btn_minwindowActionPerformed

    private void btn_doneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_doneMouseExited
       btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_done")))); // NOI18N
        btn_done.setBorder(null);
        btn_done.setBorderPainted(false);
    }//GEN-LAST:event_btn_doneMouseExited

    private void btn_doneMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_doneMouseMoved
        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_done2")))); // NOI18N
        btn_done.setBorder(null);
        btn_done.setBorderPainted(false);
    }//GEN-LAST:event_btn_doneMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Wizzard5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wizzard5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wizzard5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wizzard5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Wizzard5().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_done;
    private javax.swing.JButton btn_minwindow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb_title1;
    private javax.swing.JLabel lb_wizard;
    private javax.swing.JPanel panel_step_img;
    private javax.swing.JPanel panel_top;
    private javax.swing.JPanel panel_wizzard_img;
    // End of variables declaration//GEN-END:variables
}
