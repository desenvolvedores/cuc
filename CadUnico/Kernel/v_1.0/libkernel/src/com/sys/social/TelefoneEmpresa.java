/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.social;

import com.common.Telefone;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class TelefoneEmpresa extends Telefone {
    
    private String type;
    private long idEmpresa;
    
    public TelefoneEmpresa() {
        super();
        this.type = "telefoneempresa";
        this.idEmpresa = 0l;
    }
    
    public String getType() {
        return type;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
}
