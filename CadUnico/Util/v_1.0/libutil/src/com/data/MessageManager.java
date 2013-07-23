/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.data;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class MessageManager {
    
    public MessageManager() {
        
    }
    
    public String parseJson(com.sys.Message message) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(message);
        
    }
    
    public com.sys.Message parseMessage(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.Message.class);
        
    }
    
}
