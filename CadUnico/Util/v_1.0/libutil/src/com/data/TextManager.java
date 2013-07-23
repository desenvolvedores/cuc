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
public class TextManager {
    
    public TextManager() {
        
    }
    
    public java.lang.String addSlashes(java.lang.String text) {
        
        text = text.replaceAll("\"", "\\\"");
        text = text.replaceAll("\'", "\\\'");
        return text;
        
    }
    
    public java.lang.String removeSpecialCharacters(java.lang.String text) {
        
        char invalid = 0;
        short i = 0;
        while (text.charAt(i) != '{') {
            i++;
        }
        String temp = text.substring(i, text.length());
        return temp.replaceAll(String.valueOf(invalid), "").trim();
        
    }
    
}
