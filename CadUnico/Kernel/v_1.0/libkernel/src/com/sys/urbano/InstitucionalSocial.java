/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.urbano;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class InstitucionalSocial {
    
    private String type;
    private String nome;
    private RecursoSocial social;
    private Nucleo nucleo;
    
    public InstitucionalSocial() {
        this.type = "institucionalsocial";
        this.nome = "";
        this.social = null;
        this.nucleo = null;
    }
    
    public InstitucionalSocial(Nucleo nucleo) {
        this.type = "institucionalsocial";
        this.nome = "";
        this.social = null;
        this.nucleo = nucleo;
    }
    
    public InstitucionalSocial(RecursoSocial social) {
        this.type = "institucionalsocial";
        this.nome = "";
        this.social = social;
        this.nucleo = null;
    }
    
    public InstitucionalSocial(Nucleo nucleo, RecursoSocial social) {
        this.type = "institucionalsocial";
        this.nome = "";
        this.social = social;
        this.nucleo = nucleo;
    }
    
    public String getType() {
        return type;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RecursoSocial getSocial() {
        return social;
    }

    public void setSocial(RecursoSocial social) {
        this.social = social;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    
}
