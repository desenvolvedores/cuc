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
    
    private java.lang.String type;
    private long id;
    private long idImovel;
    private java.lang.String dataDemolicao;
    private java.lang.String horarioDemolicao;
    private java.lang.String numeroProcesso;
    private java.lang.String motivo;
    private java.lang.String executadoPor;
    
    public DemolicaoImovel() {
        this.type = "demolicaoimovel";
        this.id = 0l;
        this.idImovel = 0l;
        this.dataDemolicao = "";
        this.horarioDemolicao = "";
        this.numeroProcesso = "";
        this.motivo = "";
        this.executadoPor = "";
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

    public java.lang.String getDataDemolicao() {
        return dataDemolicao;
    }

    public void setDataDemolicao(java.lang.String dataDemolicao) {
        this.dataDemolicao = dataDemolicao;
    }

    public java.lang.String getHorarioDemolicao() {
        return horarioDemolicao;
    }

    public void setHorarioDemolicao(java.lang.String horarioDemolicao) {
        this.horarioDemolicao = horarioDemolicao;
    }

    public java.lang.String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(java.lang.String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public java.lang.String getMotivo() {
        return motivo;
    }

    public void setMotivo(java.lang.String motivo) {
        this.motivo = motivo;
    }

    public java.lang.String getExecutadoPor() {
        return executadoPor;
    }

    public void setExecutadoPor(java.lang.String executadoPor) {
        this.executadoPor = executadoPor;
    }
    
}
