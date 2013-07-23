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
public class CustomMouseListener extends java.awt.event.MouseAdapter {
    
    private int componentIndex;
   
    public CustomMouseListener(int componentIndex) {
        this.componentIndex = componentIndex;
    }
    
    public int getComponentIndex() {
        return componentIndex;
    }
    
}
