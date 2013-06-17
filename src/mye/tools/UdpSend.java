/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.io.IOException;
import java.net.*;

public class UdpSend{
    public void sendData(byte[] datas){
        DatagramSocket socket = null;
    	try {
            socket = new DatagramSocket();        
            DatagramPacket dp = new DatagramPacket(datas,datas.length,InetAddress.getByName("255.255.255.255"), Constants.SEND_PORT);
            socket.send(dp);
            
//            while (true)
//            {
//            byte[] inBuff = new byte[104];
//            DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
//            socket.receive(inPacket);
//            System.out.print("SendRecive：");
//            byte[] RecDatas = inPacket.getData();
//            Util.printHexString(RecDatas);
//
//            }

            
        } catch (IOException e) { 
            e.printStackTrace();
        }finally{
            socket.close();
        }	
    }
}