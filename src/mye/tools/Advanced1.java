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
public class Advanced1 extends AbstractWin {

    /**
     * Creates new form NewJFrame2
     */
    public Advanced1() {
        initComponents();
        //图片
        ImageIcon imgWizzard = new ImageIcon(getClass().getResource("/mye/tools/src/01.png"));//背景图片
        JLabel lb_img_wizzard = new JLabel(imgWizzard);
        lb_img_wizzard.setBounds(0,0,imgWizzard.getIconWidth(),imgWizzard.getIconHeight());
        panel_wizzard_img.add(lb_img_wizzard);
        txt_mac.setEditable(false);
        txt_name.setDocument(new MyEAliasDoc(10));
        txt_subnetmask.setDocument(new MyEAliasDoc(15));
        txt_gateway.setDocument(new MyEAliasDoc(15));
        txt_dns.setDocument(new MyEAliasDoc(15));
        txt_ip.setDocument(new MyEAliasDoc(15));
        this.getContentPane().setBackground(Color.white);
    }

    private void setConfigInfo(MConfig config){
        txt_name.setText(config.getName());
        txt_mac.setText(config.getPhysicalAddress());
        txt_subnetmask.setText(config.getDeviceSubnetMask());
        txt_gateway.setText(config.getDeviceGateway());
        txt_dns.setText(config.getDeviceDNS());
        byte[] bNS = config.getNetworkSetting();
        if(new Util().byte2BinaryString(bNS[0]).substring(1,2).equals("1")){
            sel_dhcp.setSelectedIndex(0);
            txt_ip.setText(config.getDynamicIP());
        }else{
            sel_dhcp.setSelectedIndex(1);
            txt_ip.setText(config.getStaticIP());
        }
        
    }
    
