/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

/**
 *
 * @author Administrator
 */
public class MConfig {
    private int isSelect = 0;
    //设备名称(16bytes)
    private String name;
    //物理地址(6Bytes)
    private String physicalAddress;
    //网络设置(2bytes)
    private byte[] networkSetting;
    //动态IP地址(4bytes)
    private String dynamicIP;
    //静态IP地址(4bytes)
    private String staticIP;
    //单包数据端口号(2bytes)
    private String singlePort;
    //多包数据端口号(2bytes)
    private String multicastPort;
    //广播包端口号(2bytes)
    private String broadcastPort;
    //设备端的IP地址(4bytes exp: 0xc0a80003)
    private String deviceIP;
    //设备端接收的端口号（2bytes  保留）
    private String deviceRecPort;
    //设备端的子网掩码(4bytes)
    private String deviceSubnetMask;
    //设备端的网关值(4bytes 0xc0a80001)
    private String deviceGateway;
    //设备端的DNS值(4bytes 0xc0a80001)
    private String deviceDNS;
    //设备端的串口配置(2bytes reserved )
    private byte[] deviceSerial;
    //设备端的串口状态(2bytes reserved)
    private byte[] deviceSerialState;
    //设备端的其它EEPROM参数（34bytes）
    private byte[] deviceEEPROM;
    
    
    
    public byte[] MConfigToByte(MConfig mconfig){
        byte[] datas = new byte[104];
        int i = 0;
        System.arraycopy(Constants.HEAD,0, datas,i,Constants.HEAD.length);
        i+=Constants.HEAD.length;
        
        datas[i+1] = 0x0;
        datas[i+2] = 0x0;
        i+=2;
        
        byte[] bName = new byte[16];
        byte[] bTmpName = mconfig.getName().getBytes();
        System.arraycopy(bTmpName,0, bName,0, bTmpName.length);    
        System.arraycopy(bName,0, datas,i, bName.length);
        i+=bName.length;
        
        byte[] bPhysicalAddress = new Util().hexStrToByte(mconfig.getPhysicalAddress(), " ");
        System.arraycopy(bPhysicalAddress,0, datas,i,bPhysicalAddress.length);
        i+=bPhysicalAddress.length;
        
        byte[] bNetworkSetting = mconfig.getNetworkSetting();
        System.arraycopy(bNetworkSetting,0, datas,i,bNetworkSetting.length);
        i+=bNetworkSetting.length;
        
        byte[] bDynamicIP = Util.strToByte(mconfig.getDynamicIP(),"\\.");
        System.arraycopy(bDynamicIP,0, datas,i,bDynamicIP.length);
        i+=bDynamicIP.length;
        
        byte[] bStaticIP = Util.strToByte(mconfig.getStaticIP(),"\\.");
        System.arraycopy(bStaticIP,0, datas,i,bStaticIP.length);
        i+=bStaticIP.length;
        
        byte[] bSinglePort = Util.encPort(Integer.parseInt(mconfig.getSinglePort()));   
        System.arraycopy(bSinglePort,0, datas,i,bSinglePort.length);
        i+=bSinglePort.length;
        
        byte[] bMulticastPort = Util.encPort(Integer.parseInt(mconfig.getMulticastPort()));   
        System.arraycopy(bMulticastPort,0, datas,i,bMulticastPort.length);
        i+=bMulticastPort.length;
        
        byte[] bBroadcastPort = Util.encPort(Integer.parseInt(mconfig.getBroadcastPort()));   
        System.arraycopy(bBroadcastPort,0, datas,i,bBroadcastPort.length);
        i+=bBroadcastPort.length;
        
        byte[] bDeviceIP = Util.strToByte(mconfig.getDeviceIP(),"\\.");
        System.arraycopy(bDeviceIP,0, datas,i,bDeviceIP.length);
        i+=bDeviceIP.length;
        
        byte[] bDeviceRecPort = Util.encPort(Integer.parseInt(mconfig.getDeviceRecPort()));   
        System.arraycopy(bDeviceRecPort,0, datas,i,bDeviceRecPort.length);
        i+=bDeviceRecPort.length;
                
        byte[] bDeviceSubnetMask = Util.strToByte(mconfig.getDeviceSubnetMask(),"\\.");
        System.arraycopy(bDeviceSubnetMask,0, datas,i,bDeviceSubnetMask.length);
        i+=bDeviceSubnetMask.length;
        
        byte[] bDeviceGateway = Util.strToByte(mconfig.getDeviceGateway(),"\\.");
        System.arraycopy(bDeviceGateway,0, datas,i,bDeviceGateway.length);
        i+=bDeviceGateway.length;   
        
        byte[] bDeviceDNS = Util.strToByte(mconfig.getDeviceDNS(),"\\.");
        System.arraycopy(bDeviceDNS,0, datas,i,bDeviceDNS.length);
        i+=bDeviceDNS.length;                  
        
        byte[] bDeviceSerial = mconfig.getDeviceSerial();
        System.arraycopy(bDeviceSerial,0, datas,i,bDeviceSerial.length);
        i+=bDeviceSerial.length;
                
        byte[] bDeviceSerialState = mconfig.getDeviceSerialState();
        System.arraycopy(bDeviceSerialState,0, datas,i,bDeviceSerialState.length);
        i+=bDeviceSerialState.length;
                
        byte[] bDeviceEEPROM = mconfig.getDeviceEEPROM();
        System.arraycopy(bDeviceEEPROM,0, datas,i,bDeviceEEPROM.length);
        i+=bDeviceEEPROM.length;

        return datas;
    }
    
