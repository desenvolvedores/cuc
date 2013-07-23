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
public class FieldManager {
    
    public FieldManager() {
        
    }
    
    public static boolean checkEmptyField(javax.swing.JTextField field) {
        
        if (field.getText().isEmpty()) {
            
            field.setBackground(com.sys.SystemSettings.EMPTY_REQUIRED_TEXTBOX);
            return false;
            
        } else {
            
            field.setBackground(com.sys.SystemSettings.FILLED_UP_REQUIRED_TEXTBOX);
            return true;
            
        }
        
    }
    
    public static boolean checkEmptyField(javax.swing.JTextArea field) {
        
        if (field.getText().isEmpty()) {
            
            field.setBackground(com.sys.SystemSettings.EMPTY_REQUIRED_TEXTBOX);
            return false;
            
        } else {
            
            field.setBackground(com.sys.SystemSettings.FILLED_UP_REQUIRED_TEXTBOX);
            return true;
            
        }
        
    }
    
    public static boolean checkEmptyField(javax.swing.JComboBox field, javax.swing.JLabel label) {
        
        if (field.getSelectedIndex() <= 0) {
            
            label.setForeground(com.sys.SystemSettings.EMPTY_REQUIRED_COMBOBOX);
            return false;
            
        } else {
            
            label.setForeground(com.sys.SystemSettings.FILLED_UP_REQUIRED_COMBOBOX);
            return true;
            
        }
    }
    
}
