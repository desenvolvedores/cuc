/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.social;

import com.common.Telefone;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class TelefoneIndividuo extends Telefone {
    
    private String type;
    private long idIndividuo;
    
    public TelefoneIndividuo() {
        super();
        this.type = "telefoneindividuo";
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
