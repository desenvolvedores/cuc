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
public class AnexoJudicial extends Anexo {
    
    private String type;
    private long idFundiaria;
    
    public AnexoJudicial() {
        super();
        this.type = "anexojudicial";
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
