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
public class AreaRisco {
    
    private String type;
    private long id;
    private String codigoSetor;
    private String grauRisco;
    private String vegetacao;
    private String processoInstabilizacao;
    private String condicoesSolo;
    private String existePavimentacao;
    private String obsPavimentacao;
    private double latitude;
    private double longitude;
    private AspectoAmbiental aspectoAmbiental;
    
    public AreaRisco() {
        this.type = "arearisco";
        this.id = 0l;
        this.codigoSetor = "";
        this.grauRisco = "";
        this.vegetacao = "";
        this.processoInstabilizacao = "";
        this.condicoesSolo = "";
        this.existePavimentacao = "";
        this.obsPavimentacao = "";
        this.latitude = 0.00d;
        this.longitude = 0.00d;
        this.aspectoAmbiental = null;
    }
    
    public AreaRisco(AspectoAmbiental aspectoAmbiental) {
        this.type = "arearisco";
        this.id = 0l;
        this.codigoSetor = "";
        this.grauRisco = "";
        this.vegetacao = "";
        this.processoInstabilizacao = "";
        this.condicoesSolo = "";
        this.existePavimentacao = "";
        this.obsPavimentacao = "";
        this.latitude = 0.00d;
        this.longitude = 0.00d;
        this.aspectoAmbiental = aspectoAmbiental;
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

    public String getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(String codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public String getGrauRisco() {
        return grauRisco;
    }

    public void setGrauRisco(String grauRisco) {
        this.grauRisco = grauRisco;
    }

    public String getVegetacao() {
        return vegetacao;
    }

    public void setVegetacao(String vegetacao) {
        this.vegetacao = vegetacao;
    }

    public String getProcessoInstabilizacao() {
        return processoInstabilizacao;
    }

    public void setProcessoInstabilizacao(String processoInstabilizacao) {
        this.processoInstabilizacao = processoInstabilizacao;
    }

    public String getCondicoesSolo() {
        return condicoesSolo;
    }

    public void setCondicoesSolo(String condicoesSolo) {
        this.condicoesSolo = condicoesSolo;
    }

    public String getExistePavimentacao() {
        return existePavimentacao;
    }

    public void setExistePavimentacao(String existePavimentacao) {
        this.existePavimentacao = existePavimentacao;
    }

    public String getObsPavimentacao() {
        return obsPavimentacao;
    }

    public void setObsPavimentacao(String obsPavimentacao) {
        this.obsPavimentacao = obsPavimentacao;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public AspectoAmbiental getAspectoAmbiental() {
        return aspectoAmbiental;
    }

    public void setAspectoAmbiental(AspectoAmbiental aspectoAmbiental) {
        this.aspectoAmbiental = aspectoAmbiental;
    }
    
}
