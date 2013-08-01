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
public class InfraestruturaUrbana {
    
    private String type;
    private long id;
    private long idNucleo;
    private String abastecimentoAgua;
    private String coletaEsgoto;
    private String servicosLimpeza;
    private String aguasPluviaisSuperficial;
    private String aguasPluviaisRede;
    private String energiaEletrica;
    private String iluminacaoPublica;
    
    public InfraestruturaUrbana() {
        
        this.type = "infraestruturaurbana";
        this.id = 0l;
        this.idNucleo = 0l;
        this.abastecimentoAgua = "";
        this.coletaEsgoto = "";
        this.servicosLimpeza = "";
        this.aguasPluviaisSuperficial = "";
        this.aguasPluviaisRede = "";
        this.energiaEletrica = "";
        this.iluminacaoPublica = "";

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

    public String getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(String abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public String getColetaEsgoto() {
        return coletaEsgoto;
    }

    public void setColetaEsgoto(String coletaEsgoto) {
        this.coletaEsgoto = coletaEsgoto;
    }

    public String getServicosLimpeza() {
        return servicosLimpeza;
    }

    public void setServicosLimpeza(String servicosLimpeza) {
        this.servicosLimpeza = servicosLimpeza;
    }

    public String getAguasPluviaisSuperficial() {
        return aguasPluviaisSuperficial;
    }

    public void setAguasPluviaisSuperficial(String aguasPluviaisSuperficial) {
        this.aguasPluviaisSuperficial = aguasPluviaisSuperficial;
    }

    public String getAguasPluviaisRede() {
        return aguasPluviaisRede;
    }

    public void setAguasPluviaisRede(String aguasPluviaisRede) {
        this.aguasPluviaisRede = aguasPluviaisRede;
    }

    public String getEnergiaEletrica() {
        return energiaEletrica;
    }

    public void setEnergiaEletrica(String energiaEletrica) {
        this.energiaEletrica = energiaEletrica;
    }

    public String getIluminacaoPublica() {
        return iluminacaoPublica;
    }

    public void setIluminacaoPublica(String iluminacaoPublica) {
        this.iluminacaoPublica = iluminacaoPublica;
    }
    
}
