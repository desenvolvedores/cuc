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
public class Notification implements Runnable {
    
    private Notification() {
        
        
        
    }
    
    public static Notification getInstance() {
        
        if (note == null)
            note = new Notification();
        
        return note;
        
    }
    
    public void setMessage(java.lang.String message) {
        
        this.message = message;
        
    }
    
    public void setMessageType(short messageType) {
        
        this.messageType = messageType;
        
    }
    
    public void setIcon(java.awt.Image icon) {
        
        this.icon = icon;
        
    }
    
    @Override
    public void run() {
        
        try {
            
            Thread.sleep(20000);
            
            while (true) {
                
                execute();
                Thread.sleep(1000);
                
            }
            
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
            trayIcon.displayMessage(com.sys.SystemSettings.systemName, "Não foi possível fazer a busca por tarefas pendentes!", java.awt.TrayIcon.MessageType.ERROR);
            
        }
        
    }
    
    private void execute() throws InterruptedException {
        
        if (this.message.isEmpty())
            return;
        
        switch (messageType) {
            
            case 0: trayIcon.displayMessage(com.sys.SystemSettings.systemName, message, java.awt.TrayIcon.MessageType.ERROR);
                break;
            case 1: trayIcon.displayMessage(com.sys.SystemSettings.systemName, message, java.awt.TrayIcon.MessageType.INFO);
                break;
            case 2: trayIcon.displayMessage(com.sys.SystemSettings.systemName, message, java.awt.TrayIcon.MessageType.WARNING);
                break;
            case 3: trayIcon.displayMessage(com.sys.SystemSettings.systemName, message, java.awt.TrayIcon.MessageType.NONE);
                break;
            
        }
        
        Thread.sleep(20000);
        this.message = "";
        this.messageType = -1;
        
    }
    
    public void createSystemTray() {
        
        try {
            
            tray = java.awt.SystemTray.getSystemTray();
            
            if (tray.isSupported()) {
                
                if (trayIcon == null) {
                    
                    trayIcon = new java.awt.TrayIcon(icon, com.sys.SystemSettings.systemFullName, popup);
                    tray.add(trayIcon);
                    
                }
                
                Thread.sleep(500);
                trayIcon.displayMessage(com.sys.SystemSettings.systemName, "Procurando por tarefas e notificações!", java.awt.TrayIcon.MessageType.INFO);
                
            }
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public void destroySystemTray() {
        
        if (tray.getTrayIcons() != null) {
            
            tray.remove(trayIcon);
            trayIcon = null;
            tray = null;
            
        }
        
    }
    
    private static Notification note = null;
    private java.lang.String message = "";
    private short messageType = -1;
    
    private java.awt.PopupMenu popup;
    private java.awt.Image icon;
    private static java.awt.SystemTray tray;
    private static java.awt.TrayIcon trayIcon;
    
}
