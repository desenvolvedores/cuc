/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.upload;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class FileManager {
    
    private String destino;
    
    public FileManager() {
        this.destino = "";
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public void salvar(String pathDir, java.io.BufferedInputStream input) 
            throws java.io.IOException {
        
        java.io.File file = new java.io.File(pathDir);
                    
        if (! file.exists())
            file.mkdirs();
        
        if (file.isDirectory()) {
            
            String NEWLINE = "\r\n";
            java.io.BufferedInputStream bi = input;
            java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
            int tmp = 0;

            while (( tmp = bi.read()) > -1)
                bo.write(tmp);

            String content = bo.toString();
            String boundary = content.substring(0, content.indexOf(NEWLINE));
            int inicioNome = content.indexOf("filename=\"") + 10 ;
            String nome = content.substring(inicioNome  , content.indexOf( "\"",inicioNome + 1));
            int inicioArq = content.indexOf(NEWLINE + NEWLINE) + 4;
            int fimArq = content.indexOf(boundary, inicioArq )-2;
             
            boolean existe = true;
            String tempPath = "";
            java.io.File temp = null;
            
            do {
                
                tempPath = String.valueOf(new java.util.Date().getTime());
                temp = new java.io.File(pathDir + "\\" + tempPath + "_" + nome);
                
                if (! temp.exists())
                    existe = false;
                
            } while (existe);
            
            java.io.FileOutputStream fo = new java.io.FileOutputStream(new java.io.File(pathDir + "\\" + tempPath + "_" + nome));
            fo.write(bo.toByteArray(), inicioArq, fimArq - inicioArq);
            fo.close();
            
        }
        
    }
    
}
