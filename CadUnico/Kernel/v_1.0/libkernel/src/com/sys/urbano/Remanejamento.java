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
public class Remanejamento {
    
    private String type;
    private long id;
    private String estimativaRelocacao;
    private int numeroRemocaoDefinitiva;
    private int numeroRemocaoProvisoria;
    private com.sys.urbano.AcaoNucleo acao;
    
    public Remanejamento() {
        this.type = "remanejamento";
        this.id = 0l;
        this.estimativaRelocacao = "";
        this.numeroRemocaoDefinitiva = 0;
        this.numeroRemocaoProvisoria = 0;
        this.acao = null;
    }
    
    public Remanejamento(com.sys.urbano.AcaoNucleo acao) {
        this.type = "remanejamento";
        this.id = 0l;
        this.estimativaRelocacao = "";
        this.numeroRemocaoDefinitiva = 0;
        this.numeroRemocaoProvisoria = 0;
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

    public String getEstimativaRelocacao() {
        return estimativaRelocacao;
    }

    public void setEstimativaRelocacao(String estimativaRelocacao) {
        this.estimativaRelocacao = estimativaRelocacao;
    }

    public int getNumeroRemocaoDefinitiva() {
        return numeroRemocaoDefinitiva;
    }

    public void setNumeroRemocaoDefinitiva(int numeroRemocaoDefinitiva) {
        this.numeroRemocaoDefinitiva = numeroRemocaoDefinitiva;
    }

    public int getNumeroRemocaoProvisoria() {
        return numeroRemocaoProvisoria;
    }

    public void setNumeroRemocaoProvisoria(int numeroRemocaoProvisoria) {
        this.numeroRemocaoProvisoria = numeroRemocaoProvisoria;
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
