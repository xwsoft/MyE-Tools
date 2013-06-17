/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Administrator
 */
public class UDPMulticastClient {  
 
                   static String destAddressStr = "255.255.255.255";    
                   static int TTLTime = 4;  
  
         public static void main(String[] args) throws Exception {  
            InetAddress destAddress = InetAddress.getByName(destAddressStr);  

            int TTL = TTLTime;  
            MulticastSocket multiSocket =new MulticastSocket();  
            multiSocket.setTimeToLive(TTL);  
            byte[] datas = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x00};
            DatagramPacket dp = new DatagramPacket(datas, datas.length, destAddress  ,Constants.SEND_PORT);    
            multiSocket.send(dp);  
            multiSocket.receive(dp);
            multiSocket.close();  
         }  
}
  