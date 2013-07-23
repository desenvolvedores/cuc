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
public class FileFilterManager {
    
    public FileFilterManager() {
        
    }
    
    public java.util.List<javax.swing.filechooser.FileFilter> filterCommonImages() {
        
        javax.swing.filechooser.FileFilter filterBMP = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".bmp");
                
            }
                
            public String getDescription() {
                    
                return "Text Documents (*.bmp)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterGIF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".gif");
                
            }
                
            public String getDescription() {
                    
                return "Text Documents (*.gif)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterJPG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg");
                
            }
                
            public String getDescription() {
                    
                return "Text Documents (*.jpg, *.jpeg)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterPNG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
                
            }
                
            public String getDescription() {
                    
                return "Text Documents (*.png)";
                
            }
            
        };
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = new java.util.ArrayList<>();
        filters.add(filterBMP);
        filters.add(filterGIF);
        filters.add(filterJPG);
        filters.add(filterPNG);
        
        return filters;
        
    }
    
}
