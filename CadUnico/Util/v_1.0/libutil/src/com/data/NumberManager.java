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
public class NumberManager {
    
    public NumberManager() {
        
    }
    
    public static short formatRawShort(String value) {
        
        return Short.parseShort(value.replace(".", ""));
        
    }
    
    public static int formatRawInteger(String value) {
        
        return Integer.parseInt(value.replace(".", ""));
        
    }
    
    public static long formatRawLong(String value) {
        
        return Long.parseLong(value.replace(".", ""));
        
    }
    
    public static float formatRawFloat(String value) {
        
        return Float.parseFloat(value.replace(".", "").replace(",", "."));
        
    }
    
    public static double formatRawDouble(String value) {
        
        return Double.parseDouble(value.replace(".", "").replace(",", "."));
        
    }
    
    public static java.lang.String formatIntegerPtbr(long value) {
        
        try {
            
            String formatted = "0";
            String text = String.valueOf(value);
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("0000")) {
                text = text.substring(4, text.length());
            } else if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 34) {
                
                switch (length) {
                    
                    case 0: formatted = "0";
                        break;
                    case 1:
                    case 2:
                    case 3: formatted = text;
                        break;
                    case 4: formatted = text.substring(0, 1) + "." + text.substring(1, 4);
                        break;
                    case 5: formatted = text.substring(0, 2) + "." + text.substring(2, 5);
                        break;
                    case 6: formatted = text.substring(0, 3) + "." + text.substring(3, 6);
                        break;
                    case 7: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7);
                        break;
                    case 8: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8);
                        break;
                    case 9: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9);
                        break;
                    case 10: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10);
                        break;
                    case 11: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11);
                        break;
                    case 12: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12);
                        break;
                    case 13: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13);
                        break;
                    case 14: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14);
                        break;
                    case 15: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15);
                        break;
                    case 16: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16);
                        break;
                    case 17: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17);
                        break;
                    case 18: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18);
                        break;
                    case 19: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19);
                        break;
                    case 20: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20);
                        break;
                    case 21: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21);
                        break;
                    case 22: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22);
                        break;
                    case 23: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23);
                        break;
                    case 24: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24);
                        break;
                    case 25: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25);
                        break;
                    case 26: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26);
                        break;
                    case 27: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27);
                        break;
                    case 28: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28);
                        break;
                    case 29: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29);
                        break;
                    case 30: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30);
                        break;
                    case 31: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31);
                        break;
                    case 32: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "." + text.substring(29, 32);
                        break;
                    case 33: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "." + text.substring(30, 33);
                        break;
                    case 34: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "." + text.substring(31, 34);
                        break;
                    
                }
                
            }
            
            return formatted;
            
        } catch (NumberFormatException ex) {
            
            return "0";
            
        }
        
    }
    
    public static java.lang.String formatGeoCordinatePtbr(double value) {
        
        return String.valueOf(value).replace(".", ",");
        
    }
    
    public static java.lang.String formatDecimalPtbr(double value) {
        
        try {
            
            String formatted = "0,000";
            String text = String.valueOf(value);
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("0000")) {
                text = text.substring(4, text.length());
            } else if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 34) {
                
                switch (length) {
                    
                    case 0: formatted = "0,000";
                        break;
                    case 1: formatted = "0,00" + text;
                        break;
                    case 2: formatted = "0,0" + text;
                        break;
                    case 3: formatted = "0," + text;
                        break;
                    case 4: formatted = text.substring(0, 1) + "," + text.substring(1, 4);
                        break;
                    case 5: formatted = text.substring(0, 2) + "," + text.substring(2, 5);
                        break;
                    case 6: formatted = text.substring(0, 3) + "," + text.substring(3, 6);
                        break;
                    case 7: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "," + text.substring(4, 7);
                        break;
                    case 8: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "," + text.substring(5, 8);
                        break;
                    case 9: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "," + text.substring(6, 9);
                        break;
                    case 10: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "," + text.substring(7, 10);
                        break;
                    case 11: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "," + text.substring(8, 11);
                        break;
                    case 12: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "," + text.substring(9, 12);
                        break;
                    case 13: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "," + text.substring(10, 13);
                        break;
                    case 14: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "," + text.substring(11, 14);
                        break;
                    case 15: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "," + text.substring(12, 15);
                        break;
                    case 16: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "," + text.substring(13, 16);
                        break;
                    case 17: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "," + text.substring(14, 17);
                        break;
                    case 18: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "," + text.substring(15, 18);
                        break;
                    case 19: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "," + text.substring(16, 19);
                        break;
                    case 20: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "," + text.substring(17, 20);
                        break;
                    case 21: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "," + text.substring(18, 21);
                        break;
                    case 22: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "," + text.substring(19, 22);
                        break;
                    case 23: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "," + text.substring(20, 23);
                        break;
                    case 24: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "," + text.substring(21, 24);
                        break;
                    case 25: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "," + text.substring(22, 25);
                        break;
                    case 26: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "," + text.substring(23, 26);
                        break;
                    case 27: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "," + text.substring(24, 27);
                        break;
                    case 28: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "," + text.substring(25, 28);
                        break;
                    case 29: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "," + text.substring(26, 29);
                        break;
                    case 30: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "," + text.substring(27, 30);
                        break;
                    case 31: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "," + text.substring(28, 31);
                        break;
                    case 32: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "," + text.substring(29, 32);
                        break;
                    case 33: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "," + text.substring(30, 33);
                        break;
                    case 34: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "," + text.substring(31, 34);
                        break;
                        
                }
                
            }
            
            return formatted;
            
        } catch (NumberFormatException ex) {
            
            return "0,000";
            
        }
        
    }
    
    public static java.lang.String formatMoneyPtbr(double value) {
        
        try {
            
            String formatted = "0,00";
            String text = String.valueOf(value);
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 33) {
                
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
                    case 18: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "," + text.substring(16, 18);
                        break;
                    case 19: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "," + text.substring(17, 19);
                        break;
                    case 20: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "," + text.substring(18, 20);
                        break;
                    case 21: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "," + text.substring(19, 21);
                        break;
                    case 22: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "," + text.substring(20, 22);
                        break;
                    case 23: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "," + text.substring(21, 23);
                        break;
                    case 24: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "," + text.substring(22, 24);
                        break;
                    case 25: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "," + text.substring(23, 25);
                        break;
                    case 26: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "," + text.substring(24, 26);
                        break;
                    case 27: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "," + text.substring(25, 27);
                        break;
                    case 28: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "," + text.substring(26, 28);
                        break;
                    case 29: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "," + text.substring(27, 29);
                        break;
                    case 30: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "," + text.substring(28, 30);
                        break;
                    case 31: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "," + text.substring(29, 31);
                        break;
                    case 32: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "," + text.substring(30, 32);
                        break;
                    case 33: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "," + text.substring(31, 33);
                        break;
                        
                }
                
            }
            
            return formatted;
            
        } catch (NumberFormatException ex) {
            
            return "0,00";
            
        }
        
    }
    
    public static void formatIntegerPtbr(javax.swing.JTextField field) {
        
        try {
            
            String formatted = "0";
            String text = field.getText();
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("0000")) {
                text = text.substring(4, text.length());
            } else if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 34) {
                
                switch (length) {
                    
                    case 0: formatted = "0";
                        break;
                    case 1:
                    case 2:
                    case 3: formatted = text;
                        break;
                    case 4: formatted = text.substring(0, 1) + "." + text.substring(1, 4);
                        break;
                    case 5: formatted = text.substring(0, 2) + "." + text.substring(2, 5);
                        break;
                    case 6: formatted = text.substring(0, 3) + "." + text.substring(3, 6);
                        break;
                    case 7: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7);
                        break;
                    case 8: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8);
                        break;
                    case 9: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9);
                        break;
                    case 10: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10);
                        break;
                    case 11: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11);
                        break;
                    case 12: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12);
                        break;
                    case 13: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13);
                        break;
                    case 14: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14);
                        break;
                    case 15: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15);
                        break;
                    case 16: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16);
                        break;
                    case 17: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17);
                        break;
                    case 18: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18);
                        break;
                    case 19: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19);
                        break;
                    case 20: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20);
                        break;
                    case 21: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21);
                        break;
                    case 22: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22);
                        break;
                    case 23: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23);
                        break;
                    case 24: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24);
                        break;
                    case 25: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25);
                        break;
                    case 26: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26);
                        break;
                    case 27: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27);
                        break;
                    case 28: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28);
                        break;
                    case 29: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29);
                        break;
                    case 30: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30);
                        break;
                    case 31: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31);
                        break;
                    case 32: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "." + text.substring(29, 32);
                        break;
                    case 33: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "." + text.substring(30, 33);
                        break;
                    case 34: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "." + text.substring(31, 34);
                        break;
                    
                }
                
            }
            
            field.setText(formatted);
            
        } catch (NumberFormatException ex) {
            
            field.setText("0");
            
        }
        
    }
    
    public static void formatDecimalPtbr(javax.swing.JTextField field) {
        
        try {
            
            String formatted = "0,000";
            String text = field.getText();
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("0000")) {
                text = text.substring(4, text.length());
            } else if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 34) {
                
                switch (length) {
                    
                    case 0: formatted = "0,000";
                        break;
                    case 1: formatted = "0,00" + text;
                        break;
                    case 2: formatted = "0,0" + text;
                        break;
                    case 3: formatted = "0," + text;
                        break;
                    case 4: formatted = text.substring(0, 1) + "," + text.substring(1, 4);
                        break;
                    case 5: formatted = text.substring(0, 2) + "," + text.substring(2, 5);
                        break;
                    case 6: formatted = text.substring(0, 3) + "," + text.substring(3, 6);
                        break;
                    case 7: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "," + text.substring(4, 7);
                        break;
                    case 8: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "," + text.substring(5, 8);
                        break;
                    case 9: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "," + text.substring(6, 9);
                        break;
                    case 10: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "," + text.substring(7, 10);
                        break;
                    case 11: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "," + text.substring(8, 11);
                        break;
                    case 12: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "," + text.substring(9, 12);
                        break;
                    case 13: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "," + text.substring(10, 13);
                        break;
                    case 14: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "," + text.substring(11, 14);
                        break;
                    case 15: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "," + text.substring(12, 15);
                        break;
                    case 16: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "," + text.substring(13, 16);
                        break;
                    case 17: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "," + text.substring(14, 17);
                        break;
                    case 18: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "," + text.substring(15, 18);
                        break;
                    case 19: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "," + text.substring(16, 19);
                        break;
                    case 20: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "," + text.substring(17, 20);
                        break;
                    case 21: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "," + text.substring(18, 21);
                        break;
                    case 22: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "," + text.substring(19, 22);
                        break;
                    case 23: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "," + text.substring(20, 23);
                        break;
                    case 24: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "," + text.substring(21, 24);
                        break;
                    case 25: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "," + text.substring(22, 25);
                        break;
                    case 26: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "," + text.substring(23, 26);
                        break;
                    case 27: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "," + text.substring(24, 27);
                        break;
                    case 28: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "," + text.substring(25, 28);
                        break;
                    case 29: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "," + text.substring(26, 29);
                        break;
                    case 30: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "," + text.substring(27, 30);
                        break;
                    case 31: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "," + text.substring(28, 31);
                        break;
                    case 32: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "," + text.substring(29, 32);
                        break;
                    case 33: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "," + text.substring(30, 33);
                        break;
                    case 34: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "," + text.substring(31, 34);
                        break;
                        
                }
                
            }
            
            field.setText(formatted);
            
        } catch (NumberFormatException ex) {
            
            field.setText("0,000");
            
        }
        
    }
    
    public static void formatMoneyPtbr(javax.swing.JTextField field) {
        
        try {
            
            String formatted = "0,00";
            String text = field.getText();
            text = text.replace(".", "");
            text = text.replaceAll(",", "");
            
            if (text.startsWith("000")) {
                text = text.substring(3, text.length());
            } else if (text.startsWith("00")) {
                text = text.substring(2, text.length());
            } else if (text.startsWith("0")) {
                text = text.substring(1, text.length());
            }
            
            for (short i = 0; i < text.length(); i++) {
                Long.parseLong(String.valueOf(text.charAt(i)));
            }
            
            int length = text.length();
            if (length >= 0 && length <= 33) {
                
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
                    case 18: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "," + text.substring(16, 18);
                        break;
                    case 19: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "," + text.substring(17, 19);
                        break;
                    case 20: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "," + text.substring(18, 20);
                        break;
                    case 21: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "," + text.substring(19, 21);
                        break;
                    case 22: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "," + text.substring(20, 22);
                        break;
                    case 23: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "," + text.substring(21, 23);
                        break;
                    case 24: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "," + text.substring(22, 24);
                        break;
                    case 25: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "," + text.substring(23, 25);
                        break;
                    case 26: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "," + text.substring(24, 26);
                        break;
                    case 27: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "," + text.substring(25, 27);
                        break;
                    case 28: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "," + text.substring(26, 28);
                        break;
                    case 29: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "," + text.substring(27, 29);
                        break;
                    case 30: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "," + text.substring(28, 30);
                        break;
                    case 31: formatted = text.substring(0, 2) + "." + text.substring(2, 5) + "." + text.substring(5, 8) + "." + text.substring(8, 11) + "." + text.substring(11, 14) + "." + text.substring(14, 17) + "." + text.substring(17, 20) + "." + text.substring(20, 23) + "." + text.substring(23, 26) + "." + text.substring(26, 29) + "," + text.substring(29, 31);
                        break;
                    case 32: formatted = text.substring(0, 3) + "." + text.substring(3, 6) + "." + text.substring(6, 9) + "." + text.substring(9, 12) + "." + text.substring(12, 15) + "." + text.substring(15, 18) + "." + text.substring(18, 21) + "." + text.substring(21, 24) + "." + text.substring(24, 27) + "." + text.substring(27, 30) + "," + text.substring(30, 32);
                        break;
                    case 33: formatted = text.substring(0, 1) + "." + text.substring(1, 4) + "." + text.substring(4, 7) + "." + text.substring(7, 10) + "." + text.substring(10, 13) + "." + text.substring(13, 16) + "." + text.substring(16, 19) + "." + text.substring(19, 22) + "." + text.substring(22, 25) + "." + text.substring(25, 28) + "." + text.substring(28, 31) + "," + text.substring(31, 33);
                        break;
                        
                }
                
            }
            
            field.setText(formatted);
            
        } catch (NumberFormatException ex) {
            
            field.setText("0,00");
            
        }
        
    }
    
}
