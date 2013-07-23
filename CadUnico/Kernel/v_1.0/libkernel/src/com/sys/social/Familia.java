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
public class Familia {
    
    private String type;
    private long id;
    private String remocaoFamilia;
    private String situacaoRemocao;
    private String especifiqueRemocao;
    private String atendente;
    private java.util.Date dataAtendimento;
    private String atendenteAtualizacao;
    private java.util.Date dataAtualizacao;
    private java.util.List<Individuo> individuos;
    
    public Familia() {
        this.type = "familia";
        this.id = 0l;
        this.remocaoFamilia = "";
        this.situacaoRemocao = "";
        this.especifiqueRemocao = "";
        this.atendente = "";
        this.dataAtendimento = null;
        this.atendenteAtualizacao = "";
        this.dataAtualizacao = null;
        this.individuos = null;
    }
    
    public Familia(java.util.List<Individuo> individuos) {
        this.type = "familia";
        this.id = 0l;
        this.remocaoFamilia = "";
        this.situacaoRemocao = "";
        this.especifiqueRemocao = "";
        this.atendente = "";
        this.dataAtendimento = null;
        this.atendenteAtualizacao = "";
        this.dataAtualizacao = null;
        this.individuos = individuos;
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

    public String getRemocaoFamilia() {
        return remocaoFamilia;
    }

    public void setRemocaoFamilia(String remocaoFamilia) {
        this.remocaoFamilia = remocaoFamilia;
    }

    public String getSituacaoRemocao() {
        return situacaoRemocao;
    }

    public void setSituacaoRemocao(String situacaoRemocao) {
        this.situacaoRemocao = situacaoRemocao;
    }

    public String getEspecifiqueRemocao() {
        return especifiqueRemocao;
    }

    public void setEspecifiqueRemocao(String especifiqueRemocao) {
        this.especifiqueRemocao = especifiqueRemocao;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public java.util.Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(java.util.Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getAtendenteAtualizacao() {
        return atendenteAtualizacao;
    }

    public void setAtendenteAtualizacao(String atendenteAtualizacao) {
        this.atendenteAtualizacao = atendenteAtualizacao;
    }

    public java.util.Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(java.util.Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    public java.util.List<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(java.util.List<Individuo> individuos) {
        this.individuos = individuos;
    }
    
}
