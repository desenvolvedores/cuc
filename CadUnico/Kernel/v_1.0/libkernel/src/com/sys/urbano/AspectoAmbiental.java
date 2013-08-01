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
public class AspectoAmbiental {
    
    private String type;
    private long id;
    private long idNucleo;
    private String areaRisco;
    private String areaVerde;
    private String areaAgricola;
    private String outros;
    private String outrosEspecifique;
    private double latitude;
    private double longitude;
    private App app;
    
    public AspectoAmbiental() {
        
        this.type = "aspectoambiental";
        this.id = 0l;
        this.idNucleo = 0l;
        this.areaRisco = "";
        this.areaVerde = "";
        this.areaAgricola = "";
        this.outros = "";
        this.outrosEspecifique = "";
        this.latitude = 0.00d;
        this.longitude = 0.00d;
        this.app = null;
        
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

    public String getAreaRisco() {
        return areaRisco;
    }

    public void setAreaRisco(String areaRisco) {
        this.areaRisco = areaRisco;
    }

    public String getAreaVerde() {
        return areaVerde;
    }

    public void setAreaVerde(String areaVerde) {
        this.areaVerde = areaVerde;
    }

    public String getAreaAgricola() {
        return areaAgricola;
    }

    public void setAreaAgricola(String areaAgricola) {
        this.areaAgricola = areaAgricola;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }
    
    public String getOutrosEspecifique() {
        return outrosEspecifique;
    }

    public void setOutrosEspecifique(String outrosEspecifique) {
        this.outrosEspecifique = outrosEspecifique;
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
    
    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
    
}
