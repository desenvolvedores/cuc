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
public class AnexoDemolicao extends Anexo {
    
    private String type;
    private long idDemolicao;
    
    public AnexoDemolicao() {
        super();
        this.type = "anexodemolicao";
        this.idDemolicao = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdDemolicao() {
        return idDemolicao;
    }

    public void setIdDemolicao(long idDemolicao) {
        this.idDemolicao = idDemolicao;
    }
    
}
