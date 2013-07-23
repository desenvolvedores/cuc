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
    
    public boolean salvar(String path, String extensao, int data[]) 
            throws java.io.IOException {
        
        if (data.length == 0)
            return false;
    
        java.io.File dirs = new java.io.File(path);
        String nome = String.valueOf(new java.util.Date().getTime());
        java.io.File file = new java.io.File(path + "\\" + nome + "." + extensao);
        this.setDestino(file.getAbsolutePath());
            
        if (! dirs.exists())
            dirs.mkdirs();
            
        if (! file.exists())
            file.createNewFile();
        
        java.io.FileOutputStream writer = new java.io.FileOutputStream(file);
        
        for (int i = 0; i < data.length; i++)
            writer.write(data[i]);
        
        writer.flush();
        writer.close();
        
        return true;
        
    }
    
}
