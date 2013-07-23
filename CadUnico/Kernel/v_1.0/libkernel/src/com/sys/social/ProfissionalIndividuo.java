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
public class ProfissionalIndividuo {
    
    private String type;
    private long id;
    private String situacaoTrabalhista;
    private String obsSituacaoTrabalhista;
    private String tipoTrabalho;
    private String obsTipoTrabalho;
    private String nomeTrabalho;
    private String possuiRenda;
    private double renda;
    private double outrasRendas;
    private String tipoBeneficio;
    private double doacaoRegular;
    private double aposentadoriaPensao;
    private double seguroDesemprego;
    private double pensaoAlimentar;
    private double outrosBeneficios;
    private String numeroBpcloas;
    private Individuo individuo;
    
    public ProfissionalIndividuo() {
        this.type = "profissionalindividuo";
        this.id = 0l;
        this.situacaoTrabalhista = "";
        this.obsSituacaoTrabalhista = "";
        this.tipoTrabalho = "";
        this.obsTipoTrabalho = "";
        this.nomeTrabalho = "";
        this.possuiRenda = "";
        this.renda = 0.00d;
        this.outrasRendas = 0.00d;
        this.tipoBeneficio = "";
        this.doacaoRegular = 0.00d;
        this.aposentadoriaPensao = 0.00d;
        this.seguroDesemprego = 0.00d;
        this.pensaoAlimentar = 0.00d;
        this.outrosBeneficios = 0.00d;
        this.numeroBpcloas = "";
        this.individuo = null;
    }
    
    public ProfissionalIndividuo(Individuo individuo) {
        this.type = "profissionalindividuo";
        this.id = 0l;
        this.situacaoTrabalhista = "";
        this.obsSituacaoTrabalhista = "";
        this.tipoTrabalho = "";
        this.obsTipoTrabalho = "";
        this.nomeTrabalho = "";
        this.possuiRenda = "";
        this.renda = 0.00d;
        this.outrasRendas = 0.00d;
        this.tipoBeneficio = "";
        this.doacaoRegular = 0.00d;
        this.aposentadoriaPensao = 0.00d;
        this.seguroDesemprego = 0.00d;
        this.pensaoAlimentar = 0.00d;
        this.outrosBeneficios = 0.00d;
        this.numeroBpcloas = "";
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

    public String getSituacaoTrabalhista() {
        return situacaoTrabalhista;
    }

    public void setSituacaoTrabalhista(String situacaoTrabalhista) {
        this.situacaoTrabalhista = situacaoTrabalhista;
    }

    public String getObsSituacaoTrabalhista() {
        return obsSituacaoTrabalhista;
    }

    public void setObsSituacaoTrabalhista(String obsSituacaoTrabalhista) {
        this.obsSituacaoTrabalhista = obsSituacaoTrabalhista;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public String getObsTipoTrabalho() {
        return obsTipoTrabalho;
    }

    public void setObsTipoTrabalho(String obsTipoTrabalho) {
        this.obsTipoTrabalho = obsTipoTrabalho;
    }

    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

    public String getPossuiRenda() {
        return possuiRenda;
    }

    public void setPossuiRenda(String possuiRenda) {
        this.possuiRenda = possuiRenda;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double getOutrasRendas() {
        return outrasRendas;
    }

    public void setOutrasRendas(double outrasRendas) {
        this.outrasRendas = outrasRendas;
    }

    public String getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(String tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public double getDoacaoRegular() {
        return doacaoRegular;
    }

    public void setDoacaoRegular(double doacaoRegular) {
        this.doacaoRegular = doacaoRegular;
    }

    public double getAposentadoriaPensao() {
        return aposentadoriaPensao;
    }

    public void setAposentadoriaPensao(double aposentadoriaPensao) {
        this.aposentadoriaPensao = aposentadoriaPensao;
    }

    public double getSeguroDesemprego() {
        return seguroDesemprego;
    }

    public void setSeguroDesemprego(double seguroDesemprego) {
        this.seguroDesemprego = seguroDesemprego;
    }

    public double getPensaoAlimentar() {
        return pensaoAlimentar;
    }

    public void setPensaoAlimentar(double pensaoAlimentar) {
        this.pensaoAlimentar = pensaoAlimentar;
    }

    public double getOutrosBeneficios() {
        return outrosBeneficios;
    }

    public void setOutrosBeneficios(double outrosBeneficios) {
        this.outrosBeneficios = outrosBeneficios;
    }

    public String getNumeroBpcloas() {
        return numeroBpcloas;
    }

    public void setNumeroBpcloas(String numeroBpcloas) {
        this.numeroBpcloas = numeroBpcloas;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    
}
