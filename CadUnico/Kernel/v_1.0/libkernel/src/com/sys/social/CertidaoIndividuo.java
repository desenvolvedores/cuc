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
public class CertidaoIndividuo {
    
    private String type;
    private long id;
    private java.util.Date dataNascimento;
    private String ondeNasceu;
    private String naturalidade;
    private String nascimentoRegistrado;
    private String codigoCartorio;
    private String nomeCartorio;
    private String tipoCertidao;
    private java.util.Date dataRegCertidao;
    private String municipioCertidao;
    private String ufCertidao;
    private String numeroTermo;
    private String numeroLivro;
    private String numeroFolha;
    private Individuo individuo;
    
    public CertidaoIndividuo() {
        this.type = "certidaoindividuo";
        this.id = 0l;
        this.dataNascimento = null;
        this.ondeNasceu = "";
        this.naturalidade = "";
        this.nascimentoRegistrado = "";
        this.codigoCartorio = "";
        this.nomeCartorio = "";
        this.tipoCertidao = "";
        this.dataRegCertidao = null;
        this.municipioCertidao = "";
        this.ufCertidao = "";
        this.numeroTermo = "";
        this.numeroLivro = "";
        this.numeroFolha = "";
        this.individuo = null;
    }
    
    public CertidaoIndividuo(Individuo individuo) {
        this.type = "certidaoindividuo";
        this.id = 0l;
        this.dataNascimento = null;
        this.ondeNasceu = "";
        this.naturalidade = "";
        this.nascimentoRegistrado = "";
        this.codigoCartorio = "";
        this.nomeCartorio = "";
        this.tipoCertidao = "";
        this.dataRegCertidao = null;
        this.municipioCertidao = "";
        this.ufCertidao = "";
        this.numeroTermo = "";
        this.numeroLivro = "";
        this.numeroFolha = "";
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

    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.util.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getOndeNasceu() {
        return ondeNasceu;
    }

    public void setOndeNasceu(String ondeNasceu) {
        this.ondeNasceu = ondeNasceu;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNascimentoRegistrado() {
        return nascimentoRegistrado;
    }

    public void setNascimentoRegistrado(String nascimentoRegistrado) {
        this.nascimentoRegistrado = nascimentoRegistrado;
    }

    public String getCodigoCartorio() {
        return codigoCartorio;
    }

    public void setCodigoCartorio(String codigoCartorio) {
        this.codigoCartorio = codigoCartorio;
    }

    public String getNomeCartorio() {
        return nomeCartorio;
    }

    public void setNomeCartorio(String nomeCartorio) {
        this.nomeCartorio = nomeCartorio;
    }

    public String getTipoCertidao() {
        return tipoCertidao;
    }

    public void setTipoCertidao(String tipoCertidao) {
        this.tipoCertidao = tipoCertidao;
    }

    public java.util.Date getDataRegCertidao() {
        return dataRegCertidao;
    }

    public void setDataRegCertidao(java.util.Date dataRegCertidao) {
        this.dataRegCertidao = dataRegCertidao;
    }

    public String getMunicipioCertidao() {
        return municipioCertidao;
    }

    public void setMunicipioCertidao(String municipioCertidao) {
        this.municipioCertidao = municipioCertidao;
    }

    public String getUfCertidao() {
        return ufCertidao;
    }

    public void setUfCertidao(String ufCertidao) {
        this.ufCertidao = ufCertidao;
    }

    public String getNumeroTermo() {
        return numeroTermo;
    }

    public void setNumeroTermo(String numeroTermo) {
        this.numeroTermo = numeroTermo;
    }

    public String getNumeroLivro() {
        return numeroLivro;
    }

    public void setNumeroLivro(String numeroLivro) {
        this.numeroLivro = numeroLivro;
    }

    public String getNumeroFolha() {
        return numeroFolha;
    }

    public void setNumeroFolha(String numeroFolha) {
        this.numeroFolha = numeroFolha;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    
}
