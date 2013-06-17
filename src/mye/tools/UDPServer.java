/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class UDPServer extends Thread {
    
    public void run () {
        Selector selector = null ;
        DatagramChannel channel = null;
        try {
            channel = DatagramChannel.open ();
            DatagramSocket socket = channel.socket();
            socket.setBroadcast(true);
            channel.configureBlocking(false);
            socket.bind(new InetSocketAddress(25120));
            System.out.println("server start!");
            selector = Selector.open () ;
            channel.register ( selector, SelectionKey.OP_READ ) ;
            
            
        } catch ( Exception e ) {
            e.printStackTrace () ;
        }
        
        
        try{
            byte[] datas = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x00};  
            ByteBuffer buffer = ByteBuffer.wrap(datas);
            channel.send(buffer, new InetSocketAddress("255.255.255.255",Constants.SEND_PORT));
        }catch (Exception ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate (104) ;
        while (true){
            try {
                int eventsCount = selector.select() ;
                if ( eventsCount > 0 ) {
                    Set selectedKeys = selector.selectedKeys () ;
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
                        }
                    }//while iterator
                }//if
            } catch ( Exception e ) {
                e.printStackTrace () ;
            }
        }//while
     
    }

    public static void main ( String [] args ) {
        new UDPServer().start() ;
    }
}
