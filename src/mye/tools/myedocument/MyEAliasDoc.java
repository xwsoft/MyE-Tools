/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mye.tools.myedocument;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Administrator
 */
public class MyEAliasDoc  extends PlainDocument{
    private int maxLen = 100;
    private int type = 0;
    
    public MyEAliasDoc(int max){
        this.maxLen = max;
        //this.type = itype;
    }
    
    //重载父类的insertString函数 
    public void insertString(int offs, String str, javax.swing.text.AttributeSet a)throws BadLocationException{ 
        boolean flag = true;
        try {
            if (str == null) {// 输入为空，直接返回
                return;
            }
            if((this.getLength() + str.length())>maxLen){
                 super.insertString(offs,str.substring(0,maxLen-this.getLength()),a);
                 return;
            }
            super.insertString(offs,str,a);
        } catch (Exception e) {
            e.printStackTrace();
        }  
  } 
}
