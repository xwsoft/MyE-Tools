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
public class UDPMulticastServer {  
  
         final static int RECEIVE_LENGTH = 1024;  
  
         static String multicastHost="224.0.0.1";  

  
         public static void main(String[] args) throws Exception {  

                   InetAddress receiveAddress =InetAddress.getByName(multicastHost);  
                   MulticastSocket receiveMulticast = new MulticastSocket(Constants.REC_PORT);  
                   receiveMulticast.joinGroup(receiveAddress);  
                   DatagramPacket dp = new DatagramPacket(new byte[RECEIVE_LENGTH], RECEIVE_LENGTH);  
                   receiveMulticast.receive(dp);  
                   System.out.println(new String(dp.getData()).trim());  
                   receiveMulticast.close();  
         }  
  
} 