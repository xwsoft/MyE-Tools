/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class MyETools {

    static Setup1 win1 = new Setup1();
    static Advanced1 win2 = new Advanced1();
    
    static Wizzard1 wizzard1 = new Wizzard1();
    static Wizzard2 wizzard2 = new Wizzard2();
    static Wizzard3 wizzard3 = new Wizzard3();
    static Wizzard4 wizzard4 = new Wizzard4();
    static Wizzard5 wizzard5 = new Wizzard5();

    
    public static Selector selector = null ;
    public static DatagramChannel channel = null;
    public static List<MConfig> listConfig = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       win1.setVisible(true);
       win2.setVisible(false);
       //new UDPServer().start() ;
       //Timer timer = new Timer();
       //timer.schedule(new BroadcastUdp(),1000,1000);
       try {
            MyETools.channel = DatagramChannel.open ();
            DatagramSocket socket = MyETools.channel.socket();
            socket.setBroadcast(true);
            MyETools.channel.configureBlocking(false);
            socket.bind(new InetSocketAddress(Constants.REC_PORT));
            System.out.println("server start!");
            MyETools.selector = Selector.open () ;
            MyETools.channel.register( MyETools.selector, SelectionKey.OP_READ );          
        } catch ( Exception e ) {
            e.printStackTrace() ;
        }
       new BroadcastUdp().start() ;
    }
}
