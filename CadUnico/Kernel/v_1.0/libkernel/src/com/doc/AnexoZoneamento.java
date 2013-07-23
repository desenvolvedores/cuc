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
public class AnexoZoneamento extends Anexo {
    
    private String type;
    private long idFundiaria;
    
    public AnexoZoneamento() {
        super();
        this.type = "anexoimovel";
        this.idFundiaria = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdFundiaria() {
        return idFundiaria;
    }

    public void setIdFundiaria(long idFundiaria) {
        this.idFundiaria = idFundiaria;
    }
    
}
