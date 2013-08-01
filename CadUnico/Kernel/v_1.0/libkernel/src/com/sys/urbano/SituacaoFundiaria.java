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
public class SituacaoFundiaria {
    
    private String type;
    private long id;
    private long idNucleo;
    private String propriedade;
    private String proprietario;
    private String obsPropriedade;
    private String decretoAprovacao;
    private String registrado;
    private String numeroMatricula;
    private double destinacaoAreas;
    private String descDestinacaoAreas;
    private String descZonasSolo;
    private String descEcologicoEconomico;
    private String processosJudiciais;
    private String numeroProcesso;
    private String numeroOrdem;
    private String vara;
    private String existenciaEmbargos;
    private String obsJudiciais;
    
    public SituacaoFundiaria() {
        
        this.type = "situacaofundiaria";
        this.id = 0l;
        this.idNucleo = 0l;
        this.propriedade = "";
        this.proprietario = "";
        this.obsPropriedade = "";
        this.decretoAprovacao = "";
        this.registrado = "";
        this.numeroMatricula = "";
        this.destinacaoAreas = 0.00d;
        this.descDestinacaoAreas = "";
        this.descZonasSolo = "";
        this.descEcologicoEconomico = "";
        this.processosJudiciais = "";
        this.numeroProcesso = "";
        this.numeroOrdem = "";
        this.vara = "";
        this.existenciaEmbargos = "";
        this.obsJudiciais = "";
        
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

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getObsPropriedade() {
        return obsPropriedade;
    }

    public void setObsPropriedade(String obsPropriedade) {
        this.obsPropriedade = obsPropriedade;
    }

    public String getDecretoAprovacao() {
        return decretoAprovacao;
    }

    public void setDecretoAprovacao(String decretoAprovacao) {
        this.decretoAprovacao = decretoAprovacao;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrado) {
        this.registrado = registrado;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public double getDestinacaoAreas() {
        return destinacaoAreas;
    }

    public void setDestinacaoAreas(double destinacaoAreas) {
        this.destinacaoAreas = destinacaoAreas;
    }

    public String getDescDestinacaoAreas() {
        return descDestinacaoAreas;
    }

    public void setDescDestinacaoAreas(String descDestinacaoAreas) {
        this.descDestinacaoAreas = descDestinacaoAreas;
    }

    public String getDescZonasSolo() {
        return descZonasSolo;
    }

    public void setDescZonasSolo(String descZonasSolo) {
        this.descZonasSolo = descZonasSolo;
    }

    public String getDescEcologicoEconomico() {
        return descEcologicoEconomico;
    }

    public void setDescEcologicoEconomico(String descEcologicoEconomico) {
        this.descEcologicoEconomico = descEcologicoEconomico;
    }

    public String getProcessosJudiciais() {
        return processosJudiciais;
    }

    public void setProcessosJudiciais(String processosJudiciais) {
        this.processosJudiciais = processosJudiciais;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(String numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getExistenciaEmbargos() {
        return existenciaEmbargos;
    }

    public void setExistenciaEmbargos(String existenciaEmbargos) {
        this.existenciaEmbargos = existenciaEmbargos;
    }

    public String getObsJudiciais() {
        return obsJudiciais;
    }

    public void setObsJudiciais(String obsJudiciais) {
        this.obsJudiciais = obsJudiciais;
    }
    
}
