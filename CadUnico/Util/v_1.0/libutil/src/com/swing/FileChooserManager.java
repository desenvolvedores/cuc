/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.swing;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class FileChooserManager {
    
    public FileChooserManager() {
        
        
        
    }
    
    public static java.io.File[] documentOpenerChooser(java.awt.Component component, javax.swing.JTextField field) {
        
        javax.swing.JFileChooser jfcSelectFiles;
        jfcSelectFiles = new javax.swing.JFileChooser();
        jfcSelectFiles.setMultiSelectionEnabled(true);
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = com.data.FileFilterManager.filterDocuments();
        
        for (javax.swing.filechooser.FileFilter filter : filters)
            jfcSelectFiles.addChoosableFileFilter(filter);
        
        int returnVal = jfcSelectFiles.showOpenDialog(component);
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            
            String selectedFiles = "";
            for (int i = 0; i < jfcSelectFiles.getSelectedFiles().length; i++) {
                    
                if (i <= jfcSelectFiles.getSelectedFiles().length)
                    selectedFiles += jfcSelectFiles.getSelectedFiles()[i].getName() + ";";
                else
                    selectedFiles += jfcSelectFiles.getSelectedFiles()[i].getName();
                    
            }
            field.setText(selectedFiles);
            field.setToolTipText(selectedFiles);
            
            return jfcSelectFiles.getSelectedFiles();
            
        }
        
        return null;
        
    }
    
    public static java.io.File[] commonImageOpenerChooser(java.awt.Component component, javax.swing.JTextField field) {
        
        javax.swing.JFileChooser jfcSelectFiles;
        jfcSelectFiles = new javax.swing.JFileChooser();
        jfcSelectFiles.setMultiSelectionEnabled(true);
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = com.data.FileFilterManager.filterDocuments();
        
        for (javax.swing.filechooser.FileFilter filter : filters)
            jfcSelectFiles.addChoosableFileFilter(filter);
        
        int returnVal = jfcSelectFiles.showOpenDialog(component);
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            
            String selectedFiles = "";
            for (int i = 0; i < jfcSelectFiles.getSelectedFiles().length; i++) {
                    
                if (i <= jfcSelectFiles.getSelectedFiles().length)
                    selectedFiles += jfcSelectFiles.getSelectedFiles()[i].getName() + ";";
                else
                    selectedFiles += jfcSelectFiles.getSelectedFiles()[i].getName();
                    
            }
            field.setText(selectedFiles);
            
            return jfcSelectFiles.getSelectedFiles();
            
        }
        
        return null;
        
    }
    
}