    private MConfig getConfigInfo(MConfig config){
        config.setName(txt_name.getText());
        config.setPhysicalAddress(txt_mac.getText());
        config.setStaticIP(txt_ip.getText());
        config.setDeviceSubnetMask(txt_subnetmask.getText());
        config.setDeviceGateway(txt_gateway.getText());
        config.setDeviceDNS(txt_dns.getText());
        byte[] bNS = config.getNetworkSetting();
        String strNS = new Util().byte2BinaryString(bNS[0]);
        if(sel_dhcp.getSelectedIndex()==0){
            strNS = strNS.substring(0,1)+"1"+strNS.substring(2);
        }else{
            strNS = strNS.substring(0,1)+"0"+strNS.substring(2);
        }
        bNS[0] = (byte)Integer.parseInt(strNS,2);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listDevice = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        sel_dhcp = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_dns = new javax.swing.JTextField();
        txt_gateway = new javax.swing.JTextField();
        txt_subnetmask = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_mac = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        btn_done = new javax.swing.JButton();
        btn_apply = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_wizzard_img = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        panel_top = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_minwindow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listDevice.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDeviceValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listDevice);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 157, 301));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sel_dhcp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enabled", "Disabled" }));
        jPanel4.add(sel_dhcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 95, 208, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("DHCP");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("IP address");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel4.add(txt_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 130, 208, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Subnet mask");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Default gateway");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("DNS server");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 235, -1, -1));
        jPanel4.add(txt_dns, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 235, 208, -1));
        jPanel4.add(txt_gateway, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 200, 208, -1));
        jPanel4.add(txt_subnetmask, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 165, 208, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Alias");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("MyE Gateway MAC");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, -1));
        jPanel4.add(txt_mac, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 25, 208, -1));
        jPanel4.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 60, 208, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 13, -1, -1));

        label1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label1.setText("Device");
        jPanel3.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 13, -1, -1));

        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Close.png"))); // NOI18N
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
        jPanel3.add(btn_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, -1, -1));

        btn_apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Apply.png"))); // NOI18N
        btn_apply.setBorder(null);
        btn_apply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_applyMouseExited(evt);
            }
        });
        btn_apply.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_applyMouseMoved(evt);
            }
        });
        btn_apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_applyActionPerformed(evt);
            }
        });
        jPanel3.add(btn_apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

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
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 75, -1, 350));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Advanced");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

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

        jPanel5.add(panel_wizzard_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 25, -1, -1));

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/search.png"))); // NOI18N
        btn_search.setBorder(null);
        btn_search.setBorderPainted(false);
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
        });
        btn_search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_searchMouseMoved(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel5.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 130, 270));

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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-735)/2, (screenSize.height-440)/2, 735, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void listDeviceValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDeviceValueChanged
        if(!evt.getValueIsAdjusting() && listDevice.getSelectedValue()!=null){
            List<MConfig> listConfig = MyETools.listConfig;
            MConfig currConfig = null;
            for(int i=0;i<listConfig.size();i++){
                if(listConfig.get(i).getPhysicalAddress()==listDevice.getSelectedValue().toString()){
                    currConfig = listConfig.get(i);
                    currConfig.setIsSelect(1);
                    listConfig.remove(i);
                    listConfig.add(currConfig);
                }
            }
            setConfigInfo(currConfig);
        }
    }//GEN-LAST:event_listDeviceValueChanged

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
        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Close.png"))); // NOI18N
        btn_done.setBorder(null);
        btn_done.setBorderPainted(false);
    }//GEN-LAST:event_btn_doneMouseExited

    private void btn_doneMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_doneMouseMoved
        btn_done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Close2.png"))); // NOI18N
        btn_done.setBorder(null);
        btn_done.setBorderPainted(false);
    }//GEN-LAST:event_btn_doneMouseMoved

    private void btn_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doneActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_doneActionPerformed

    private void btn_applyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_applyMouseExited
        btn_apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Apply.png"))); // NOI18N
        btn_apply.setBorder(null);
        btn_apply.setBorderPainted(false);
    }//GEN-LAST:event_btn_applyMouseExited

    private void btn_applyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_applyMouseMoved
        btn_apply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Apply2.png"))); // NOI18N
        btn_apply.setBorder(null);
        btn_apply.setBorderPainted(false);
    }//GEN-LAST:event_btn_applyMouseMoved

    private void btn_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_applyActionPerformed
       
        String ip = Util.validIP(txt_ip.getText());
        String subnetmask = Util.validIP(txt_subnetmask.getText());
        String gateway = Util.validIP(txt_gateway.getText());
        String dns = Util.validIP(txt_dns.getText());
        if(ip==null){          
           JOptionPane.showMessageDialog(null,"You enter the IP address is invalid. ");
           txt_ip.setFocusable(true);
           return;
       }else{
            txt_ip.setText(ip);
        }
        
       if(subnetmask==null){          
           JOptionPane.showMessageDialog(null,"You enter the Subnet mask is invalid. ");
           txt_subnetmask.setFocusable(true);
           return;
       }else{
            txt_subnetmask.setText(subnetmask);
        }
       if(gateway==null){          
           JOptionPane.showMessageDialog(null,"You enter the Default gateway is invalid. ");
           txt_gateway.setFocusable(true);
           return;
       }else{
            txt_gateway.setText(gateway);
        }
       
        if(dns==null){          
           JOptionPane.showMessageDialog(null,"You enter the DNS server is invalid. ");
           txt_dns.setFocusable(true);
           return;
       }else{
            txt_dns.setText(dns);
        }
        
        
        
        try{
            List<MConfig> listConfig = MyETools.listConfig;
            MConfig currConfig = null;
            for(int i=0;i<listConfig.size();i++){
                if(listConfig.get(i).getIsSelect()==1){
                    currConfig = listConfig.get(i);
                }
            }
            if(currConfig == null){
                return;
            }
            //currConfig = getConfigInfo(currConfig);
            byte[] datas = currConfig.MConfigToByte(getConfigInfo(currConfig));
            datas[8] = 0x02;
            ByteBuffer buffer = ByteBuffer.wrap(datas);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProgressWin win = new ProgressWin();
        win.setVisible(true);
    }//GEN-LAST:event_btn_applyActionPerformed

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Back.png"))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_backMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseMoved
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Back2.png"))); // NOI18N
        btn_back.setBorder(null);
        btn_back.setBorderPainted(false);
    }//GEN-LAST:event_btn_backMouseMoved

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MyETools.win2.setVisible(false);
        MyETools.win1.setVisible(true);
        MyETools.wizzard1.setVisible(false);
        MyETools.wizzard2.setVisible(false);
        MyETools.wizzard3.setVisible(false);
        MyETools.wizzard4.setVisible(false);
        MyETools.wizzard5.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
                try{
           MyETools.listConfig = new ArrayList();
            byte[] datas = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x00};  
            ByteBuffer buffer = ByteBuffer.wrap(datas);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Setup1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<MConfig> listConfig = MyETools.listConfig;
        if(listConfig.size()>0){
            final String[] arrMid = new String[listConfig.size()];
            MConfig currConfig = null;
            for(int i=0;i<listConfig.size();i++){
                if(i==0){
                    currConfig = listConfig.get(0);
                    currConfig.setIsSelect(1);
                }
                arrMid[i]  = listConfig.get(i).getPhysicalAddress();
            }
            listConfig.remove(0);
            listConfig.add(currConfig);
            setConfigInfo(currConfig);
            listDevice.setModel(new javax.swing.AbstractListModel() {
                String[] strings = arrMid;
                @Override
                public int getSize() { return strings.length; }
                @Override
                public Object getElementAt(int i) { return strings[i]; }
            });
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_searchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseMoved
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/Search2.png"))); // NOI18N
        btn_search.setBorder(null);
        btn_search.setBorderPainted(false);
    }//GEN-LAST:event_btn_searchMouseMoved

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mye/tools/src/search.png"))); // NOI18N
        btn_search.setBorder(null);
        btn_search.setBorderPainted(false);
    }//GEN-LAST:event_btn_searchMouseExited

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
            java.util.logging.Logger.getLogger(Advanced1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Advanced1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Advanced1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Advanced1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Advanced1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_apply;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_done;
    private javax.swing.JButton btn_minwindow;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JList listDevice;
    private javax.swing.JPanel panel_top;
    private javax.swing.JPanel panel_wizzard_img;
    private javax.swing.JComboBox sel_dhcp;
    private javax.swing.JTextField txt_dns;
    private javax.swing.JTextField txt_gateway;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_mac;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_subnetmask;
    // End of variables declaration//GEN-END:variables
}
