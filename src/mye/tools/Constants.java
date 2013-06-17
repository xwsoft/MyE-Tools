/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

/**
 *
 * @author Administrator
 */
public class Constants {
    public static final int REC_PORT = 25120;
    public static final int SEND_PORT = 25122;
    
    public static final byte[] HEAD = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41};
    
    public static final byte[] SEARCH = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x00}; 
    //重启
    public static final byte[] REBOOT = new byte[]{0x41,0x53,0x49,0x58,0x58,0x49,0x53,0x41,0x0B};  
}
