/*
 * Classe pertencente a API de configurações de sistema "libconfig".
 */
package com.server;

/**
 *
 * @author William Oliveira
 * 
 * @author 1.0
 */
public class ServerConfig {
    
    private String[] param = new String[4];
    private String systemPath;
    
    public ServerConfig(String systemPath) {
        this.systemPath = systemPath;
    }
    
    /**
     * This method is used to delete a malformmed configuration file.
     * delete <b>configserver.ini</b>.
     *
     * @return
     *          true or false.
     */
    public boolean deleteCurrentServerConfiguration() {
        java.io.File config = new java.io.File(this.systemPath + "\\config\\configserver.ini");
        System.out.println(config.getAbsolutePath());
        return config.delete();
    }
    
    /**
     * This method verify if the configuration server file
     * <b>configserver.ini</b> exists.
     *
     * @return
     *          true or false.
     */
    public boolean existsServerConfiguration() {
        java.io.File config = new java.io.File(this.systemPath + "\\config\\configserver.ini");
        return config.exists();
    }
    
    /**
     * It sets the configuration of the server who will be used by system.
     * This method alters the file <b>configserver.ini</b>.
     *
     * @param server
     *          IP address of the Server.
     * @param port
     *          Port who will be used to access the Server.
     * @param protocol
     *          Protocol who will be used to access the Server.
     */
    public short setServerConfiguration(String server, String port, String protocol) {

        short status = 0;
        String fileTemp = this.systemPath + "\\config\\configserver.ini";
        java.io.FileWriter file = null;
        java.io.PrintWriter save = null;
        
        try {
        
            java.io.File dir = new java.io.File(this.systemPath + "\\config");
            if (! dir.exists())
                dir.mkdirs();

            java.io.File configdb = new java.io.File(this.systemPath + "\\config\\configserver.ini");
            if (! configdb.exists())
                configdb.createNewFile();
            
            file = new java.io.FileWriter(fileTemp);
            save = new java.io.PrintWriter(file);
            save.println("[Server settings]");
            save.println("Server=" + server);
            save.println("Port=" + port);
            save.println("Protocol=" + protocol);
            save.println("\n\n");
            save.println("# This file is used in the server's system configuration.");
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
     * It loads the configuration of the file <b>configserver.ini</b>.
     *
     */
    public void getServerConfiguration() {

        try {

            java.io.File config = new java.io.File(this.systemPath + "\\config\\configserver.ini");
            java.io.FileReader reader = new java.io.FileReader(config);
            java.io.BufferedReader buffer = new java.io.BufferedReader(reader);

            if (config.exists()) {

                if (config.isFile()) {

                    for (short i = 0; i < param.length; i++)
                        param[i] = buffer.readLine();

                    param[1] = param[1].substring(7, param[1].length());
                    param[2] = param[2].substring(5, param[2].length());
                    param[3] = param[3].substring(9, param[3].length());

                }

            }

        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
        }

    }
    
    /**
     * This method returns which is the IP address or hostname of the server.
     *
     * @return
     *          The IP address or hostname of the database server.
     */
    public String getServer() {
        return param[1];
    }
    
    /**
     * This method returns the port where the server is running.
     *
     * @return
     *          The port where the server is running.
     */
    public String getPort() {
        return param[2];
    }
    
    /**
     * This method returns the protocol used by server.
     *
     * @return
     *          The protocol used by server.
     */
    public String getProtocol() {
        return param[3];
    }
    
}
