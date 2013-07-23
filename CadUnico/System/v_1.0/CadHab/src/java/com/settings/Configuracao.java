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

        com.sys.SystemSettings.url = "127.0.0.1:8080/cadunico/";
        com.sys.SystemSettings.systemPath = "C:\\Arquivos de Programas\\CadHab";
        com.sys.DBSettings.systemPath = "C:\\Arquivos de Programas\\CadHab";
        com.sys.DBSettings.systemDatabase = "cadunico";
        com.sys.DBSettings.systemUsernameDB = "postgres";
        com.sys.DBSettings.systemPasswordDB = "123";
        
    }
    
}
