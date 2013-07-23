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
public class GrupoUsuario {
    
    private String type;
    private int id;
    private String nome;
    private String descricao;
    private String ativo;
    private java.util.List<Permissao> permissoes;
    
    public GrupoUsuario() {
        this.type = "grupousuario";
        this.id = 0;
        this.nome = "";
        this.descricao = "";
        this.ativo = "";
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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public java.util.List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(java.util.List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
}
