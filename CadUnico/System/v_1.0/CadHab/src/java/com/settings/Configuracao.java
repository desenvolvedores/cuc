/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.settings;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class Configuracao {
    
    public static void iniciarConfiguracoes() {

        com.sys.SystemSettings.url = "http://127.0.0.1:8080/cadhab";
        com.sys.SystemSettings.systemPath = "C:\\Arquivos de Programas\\CadHab";
        com.sys.SystemSettings.attachmentPath = "W:";
        com.sys.DBSettings.systemPath = "C:\\Arquivos de Programas\\CadHab";
        com.sys.DBSettings.systemDatabase = "cadunico";
        com.sys.DBSettings.systemUsernameDB = "postgres";
        com.sys.DBSettings.systemPasswordDB = "123";
        
    }
    
    public static void releaseDatabase() {
        
        try {
            
            com.db.DBConnection.getInstance().getConnection().rollback();
            
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}
