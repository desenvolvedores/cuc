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
public class Individuo {
    
    private String type;
    private long id;
    private long idFamilia;
    private String responsavelFamilia;
    private String nome;
    private String apelido;
    private String idade;
    private String sexo;
    private String etnia;
    private String estadoCivil;
    private String nomeMae;
    private String nomePai;
    private String responsavel;
    private String grauParentesco;
    private String observacoes;
    private String quemPrestouInformacao;
    private String cpfInformante;
    private com.sys.social.CertidaoIndividuo nascimento;
    private com.sys.social.DocumentoIndividuo documento;
    private com.sys.social.EscolaridadeIndividuo escolaridade;
    private com.sys.social.ProfissionalIndividuo profissional;
    private com.sys.social.DeficienteIndividuo deficiente;
    private java.util.List<com.common.TelefoneIndividuo> telefones;
    private java.util.List<com.sys.habitacional.Imovel> imoveis;
    
    public Individuo() {
        
        this.type = "individuo";
        this.id = 0l;
        this.idFamilia = 0l;
        this.responsavelFamilia = "";
        this.nome = "";
        this.apelido = "";
        this.idade = "";
        this.sexo = "";
        this.etnia = "";
        this.estadoCivil = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.responsavel = "";
        this.grauParentesco = "";
        this.observacoes = "";
        this.quemPrestouInformacao = "";
        this.cpfInformante = "";
        this.nascimento = null;
        this.documento = null;
        this.escolaridade = null;
        this.profissional = null;
        this.deficiente = null;
        this.telefones = null;
        this.imoveis = null;
        
    }
    
    public Individuo(java.util.List<com.sys.habitacional.Imovel> imoveis) {
        
        this.type = "individuo";
        this.id = 0l;
        this.idFamilia = 0l;
        this.responsavelFamilia = "";
        this.nome = "";
        this.apelido = "";
        this.idade = "";
        this.sexo = "";
        this.etnia = "";
        this.estadoCivil = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.responsavel = "";
        this.grauParentesco = "";
        this.observacoes = "";
        this.quemPrestouInformacao = "";
        this.cpfInformante = "";
        this.nascimento = null;
        this.documento = null;
        this.escolaridade = null;
        this.profissional = null;
        this.deficiente = null;
        this.telefones = null;
        this.imoveis = imoveis;
        
    }
    
    public Individuo(java.util.List<com.sys.habitacional.Imovel> imoveis, java.util.List<com.common.TelefoneIndividuo> telefones) {
        
        this.type = "individuo";
        this.id = 0l;
        this.idFamilia = 0l;
        this.responsavelFamilia = "";
        this.nome = "";
        this.apelido = "";
        this.idade = "";
        this.sexo = "";
        this.etnia = "";
        this.estadoCivil = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.responsavel = "";
        this.grauParentesco = "";
        this.observacoes = "";
        this.quemPrestouInformacao = "";
        this.cpfInformante = "";
        this.nascimento = null;
        this.documento = null;
        this.escolaridade = null;
        this.profissional = null;
        this.deficiente = null;
        this.telefones = telefones;
        this.imoveis = imoveis;
        
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
    
    public long getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(long idFamilia) {
        this.idFamilia = idFamilia;
    }
    
    public String getResponsavelFamilia() {
        return responsavelFamilia;
    }

    public void setResponsavelFamilia(String responsavelFamilia) {
        this.responsavelFamilia = responsavelFamilia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
    
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getQuemPrestouInformacao() {
        return quemPrestouInformacao;
    }

    public void setQuemPrestouInformacao(String quemPrestouInformacao) {
        this.quemPrestouInformacao = quemPrestouInformacao;
    }
    
    public String getCpfInformante() {
        return cpfInformante;
    }

    public void setCpfInformante(String cpfInformante) {
        this.cpfInformante = cpfInformante;
    }
    
    public com.sys.social.CertidaoIndividuo getNascimento() {
        return nascimento;
    }

    public void setNascimento(com.sys.social.CertidaoIndividuo nascimento) {
        this.nascimento = nascimento;
    }

    public com.sys.social.DocumentoIndividuo getDocumento() {
        return documento;
    }

    public void setDocumento(com.sys.social.DocumentoIndividuo documento) {
        this.documento = documento;
    }

    public com.sys.social.EscolaridadeIndividuo getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(com.sys.social.EscolaridadeIndividuo escolaridade) {
        this.escolaridade = escolaridade;
    }

    public com.sys.social.ProfissionalIndividuo getProfissional() {
        return profissional;
    }

    public void setProfissional(com.sys.social.ProfissionalIndividuo profissional) {
        this.profissional = profissional;
    }

    public com.sys.social.DeficienteIndividuo getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(com.sys.social.DeficienteIndividuo deficiente) {
        this.deficiente = deficiente;
    }

    public java.util.List<com.common.TelefoneIndividuo> getTelefones() {
        return telefones;
    }

    public void setTelefones(java.util.List<com.common.TelefoneIndividuo> telefones) {
        this.telefones = telefones;
    }

    public java.util.List<com.sys.habitacional.Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(java.util.List<com.sys.habitacional.Imovel> imoveis) {
        this.imoveis = imoveis;
    }
    
}
