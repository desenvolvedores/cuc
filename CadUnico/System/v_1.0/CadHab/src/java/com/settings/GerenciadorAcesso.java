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
public class GerenciadorAcesso {
    
    private static java.util.List<java.lang.String[]> authentication = new java.util.ArrayList<java.lang.String[]>();
    
    public GerenciadorAcesso() {
        
    }
    
    public static boolean setAuthentication(com.access.Usuario usuario) 
            throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        
        if (usuario.getId() < 1 || usuario.getUsuario().isEmpty() || usuario.getGrupo().getId() < 1 
                || usuario.getDepartamento().getId() < 1)
            return false;
        
        for (int i = 0; i < authentication.size(); i++) {
            if (authentication.get(i)[0].equals(String.valueOf(usuario.getId())) && authentication.get(i)[1].equals(usuario.getUsuario()))
                return true;
        }
        
        java.lang.String[] auth = new java.lang.String[6];
        auth[0] = String.valueOf(usuario.getId());
        auth[1] = usuario.getUsuario();
        auth[2] = String.valueOf(usuario.getGrupo().getId());
        auth[3] = String.valueOf(usuario.getDepartamento().getId());
        auth[4] = generateToken();
        auth[5] = generateUserKey();
        authentication.add(auth);
        
        return true;
        
    }
    
    public static boolean checkAuthentication(String token, String userKey) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (temp[4].equals(token) && temp[5].equals(userKey))
                return true;
        }
        
        return false;
        
    }
    
    public static boolean updateAuthentication(com.access.Usuario usuario) 
            throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        
        if (usuario.getId() < 1 || usuario.getUsuario().isEmpty() || usuario.getGrupo().getId() < 1 
                || usuario.getDepartamento().getId() < 1)
            return false;
        
        for (int i = 0; i < authentication.size(); i++) {
            if (authentication.get(i)[0].equals(String.valueOf(usuario.getId())) && authentication.get(i)[1].equals(usuario.getUsuario())) {
                authentication.get(i)[4] = generateToken();
                authentication.get(i)[5] = generateUserKey();
            }
        }
        
        return true;
        
    }
    
    public static void destroyAuthentication(com.access.Usuario usuario) 
            throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        
        if (usuario.getId() < 1 || usuario.getUsuario().isEmpty())
            return;
        
        for (int i = 0; i < authentication.size(); i++) {
            if (authentication.get(i)[0].equals(String.valueOf(usuario.getId())) && authentication.get(i)[1].equals(usuario.getUsuario())) {
                authentication.remove(i);
            }
        }
        
    }
    
    public static long getUserID(String token, String userKey) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (temp[4].equals(token) && temp[5].equals(userKey))
                return Long.parseLong(temp[0]);
        }
        
        return 0;
        
    }
    
    public static long getUserMatricula(String token, String userKey) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (temp[4].equals(token) && temp[5].equals(userKey))
                return Long.parseLong(temp[1]);
        }
        
        return 0;
        
    }
    
    public static long getUserGroupID(String token, String userKey) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (temp[4].equals(token) && temp[5].equals(userKey))
                return Long.parseLong(temp[2]);
        }
        
        return 0;
        
    }
    
    public static long getUserSecretariaID(String token, String userKey) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (temp[4].equals(token) && temp[5].equals(userKey))
                return Long.parseLong(temp[3]);
        }
        
        return 0;
        
    }
    
    public static String getUserToken(int idUsuario) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (Integer.parseInt(temp[0]) == idUsuario)
                return temp[4];
        }
        
        return "";
        
    }
    
    public static String getUserKey(int idUsuario) {
        
        String[] temp = null;
        
        for (int i = 0; i < authentication.size(); i++) {
            temp = authentication.get(i);
            if (Integer.parseInt(temp[0]) == idUsuario)
                return temp[5];
        }
        
        return "";
        
    }
    
    private static String generateToken() 
            throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        
        String token = String.valueOf(java.lang.System.nanoTime());
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        java.math.BigInteger hash = new java.math.BigInteger(1, md.digest(token.getBytes("UTF-8")));
        
        return hash.toString(16);
        
    }
    
    private static String generateUserKey() 
            throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        
        String userKey = String.valueOf(java.lang.System.nanoTime());
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        java.math.BigInteger hash = new java.math.BigInteger(1, md.digest(userKey.getBytes("UTF-8")));
        
        return hash.toString(16);
        
    }
    
}
