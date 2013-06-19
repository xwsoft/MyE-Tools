/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools;

import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Administrator
 */
public class ResourceUtil {

    public static Font cn_font = new java.awt.Font("宋体", 0, 12);
    public static Font cn_font_title = new java.awt.Font("宋体", 1, 15);
    
    public static Font font = new java.awt.Font("Arial", 0, 12);
    public static Font font_title = new java.awt.Font("Arial", 1, 14);
    
    public static Font cn_font_12 = new java.awt.Font("宋体", 1, 12);
    public static Font font_12 = new java.awt.Font("宋体", 1, 12);
    
    public static Font font_dialog12 =new java.awt.Font("Dialog", 1, 12);
    public static Font cn_font_dialog12 =new java.awt.Font("Dialog", 1, 12);

    public static Locale _local = Locale.SIMPLIFIED_CHINESE;
    public static String resourceFile = "mye.tools.language.tools";
    public static ResourceBundle resource = ResourceBundle.getBundle(resourceFile, _local);

    public ResourceUtil() {
        resource = ResourceBundle.getBundle(resourceFile, _local);
    }

    public static String getResource(String key) {
        resource = ResourceBundle.getBundle(resourceFile, _local);
        String val = resource.getString(key);
        return val;
    }

    public static String getResource(Locale local, String key) {
        resource = ResourceBundle.getBundle(resourceFile, local);
        String val = resource.getString(key);
        return val;
    }

    public static Font getFont() {
        if (_local == Locale.SIMPLIFIED_CHINESE) {
            return cn_font;
        }
        return font;
    }

    public static Font getFontTitle() {
        if (_local == Locale.SIMPLIFIED_CHINESE) {
            return cn_font_title;
        }
        return font_title;
    }

    public static Font getFont12() {
        if (_local == Locale.SIMPLIFIED_CHINESE) {
            return cn_font_12;
        }
        return font_12;
    }
    public static Font getFontDialog12() {
        if (_local == Locale.SIMPLIFIED_CHINESE) {
            return cn_font_dialog12;
        }
        return font_dialog12;
    }    
    
}
