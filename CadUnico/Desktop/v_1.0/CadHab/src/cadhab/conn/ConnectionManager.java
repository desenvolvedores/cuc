/*
 * Classe pertencente ao módulo de GUI do sistema "CadHab".
 */
package cadhab.conn;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class ConnectionManager {
    
    private static  com.sys.Message mensagem;
    private static com.data.MessageManager mensMgr = new com.data.MessageManager();
    private static com.util.JsonManager jMgr = new com.util.JsonManager();
    private static com.utils.JsonManager jsonMgr = new com.utils.JsonManager();
    
    public ConnectionManager() {
        
    }
    
    public static java.lang.Object connect(String urlConnection, String output) 
            throws java.net.MalformedURLException, java.io.IOException, java.net.ConnectException {
        
        java.net.URL url = new java.net.URL(com.sys.SystemSettings.url + urlConnection);  
        java.net.URLConnection urlConn = url.openConnection();  
        urlConn.setDoInput(true);  
        urlConn.setDoOutput(true);  
        urlConn.setUseCaches(false);
        urlConn.setDefaultUseCaches(false);
        urlConn.setRequestProperty("content-type", "text/plain");
        
        java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(urlConn.getOutputStream());
        objectOutputStream.writeChars(output);
        objectOutputStream.flush();  
        objectOutputStream.close();
        
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
        String objectReceived = objectInputStream.readLine();
        objectInputStream.close();
        
        //System.out.println(objectReceived);
        
        if (objectReceived.contains("\"type\":\"mensagem\"")) {
            mensagem = mensMgr.parseMessage(objectReceived);
            mensagem.setMessage(mensagem.getMessage().replaceAll("<br />", "\n"));
            return mensagem;
        }
        
        if (objectReceived.contains("\"type\":\"usuario\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaUsuario(objectReceived);
            else
                return jMgr.parseUsuario(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"departamento\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaDepartamento(objectReceived);
            else
                return jMgr.parseDepartamento(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"grupousuario\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaGrupoUsuario(objectReceived);
            else
                return jMgr.parseGrupoUsuario(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"recursomobilidade\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaRecursoMobilidade(objectReceived);
            else
                return jsonMgr.parseRecursoMobilidade(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"recursosocial\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaRecursoSocial(objectReceived);
            else
                return jsonMgr.parseRecursoSocial(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"nucleo\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaNucleo(objectReceived);
            else
                return jsonMgr.parseNucleo(objectReceived);
            
        }
        
        return null;
        
    }
    
    public static java.lang.Object connect2(String urlConnection, String output) 
            throws java.net.MalformedURLException, java.io.IOException, java.net.ConnectException {
        
        java.net.URL url = new java.net.URL(com.sys.SystemSettings.url + urlConnection);  
        java.net.URLConnection urlConn = url.openConnection();  
        urlConn.setDoInput(true);  
        urlConn.setDoOutput(true);  
        urlConn.setUseCaches(false);
        urlConn.setDefaultUseCaches(false);
        urlConn.setRequestProperty("content-type", "text/plain");
        
        java.io.OutputStreamWriter outStream = new java.io.OutputStreamWriter(urlConn.getOutputStream());
        outStream.write(output);
        outStream.flush();  
        outStream.close();
        
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
        String objectReceived = objectInputStream.readLine();
        objectInputStream.close();
        
        //System.out.println(objectReceived);
        
        if (objectReceived.contains("\"type\":\"mensagem\"")) {
            mensagem = mensMgr.parseMessage(objectReceived);
            mensagem.setMessage(mensagem.getMessage().replaceAll("<br />", "\n"));
            return mensagem;
        }
        
        if (objectReceived.contains("\"type\":\"usuario\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaUsuario(objectReceived);
            else
                return jMgr.parseUsuario(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"departamento\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaDepartamento(objectReceived);
            else
                return jMgr.parseDepartamento(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"grupousuario\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jMgr.parseListaGrupoUsuario(objectReceived);
            else
                return jMgr.parseGrupoUsuario(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"recursomobilidade\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaRecursoMobilidade(objectReceived);
            else
                return jsonMgr.parseRecursoMobilidade(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"recursosocial\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaRecursoSocial(objectReceived);
            else
                return jsonMgr.parseRecursoSocial(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"nucleo\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaNucleo(objectReceived);
            else
                return jsonMgr.parseNucleo(objectReceived);
            
        }
        
        return null;
        
    }
    
    public static java.lang.Object upload(String urlConnection, int data[]) 
            throws java.net.MalformedURLException, java.io.IOException, java.net.ConnectException {
        
        java.net.URL url = new java.net.URL(com.sys.SystemSettings.url + urlConnection);  
        java.net.URLConnection urlConn = url.openConnection();  
        urlConn.setDoInput(true);  
        urlConn.setDoOutput(true);  
        urlConn.setUseCaches(false);  
        urlConn.setDefaultUseCaches(false);
        urlConn.setRequestProperty("content-type", "image/*");
        
        java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(urlConn.getOutputStream());
        
        for (int i = 0; i < data.length; i++)
            objectOutputStream.writeInt(data[i]);
        
        objectOutputStream.flush();  
        objectOutputStream.close();
        
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
        String objectReceived = objectInputStream.readLine();
        objectInputStream.close();
        
        if (objectReceived.contains("\"type\":\"mensagem\"")) {
            mensagem = mensMgr.parseMessage(objectReceived);
            mensagem.setMessage(mensagem.getMessage().replaceAll("<br />", "\n"));
            return mensagem;
        }
        
        return null;
        
    }
    
}
