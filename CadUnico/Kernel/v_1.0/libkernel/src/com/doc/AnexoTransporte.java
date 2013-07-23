/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.doc;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class AnexoTransporte extends Anexo {
    
    private String type;
    private long idNucleo;
    
    public AnexoTransporte() {
        super();
        this.type = "anexotransporte";
        this.idNucleo = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdNucleo() {
        return idNucleo;
    }

    public void setIdNucleo(long idNucleo) {
        this.idNucleo = idNucleo;
    }
    
}
