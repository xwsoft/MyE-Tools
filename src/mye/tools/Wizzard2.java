/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class Wizzard2 extends AbstractWin implements Runnable{
    public JLabel lb_img_step;
    boolean flagwhile=true;
    @Override
    public void run() {
        while(flagwhile){
            if(this.jProgressBar1.getValue()<this.jProgressBar1.getMaximum()){
                this.jProgressBar1.setValue(this.jProgressBar1.getValue()+1); 
                try {
                Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Wizzard2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                flagwhile = false;
                MyETools.win2.setVisible(false);
                MyETools.win1.setVisible(false);
                MyETools.wizzard1.setVisible(false);
                MyETools.wizzard2.setVisible(false);
                MyETools.wizzard3.setVisible(true);
                MyETools.wizzard3.initI18N();
                MyETools.wizzard4.setVisible(false);
                MyETools.wizzard5.setVisible(false);
            }

        }
    }
    
    /**
     * Creates new form Wizzard2
     */
    public Wizzard2() {
        initComponents();
        //图片
        ImageIcon imgWizzard = new ImageIcon(getClass().getResource("/mye/tools/src/02.png"));//背景图片
        JLabel lb_img_wizzard = new JLabel(imgWizzard);
        lb_img_wizzard.setBounds(0,0,imgWizzard.getIconWidth(),imgWizzard.getIconHeight());
        panel_wizzard_img.add(lb_img_wizzard);
        

        this.getContentPane().setBackground(Color.white);
        initI18N();

    }
    public void initI18N(){
        baseInitI18N();
        if(lb_img_step!=null){
            panel_step_img.remove(lb_img_step);
        }
        ImageIcon imgStep = new ImageIcon(getClass().getResource(ResourceUtil.getResource("img_setup2")));//背景图片
        lb_img_step = new JLabel(imgStep);
        lb_img_step.setBounds(0,0,imgStep.getIconWidth(),imgStep.getIconHeight());
        panel_step_img.add(lb_img_step);
        
        ResourceUtil resUtil = new ResourceUtil();
        String wizard = resUtil.getResource("wizzard");
        String wizard1_title1 = resUtil.getResource("wizard2_title1");
        
        lb_wizard.setText(wizard);
        lb_title1.setText(wizard1_title1);

        
        lb_wizard.setFont(resUtil.getFontDialog12());
        lb_title1.setFont(resUtil.getFont());
        
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_cancel"))));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_back"))));
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
        jProgressBar1 = new javax.swing.JProgressBar();
        btn_back = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lb_title1 = new javax.swing.JLabel();
        panel_top = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_minwindow = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lb_wizard = new javax.swing.JLabel();
        panel_wizzard_img = new javax.swing.JPanel();
        panel_step_img = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 197, -1));

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Back.png"))); // NOI18N
        btn_back.setBorder(null);
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });
        btn_back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_backMouseMoved(evt);
            }
        });
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 320, -1, 26));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Cancel.png"))); // NOI18N
        btn_cancel.setBorder(null);
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
        });
        btn_cancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_cancelMouseMoved(evt);
            }
        });
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, 26));

        lb_title1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title1.setText("The setup tools is obtaining the network configuration from you computer. Please wait...");
        jPanel3.add(lb_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 80, 561, 350));

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

    private void btn_backMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseMoved
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_back2")))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseMoved

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_back")))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_cancel")))); // NOI18N
        btn_cancel.setBorder(null);
        btn_cancel.setBorderPainted(false);
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_cancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseMoved
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_cancel2")))); // NOI18N
        btn_cancel.setBorder(null);
        btn_cancel.setBorderPainted(false);
    }//GEN-LAST:event_btn_cancelMouseMoved

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(false);
        MyETools.wizzard1.setVisible(true);
        MyETools.wizzard1.initI18N();
        MyETools.wizzard2.setVisible(false);
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(false);
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cancelActionPerformed

    //初始化后执行
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setValue(0);
        flagwhile=true;
        Thread t=new Thread(this);
        t.start();
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(Wizzard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wizzard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wizzard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wizzard2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Wizzard2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_minwindow;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lb_title1;
    private javax.swing.JLabel lb_wizard;
    private javax.swing.JPanel panel_step_img;
    private javax.swing.JPanel panel_top;
    private javax.swing.JPanel panel_wizzard_img;
    // End of variables declaration//GEN-END:variables
}
