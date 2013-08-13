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
    
    public static java.util.List<javax.swing.filechooser.FileFilter> filterCommonImages() {
        
        javax.swing.filechooser.FileFilter filterBMP = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".bmp");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.bmp)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterGIF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".gif");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.gif)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterJPG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.jpg, *.jpeg)";
                
            }
            
        };
            
        javax.swing.filechooser.FileFilter filterPNG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.png)";
                
            }
            
        };
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = new java.util.ArrayList<>();
        filters.add(filterBMP);
        filters.add(filterGIF);
        filters.add(filterJPG);
        filters.add(filterPNG);
        
        return filters;
        
    }
    
    public static java.util.List<javax.swing.filechooser.FileFilter> filterCommonDocuments() {
        
        javax.swing.filechooser.FileFilter filterDOC = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".doc") 
                        || file.getName().toLowerCase().endsWith(".docx");
                
            }
                
            public String getDescription() {
                    
                return "Documentos do MS Word (*.doc, *.docx)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterKMZ = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".kmz");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos do Google Earth (*.kmz)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterODS = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".ods");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Planilhas Eletrônicas (*.ods)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterODT = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".odt");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Processadores de Texto (*.odt)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterPDF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".pdf");
                
            }
                
            public String getDescription() {
                    
                return "Documetos de PDF (*.pdf)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterRTF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".rtf");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Rich Text (*.rtf)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterTXT = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Texto (*.txt)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterXLS = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".xls") 
                        || file.getName().toLowerCase().endsWith(".xlsx");
                
            }
                
            public String getDescription() {
                    
                return "Documentos do MS Excel (*.xls, *.xlsx)";
                
            }
            
        };
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = new java.util.ArrayList<>();
        filters.add(filterDOC);
        filters.add(filterKMZ);
        filters.add(filterODS);
        filters.add(filterODT);
        filters.add(filterPDF);
        filters.add(filterRTF);
        filters.add(filterTXT);
        filters.add(filterXLS);
        
        return filters;
        
    }
    
    public static java.util.List<javax.swing.filechooser.FileFilter> filterDocuments() {
        
        javax.swing.filechooser.FileFilter filterBMP = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".bmp");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.bmp)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterDOC = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".doc") 
                        || file.getName().toLowerCase().endsWith(".docx");
                
            }
                
            public String getDescription() {
                    
                return "Documentos do MS Word (*.doc, *.docx)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterGIF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".gif");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.gif)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterJPG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.jpg, *.jpeg)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterKMZ = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".kmz");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos do Google Earth (*.kmz)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterODS = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".ods");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Planilhas Eletrônicas (*.ods)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterODT = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".odt");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Processadores de Texto (*.odt)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterPDF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".pdf");
                
            }
                
            public String getDescription() {
                    
                return "Documetos de PDF (*.pdf)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterPNG = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".png");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Imagem (*.png)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterRTF = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".rtf");
                
            }
                
            public String getDescription() {
                    
                return "Documentos de Rich Text (*.rtf)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterTXT = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
                
            }
                
            public String getDescription() {
                    
                return "Arquivos de Texto (*.txt)";
                
            }
            
        };
        
        javax.swing.filechooser.FileFilter filterXLS = new javax.swing.filechooser.FileFilter() {
                
            public boolean accept(java.io.File file) {
                    
                return file.isDirectory() || file.getName().toLowerCase().endsWith(".xls") 
                        || file.getName().toLowerCase().endsWith(".xlsx");
                
            }
                
            public String getDescription() {
                    
                return "Documentos do MS Excel (*.xls, *.xlsx)";
                
            }
            
        };
        
        java.util.List<javax.swing.filechooser.FileFilter> filters = new java.util.ArrayList<>();
        filters.add(filterBMP);
        filters.add(filterDOC);
        filters.add(filterGIF);
        filters.add(filterJPG);
        filters.add(filterKMZ);
        filters.add(filterODS);
        filters.add(filterODT);
        filters.add(filterPDF);
        filters.add(filterPNG);
        filters.add(filterRTF);
        filters.add(filterTXT);
        filters.add(filterXLS);
        
        return filters;
        
    }
    
}
