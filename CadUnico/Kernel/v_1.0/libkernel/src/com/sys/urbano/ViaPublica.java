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
    private String descricao;
    private RecursoMobilidade mobilidade;
    private Nucleo nucleo;
    
    public ViaPublica() {
        this.type = "viapublica";
        this.id = 0l;
        this.descricao = "";
        this.mobilidade = null;
        this.nucleo = null;
    }
    
    public ViaPublica(Nucleo nucleo) {
        this.type = "viapublica";
        this.id = 0l;
        this.descricao = "";
        this.mobilidade = null;
        this.nucleo = nucleo;
    }
    
    public ViaPublica(RecursoMobilidade mobilidade) {
        this.type = "viapublica";
        this.id = 0l;
        this.descricao = "";
        this.mobilidade = mobilidade;
        this.nucleo = null;
    }
    
    public ViaPublica(Nucleo nucleo, RecursoMobilidade mobilidade) {
        this.type = "viapublica";
        this.id = 0l;
        this.descricao = "";
        this.mobilidade = mobilidade;
        this.nucleo = nucleo;
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

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    
}
