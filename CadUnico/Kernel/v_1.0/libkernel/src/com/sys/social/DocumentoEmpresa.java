/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.social;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DocumentoEmpresa extends com.common.Documento {
    
    private String type;
    private Empresa empresa;
    
    public DocumentoEmpresa() {
        super();
        this.type = "documentoempresa";
        this.empresa = null;
    }
    
    public DocumentoEmpresa(Empresa empresa) {
        super();
        this.type = "documentoempresa";
        this.empresa = empresa;
    }
    
    public String getType() {
        return type;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
