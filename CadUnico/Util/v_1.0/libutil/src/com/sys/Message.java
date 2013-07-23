/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.sys;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class Message {
    
    private String type;
    private int code;
    private String message;
    
    public Message() {
        this.type = "mensagem";
        this.code = 0;
        this.message = "";
    }
    
    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
