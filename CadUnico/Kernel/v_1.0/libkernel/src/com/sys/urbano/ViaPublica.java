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
public class ViaPublica {
    
    private String type;
    private long id;
    private long idNucleo;
    private String descricao;
    private RecursoMobilidade mobilidade;
    
    public ViaPublica() {
        
        this.type = "viapublica";
        this.id = 0l;
        this.idNucleo = 0l;
        this.descricao = "";
        this.mobilidade = null;
        
    }
    
    public ViaPublica(RecursoMobilidade mobilidade) {
        
        this.type = "viapublica";
        this.id = 0l;
        this.idNucleo = 0l;
        this.descricao = "";
        this.mobilidade = mobilidade;
        
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
    
    public long getIdNucleo() {
        return idNucleo;
    }

    public void setIdNucleo(long idNucleo) {
        this.idNucleo = idNucleo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RecursoMobilidade getMobilidade() {
        return mobilidade;
    }

    public void setMobilidade(RecursoMobilidade mobilidade) {
        this.mobilidade = mobilidade;
    }
    
}
