/*
 * Classe pertencente a API de configuração de banco de dados "libdb-windows".
 */
package com.db;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DBConnection {
    
    private static DBConnection instance = new DBConnection();
    private static java.sql.Connection conn;
    
    private DBConnection() {
        
    }
    
    public static DBConnection getInstance() throws java.lang.ClassNotFoundException, java.sql.SQLException {
        startConnection();
        return instance;
    }
    
    private static void startConnection() throws java.lang.ClassNotFoundException, java.sql.SQLException {
        if (conn == null) {
            DBConfig config = new DBConfig(com.sys.DBSettings.systemPath, com.sys.DBSettings.systemDatabase);
            config.getSGBDConfiguration();
            Class.forName(config.getDriverDB());
            conn = java.sql.DriverManager.getConnection(config.getURL(), com.sys.DBSettings.systemUsernameDB, com.sys.DBSettings.systemPasswordDB);
            conn.setAutoCommit(false);
        }
    }
    
    public java.sql.Connection getConnection() {
        return conn;
    }
    
}
