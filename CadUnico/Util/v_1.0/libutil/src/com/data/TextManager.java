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
    
    public static java.lang.String removeSimpleSpecialCharacters(java.lang.String text) {
        
//        char invalid = 0;
//        short k = 0;
//        
//        while (text.charAt(k) != '{') {
//            k++;
//        }
//        
//        String temp = text.substring(k, text.length());
//        temp = temp.replaceAll(String.valueOf(invalid), "").trim();
//        temp = temp.replaceAll("[^{}\"]:[^{}\"n]", ":");
//        temp = temp.replaceAll("[^{}]" + String.valueOf((char) 4), "");
//        temp = temp.replaceAll("[^{}]" + String.valueOf((char) 18), "");
//        temp = temp.replaceAll("z" + String.valueOf((char) 4), "");
//        temp = temp.replaceAll("z" + String.valueOf((char) 4) + "Î", "");
//        temp = temp.replaceAll("z Î", "");
//        temp = temp.replaceAll("z" + String.valueOf((char) 4), "");
//        temp = temp.replaceAll("z ", "");
//        
//        for (int i = 32; i <= 127; i++) {
//            
//            for (int j = 0; j <= 31; j++) {
//                
//                temp = temp.replace(String.valueOf((char) i) + String.valueOf((char) j), "");
//                
//            }
//            
//            for (int j = 128; j <= 255; j++) {
//                
//                temp = temp.replace(String.valueOf((char) i) + String.valueOf((char) j), "");
//                
//            }
//            
//        }
//        
//        for (int i = 0; i <= 31; i++) {
//            
//            temp = temp.replace(String.valueOf((char) i), "");
//            
//        }

        text = text.replace("Ã£", "ã");
        text = text.replace("Ã©", "é");
        text = text.replace("Ãº", "ú");
        text = text.replace("Ã§", "ç");
        
        return text;
        
    }
    
}
