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
public class MoneyManager {
    
    private javax.swing.JTextField jtxtField;
    
    public MoneyManager() {
        
    }
    
    public void setTextField(javax.swing.JTextField field) {
        jtxtField = field;
    }
    
    public void setFormattedText() {
        try {
            String formatted = "";
            String text = jtxtField.getText();
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Integer.parseInt(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 17) {
                switch (length) {
                    case 0: formatted = "0,00";
                        break;
                    case 1: formatted = "0,0" + text;
                        break;
                    case 2: formatted = "0," + text;
                        break;
                    case 3: formatted = text.substring(0, 1) + "," + text.substring(1, 3);
                        break;
                    case 4: formatted = text.substring(0, 2) + "," + text.substring(2, 4);
                        break;
                    case 5: formatted = text.substring(0, 3) + "," + text.substring(3, 5);
                        break;
                    case 6: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "," + text.substring(4, 6);
                        break;
                    case 7: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "," + text.substring(5, 7);
                        break;
                    case 8: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "," + text.substring(6, 8);
                        break;
                    case 9: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "," + text.substring(7, 9);
                        break;
                    case 10: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "," + text.substring(8, 10);
                        break;
                    case 11: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "," + text.substring(9, 11);
                        break;
                    case 12: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "," + text.substring(10, 12);
                        break;
                    case 13: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "," + text.substring(11, 13);
                        break;
                    case 14: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "," + text.substring(12, 14);
                        break;
                    case 15: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "," + text.substring(13, 15);
                        break;
                    case 16: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "," + text.substring(14, 16);
                        break;
                    case 17: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "," + text.substring(15, 17);
                        break;
                }
            }
            jtxtField.setText(formatted);
        } catch (NumberFormatException ex) {
            jtxtField.setText("0,00");
        }
    }
    
    public String setFormattedValue(String value) {
        try {
            String formatted = "";
            value = value.replace(".", "");
            value = value.replaceAll(",", "");
            
            if (value.startsWith("0")) {
                value = value.substring(1, value.length());
            } else if (value.startsWith("00")) {
                value = value.substring(2, value.length());
            } else if (value.startsWith("000")) {
                value = value.substring(3, value.length());
            }
            
            for (short i = 0; i < value.length(); i++) {
                Integer.parseInt(String.valueOf(value.charAt(i)));
            }
            
            int length = value.length();
            if (length >= 0 && length <= 17) {
                switch (length) {
                    case 0: formatted = "0,00";
                        break;
                    case 1: formatted = "0,0" + value;
                        break;
                    case 2: formatted = "0," + value;
                        break;
                    case 3: formatted = value.substring(0, 1) + "," + value.substring(1, 3);
                        break;
                    case 4: formatted = value.substring(0, 2) + "," + value.substring(2, 4);
                        break;
                    case 5: formatted = value.substring(0, 3) + "," + value.substring(3, 5);
                        break;
                    case 6: formatted = value.substring(0, 1) + "." + value.substring(1, 4) + "," + value.substring(4, 6);
                        break;
                    case 7: formatted = value.substring(0, 2) + "." + value.substring(2, 5) + "," + value.substring(5, 7);
                        break;
                    case 8: formatted = value.substring(0, 3) + "." + value.substring(3, 6) + "," + value.substring(6, 8);
                        break;
                    case 9: formatted = value.substring(0, 1) + "." + value.substring(1, 4) + "." + value.substring(4, 7) + "," + value.substring(7, 9);
                        break;
                    case 10: formatted = value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "," + value.substring(8, 10);
                        break;
                    case 11: formatted = value.substring(0, 3) + "." + value.substring(3, 6) + "." + value.substring(6, 9) + "," + value.substring(9, 11);
                        break;
                    case 12: formatted = value.substring(0, 1) + "." + value.substring(1, 4) + "." + value.substring(4, 7) + "." + value.substring(7, 10) + "," + value.substring(10, 12);
                        break;
                    case 13: formatted = value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "." + value.substring(8, 11) + "," + value.substring(11, 13);
                        break;
                    case 14: formatted = value.substring(0, 3) + "." + value.substring(3, 6) + "." + value.substring(6, 9) + "." + value.substring(9, 12) + "," + value.substring(12, 14);
                        break;
                    case 15: formatted = value.substring(0, 1) + "." + value.substring(1, 4) + "." + value.substring(4, 7) + "." + value.substring(7, 10) + "." + value.substring(10, 13) + "," + value.substring(13, 15);
                        break;
                    case 16: formatted = value.substring(0, 2) + "." + value.substring(2, 5) + "." + value.substring(5, 8) + "." + value.substring(8, 11) + "." + value.substring(11, 14) + "," + value.substring(14, 16);
                        break;
                    case 17: formatted = value.substring(0, 3) + "." + value.substring(3, 6) + "." + value.substring(6, 9) + "." + value.substring(9, 12) + "." + value.substring(12, 15) + "," + value.substring(15, 17);
                        break;
                }
            }
            return formatted;
        } catch (NumberFormatException ex) {
            return "0,00";
        }
    }
    
}
