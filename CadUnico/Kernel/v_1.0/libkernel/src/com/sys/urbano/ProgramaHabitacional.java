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
public class ProgramaHabitacional {
    
    private String type;
    private long id;
    private String materialConstrucao;
    private String producaoMoradias;
    private String assistenciaTecnica;
    private String urbAssentamentosPrecarios;
    private String complemInfraestrutura;
    private String regularizacaoFundiaria;
    private String cdhu;
    private String pmcmv;
    private Nucleo nucleo;
    
    public ProgramaHabitacional() {
        this.type = "programahabitacional";
        this.id = 0l;
        this.materialConstrucao = "";
        this.producaoMoradias = "";
        this.assistenciaTecnica = "";
        this.urbAssentamentosPrecarios = "";
        this.complemInfraestrutura = "";
        this.regularizacaoFundiaria = "";
        this.cdhu = "";
        this.pmcmv = "";
        this.nucleo = null;
    }
    
    public ProgramaHabitacional(Nucleo nucleo) {
        this.type = "programahabitacional";
        this.id = 0l;
        this.materialConstrucao = "";
        this.producaoMoradias = "";
        this.assistenciaTecnica = "";
        this.urbAssentamentosPrecarios = "";
        this.complemInfraestrutura = "";
        this.regularizacaoFundiaria = "";
        this.cdhu = "";
        this.pmcmv = "";
        this.nucleo = nucleo;
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

    public String getMaterialConstrucao() {
        return materialConstrucao;
    }

    public void setMaterialConstrucao(String materialConstrucao) {
        this.materialConstrucao = materialConstrucao;
    }

    public String getProducaoMoradias() {
        return producaoMoradias;
    }

    public void setProducaoMoradias(String producaoMoradias) {
        this.producaoMoradias = producaoMoradias;
    }

    public String getAssistenciaTecnica() {
        return assistenciaTecnica;
    }

    public void setAssistenciaTecnica(String assistenciaTecnica) {
        this.assistenciaTecnica = assistenciaTecnica;
    }

    public String getUrbAssentamentosPrecarios() {
        return urbAssentamentosPrecarios;
    }

    public void setUrbAssentamentosPrecarios(String urbAssentamentosPrecarios) {
        this.urbAssentamentosPrecarios = urbAssentamentosPrecarios;
    }

    public String getComplemInfraestrutura() {
        return complemInfraestrutura;
    }

    public void setComplemInfraestrutura(String complemInfraestrutura) {
        this.complemInfraestrutura = complemInfraestrutura;
    }

    public String getRegularizacaoFundiaria() {
        return regularizacaoFundiaria;
    }

    public void setRegularizacaoFundiaria(String regularizacaoFundiaria) {
        this.regularizacaoFundiaria = regularizacaoFundiaria;
    }

    public String getCdhu() {
        return cdhu;
    }

    public void setCdhu(String cdhu) {
        this.cdhu = cdhu;
    }

    public String getPmcmv() {
        return pmcmv;
    }

    public void setPmcmv(String pmcmv) {
        this.pmcmv = pmcmv;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    
}
