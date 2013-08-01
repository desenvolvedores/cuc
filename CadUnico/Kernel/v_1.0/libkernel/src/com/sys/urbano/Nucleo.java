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
public class Nucleo {
    
    private String type;
    private long id;
    private String nome;
    private String origem;
    private String ocupacao;
    private double areaTotal;
    private double areaOcupada;
    private int numeroDomicilios;
    private int populacaoEstimada;
    private String popFonteDados;
    private String popOutrasFontesDados;
    private String rendaPopulacao;
    private String inicioOcupacao;
    private String setorCadastral;
    private String zona;
    private String controleOcupacao;
    private String obsControleOcupacao;
    private String padraoConstrutivo;
    private String transportePublico;
    private String adensamento;
    private String adensFonteDados;
    private String obsAdensamento;
    private String usoIncompativel;
    private com.sys.urbano.InfraestruturaUrbana infraestruturaUrbana;
    private com.sys.urbano.SituacaoFundiaria situacaoFundiaria;
    private com.sys.urbano.AcaoNucleo acaoNucleo;
    private com.sys.urbano.AspectoAmbiental aspectoAmbiental;
    private com.sys.urbano.ProgramaHabitacional programaHabitacional;
    
    public Nucleo() {
        
        this.type = "nucleo";
        this.id = 0l;
        this.nome = "";
        this.origem = "";
        this.ocupacao = "";
        this.areaTotal = 0.00d;
        this.areaOcupada = 0.00d;
        this.numeroDomicilios = 0;
        this.populacaoEstimada = 0;
        this.popFonteDados = "";
        this.popOutrasFontesDados = "";
        this.rendaPopulacao = "";
        this.inicioOcupacao = "";
        this.setorCadastral = "";
        this.zona = "";
        this.controleOcupacao = "";
        this.obsControleOcupacao = "";
        this.padraoConstrutivo = "";
        this.transportePublico = "";
        this.adensamento = "";
        this.adensFonteDados = "";
        this.obsAdensamento = "";
        this.usoIncompativel = "";
        this.infraestruturaUrbana = null;
        this.situacaoFundiaria = null;
        this.acaoNucleo = null;
        this.aspectoAmbiental = null;
        this.programaHabitacional = null;
        
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getAreaOcupada() {
        return areaOcupada;
    }

    public void setAreaOcupada(double areaOcupada) {
        this.areaOcupada = areaOcupada;
    }

    public int getNumeroDomicilios() {
        return numeroDomicilios;
    }

    public void setNumeroDomicilios(int numeroDomicilios) {
        this.numeroDomicilios = numeroDomicilios;
    }

    public int getPopulacaoEstimada() {
        return populacaoEstimada;
    }

    public void setPopulacaoEstimada(int populacaoEstimada) {
        this.populacaoEstimada = populacaoEstimada;
    }

    public String getPopFonteDados() {
        return popFonteDados;
    }

    public void setPopFonteDados(String popFonteDados) {
        this.popFonteDados = popFonteDados;
    }

    public String getPopOutrasFontesDados() {
        return popOutrasFontesDados;
    }

    public void setPopOutrasFontesDados(String popOutrasFontesDados) {
        this.popOutrasFontesDados = popOutrasFontesDados;
    }

    public String getRendaPopulacao() {
        return rendaPopulacao;
    }

    public void setRendaPopulacao(String rendaPopulacao) {
        this.rendaPopulacao = rendaPopulacao;
    }

    public String getInicioOcupacao() {
        return inicioOcupacao;
    }

    public void setInicioOcupacao(String inicioOcupacao) {
        this.inicioOcupacao = inicioOcupacao;
    }

    public String getSetorCadastral() {
        return setorCadastral;
    }

    public void setSetorCadastral(String setorCadastral) {
        this.setorCadastral = setorCadastral;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getControleOcupacao() {
        return controleOcupacao;
    }

    public void setControleOcupacao(String controleOcupacao) {
        this.controleOcupacao = controleOcupacao;
    }

    public String getObsControleOcupacao() {
        return obsControleOcupacao;
    }

    public void setObsControleOcupacao(String obsControleOcupacao) {
        this.obsControleOcupacao = obsControleOcupacao;
    }

    public String getPadraoConstrutivo() {
        return padraoConstrutivo;
    }

    public void setPadraoConstrutivo(String padraoConstrutivo) {
        this.padraoConstrutivo = padraoConstrutivo;
    }

    public String getTransportePublico() {
        return transportePublico;
    }

    public void setTransportePublico(String transportePublico) {
        this.transportePublico = transportePublico;
    }

    public String getAdensamento() {
        return adensamento;
    }

    public void setAdensamento(String adensamento) {
        this.adensamento = adensamento;
    }

    public String getAdensFonteDados() {
        return adensFonteDados;
    }

    public void setAdensFonteDados(String adensFonteDados) {
        this.adensFonteDados = adensFonteDados;
    }

    public String getObsAdensamento() {
        return obsAdensamento;
    }

    public void setObsAdensamento(String obsAdensamento) {
        this.obsAdensamento = obsAdensamento;
    }

    public String getUsoIncompativel() {
        return usoIncompativel;
    }

    public void setUsoIncompativel(String usoIncompativel) {
        this.usoIncompativel = usoIncompativel;
    }
    
    public com.sys.urbano.InfraestruturaUrbana getInfraestruturaUrbana() {
        return infraestruturaUrbana;
    }

    public void setInfraestruturaUrbana(com.sys.urbano.InfraestruturaUrbana infraestruturaUrbana) {
        this.infraestruturaUrbana = infraestruturaUrbana;
    }

    public com.sys.urbano.SituacaoFundiaria getSituacaoFundiaria() {
        return situacaoFundiaria;
    }

    public void setSituacaoFundiaria(com.sys.urbano.SituacaoFundiaria situacaoFundiaria) {
        this.situacaoFundiaria = situacaoFundiaria;
    }

    public com.sys.urbano.AcaoNucleo getAcaoNucleo() {
        return acaoNucleo;
    }

    public void setAcaoNucleo(com.sys.urbano.AcaoNucleo acaoNucleo) {
        this.acaoNucleo = acaoNucleo;
    }

    public com.sys.urbano.AspectoAmbiental getAspectoAmbiental() {
        return aspectoAmbiental;
    }

    public void setAspectoAmbiental(com.sys.urbano.AspectoAmbiental aspectoAmbiental) {
        this.aspectoAmbiental = aspectoAmbiental;
    }

    public com.sys.urbano.ProgramaHabitacional getProgramaHabitacional() {
        return programaHabitacional;
    }

    public void setProgramaHabitacional(com.sys.urbano.ProgramaHabitacional programaHabitacional) {
        this.programaHabitacional = programaHabitacional;
    }
    
}
