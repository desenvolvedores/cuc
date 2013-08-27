/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.habitacional;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class Imovel {
    
    private java.lang.String type;
    private long id;
    private long idNucleo;
    private java.lang.String tipo;
    private double valorAluguel;
    private java.lang.String tipoPropriedade;
    private java.lang.String docPropriedade;
    private java.lang.String numDocPropriedade;
    private java.lang.String localidade;
    private java.lang.String pagaIPTU;
    private java.lang.String ic;
    private java.lang.String selagem;
    private java.lang.String atendente;
    private java.lang.String atendenteAtualizacao;
    private java.lang.String dataAtualizacao;
    private com.sys.habitacional.ComposicaoImovel composicao;
    private com.sys.habitacional.EnderecoImovel endereco;
    private com.sys.habitacional.ServicoImovel servico;
    private com.sys.habitacional.DemolicaoImovel demolicao;
    private java.util.List<com.sys.social.Individuo> individuos;
    private java.util.List<com.sys.social.Empresa> empresas;
    
    public Imovel() {
        this.type = "imovel";
        this.id = 0l;
        this.idNucleo = 0l;
        this.tipo = "";
        this.valorAluguel = 0.00d;
        this.tipoPropriedade = "";
        this.docPropriedade = "";
        this.numDocPropriedade = "";
        this.localidade = "";
        this.pagaIPTU = "";
        this.ic = "";
        this.selagem = "";
        this.atendente = "";
        this.atendenteAtualizacao = "";
        this.dataAtualizacao = "";
        this.composicao = null;
        this.endereco = null;
        this.servico = null;
        this.demolicao = null;
        this.individuos = null;
        this.empresas = null;
    }
    
    public java.lang.String getType() {
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

    public java.lang.String getTipo() {
        return tipo;
    }

    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public java.lang.String getTipoPropriedade() {
        return tipoPropriedade;
    }

    public void setTipoPropriedade(java.lang.String tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }

    public java.lang.String getDocPropriedade() {
        return docPropriedade;
    }

    public void setDocPropriedade(java.lang.String docPropriedade) {
        this.docPropriedade = docPropriedade;
    }

    public java.lang.String getNumDocPropriedade() {
        return numDocPropriedade;
    }

    public void setNumDocPropriedade(java.lang.String numDocPropriedade) {
        this.numDocPropriedade = numDocPropriedade;
    }

    public java.lang.String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(java.lang.String localidade) {
        this.localidade = localidade;
    }

    public java.lang.String getPagaIPTU() {
        return pagaIPTU;
    }

    public void setPagaIPTU(java.lang.String pagaIPTU) {
        this.pagaIPTU = pagaIPTU;
    }

    public java.lang.String getIc() {
        return ic;
    }

    public void setIc(java.lang.String ic) {
        this.ic = ic;
    }
    
    public java.lang.String getSelagem() {
        return selagem;
    }

    public void setSelagem(java.lang.String selagem) {
        this.selagem = selagem;
    }
    
    public java.lang.String getAtendente() {
        return atendente;
    }

    public void setAtendente(java.lang.String atendente) {
        this.atendente = atendente;
    }

    public java.lang.String getAtendenteAtualizacao() {
        return atendenteAtualizacao;
    }

    public void setAtendenteAtualizacao(java.lang.String atendenteAtualizacao) {
        this.atendenteAtualizacao = atendenteAtualizacao;
    }

    public java.lang.String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(java.lang.String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    public com.sys.habitacional.ComposicaoImovel getComposicao() {
        return composicao;
    }

    public void setComposicao(com.sys.habitacional.ComposicaoImovel composicao) {
        this.composicao = composicao;
    }
    
    public com.sys.habitacional.EnderecoImovel getEndereco() {
        return endereco;
    }

    public void setEndereco(com.sys.habitacional.EnderecoImovel endereco) {
        this.endereco = endereco;
    }

    public com.sys.habitacional.ServicoImovel getServico() {
        return servico;
    }

    public void setServico(com.sys.habitacional.ServicoImovel servico) {
        this.servico = servico;
    }

    public com.sys.habitacional.DemolicaoImovel getDemolicao() {
        return demolicao;
    }

    public void setDemolicao(com.sys.habitacional.DemolicaoImovel demolicao) {
        this.demolicao = demolicao;
    }

    public java.util.List<com.sys.social.Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(java.util.List<com.sys.social.Individuo> individuos) {
        this.individuos = individuos;
    }

    public java.util.List<com.sys.social.Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(java.util.List<com.sys.social.Empresa> empresas) {
        this.empresas = empresas;
    }
    
}
