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
public class AcaoNucleo {
    
    private String type;
    private long id;
    private String remanejamento;
    private String reassentamento;
    private String desconstrucao;
    private String melhoriaHabitacional;
    private String fonteMelhoria;
    private String recuperacaoAmbiental;
    private String prad;
    private String adequacaoInfraestrutura;
    private String fonteAdequacao;
    private String outros;
    private String descricaoOutros;
    private Nucleo nucleo;
    private Remanejamento objRemanejamento;
    private Reassentamento objReassentamento;
    private Desconstrucao objDesconstrucao;
    
    public AcaoNucleo() {
        this.type = "acaonucleo";
        this.id = 0l;
        this.remanejamento = "";
        this.reassentamento = "";
        this.desconstrucao = "";
        this.melhoriaHabitacional = "";
        this.fonteMelhoria = "";
        this.recuperacaoAmbiental = "";
        this.prad = "";
        this.adequacaoInfraestrutura = "";
        this.fonteAdequacao = "";
        this.outros = "";
        this.descricaoOutros = "";
        this.nucleo = null;
        this.objRemanejamento = null;
        this.objReassentamento = null;
        this.objDesconstrucao = null;
    }
    
    public AcaoNucleo(Nucleo nucleo) {
        this.type = "acaonucleo";
        this.id = 0l;
        this.remanejamento = "";
        this.reassentamento = "";
        this.desconstrucao = "";
        this.melhoriaHabitacional = "";
        this.fonteMelhoria = "";
        this.recuperacaoAmbiental = "";
        this.prad = "";
        this.adequacaoInfraestrutura = "";
        this.fonteAdequacao = "";
        this.outros = "";
        this.descricaoOutros = "";
        this.nucleo = nucleo;
        this.objRemanejamento = null;
        this.objReassentamento = null;
        this.objDesconstrucao = null;
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
    
    /**
     * @return the remanejamento
     */
    public String getRemanejamento() {
        return remanejamento;
    }

    /**
     * @param remanejamento the remanejamento to set
     */
    public void setRemanejamento(String remanejamento) {
        this.remanejamento = remanejamento;
    }

    /**
     * @return the reassentamento
     */
    public String getReassentamento() {
        return reassentamento;
    }

    /**
     * @param reassentamento the reassentamento to set
     */
    public void setReassentamento(String reassentamento) {
        this.reassentamento = reassentamento;
    }

    /**
     * @return the desconstrucao
     */
    public String getDesconstrucao() {
        return desconstrucao;
    }

    /**
     * @param desconstrucao the desconstrucao to set
     */
    public void setDesconstrucao(String desconstrucao) {
        this.desconstrucao = desconstrucao;
    }

    public String getMelhoriaHabitacional() {
        return melhoriaHabitacional;
    }

    public void setMelhoriaHabitacional(String melhoriaHabitacional) {
        this.melhoriaHabitacional = melhoriaHabitacional;
    }

    public String getFonteMelhoria() {
        return fonteMelhoria;
    }

    public void setFonteMelhoria(String fonteMelhoria) {
        this.fonteMelhoria = fonteMelhoria;
    }

    public String getRecuperacaoAmbiental() {
        return recuperacaoAmbiental;
    }

    public void setRecuperacaoAmbiental(String recuperacaoAmbiental) {
        this.recuperacaoAmbiental = recuperacaoAmbiental;
    }

    public String getPrad() {
        return prad;
    }

    public void setPrad(String prad) {
        this.prad = prad;
    }

    public String getAdequacaoInfraestrutura() {
        return adequacaoInfraestrutura;
    }

    public void setAdequacaoInfraestrutura(String adequacaoInfraestrutura) {
        this.adequacaoInfraestrutura = adequacaoInfraestrutura;
    }

    public String getFonteAdequacao() {
        return fonteAdequacao;
    }

    public void setFonteAdequacao(String fonteAdequacao) {
        this.fonteAdequacao = fonteAdequacao;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getDescricaoOutros() {
        return descricaoOutros;
    }

    public void setDescricaoOutros(String descricaoOutros) {
        this.descricaoOutros = descricaoOutros;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    
    /**
     * @return the Remanejamento
     */
    public Remanejamento getObjRemanejamento() {
        return objRemanejamento;
    }

    /**
     * @param objRemanejamento the Remanejamento to set
     */
    public void setObjRemanejamento(Remanejamento objRemanejamento) {
        this.objRemanejamento = objRemanejamento;
    }
    
    /**
     * @return the Reassentamento
     */
    public Reassentamento getObjReassentamento() {
        return objReassentamento;
    }

    /**
     * @param objReassentamento the Reassentamento to set
     */
    public void setObjReassentamento(Reassentamento objReassentamento) {
        this.objReassentamento = objReassentamento;
    }
    
    /**
     * @return the Desconstrucao
     */
    public Desconstrucao getObjDesconstrucao() {
        return objDesconstrucao;
    }

    /**
     * @param objDesconstrucao the Desconstrucao to set
     */
    public void setObjDesconstrucao(Desconstrucao objDesconstrucao) {
        this.objDesconstrucao = objDesconstrucao;
    }
    
}
