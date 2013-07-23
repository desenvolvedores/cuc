/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.common;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EnderecoImovel extends Endereco {
    
    private String type;
    private String tipoArea;
    private com.sys.habitacional.Imovel imovel;
    
    public EnderecoImovel() {
        super();
        this.type = "enderecoimovel";
        this.tipoArea = "";
        this.imovel = null;
    }
    
    public EnderecoImovel(com.sys.habitacional.Imovel imovel) {
        super();
        this.type = "enderecoimovel";
        this.tipoArea = "";
        this.imovel = imovel;
    }
    
    public String getType() {
        return type;
    }

    public com.sys.habitacional.Imovel getImovel() {
        return imovel;
    }

    public void setImovel(com.sys.habitacional.Imovel imovel) {
        this.imovel = imovel;
    }

    public String getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(String tipoArea) {
        this.tipoArea = tipoArea;
    }
    
}
