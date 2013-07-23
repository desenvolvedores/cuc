/*
 * Classe pertencente a API de acesso à sistemas "libaccess".
 */
package com.util;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class JsonManager {
    
    public JsonManager() {
        
    }
    
    public String parseJson(com.common.Departamento departamento) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(departamento);
        
    }
    
    public String parseJson(com.access.GrupoUsuario grupo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(grupo);
        
    }
    
    public String parseJson(com.access.Permissao permissao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(permissao);
        
    }
    
    public String parseJson(com.access.Usuario usuario) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(usuario);
        
    }
    
    public String parseJsonListaDepartamento(java.util.List<com.common.Departamento> departamentos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(departamentos);
        
    }
    
    public String parseJsonListaGrupoUsuario(java.util.List<com.access.GrupoUsuario> grupos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(grupos);
        
    }
    
    public String parseJsonListaPermissao(java.util.List<com.access.Permissao> permissoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(permissoes);
        
    }
    
    public String parseJsonListaUsuario(java.util.List<com.access.Usuario> usuarios) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(usuarios);
        
    }
    
    public com.common.Departamento parseDepartamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.Departamento.class);
        
    }
    
    public com.access.GrupoUsuario parseGrupoUsuario(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.access.GrupoUsuario.class);
        
    }
    
    public com.access.Permissao parsePermissao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.access.Permissao.class);
        
    }
    
    public com.access.Usuario parseUsuario(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.access.Usuario.class);
        
    }
    
    public java.util.List<com.common.Departamento> parseListaDepartamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.Departamento>>() {});
        
    }
    
    public java.util.List<com.access.GrupoUsuario> parseListaGrupoUsuario(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.access.GrupoUsuario>>() {});
        
    }
    
    public java.util.List<com.access.Permissao> parseListaPermissao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.access.Permissao>>() {});
        
    }
    
    public java.util.List<com.access.Usuario> parseListaUsuario(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.access.Usuario>>() {});
        
    }
    
}
