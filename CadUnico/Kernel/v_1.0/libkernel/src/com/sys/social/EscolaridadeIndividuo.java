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
public class EscolaridadeIndividuo {
    
    private String type;
    private long id;
    private String grauEscolaridade;
    private String unidadeEducacional;
    private String leEscreve;
    private Individuo individuo;
    
    public EscolaridadeIndividuo() {
        this.type = "escolaridadeindividuo";
        this.id = 0l;
        this.grauEscolaridade = "";
        this.unidadeEducacional = "";
        this.leEscreve = "";
        this.individuo = null;
    }
    
    public EscolaridadeIndividuo(Individuo individuo) {
        this.type = "escolaridadeindividuo";
        this.id = 0l;
        this.grauEscolaridade = "";
        this.unidadeEducacional = "";
        this.leEscreve = "";
        this.individuo = individuo;
    }
    
    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public String getUnidadeEducacional() {
        return unidadeEducacional;
    }

    public void setUnidadeEducacional(String unidadeEducacional) {
        this.unidadeEducacional = unidadeEducacional;
    }
    
    public String getLeEscreve() {
        return leEscreve;
    }

    public void setLeEscreve(String leEscreve) {
        this.leEscreve = leEscreve;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    
}
