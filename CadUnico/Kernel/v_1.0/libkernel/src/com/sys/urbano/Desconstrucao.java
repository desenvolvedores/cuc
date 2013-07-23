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
public class Desconstrucao {
    
    private String type;
    private long id;
    private int numeroADemolir;
    private String motivo;
    private String processos;
    private com.sys.urbano.AcaoNucleo acao;
    
    public Desconstrucao() {
        this.type = "desconstrucao";
        this.id = 0l;
        this.numeroADemolir = 0;
        this.motivo = "";
        this.processos = "";
        this.acao = null;
    }
    
    public Desconstrucao(com.sys.urbano.AcaoNucleo acao) {
        this.type = "desconstrucao";
        this.id = 0l;
        this.numeroADemolir = 0;
        this.motivo = "";
        this.processos = "";
        this.acao = acao;
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

    public int getNumeroADemolir() {
        return numeroADemolir;
    }

    public void setNumeroADemolir(int numeroADemolir) {
        this.numeroADemolir = numeroADemolir;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getProcessos() {
        return processos;
    }

    public void setProcessos(String processos) {
        this.processos = processos;
    }

    /**
     * @return the acao
     */
    public com.sys.urbano.AcaoNucleo getAcao() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcao(com.sys.urbano.AcaoNucleo acao) {
        this.acao = acao;
    }
    
}
