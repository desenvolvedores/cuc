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
public class DBConfig {

    private String[] param = new String[5];
    private String systemPath;
    private String database;
    public static final int POSTGRESQL = 1;
    public static final int MYSQL = 2;
    public static final int ORACLE = 3;
    public static final int FIREBIRD = 4;
    public static final int SQLSERVER = 5;
    
    public DBConfig(String systemPath, String database) {
        this.systemPath = systemPath;
        this.database = database;
    }
    
    /**
     * This method is used to delete a malformmed configuration file.
     * delete <b>configdb.ini</b>.
     *
     * @return
     *          true or false.
     */
    public boolean deleteCurrentSGBDConfiguration() {
        java.io.File config = new java.io.File(this.systemPath + "\\config\\configdb.ini");
        System.out.println(config.getAbsolutePath());
        return config.delete();
    }

    /**
     * This method verify if the configuration database file
     * <b>configdb.ini</b> exists.
     *
     * @return
     *          true or false.
     */
    public boolean existsSGBDConfiguration() {
        java.io.File config = new java.io.File(this.systemPath + "\\config\\configdb.ini");
        return config.exists();
    }

    /**
     * It sets the configuration of the SGBD and location of database
     * who will be used by system. This method alters the file <b>configdb.ini</b>.
     *
     * @param sgbd
     *          Number of the SGBD choiced.
     * @param server
     *          IP address of the Server where the SGBD choiced is installed.
     * @param port
     *          Port who will be used to access the SGBD.
     */
    public short setSGBDConfiguration(short sgbd, String server, String port) {

        short status = 0;
        String dbSelected = "";
        String fileTemp = this.systemPath + "\\config\\configdb.ini";
        java.io.FileWriter file = null;
        java.io.PrintWriter save = null;
        
        try {
        
            java.io.File dir = new java.io.File(this.systemPath + "\\config");
            if (! dir.exists())
                dir.mkdirs();

            java.io.File configdb = new java.io.File(this.systemPath + "\\config\\configdb.ini");
            if (! configdb.exists())
                configdb.createNewFile();

            switch (sgbd) {

                // Routines for PostgreSQL
                case POSTGRESQL: dbSelected = "PTG";
                    break;

                // Routines for MySQL Server
                case MYSQL: dbSelected = "MYS";
                    break;

                // Routines for Oracle Database
                case ORACLE: dbSelected = "ORA";
                    break;

                // Routines for Firebird
                case FIREBIRD: dbSelected = "FBD";
                    break;

                // Routines for MS SQL Server
                case SQLSERVER: dbSelected = "MSS";
                    break;

                // Other parameter
                default:
                    break;

            }
            
            file = new java.io.FileWriter(fileTemp);
            save = new java.io.PrintWriter(file);
            save.println("[Database settings]");
            save.println("SGBD=" + dbSelected);
            save.println("Server=" + server);
            save.println("Port=" + port);
            save.println("\n\n");
            save.println("# This file is used in the database's system configuration.");
            save.println("# Change or delete this content, delete or change this file of this directory");
            save.println("# will cause damages on system.");
            status = 1;
        
        } catch (java.io.IOException ex) {
            status = 0;
        } finally {
            save.close();
        }

        return status;

    }

    /**
     * It loads the configuration of the file <b>configdb.ini</b>.
     *
     */
    public void getSGBDConfiguration() {

        try {

            java.io.File config = new java.io.File(this.systemPath + "\\config\\configdb.ini");
            java.io.FileReader reader = new java.io.FileReader(config);
            java.io.BufferedReader buffer = new java.io.BufferedReader(reader);

            if (config.exists()) {

                if (config.isFile()) {

                    for (short i = 0; i < param.length; i++)
                        param[i] = buffer.readLine();

                    param[1] = param[1].substring(5, param[1].length());
                    param[2] = param[2].substring(7, param[2].length());
                    param[3] = param[3].substring(5, param[3].length());
                    param[4] = this.database;

                }

            }

        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * This method returns the SGBD which is used by the system.
     *
     * @return
     *          The SGBD used by system.
     */
    public short getSGBD() {

        short sgbd = 0;

        // Routines for PostgreSQL
        if (param[1].equals("PTG"))
            sgbd = POSTGRESQL;

        // Routines for MySQL Server
        else if (param[1].equals("MYS"))
            sgbd = MYSQL;

        // Routines for Oracle Database
        else if (param[1].equals("ORA"))
            sgbd = ORACLE;

        // Routines for Firebird
        else if (param[1].equals("FBD"))
            sgbd = FIREBIRD;

        // Routines for MS SQL Server
        else if (param[1].equals("MSS"))
            sgbd = SQLSERVER;

        return sgbd;

    }

    /**
     * This method returns which is the IP address of the database server.
     *
     * @return
     *          The IP address of the database server.
     */
    public String getServer() {
        return param[2];
    }

    /**
     * This method returns the port where the SGBD is running.
     *
     * @return
     *          The port where the SGBD is running.
     */
    public String getPort() {
        return param[3];
    }

    /**
     * This method returns the name of the database system.
     *
     * @return
     *          The database system name.
     */
    public String getDatabase() {
        return param[4];
    }

    /**
     * It returns the connection driver of the SGBD setted in
     * system file <b>configdb.ini</b> on Microsoft Windows systems.
     *
     * @return
     *          The connection driver of the SGBD setted in configuration system file.
     */
    public String getDriverDB() {

        String driver = null;
        this.getSGBDConfiguration();
        short sgbd = this.getSGBD();

        switch (sgbd) {

            // Routines for PostgreSQL
            case POSTGRESQL: driver = "org.postgresql.Driver";
                break;

            // Routines for MySQL Server
            case MYSQL: driver = "com.mysql.jdbc.Driver";
                break;

            // Routines for Oracle Database
            case ORACLE: driver = "";
                break;

            // Routines for Firebird
            case FIREBIRD: driver = "org.firebirdsql.jdbc.FBDriver";
                break;

            // Routines for MS SQL Server
            case SQLSERVER: driver = "";
                break;

            // Other parameter
            default:
                break;

        }

        // It returns the driver connection of the SGBD setted in configuration file
        return driver;

    }

    /**
     * It returns the URL connection of the SGBD setted in system
     * file <b>configdb.ini</b> on Microsoft Windows systems.
     *
     * @return
     *          The URL connection for the SGBD choiced.
     */
    public String getURL() {

        String url = null;
        this.getSGBDConfiguration();
        short sgbd = this.getSGBD();

        switch (sgbd) {

            // Routines for PostgreSQL
            case POSTGRESQL: url = "jdbc:postgresql://" + this.getServer() + ":" + this.getPort() + "/" + this.getDatabase();
                break;

            // Routines for MySQL Server
            case MYSQL: url = "jdbc:mysql://" + this.getServer() + ":" + this.getPort() + "/" + this.getDatabase();
                break;

            // Routines for Oracle Database
            case ORACLE: url = "";
                break;

            // Routines for Firebird
            case FIREBIRD: url = "jdbc:firebirdsql://" + this.getServer() + ":" + this.getPort() + "/" + System.getProperty("user.dir") + "\\Database\\" + this.getDatabase() + ".fdb";
                break;

            // Routines for MS SQL Server
            case SQLSERVER: url = "";
                break;

            // Other parameter
            default:
                break;

        }

        // It returns the URL connection of the SGBD setted in configuration file
        return url;

    }

}
