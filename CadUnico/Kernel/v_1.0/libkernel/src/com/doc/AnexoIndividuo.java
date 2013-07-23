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
public class AnexoIndividuo extends Anexo {
    
    private String type;
    private long idIndividuo;
    
    public AnexoIndividuo() {
        super();
        this.type = "anexoindividuo";
        this.idIndividuo = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdIndividuo() {
        return idIndividuo;
    }

    public void setIdIndividuo(long idIndividuo) {
        this.idIndividuo = idIndividuo;
    }
    
}
