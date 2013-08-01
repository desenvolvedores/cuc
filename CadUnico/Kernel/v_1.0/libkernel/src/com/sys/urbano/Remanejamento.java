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
    private long idAcao;
    private String estimativaRelocacao;
    private int numeroRemocaoDefinitiva;
    private int numeroRemocaoProvisoria;
    
    public Remanejamento() {
        
        this.type = "remanejamento";
        this.id = 0l;
        this.idAcao = 0l;
        this.estimativaRelocacao = "";
        this.numeroRemocaoDefinitiva = 0;
        this.numeroRemocaoProvisoria = 0;
        
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
    
    public long getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(long idAcao) {
        this.idAcao = idAcao;
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
    
}
