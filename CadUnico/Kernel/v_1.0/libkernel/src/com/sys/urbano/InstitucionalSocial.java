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
    private long idNucleo;
    private String nome;
    private RecursoSocial social;
    
    public InstitucionalSocial() {
        
        this.type = "institucionalsocial";
        this.idNucleo = 0l;
        this.nome = "";
        this.social = null;
        
    }
    
    public InstitucionalSocial(RecursoSocial social) {
        
        this.type = "institucionalsocial";
        this.idNucleo = 0l;
        this.nome = "";
        this.social = social;
        
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
    
}
