/*
 * Classe pertencente a API de acesso à sistemas "libaccess".
 */
package com.access;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class Permissao {
    
    private String type;
    private int id;
    private String nome;
    private String descricao;
    private boolean permitido;
    
    public Permissao() {
        this.type = "permissao";
        this.id = 0;
        this.nome = "";
        this.permitido = false;
    }
    
    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }
    
}
