/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class IpConfig {
    
    
        public static String getMACAddress(){   
            String address = "";   
            String os = System.getProperty("os.name");   
            String osUser=System.getProperty("user.name");   
            if (os != null && os.startsWith("Windows")) {    
                try {    
                    String command = "cmd.exe /c ipconfig /all";                   
                    Process p = Runtime.getRuntime().exec(command);    
                    BufferedReader br =new BufferedReader(new InputStreamReader(p.getInputStream()));   
                    String line;   
                    while ((line = br.readLine()) != null) {     
                        if (line.indexOf("Physical Address") > 0) {   
                            int index = line.indexOf(":");   
                            index += 2;   
                            address = line.substring(index);   
                            break;   
                        }
                        if (line.indexOf("Default Gateway") > 0) {   
                            int index = line.indexOf(":");   
                            index += 2;   
                            address = line.substring(index);   
                            break;   
                        }
                    }    
                    br.close();   
                    return address.trim();   
                }   
                catch (IOException e) {   
                }   
            }
            return address;   
        }
}
