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
public class Usuario {
    
    private String type;
    private int id;
    private String usuario;
    private String senha;
    private String foto;
    private String nome;
    private String email;
    private String ativo;
    private String token;
    private String userKey;
    private GrupoUsuario grupo;
    private com.common.Departamento departamento;
    
    public Usuario() {
        this.type = "usuario";
        this.id = 0;
        this.usuario = "";
        this.senha = "";
        this.foto = "";
        this.nome = "";
        this.email = "";
        this.ativo = "";
        this.token = "";
        this.userKey = "";
        this.grupo = null;
        this.departamento = null;
    }
    
    public Usuario(GrupoUsuario grupo) {
        this.type = "usuario";
        this.id = 0;
        this.usuario = "";
        this.senha = "";
        this.foto = "";
        this.nome = "";
        this.email = "";
        this.ativo = "";
        this.token = "";
        this.userKey = "";
        this.grupo = grupo;
        this.departamento = null;
    }
    
    public Usuario(com.common.Departamento departamento) {
        this.type = "usuario";
        this.id = 0;
        this.usuario = "";
        this.senha = "";
        this.foto = "";
        this.nome = "";
        this.email = "";
        this.ativo = "";
        this.token = "";
        this.userKey = "";
        this.grupo = null;
        this.departamento = departamento;
    }
    
    public Usuario(GrupoUsuario grupo, com.common.Departamento departamento) {
        this.type = "usuario";
        this.id = 0;
        this.usuario = "";
        this.senha = "";
        this.foto = "";
        this.nome = "";
        this.email = "";
        this.ativo = "";
        this.token = "";
        this.userKey = "";
        this.grupo = grupo;
        this.departamento = departamento;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public GrupoUsuario getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoUsuario grupo) {
        this.grupo = grupo;
    }

    public com.common.Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(com.common.Departamento departamento) {
        this.departamento = departamento;
    }
    
}
