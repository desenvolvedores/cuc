/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.social;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DocumentoIndividuo extends com.common.Documento {
    
    private String type;
    private Individuo individuo;
    
    public DocumentoIndividuo() {
        super();
        this.type = "documentoindividuo";
        this.individuo = null;
    }
    
    public DocumentoIndividuo(Individuo individuo) {
        super();
        this.type = "documentoindividuo";
        this.individuo = individuo;
    }
    
    public String getType() {
        return type;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    
}
