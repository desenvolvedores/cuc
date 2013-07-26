/*
 * Classe pertencente a API de configurações de sistema "libconfig".
 */
package com.sys;

/**
 *
 * @author William Oliveira
 * 
 * @author 1.0
 */
public class SystemSettings {
    
    public static java.lang.String systemPath = "";
    public static java.lang.String systemName = "";
    public static java.lang.String url = "";
    public static java.lang.String theme = "";
    public static final java.awt.Color EMPTY_REQUIRED_TEXTBOX = new java.awt.Color(156, 193, 243);
    public static final java.awt.Color EMPTY_REQUIRED_COMBOBOX = new java.awt.Color(0, 0, 255);
    public static final java.awt.Color FILLED_UP_REQUIRED_TEXTBOX = new java.awt.Color(255, 255, 255);
    public static final java.awt.Color FILLED_UP_REQUIRED_COMBOBOX = new java.awt.Color(0, 0, 0);
    
    public static void setSystemThemeNimbus() 
            throws java.lang.ClassNotFoundException, java.lang.InstantiationException, 
            java.lang.IllegalAccessException, javax.swing.UnsupportedLookAndFeelException {
        
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        
    }
    
    public static void setSystemThemeNimrod(javax.swing.JFrame frame, java.lang.String theme) 
            throws javax.swing.UnsupportedLookAndFeelException {

        com.nilo.plaf.nimrod.NimRODTheme nt = new com.nilo.plaf.nimrod.NimRODTheme(theme);
        com.nilo.plaf.nimrod.NimRODLookAndFeel nf = new com.nilo.plaf.nimrod.NimRODLookAndFeel();
        nf.setCurrentTheme(nt);
        javax.swing.UIManager.setLookAndFeel(nf);
        javax.swing.SwingUtilities.updateComponentTreeUI(frame);
        
    }
    
    public static void setSystemThemeNimrod(javax.swing.JInternalFrame internalFrame, java.lang.String theme) 
            throws javax.swing.UnsupportedLookAndFeelException {
            
        com.nilo.plaf.nimrod.NimRODTheme nt = new com.nilo.plaf.nimrod.NimRODTheme(theme);
        com.nilo.plaf.nimrod.NimRODLookAndFeel nf = new com.nilo.plaf.nimrod.NimRODLookAndFeel();
        nf.setCurrentTheme(nt);
        javax.swing.UIManager.setLookAndFeel(nf);
        javax.swing.SwingUtilities.updateComponentTreeUI(internalFrame);
        
    }
    
    public static void setSystemThemeNimrod(javax.swing.JDialog dialog, java.lang.String theme) 
            throws javax.swing.UnsupportedLookAndFeelException {

        com.nilo.plaf.nimrod.NimRODTheme nt = new com.nilo.plaf.nimrod.NimRODTheme(theme);
        com.nilo.plaf.nimrod.NimRODLookAndFeel nf = new com.nilo.plaf.nimrod.NimRODLookAndFeel();
        nf.setCurrentTheme(nt);
        javax.swing.UIManager.setLookAndFeel(nf);
        javax.swing.SwingUtilities.updateComponentTreeUI(dialog);
        
    }
    
    public static void setSystemThemeOyoaha(javax.swing.JFrame frame) 
            throws javax.swing.UnsupportedLookAndFeelException {

        com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel laf = new com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel();
        javax.swing.UIManager.setLookAndFeel(laf);
        javax.swing.SwingUtilities.updateComponentTreeUI(frame);
        
    }
    
    public static void setSystemThemeOyoaha(javax.swing.JInternalFrame internalFrame) 
            throws javax.swing.UnsupportedLookAndFeelException {

        com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel laf = new com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel();
        javax.swing.UIManager.setLookAndFeel(laf);
        javax.swing.SwingUtilities.updateComponentTreeUI(internalFrame);
        
    }
    
    public static void setSystemThemeOyoaha(javax.swing.JDialog dialog) 
            throws javax.swing.UnsupportedLookAndFeelException {

        com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel laf = new com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel();
        javax.swing.UIManager.setLookAndFeel(laf);
        javax.swing.SwingUtilities.updateComponentTreeUI(dialog);
        
    }
    
}
