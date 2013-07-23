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
public class DeficienteIndividuo {
    
    private String type;
    private long id;
    private String deficiente;
    private String deficienciaFisica;
    private String deficienciaMental;
    private String transtornoMental;
    private String sindromeDown;
    private String cegueira;
    private String baixaVisao;
    private String surdezSevera;
    private String surdezModerada;
    private String obsTipoDeficiencia;
    private String causaDeficiencia;
    private String obsCausaDeficiencia;
    private String quandoAdquiriu;
    private String cuidadosFamilia;
    private String cuidadosEspecializado;
    private String cuidadosVizinho;
    private String cuidadosInstituicao;
    private String cuidadosOutros;
    private String cadastroSepedi;
    private Individuo individuo;
    
    public DeficienteIndividuo() {
        this.type = "deficienteindividuo";
        this.id = 0l;
        this.deficiente = "";
        this.deficienciaFisica = "";
        this.deficienciaMental = "";
        this.transtornoMental = "";
        this.sindromeDown = "";
        this.cegueira = "";
        this.baixaVisao = "";
        this.surdezSevera = "";
        this.surdezModerada = "";
        this.obsTipoDeficiencia = "";
        this.causaDeficiencia = "";
        this.obsCausaDeficiencia = "";
        this.quandoAdquiriu = "";
        this.cuidadosFamilia = "";
        this.cuidadosEspecializado = "";
        this.cuidadosVizinho = "";
        this.cuidadosInstituicao = "";
        this.cuidadosOutros = "";
        this.cadastroSepedi = "";
        this.individuo = null;
    }
    
    public DeficienteIndividuo(Individuo individuo) {
        this.type = "deficienteindividuo";
        this.id = 0l;
        this.deficiente = "";
        this.deficienciaFisica = "";
        this.deficienciaMental = "";
        this.transtornoMental = "";
        this.sindromeDown = "";
        this.cegueira = "";
        this.baixaVisao = "";
        this.surdezSevera = "";
        this.surdezModerada = "";
        this.obsTipoDeficiencia = "";
        this.causaDeficiencia = "";
        this.obsCausaDeficiencia = "";
        this.quandoAdquiriu = "";
        this.cuidadosFamilia = "";
        this.cuidadosEspecializado = "";
        this.cuidadosVizinho = "";
        this.cuidadosInstituicao = "";
        this.cuidadosOutros = "";
        this.cadastroSepedi = "";
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

    public String getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(String deficiente) {
        this.deficiente = deficiente;
    }

    public String getDeficienciaFisica() {
        return deficienciaFisica;
    }

    public void setDeficienciaFisica(String deficienciaFisica) {
        this.deficienciaFisica = deficienciaFisica;
    }

    public String getDeficienciaMental() {
        return deficienciaMental;
    }

    public void setDeficienciaMental(String deficienciaMental) {
        this.deficienciaMental = deficienciaMental;
    }

    public String getTranstornoMental() {
        return transtornoMental;
    }

    public void setTranstornoMental(String transtornoMental) {
        this.transtornoMental = transtornoMental;
    }

    public String getSindromeDown() {
        return sindromeDown;
    }

    public void setSindromeDown(String sindromeDown) {
        this.sindromeDown = sindromeDown;
    }

    public String getCegueira() {
        return cegueira;
    }

    public void setCegueira(String cegueira) {
        this.cegueira = cegueira;
    }

    public String getBaixaVisao() {
        return baixaVisao;
    }

    public void setBaixaVisao(String baixaVisao) {
        this.baixaVisao = baixaVisao;
    }

    public String getSurdezSevera() {
        return surdezSevera;
    }

    public void setSurdezSevera(String surdezSevera) {
        this.surdezSevera = surdezSevera;
    }

    public String getSurdezModerada() {
        return surdezModerada;
    }

    public void setSurdezModerada(String surdezModerada) {
        this.surdezModerada = surdezModerada;
    }

    public String getObsTipoDeficiencia() {
        return obsTipoDeficiencia;
    }

    public void setObsTipoDeficiencia(String obsTipoDeficiencia) {
        this.obsTipoDeficiencia = obsTipoDeficiencia;
    }

    public String getCausaDeficiencia() {
        return causaDeficiencia;
    }

    public void setCausaDeficiencia(String causaDeficiencia) {
        this.causaDeficiencia = causaDeficiencia;
    }

    public String getObsCausaDeficiencia() {
        return obsCausaDeficiencia;
    }

    public void setObsCausaDeficiencia(String obsCausaDeficiencia) {
        this.obsCausaDeficiencia = obsCausaDeficiencia;
    }

    public String getQuandoAdquiriu() {
        return quandoAdquiriu;
    }

    public void setQuandoAdquiriu(String quandoAdquiriu) {
        this.quandoAdquiriu = quandoAdquiriu;
    }

    public String getCuidadosFamilia() {
        return cuidadosFamilia;
    }

    public void setCuidadosFamilia(String cuidadosFamilia) {
        this.cuidadosFamilia = cuidadosFamilia;
    }

    public String getCuidadosEspecializado() {
        return cuidadosEspecializado;
    }

    public void setCuidadosEspecializado(String cuidadosEspecializado) {
        this.cuidadosEspecializado = cuidadosEspecializado;
    }

    public String getCuidadosVizinho() {
        return cuidadosVizinho;
    }

    public void setCuidadosVizinho(String cuidadosVizinho) {
        this.cuidadosVizinho = cuidadosVizinho;
    }

    public String getCuidadosInstituicao() {
        return cuidadosInstituicao;
    }

    public void setCuidadosInstituicao(String cuidadosInstituicao) {
        this.cuidadosInstituicao = cuidadosInstituicao;
    }

    public String getCuidadosOutros() {
        return cuidadosOutros;
    }

    public void setCuidadosOutros(String cuidadosOutros) {
        this.cuidadosOutros = cuidadosOutros;
    }

    public String getCadastroSepedi() {
        return cadastroSepedi;
    }

    public void setCadastroSepedi(String cadastroSepedi) {
        this.cadastroSepedi = cadastroSepedi;
    }

    public Individuo getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    
}
