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
public class Reassentamento {
    
    private String type;
    private long id;
    private String estimativaRemocao;
    private int numeroAConstruir;
    private int numeroProvisorias;
    private String localDefinitivo;
    private com.sys.urbano.AcaoNucleo acao;
    
    public Reassentamento() {
        this.type = "reassentamento";
        this.id = 0l;
        this.estimativaRemocao = "";
        this.numeroAConstruir = 0;
        this.numeroProvisorias = 0;
        this.localDefinitivo = "";
        this.acao = null;
    }
    
    public Reassentamento(com.sys.urbano.AcaoNucleo acao) {
        this.type = "reassentamento";
        this.id = 0l;
        this.estimativaRemocao = "";
        this.numeroAConstruir = 0;
        this.numeroProvisorias = 0;
        this.localDefinitivo = "";
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

    public String getEstimativaRemocao() {
        return estimativaRemocao;
    }

    public void setEstimativaRemocao(String estimativaRemocao) {
        this.estimativaRemocao = estimativaRemocao;
    }

    public int getNumeroAConstruir() {
        return numeroAConstruir;
    }

    public void setNumeroAConstruir(int numeroAConstruir) {
        this.numeroAConstruir = numeroAConstruir;
    }

    public int getNumeroProvisorias() {
        return numeroProvisorias;
    }

    public void setNumeroProvisorias(int numeroProvisorias) {
        this.numeroProvisorias = numeroProvisorias;
    }

    public String getLocalDefinitivo() {
        return localDefinitivo;
    }

    public void setLocalDefinitivo(String localDefinitivo) {
        this.localDefinitivo = localDefinitivo;
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