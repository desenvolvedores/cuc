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
    
    private String type;
    private long id;
    private long idNucleo;
    private String tipo;
    private String situacao;
    private double valorAluguel;
    private String tipoPropriedade;
    private String docPropriedade;
    private String numDocPropriedade;
    private String construcao;
    private String localidade;
    private String pagaIPTU;
    private String ic;
    private String selagem;
    private String atendente;
    private String atendenteAtualizacao;
    private java.util.Date dataAtualizacao;
    private com.sys.habitacional.ComposicaoImovel composicao;
    private com.sys.habitacional.ServicoImovel servico;
    private com.sys.habitacional.DemolicaoImovel demolicao;
    private com.sys.urbano.Nucleo nucleo;
    private java.util.List<com.sys.social.Individuo> individuos;
    private java.util.List<com.sys.social.Empresa> empresas;
    
    public Imovel() {
        this.type = "imovel";
        this.id = 0l;
        this.idNucleo = 0l;
        this.tipo = "";
        this.situacao = "";
        this.valorAluguel = 0.00d;
        this.tipoPropriedade = "";
        this.docPropriedade = "";
        this.numDocPropriedade = "";
        this.construcao = "";
        this.localidade = "";
        this.pagaIPTU = "";
        this.ic = "";
        this.selagem = "";
        this.atendente = "";
        this.atendenteAtualizacao = "";
        this.dataAtualizacao = null;
        this.composicao = null;
        this.servico = null;
        this.demolicao = null;
        this.nucleo = null;
        this.individuos = null;
        this.empresas = null;
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

    public long getIdNucleo() {
        return idNucleo;
    }

    public void setIdNucleo(long idNucleo) {
        this.idNucleo = idNucleo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getTipoPropriedade() {
        return tipoPropriedade;
    }

    public void setTipoPropriedade(String tipoPropriedade) {
        this.tipoPropriedade = tipoPropriedade;
    }

    public String getDocPropriedade() {
        return docPropriedade;
    }

    public void setDocPropriedade(String docPropriedade) {
        this.docPropriedade = docPropriedade;
    }

    public String getNumDocPropriedade() {
        return numDocPropriedade;
    }

    public void setNumDocPropriedade(String numDocPropriedade) {
        this.numDocPropriedade = numDocPropriedade;
    }

    public String getConstrucao() {
        return construcao;
    }

    public void setConstrucao(String construcao) {
        this.construcao = construcao;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getPagaIPTU() {
        return pagaIPTU;
    }

    public void setPagaIPTU(String pagaIPTU) {
        this.pagaIPTU = pagaIPTU;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }
    
    public String getSelagem() {
        return selagem;
    }

    public void setSelagem(String selagem) {
        this.selagem = selagem;
    }
    
    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
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
    
    public com.sys.habitacional.ComposicaoImovel getComposicao() {
        return composicao;
    }

    public void setComposicao(com.sys.habitacional.ComposicaoImovel composicao) {
        this.composicao = composicao;
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

    public com.sys.urbano.Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(com.sys.urbano.Nucleo nucleo) {
        this.nucleo = nucleo;
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
