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
public class Telefone {
    
    protected long id;
    protected String numero;
    protected String tipo;
    
    public Telefone() {
        this.id = 0l;
        this.numero = "";
        this.tipo = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
