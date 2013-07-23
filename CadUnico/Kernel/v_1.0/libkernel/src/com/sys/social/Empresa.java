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
public class Empresa {
    
    private String type;
    private long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String fundador;
    private java.util.Date dataFundacao;
    private String localOrigem;
    private com.sys.social.DocumentoEmpresa documento;
    private java.util.List<com.sys.habitacional.Imovel> imoveis;
    
    public Empresa() {
        this.type = "empresa";
        this.id = 0l;
        this.razaoSocial = "";
        this.nomeFantasia = "";
        this.fundador = "";
        this.dataFundacao = null;
        this.localOrigem = "";
        this.documento = null;
        this.imoveis = null;
    }
    
    public Empresa(java.util.List<com.sys.habitacional.Imovel> imoveis) {
        this.type = "empresa";
        this.id = 0l;
        this.razaoSocial = "";
        this.nomeFantasia = "";
        this.fundador = "";
        this.dataFundacao = null;
        this.localOrigem = "";
        this.documento = null;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public java.util.Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(java.util.Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }
    
    public com.sys.social.DocumentoEmpresa getDocumento() {
        return documento;
    }

    public void setDocumento(com.sys.social.DocumentoEmpresa documento) {
        this.documento = documento;
    }

    public java.util.List<com.sys.habitacional.Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(java.util.List<com.sys.habitacional.Imovel> imoveis) {
        this.imoveis = imoveis;
    }
    
}
