/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class BroadcastUdp extends Thread{
 
    
    public void Sender(){
        try{
            byte[] datas = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x00};  
            ByteBuffer buffer = ByteBuffer.wrap(datas);
            MyETools.channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(BroadcastUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run () {
       ByteBuffer byteBuffer = ByteBuffer.allocate (104) ;
        while (true){
            try {
                int eventsCount = MyETools.selector.select() ;
                if ( eventsCount > 0 ) {
                    Set selectedKeys = MyETools.selector.selectedKeys () ;
                    Iterator iterator = selectedKeys.iterator () ;
                    while ( iterator.hasNext ()) {
                        SelectionKey sk = ( SelectionKey ) iterator.next () ;
                        iterator.remove () ;
                        if ( sk.isReadable ()) {
                            //在这里datagramChannel与channel实际是同一个对象
                            DatagramChannel datagramChannel = ( DatagramChannel ) sk.channel () ;
                            byteBuffer.clear();
                            SocketAddress sa = datagramChannel.receive(byteBuffer) ;
                            byteBuffer.flip();                           
                            byte[] datas = byteBuffer.array();
                            Util.printHexString(datas);
                            System.out.println();
                            MConfig mConfig = new MConfig().ByteToMConfig(datas);
                            MyETools.listConfig.add(mConfig);
                        }
                    }//while iterator
                }//if
            } catch ( Exception e ) {
            }
        }//while
    }
    
    
    
    
    
    
    
   
   
   
}
