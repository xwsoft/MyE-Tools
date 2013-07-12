/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.awt.Color;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mye.tools.myedocument.MyEAliasDoc;

/**
 *
 * @author Administrator
 */
public class Wizzard3 extends AbstractWin {
    public JLabel lb_img_step;
    /**
     * Creates new form Wizzard3
     */
    public Wizzard3() {
        initComponents();
        //图片
        ImageIcon imgWizzard = new ImageIcon(getClass().getResource("/mye/tools/src/02.png"));//背景图片
        JLabel lb_img_wizzard = new JLabel(imgWizzard);
        lb_img_wizzard.setBounds(0, 0, imgWizzard.getIconWidth(), imgWizzard.getIconHeight());
        panel_wizzard_img.add(lb_img_wizzard);

        txt_alias.setDocument(new MyEAliasDoc(10));
        txt_subnetmask.setDocument(new MyEAliasDoc(15));
        txt_gateway.setDocument(new MyEAliasDoc(15));
        txt_dns.setDocument(new MyEAliasDoc(15));
        txt_ip.setDocument(new MyEAliasDoc(15));
        this.getContentPane().setBackground(Color.white);
        initI18N();
    }

    public void initI18N() {
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
        String gateway_mac = resUtil.getResource("gateway_mac");
        String alias = resUtil.getResource("alias");
        String dhcp = resUtil.getResource("dhcp");
        String ipaddress = resUtil.getResource("ipaddress");
        String subnet_mask = resUtil.getResource("subnet_mask");
        String default_gateway = resUtil.getResource("default_gateway");
        String dns = resUtil.getResource("dns");
        String wizard3_title1 = resUtil.getResource("wizard3_title1");
        String wizard3_title2 = resUtil.getResource("wizard3_title2");

        lb_wizard.setText(wizard);
        lb_title1.setText(wizard3_title1);
        lb_title2.setText(wizard3_title2);


        lb_wizard.setFont(resUtil.getFontDialog12());
        lb_title1.setFont(resUtil.getFont());
        lb_title2.setFont(resUtil.getFont());

        lb_mac.setText(gateway_mac);
        lb_alias.setText(alias);
        lb_dhcp.setText(dhcp);
        lb_ip.setText(ipaddress);
        lb_subnet.setText(subnet_mask);
        lb_default_gateway.setText(default_gateway);
        lb_dns.setText(dns);

        lb_mac.setFont(resUtil.getFont());
        lb_alias.setFont(resUtil.getFont());
        lb_dhcp.setFont(resUtil.getFont());
        lb_ip.setFont(resUtil.getFont());
        lb_subnet.setFont(resUtil.getFont());
        lb_default_gateway.setFont(resUtil.getFont());
        lb_dns.setFont(resUtil.getFont());

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_next"))));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_back"))));
        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resUtil.getResource("img_cancel"))));
    }

    private void setConfigInfo(MConfig config) {
        txt_alias.setText(config.getName());
        txt_subnetmask.setText(config.getDeviceSubnetMask());
        txt_gateway.setText(config.getDeviceGateway());
        txt_dns.setText(config.getDeviceDNS());
        byte[] bNS = config.getNetworkSetting();
        if (new Util().byte2BinaryString(bNS[0]).substring(1, 2).equals("1")) {
            sel_dhcp.setSelectedIndex(0);
            txt_ip.setText(config.getDynamicIP());
        } else {
            sel_dhcp.setSelectedIndex(1);
            txt_ip.setText(config.getStaticIP());
        }

    }

    private MConfig getConfigInfo(MConfig config) {
        config.setName(txt_alias.getText());
        config.setStaticIP(txt_ip.getText());
        config.setDeviceSubnetMask(txt_subnetmask.getText());
        config.setDeviceGateway(txt_gateway.getText());
        config.setDeviceDNS(txt_dns.getText());
        byte[] bNS = config.getNetworkSetting();
        String strNS = new Util().byte2BinaryString(bNS[0]);
        if (sel_dhcp.getSelectedIndex() == 0) {
            strNS = strNS.substring(0, 1) + "1" + strNS.substring(2);
        } else {
            strNS = strNS.substring(0, 1) + "0" + strNS.substring(2);
        }
        bNS[0] = (byte) Integer.parseInt(strNS, 2);
        config.setNetworkSetting(bNS);
        return config;
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
        btn_next = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lb_alias = new javax.swing.JLabel();
        lb_dhcp = new javax.swing.JLabel();
        lb_ip = new javax.swing.JLabel();
        lb_subnet = new javax.swing.JLabel();
        lb_default_gateway = new javax.swing.JLabel();
        lb_dns = new javax.swing.JLabel();
        txt_alias = new javax.swing.JTextField();
        txt_ip = new javax.swing.JTextField();
        txt_subnetmask = new javax.swing.JTextField();
        txt_gateway = new javax.swing.JTextField();
        txt_dns = new javax.swing.JTextField();
        sel_dhcp = new javax.swing.JComboBox();
        lb_mac = new javax.swing.JLabel();
        sel_mid = new javax.swing.JComboBox();
        lb_title2 = new javax.swing.JLabel();
        lb_title1 = new javax.swing.JLabel();
        panel_top = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_minwindow = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lb_wizard = new javax.swing.JLabel();
        panel_wizzard_img = new javax.swing.JPanel();
        panel_step_img = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(735, 440));
        setMinimumSize(new java.awt.Dimension(735, 440));
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
        jPanel3.add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

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
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

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
        jPanel3.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        lb_alias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_alias.setText("Alias");
        jPanel3.add(lb_alias, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 105, -1, -1));

        lb_dhcp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_dhcp.setText("DHCP");
        jPanel3.add(lb_dhcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        lb_ip.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_ip.setText("IP address");
        jPanel3.add(lb_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 175, -1, -1));

        lb_subnet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_subnet.setText("Subnet mask");
        jPanel3.add(lb_subnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        lb_default_gateway.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_default_gateway.setText("Default gateway");
        jPanel3.add(lb_default_gateway, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 245, -1, -1));

        lb_dns.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_dns.setText("DNS server");
        jPanel3.add(lb_dns, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));
        jPanel3.add(txt_alias, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 105, 208, -1));
        txt_alias.getAccessibleContext().setAccessibleName("txt_alias");

        jPanel3.add(txt_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 175, 208, -1));
        txt_ip.getAccessibleContext().setAccessibleName("txt_ip");

        jPanel3.add(txt_subnetmask, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 208, -1));
        txt_subnetmask.getAccessibleContext().setAccessibleName("txt_subnetmask");

        jPanel3.add(txt_gateway, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 245, 208, -1));
        txt_gateway.getAccessibleContext().setAccessibleName("txt_gateway");

        jPanel3.add(txt_dns, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 208, -1));
        txt_dns.getAccessibleContext().setAccessibleName("txt_dns");

        sel_dhcp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enabled", "Disabled" }));
        jPanel3.add(sel_dhcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 208, -1));
        sel_dhcp.getAccessibleContext().setAccessibleName("sel_dhcp");

        lb_mac.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_mac.setText("MyE Gateway MAC");
        jPanel3.add(lb_mac, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        sel_mid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sel_midItemStateChanged(evt);
            }
        });
        jPanel3.add(sel_mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 208, -1));

        lb_title2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title2.setText("to configure the MyE Smart Home Gateway.");
        jPanel3.add(lb_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        lb_title1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lb_title1.setText("Based on the network configuration obtained from your computer, the following settings will be used");
        jPanel3.add(lb_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 560, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 75, 570, 350));

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
        setBounds((screenSize.width-737)/2, (screenSize.height-442)/2, 737, 442);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        String ip = Util.validIP(txt_ip.getText());
        String subnetmask = Util.validIP(txt_subnetmask.getText());
        String gateway = Util.validIP(txt_gateway.getText());
        String dns = Util.validIP(txt_dns.getText());
        if (ip == null) {
            JOptionPane.showMessageDialog(null, new ResourceUtil().getResource("ip_alert"));
            txt_ip.setFocusable(true);
            return;
        } else {
            txt_ip.setText(ip);
        }

        if (subnetmask == null) {
            JOptionPane.showMessageDialog(null, new ResourceUtil().getResource("subnet_alert"));
            txt_subnetmask.setFocusable(true);
            return;
        } else {
            txt_subnetmask.setText(subnetmask);
        }
        if (gateway == null) {
            JOptionPane.showMessageDialog(null,new ResourceUtil().getResource("gateway_alert"));
            txt_gateway.setFocusable(true);
            return;
        } else {
            txt_gateway.setText(gateway);
        }

        if (dns == null) {
            JOptionPane.showMessageDialog(null,new ResourceUtil().getResource("dns_alert"));
            txt_dns.setFocusable(true);
            return;
        } else {
            txt_dns.setText(dns);
        }



        try {
            List<MConfig> listConfig = MyETools.listConfig;
            MConfig currConfig = null;
            for (int i = 0; i < listConfig.size(); i++) {
                if (listConfig.get(i).getIsSelect() == 1) {
                    currConfig = listConfig.get(i);
                }
            }
            //currConfig = getConfigInfo(currConfig);
            byte[] datas = currConfig.MConfigToByte(getConfigInfo(currConfig));
            datas[8] = 0x02;
            ByteBuffer buffer = ByteBuffer.wrap(datas);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255", Constants.SEND_PORT));

        } catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(false);
        MyETools.wizzard1.setVisible(false);
        MyETools.wizzard2.setVisible(false);
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(true);
        MyETools.wizzard4.initI18N();
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        List<MConfig> listConfig = MyETools.listConfig;
        if (listConfig.size() > 0) {
            String[] arrMid = new String[listConfig.size()];
            MConfig currConfig = null;
            for (int i = 0; i < listConfig.size(); i++) {
                if (i == 0) {
                    currConfig = listConfig.get(0);
                    currConfig.setIsSelect(1);
                }
                arrMid[i] = listConfig.get(i).getPhysicalAddress();
            }
            listConfig.remove(0);
            listConfig.add(currConfig);
            setConfigInfo(currConfig);
            sel_mid.setModel(new javax.swing.DefaultComboBoxModel(arrMid));
        }
    }//GEN-LAST:event_formComponentShown

    private void sel_midItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sel_midItemStateChanged
        if (evt.getStateChange() == evt.SELECTED) { //这里控制为只处理一次 
            List<MConfig> listConfig = MyETools.listConfig;
            MConfig currConfig = null;
            for (int i = 0; i < listConfig.size(); i++) {
                if (listConfig.get(i).getPhysicalAddress() == evt.getItem().toString()) {
                    currConfig = listConfig.get(i);
                    currConfig.setIsSelect(1);
                    listConfig.remove(i);
                    listConfig.add(currConfig);
                }
            }
            setConfigInfo(currConfig);
        }
    }//GEN-LAST:event_sel_midItemStateChanged

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

    private void btn_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseExited
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_next")))); // NOI18N
        btn_next.setBorder(null);
        btn_next.setBorderPainted(false);
    }//GEN-LAST:event_btn_nextMouseExited

    private void btn_nextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseMoved
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_next2")))); // NOI18N
        btn_next.setBorder(null);
        btn_next.setBorderPainted(false);
    }//GEN-LAST:event_btn_nextMouseMoved

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_back")))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_backMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseMoved
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource(new ResourceUtil().getResource("img_back2")))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseMoved

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
        try{
           MyETools.listConfig = new ArrayList();
            ByteBuffer buffer = ByteBuffer.wrap(Constants.SEARCH);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(false);
        MyETools.wizzard1.setVisible(false);
        MyETools.wizzard2.setVisible(true);
        MyETools.wizzard2.initI18N();
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(false);
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(Wizzard3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wizzard3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wizzard3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wizzard3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Wizzard3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_minwindow;
    private javax.swing.JButton btn_next;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb_alias;
    private javax.swing.JLabel lb_default_gateway;
    private javax.swing.JLabel lb_dhcp;
    private javax.swing.JLabel lb_dns;
    private javax.swing.JLabel lb_ip;
    private javax.swing.JLabel lb_mac;
    private javax.swing.JLabel lb_subnet;
    private javax.swing.JLabel lb_title1;
    private javax.swing.JLabel lb_title2;
    private javax.swing.JLabel lb_wizard;
    private javax.swing.JPanel panel_step_img;
    private javax.swing.JPanel panel_top;
    private javax.swing.JPanel panel_wizzard_img;
    private javax.swing.JComboBox sel_dhcp;
    private javax.swing.JComboBox sel_mid;
    private javax.swing.JTextField txt_alias;
    private javax.swing.JTextField txt_dns;
    private javax.swing.JTextField txt_gateway;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_subnetmask;
    // End of variables declaration//GEN-END:variables
}
