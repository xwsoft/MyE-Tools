/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class UdpListener extends java.util.TimerTask{
    private DatagramSocket socket = null;
    byte[] inBuff = new byte[120];
    
    public UdpListener(){
        
    }
    public void listener() {
        if(socket==null){
            System.out.println("Listener....");  
            try {
                socket = new DatagramSocket(Constants.REC_PORT);
                DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
                socket.receive(inPacket);
                System.out.print("Recive：");
                byte[] datas = inPacket.getData();
                Util.printHexString(datas);
                System.out.println();
                if(Util.compareHead(datas)){
                    if(datas[8]==0x01){
                        MConfig mConfig = new MConfig().ByteToMConfig(datas);
                        System.out.println(mConfig.getName());
                        byte[] datasReturn = new MConfig().MConfigToByte(mConfig);
                        System.out.print("还原：");
                        Util.printHexString(datasReturn);
                        System.out.println();
                    }
                }
                
                }catch (IOException ex) {
                    Logger.getLogger(UdpListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(socket!=null){
                socket.close();
                socket=null;
            }
        }
    }
       
    @Override
    public void run() {          
        listener();
    }
    
    
}
