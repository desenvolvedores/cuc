/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.habitacional;

import com.common.Endereco;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EnderecoImovel extends Endereco {
    
    private java.lang.String type;
    private long idImovel;
    private java.lang.String tipoArea;
    
    public EnderecoImovel() {
        super();
        this.type = "enderecoimovel";
        this.idImovel = 0l;
        this.tipoArea = "";
    }
    
    public java.lang.String getType() {
        return type;
    }

    public long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(long idImovel) {
        this.idImovel = idImovel;
    }

    public java.lang.String getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(java.lang.String tipoArea) {
        this.tipoArea = tipoArea;
    }
    
}
