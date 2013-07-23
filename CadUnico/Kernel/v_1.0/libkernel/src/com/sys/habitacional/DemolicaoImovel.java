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
public class DemolicaoImovel {
    
    private String type;
    private long id;
    private java.util.Date dataDemolicao;
    private String horarioDemolicao;
    private String numeroProcesso;
    private String motivo;
    private String executadoPor;
    private Imovel imovel;
    
    public DemolicaoImovel() {
        this.type = "demolicaoimovel";
        this.id = 0l;
        this.dataDemolicao = null;
        this.horarioDemolicao = "";
        this.numeroProcesso = "";
        this.motivo = "";
        this.executadoPor = "";
        this.imovel = null;
    }
    
    public DemolicaoImovel(Imovel imovel) {
        this.type = "demolicaoimovel";
        this.id = 0l;
        this.dataDemolicao = null;
        this.horarioDemolicao = "";
        this.numeroProcesso = "";
        this.motivo = "";
        this.executadoPor = "";
        this.imovel = imovel;
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

    public java.util.Date getDataDemolicao() {
        return dataDemolicao;
    }

    public void setDataDemolicao(java.util.Date dataDemolicao) {
        this.dataDemolicao = dataDemolicao;
    }

    public String getHorarioDemolicao() {
        return horarioDemolicao;
    }

    public void setHorarioDemolicao(String horarioDemolicao) {
        this.horarioDemolicao = horarioDemolicao;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getExecutadoPor() {
        return executadoPor;
    }

    public void setExecutadoPor(String executadoPor) {
        this.executadoPor = executadoPor;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
}
