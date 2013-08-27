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
public class ServicoImovel {
    
    private java.lang.String type;
    private long id;
    private long idImovel;
    private java.lang.String existePavimentacao;
    private java.lang.String qualPavimentacao;
    private java.lang.String iluminacaoUtilizada;
    private java.lang.String especifiqueIluminacao;
    private java.lang.String abastecimentoAgua;
    private java.lang.String tratamentoAgua;
    private java.lang.String aguaEncanada;
    private java.lang.String existeBanheiro;
    private java.lang.String escoamentoSanitario;
    private java.lang.String tratamentoLixo;
    private java.lang.String caes;
    private java.lang.String gatos;
    private java.lang.String aves;
    private java.lang.String suinos;
    private java.lang.String insetos;
    private java.lang.String ratos;
    private java.lang.String cobras;
    
    public ServicoImovel() {
        this.type = "servicoimovel";
        this.id = 0l;
        this.idImovel = 0l;
        this.existePavimentacao = "";
        this.qualPavimentacao = "";
        this.iluminacaoUtilizada = "";
        this.especifiqueIluminacao = "";
        this.abastecimentoAgua = "";
        this.tratamentoAgua = "";
        this.aguaEncanada = "";
        this.existeBanheiro = "";
        this.escoamentoSanitario = "";
        this.tratamentoLixo = "";
        this.caes = "";
        this.gatos = "";
        this.aves = "";
        this.suinos = "";
        this.insetos = "";
        this.ratos = "";
        this.cobras = "";
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
    
    public long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(long idImovel) {
        this.idImovel = idImovel;
    }

    public java.lang.String getExistePavimentacao() {
        return existePavimentacao;
    }

    public void setExistePavimentacao(java.lang.String existePavimentacao) {
        this.existePavimentacao = existePavimentacao;
    }
    
    public java.lang.String getQualPavimentacao() {
        return qualPavimentacao;
    }

    public void setQualPavimentacao(java.lang.String qualPavimentacao) {
        this.qualPavimentacao = qualPavimentacao;
    }

    public java.lang.String getIluminacaoUtilizada() {
        return iluminacaoUtilizada;
    }

    public void setIluminacaoUtilizada(java.lang.String iluminacaoUtilizada) {
        this.iluminacaoUtilizada = iluminacaoUtilizada;
    }
    
    public java.lang.String getEspecifiqueIluminacao() {
        return especifiqueIluminacao;
    }

    public void setEspecifiqueIluminacao(java.lang.String especifiqueIluminacao) {
        this.especifiqueIluminacao = especifiqueIluminacao;
    }

    public java.lang.String getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(java.lang.String abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public java.lang.String getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(java.lang.String tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public java.lang.String getAguaEncanada() {
        return aguaEncanada;
    }

    public void setAguaEncanada(java.lang.String aguaEncanada) {
        this.aguaEncanada = aguaEncanada;
    }

    public java.lang.String getExisteBanheiro() {
        return existeBanheiro;
    }

    public void setExisteBanheiro(java.lang.String existeBanheiro) {
        this.existeBanheiro = existeBanheiro;
    }

    public java.lang.String getEscoamentoSanitario() {
        return escoamentoSanitario;
    }

    public void setEscoamentoSanitario(java.lang.String escoamentoSanitario) {
        this.escoamentoSanitario = escoamentoSanitario;
    }

    public java.lang.String getTratamentoLixo() {
        return tratamentoLixo;
    }

    public void setTratamentoLixo(java.lang.String tratamentoLixo) {
        this.tratamentoLixo = tratamentoLixo;
    }

    public java.lang.String getCaes() {
        return caes;
    }

    public void setCaes(java.lang.String caes) {
        this.caes = caes;
    }

    public java.lang.String getGatos() {
        return gatos;
    }

    public void setGatos(java.lang.String gatos) {
        this.gatos = gatos;
    }

    public java.lang.String getAves() {
        return aves;
    }

    public void setAves(java.lang.String aves) {
        this.aves = aves;
    }

    public java.lang.String getSuinos() {
        return suinos;
    }

    public void setSuinos(java.lang.String suinos) {
        this.suinos = suinos;
    }

    public java.lang.String getInsetos() {
        return insetos;
    }

    public void setInsetos(java.lang.String insetos) {
        this.insetos = insetos;
    }

    public java.lang.String getRatos() {
        return ratos;
    }

    public void setRatos(java.lang.String ratos) {
        this.ratos = ratos;
    }

    public java.lang.String getCobras() {
        return cobras;
    }

    public void setCobras(java.lang.String cobras) {
        this.cobras = cobras;
    }
    
}
