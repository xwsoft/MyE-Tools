/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.awt.Color;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 点击next 开发送指令查找硬件
 * @author Administrator
 */
public class Wizzard1 extends AbstractWin {
    public JLabel lb_img_step;
    /**
     * Creates new form Wizzard1
     */
    public Wizzard1() {
        initComponents();
        //图片
        ImageIcon imgWizzard = new ImageIcon(getClass().getResource("/mye/tools/src/02.png"));//背景图片
        JLabel lb_img_wizzard = new JLabel(imgWizzard);
        lb_img_wizzard.setBounds(0,0,imgWizzard.getIconWidth(),imgWizzard.getIconHeight());
        panel_wizzard_img.add(lb_img_wizzard);
        
/*        ImageIcon imgStep = new ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_setup1")));//背景图片
        JLabel lb_img_step = new JLabel(imgStep);
        lb_img_step.setBounds(0,0,imgStep.getIconWidth(),imgStep.getIconHeight());
        panel_step_img.add(lb_img_step);
        */
        ImageIcon imgHome2 = new ImageIcon(getClass().getResource("/mye/tools/src/home2.png"));//背景图片
        JLabel lb_img_Home2 = new JLabel(imgHome2);
        lb_img_Home2.setBounds(0,0,imgHome2.getIconWidth(),imgHome2.getIconHeight());
        jPanel1.add(lb_img_Home2);   
        
        this.getContentPane().setBackground(Color.white);
        this.setBackground(Color.white);
        initI18N();
    }
    public void initI18N(){
        baseInitI18N();
        if(lb_img_step!=null){
            panel_step_img.remove(lb_img_step);
        }
        ImageIcon imgStep = new ImageIcon(getClass().getResource(ResourceUtil.getResource("img_setup1")));//背景图片
        lb_img_step = new JLabel(imgStep);
        lb_img_step.setBounds(0,0,imgStep.getIconWidth(),imgStep.getIconHeight());
        panel_step_img.add(lb_img_step);
        
        ResourceUtil resUtil = new ResourceUtil();
        String wizard = resUtil.getResource("wizzard");
        String wizard1_title1 = ResourceUtil.getResource("wizard1_title1");
        String wizard1_title2 = resUtil.getResource("wizard1_title2");
        String wizard1_title3 = resUtil.getResource("wizard1_title3");

        lb_wizard.setText(wizard);
        lb_title1.setText(wizard1_title1);
        lb_title2.setText(wizard1_title2);
        lb_next.setText(wizard1_title3);

        
        lb_wizard.setFont(ResourceUtil.getFontDialog12());
        
        lb_title1.setFont(ResourceUtil.getFont());
        lb_title2.setFont(resUtil.getFont());
        lb_next.setFont(resUtil.getFont12());
        
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_next"))));
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

        jPanel2 = new javax.swing.JPanel();
        lb_wizard = new javax.swing.JLabel();
        panel_wizzard_img = new javax.swing.JPanel();
        panel_step_img = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_next = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        lb_next = new javax.swing.JLabel();
        lb_title1 = new javax.swing.JLabel();
        lb_title2 = new javax.swing.JLabel();
        panel_top = new javax.swing.JPanel();
        btn_minwindow = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_wizard.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        lb_wizard.setText("Wizard");
        jPanel2.add(lb_wizard, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 0, -1, -1));

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

        jPanel2.add(panel_wizzard_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 25, -1, -1));

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

        jPanel2.add(panel_step_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, 268));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Next.png"))); // NOI18N
        btn_next.setBorder(null);
        btn_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nextMouseExited(evt);
            }
        });
        btn_next.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_nextMouseMoved(evt);
            }
        });
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        jPanel3.add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 320, -1, 26));

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

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, 229));

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
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, 26));

        lb_next.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_next.setText("Next.");
        jPanel3.add(lb_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 22));

        lb_title1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title1.setText("Make sure the MyE Smart Home Gateway has been powered up and connected to your home internet router.");
        jPanel3.add(lb_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 20));

        lb_title2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title2.setText("When you are ready, click");
        jPanel3.add(lb_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 83, 590, -1));

        panel_top.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_top.setMinimumSize(new java.awt.Dimension(735, 24));
        panel_top.setOpaque(false);
        panel_top.setPreferredSize(new java.awt.Dimension(60, 43));
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 735, 41));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-735)/2, (screenSize.height-440)/2, 735, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try{
           MyETools.listConfig = new ArrayList();
            ByteBuffer buffer = ByteBuffer.wrap(Constants.SEARCH);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(false);
        MyETools.wizzard1.setVisible(false);
        MyETools.wizzard2.setVisible(true);
        MyETools.wizzard2.initI18N();
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(false);
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(true);
        MyETools.win1.initI18N();
        MyETools.wizzard1.setVisible(false);
        MyETools.wizzard2.setVisible(false);
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(false);
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

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

    private void btn_nextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseMoved
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_next2")))); // NOI18N
        btn_next.setBorder(null);
        btn_next.setBorderPainted(false);
    }//GEN-LAST:event_btn_nextMouseMoved

    private void btn_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseExited
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_next")))); // NOI18N
        btn_next.setBorder(null);
        btn_next.setBorderPainted(false);
    }//GEN-LAST:event_btn_nextMouseExited

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
            java.util.logging.Logger.getLogger(Wizzard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wizzard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wizzard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wizzard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Wizzard1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_minwindow;
    private javax.swing.JButton btn_next;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_next;
    private javax.swing.JLabel lb_title1;
    private javax.swing.JLabel lb_title2;
    private javax.swing.JLabel lb_wizard;
    private javax.swing.JPanel panel_step_img;
    private javax.swing.JPanel panel_top;
    private javax.swing.JPanel panel_wizzard_img;
    // End of variables declaration//GEN-END:variables
}
