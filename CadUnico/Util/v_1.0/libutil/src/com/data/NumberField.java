/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.data;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class NumberField extends javax.swing.JTextField {
    
    public NumberField() {
        
        super();
        
    }
    
    public NumberField(int cols) {
        
        super(cols);
        
    }
    
    @Override
    protected javax.swing.text.Document createDefaultModel() {
        
        return new DecimalDocument();
        
    }
    
    static class DecimalDocument extends javax.swing.text.PlainDocument {
        
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a) 
                throws javax.swing.text.BadLocationException {
            
            if (str == null || str.isEmpty())
                return;
            
            char[] chars = str.toCharArray();
            boolean ok = true;
            
            for (int i = 0; i < chars.length; i++) {
                
                if (! Character.isDigit(chars[i]) && chars[i] != ',' && chars[i] != '.') {
                    ok = false;
                    break;
                }
                
            }
            
            if (ok)
                super.insertString(offs, new String (chars), a);
            
        }
        
    }
    
}
