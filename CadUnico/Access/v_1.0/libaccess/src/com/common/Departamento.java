/*
 * Classe pertencente a API de acesso à sistemas "libaccess".
 */
package com.common;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class Departamento {
    
    private String type;
    private int id;
    private String sigla;
    private String nome;
    private String descricao;
    private String ativo;
    
    public Departamento() {
        this.type = "departamento";
        this.id = 0;
        this.sigla = "";
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
    
}
