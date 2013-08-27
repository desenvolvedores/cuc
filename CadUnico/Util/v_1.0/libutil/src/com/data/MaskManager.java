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
public class MaskManager {
    
    public MaskManager() {

    }

    public static javax.swing.text.MaskFormatter setDateMask() {
        try {
            javax.swing.text.MaskFormatter dateMask = new javax.swing.text.MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            return dateMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static javax.swing.text.MaskFormatter setTimeMask() {
        try {
            javax.swing.text.MaskFormatter dateMask = new javax.swing.text.MaskFormatter("##:##:##");
            dateMask.setPlaceholderCharacter('_');
            return dateMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static javax.swing.text.MaskFormatter setCpfMask() {
        try {
            javax.swing.text.MaskFormatter cpfMask = new javax.swing.text.MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');
            return cpfMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static javax.swing.text.MaskFormatter setZipMask() {
        try {
            javax.swing.text.MaskFormatter zipMask = new javax.swing.text.MaskFormatter("##.###-###");
            zipMask.setPlaceholderCharacter('_');
            return zipMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static javax.swing.text.MaskFormatter setPhoneMask() {
        try {
            javax.swing.text.MaskFormatter phoneMask = new javax.swing.text.MaskFormatter("(##) ####-####");
            phoneMask.setPlaceholderCharacter('_');
            return phoneMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static javax.swing.text.MaskFormatter setMunicipalRegistrationMask() {
        try {
            javax.swing.text.MaskFormatter munRegMask = new javax.swing.text.MaskFormatter("##.###.###");
            munRegMask.setPlaceholderCharacter('_');
            return munRegMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static javax.swing.text.MaskFormatter setMoneyMask() {
        try {
            javax.swing.text.MaskFormatter munRegMask = new javax.swing.text.MaskFormatter("###.###,##");
            munRegMask.setPlaceholderCharacter(' ');
            return munRegMask;
        }
        catch(java.text.ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
