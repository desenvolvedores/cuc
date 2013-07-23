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
public class AnexoImovel extends Anexo {
    
    private String type;
    private long idImovel;
    
    public AnexoImovel() {
        super();
        this.type = "anexoimovel";
        this.idImovel = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(long idImovel) {
        this.idImovel = idImovel;
    }
    
}
