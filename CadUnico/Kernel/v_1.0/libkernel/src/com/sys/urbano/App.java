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
public class App {
    
    private String type;
    private long id;
    private String corpoDagua;
    private String brejoCharco;
    private String topoMorro;
    private String encosta;
    private String restinga;
    private String outros;
    private String especifiqueOutros;
    private com.sys.urbano.AspectoAmbiental aspecto;
    
    public App() {
        this.type = "app";
        this.id = 0l;
        this.corpoDagua = "";
        this.brejoCharco = "";
        this.topoMorro = "";
        this.encosta = "";
        this.restinga = "";
        this.outros = "";
        this.especifiqueOutros = "";
        this.aspecto = null;
    }
    
    public App(com.sys.urbano.AspectoAmbiental aspecto) {
        this.type = "app";
        this.id = 0l;
        this.corpoDagua = "";
        this.brejoCharco = "";
        this.topoMorro = "";
        this.encosta = "";
        this.restinga = "";
        this.outros = "";
        this.especifiqueOutros = "";
        this.aspecto = aspecto;
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

    public String getCorpoDagua() {
        return corpoDagua;
    }

    public void setCorpoDagua(String corpoDagua) {
        this.corpoDagua = corpoDagua;
    }

    public String getBrejoCharco() {
        return brejoCharco;
    }

    public void setBrejoCharco(String brejoCharco) {
        this.brejoCharco = brejoCharco;
    }

    public String getTopoMorro() {
        return topoMorro;
    }

    public void setTopoMorro(String topoMorro) {
        this.topoMorro = topoMorro;
    }

    public String getEncosta() {
        return encosta;
    }

    public void setEncosta(String encosta) {
        this.encosta = encosta;
    }

    public String getRestinga() {
        return restinga;
    }

    public void setRestinga(String restinga) {
        this.restinga = restinga;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getEspecifiqueOutros() {
        return especifiqueOutros;
    }

    public void setEspecifiqueOutros(String especifiqueOutros) {
        this.especifiqueOutros = especifiqueOutros;
    }

    public com.sys.urbano.AspectoAmbiental getAspecto() {
        return aspecto;
    }

    public void setAspecto(com.sys.urbano.AspectoAmbiental aspecto) {
        this.aspecto = aspecto;
    }
    
}