    public MConfig ByteToMConfig(byte[] datas){
        if(datas.length>=104){
            int i = 10;
            
            byte[] bName = new byte[16];
            System.arraycopy(datas,i, bName,0, bName.length);
            this.setName(new String(bName,0,bName.length).trim());
            i+=bName.length;
            
            byte[] bPhysicalAddress = new byte[6];
            System.arraycopy(datas,i, bPhysicalAddress,0, bPhysicalAddress.length);
            this.setPhysicalAddress(new Util().getByteArrayString(bPhysicalAddress," "));            
            i+=bPhysicalAddress.length;
            
            byte[] bNetworkSetting = new byte[2];
            System.arraycopy(datas,i,bNetworkSetting,0,bNetworkSetting.length);
            this.setNetworkSetting(bNetworkSetting);
            i+=bNetworkSetting.length;
            
            byte[] bDynamicIP = new byte[4];
            System.arraycopy(datas,i,bDynamicIP,0,bDynamicIP.length);
            this.setDynamicIP(Util.desIP(bDynamicIP));
            i+=bDynamicIP.length;
            
            byte[] bStaticIP = new byte[4];
            System.arraycopy(datas,i,bStaticIP,0,bStaticIP.length);
            this.setStaticIP(Util.desIP(bStaticIP));
            i+=bStaticIP.length; 
            
            byte[] bSinglePort = new byte[2];
            System.arraycopy(datas,i,bSinglePort,0,bSinglePort.length);
            this.setSinglePort(Util.desPort(bSinglePort)+"");
            i+=bSinglePort.length;           
             
            byte[] bMulticastPort = new byte[2];
            System.arraycopy(datas,i,bMulticastPort,0,bMulticastPort.length);
            this.setMulticastPort(Util.desPort(bMulticastPort)+"");
            i+=bMulticastPort.length;   
       
            byte[] bBroadcastPort = new byte[2];
            System.arraycopy(datas,i,bBroadcastPort,0,bBroadcastPort.length);
            this.setBroadcastPort(Util.desPort(bBroadcastPort)+"");
            i+=bBroadcastPort.length;   
       
            byte[] bDeviceIP = new byte[4];
            System.arraycopy(datas,i,bDeviceIP,0,bDeviceIP.length);
            this.setDeviceIP(Util.desIP(bDeviceIP));
            i+=bDeviceIP.length;   
         
            byte[] bDeviceRecPort = new byte[2];
            System.arraycopy(datas,i,bDeviceRecPort,0,bDeviceRecPort.length);
            this.setDeviceRecPort(Util.desPort(bDeviceRecPort)+"");
            i+=bDeviceRecPort.length;            
         
            byte[] bDeviceSubnetMask = new byte[4];
            System.arraycopy(datas,i,bDeviceSubnetMask,0,bDeviceSubnetMask.length);
            this.setDeviceSubnetMask(Util.desIP(bDeviceSubnetMask));
            i+=bDeviceSubnetMask.length;   
         
            byte[] bDeviceGateway = new byte[4];
            System.arraycopy(datas,i,bDeviceGateway,0,bDeviceGateway.length);
            this.setDeviceGateway(Util.desIP(bDeviceGateway));
            i+=bDeviceGateway.length;  
         
            byte[] bDeviceDNS = new byte[4];
            System.arraycopy(datas,i,bDeviceDNS,0,bDeviceDNS.length);
            this.setDeviceDNS(Util.desIP(bDeviceDNS));
            i+=bDeviceDNS.length;  
         
            byte[] bDeviceSerial = new byte[2];
            System.arraycopy(datas,i,bDeviceSerial,0,bDeviceSerial.length);
            this.setDeviceSerial(bDeviceSerial);
            i+=bDeviceSerial.length;  
         
            byte[] bDeviceSerialState = new byte[2];
            System.arraycopy(datas,i,bDeviceSerialState,0,bDeviceSerialState.length);
            this.setDeviceSerialState(bDeviceSerialState);
            i+=bDeviceSerialState.length;  
         
            byte[] bDeviceEEPROM = new byte[34];
            System.arraycopy(datas,i,bDeviceEEPROM,0,bDeviceEEPROM.length);
            this.setDeviceEEPROM(bDeviceEEPROM);
            i+=bDeviceEEPROM.length;  
        }
        return this;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the physicalAddress
     */
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * @param physicalAddress the physicalAddress to set
     */
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    /**
     * @return the networkSetting
     */
    public byte[] getNetworkSetting() {
        return networkSetting;
    }

    /**
     * @param networkSetting the networkSetting to set
     */
    public void setNetworkSetting(byte[] networkSetting) {
        this.networkSetting = networkSetting;
    }

    /**
     * @return the dynamicIP
     */
    public String getDynamicIP() {
        return dynamicIP;
    }

    /**
     * @param dynamicIP the dynamicIP to set
     */
    public void setDynamicIP(String dynamicIP) {
        this.dynamicIP = dynamicIP;
    }

    /**
     * @return the staticIP
     */
    public String getStaticIP() {
        return staticIP;
    }

    /**
     * @param staticIP the staticIP to set
     */
    public void setStaticIP(String staticIP) {
        this.staticIP = staticIP;
    }

    /**
     * @return the singlePort
     */
    public String getSinglePort() {
        return singlePort;
    }

    /**
     * @param singlePort the singlePort to set
     */
    public void setSinglePort(String singlePort) {
        this.singlePort = singlePort;
    }

    /**
     * @return the multicastPort
     */
    public String getMulticastPort() {
        return multicastPort;
    }

    /**
     * @param multicastPort the multicastPort to set
     */
    public void setMulticastPort(String multicastPort) {
        this.multicastPort = multicastPort;
    }

    /**
     * @return the broadcastPort
     */
    public String getBroadcastPort() {
        return broadcastPort;
    }

    /**
     * @param broadcastPort the broadcastPort to set
     */
    public void setBroadcastPort(String broadcastPort) {
        this.broadcastPort = broadcastPort;
    }

    /**
     * @return the deviceIP
     */
    public String getDeviceIP() {
        return deviceIP;
    }

    /**
     * @param deviceIP the deviceIP to set
     */
    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    /**
     * @return the deviceRecPort
     */
    public String getDeviceRecPort() {
        return deviceRecPort;
    }

    /**
     * @param deviceRecPort the deviceRecPort to set
     */
    public void setDeviceRecPort(String deviceRecPort) {
        this.deviceRecPort = deviceRecPort;
    }

    /**
     * @return the deviceSubnetMask
     */
    public String getDeviceSubnetMask() {
        return deviceSubnetMask;
    }

    /**
     * @param deviceSubnetMask the deviceSubnetMask to set
     */
    public void setDeviceSubnetMask(String deviceSubnetMask) {
        this.deviceSubnetMask = deviceSubnetMask;
    }

    /**
     * @return the deviceGateway
     */
    public String getDeviceGateway() {
        return deviceGateway;
    }

    /**
     * @param deviceGateway the deviceGateway to set
     */
    public void setDeviceGateway(String deviceGateway) {
        this.deviceGateway = deviceGateway;
    }

    /**
     * @return the deviceDNS
     */
    public String getDeviceDNS() {
        return deviceDNS;
    }

    /**
     * @param deviceDNS the deviceDNS to set
     */
    public void setDeviceDNS(String deviceDNS) {
        this.deviceDNS = deviceDNS;
    }

    /**
     * @return the deviceSerial
     */
    public byte[] getDeviceSerial() {
        return deviceSerial;
    }

    /**
     * @param deviceSerial the deviceSerial to set
     */
    public void setDeviceSerial(byte[] deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    /**
     * @return the deviceSerialState
     */
    public byte[] getDeviceSerialState() {
        return deviceSerialState;
    }

    /**
     * @param deviceSerialState the deviceSerialState to set
     */
    public void setDeviceSerialState(byte[] deviceSerialState) {
        this.deviceSerialState = deviceSerialState;
    }

    /**
     * @return the deviceEEPROM
     */
    public byte[] getDeviceEEPROM() {
        return deviceEEPROM;
    }

    /**
     * @param deviceEEPROM the deviceEEPROM to set
     */
    public void setDeviceEEPROM(byte[] deviceEEPROM) {
        this.deviceEEPROM = deviceEEPROM;
    }

    /**
     * @return the isSelect
     */
    public int getIsSelect() {
        return isSelect;
    }

    /**
     * @param isSelect the isSelect to set
     */
    public void setIsSelect(int isSelect) {
        this.isSelect = isSelect;
    }



}
