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
    
    private static com.sys.Message mensagem;
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
        
        java.io.OutputStreamWriter outStream = new java.io.OutputStreamWriter(urlConn.getOutputStream());
        outStream.write(output);
        outStream.flush();  
        outStream.close();
        
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
        String objectReceived = objectInputStream.readLine();
        objectInputStream.close();
        
//        System.out.println(objectReceived);
        
        if (objectReceived.contains("\"type\":\"mensagem\"")) {
            mensagem = mensMgr.parseMessage(objectReceived);
            mensagem.setMessage(mensagem.getMessage().replaceAll("<br />", "\n"));
            return mensagem;
        }
        
        if (objectReceived.contains("\"type\":\"pais\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaPais(objectReceived);
            else
                return jsonMgr.parsePais(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"estado\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaEstado(objectReceived);
            else
                return jsonMgr.parseEstado(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"municipio\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaMunicipio(objectReceived);
            else
                return jsonMgr.parseMunicipio(objectReceived);
            
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
        
        if (objectReceived.contains("\"type\":\"institucionalsocial\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaInstitucionalSocial(objectReceived);
            else
                return jsonMgr.parseInstitucionalSocial(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"viapublica\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaViaPublica(objectReceived);
            else
                return jsonMgr.parseViaPublica(objectReceived);
            
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
        
        if (objectReceived.contains("\"type\":\"infraestruturaurbana\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaInfraestruturaUrbana(objectReceived);
            else
                return jsonMgr.parseInfraestruturaUrbana(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"programahabitacional\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaProgramaHabitacional(objectReceived);
            else
                return jsonMgr.parseProgramaHabitacional(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"situacaofundiaria\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaSituacaoFundiaria(objectReceived);
            else
                return jsonMgr.parseSituacaoFundiaria(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"acaonucleo\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaAcaoNucleo(objectReceived);
            else
                return jsonMgr.parseAcaoNucleo(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"aspectoambiental\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaAspectoAmbiental(objectReceived);
            else
                return jsonMgr.parseAspectoAmbiental(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"remanejamento\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaRemanejamento(objectReceived);
            else
                return jsonMgr.parseRemanejamento(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"reassentamento\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaReassentamento(objectReceived);
            else
                return jsonMgr.parseReassentamento(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"desconstrucao\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaDesconstrucao(objectReceived);
            else
                return jsonMgr.parseDesconstrucao(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"app\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaApp(objectReceived);
            else
                return jsonMgr.parseApp(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"imovel\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaImovel(objectReceived);
            else
                return jsonMgr.parseImovel(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"composicaoimovel\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaComposicaoImovel(objectReceived);
            else
                return jsonMgr.parseComposicaoImovel(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"enderecoimovel\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaEnderecoImovel(objectReceived);
            else
                return jsonMgr.parseEnderecoImovel(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"servicoimovel\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaServicoImovel(objectReceived);
            else
                return jsonMgr.parseServicoImovel(objectReceived);
            
        }
        
        if (objectReceived.contains("\"type\":\"demolicaoimovel\"")) {
            
            if (objectReceived.contains("[") && objectReceived.contains("]"))
                return jsonMgr.parseListaDemolicaoImovel(objectReceived);
            else
                return jsonMgr.parseDemolicaoImovel(objectReceived);
            
        }
        
        return null;
        
    }
    
    public static void upload(String urlConnection, String nomeArquivo) 
            throws java.net.MalformedURLException, java.io.IOException, java.net.ConnectException {
        
        java.net.URL url = new java.net.URL(com.sys.SystemSettings.url + urlConnection);  
        java.io.File fi = new java.io.File(nomeArquivo);
        String nome = fi.getName();
        java.net.URLConnection urlConn = url.openConnection();
        
        if (urlConn instanceof java.net.HttpURLConnection) {
            
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) urlConn;
            httpConn.setRequestMethod("POST");
            
        }
        
        String NEWLINE = "\r\n";
        String PREFIX = "--";
        String boundary = "--------------------" + Long.toString(System.currentTimeMillis(), 50);
        String contenttype = "multipart/form-data; boundary=" + boundary;
        
        java.io.DataOutputStream out = null;
        
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setDefaultUseCaches(false);
        urlConn.setRequestProperty("Accept", "*/*");
        urlConn.setRequestProperty("Content-Type", contenttype);
        urlConn.setRequestProperty("Connection", "Keep-Alive");
        urlConn.setRequestProperty("Cache-Control", "no-cache");
        
        out = new java.io.DataOutputStream(urlConn.getOutputStream());
        
        //Transformo o Arquivo em um Stream para ser enviado.
        java.io.FileInputStream fis = null;
        boolean fileExists = true;
        
        try {
            
            fis = new java.io.FileInputStream(fi);
            
        } catch (java.io.FileNotFoundException e) {
            
            fileExists = false;
            
        }
        
//        //Inicia a Barra de Progresso.
//        Integer posicao = 0;
//        if (barraProgresso != null){
//            barraProgresso.setMaximum(Long.valueOf(fi.length()/4096).intValue());
//            barraProgresso.setValue(0);
//            barraProgresso.setStringPainted(true);
//        }
        
        //Escrevo o Header do meu POST.
        out.writeBytes(PREFIX);
        out.writeBytes(boundary);
        out.writeBytes(NEWLINE);
        out.writeBytes("Content-Disposition: form-data; name=\"arquivo\"; filename=\"" + nome + "\"");
        out.writeBytes(NEWLINE);
        out.writeBytes("Content-Type: image/jpg");
        out.writeBytes(NEWLINE);
        out.writeBytes(NEWLINE);
        
        // Envio o arquivo em pacotes de 4k(4096 bytes) .
        if(fileExists) {
            
            byte[] buffer= new byte[4096];
            int bytes = 0;
            
            //Envio os dados em pacotes de 4k .
            while((bytes = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
                //Incremento a barra de progresso.
//                if (barraProgresso != null){
//                    posicao++;
//                    corrigeProgressao(posicao);
//                }
            }
            
            fis.close();
            
        }
        
        out.writeBytes(NEWLINE);
        out.writeBytes(PREFIX);
        out.writeBytes(boundary);
        out.writeBytes(PREFIX);
        out.writeBytes(NEWLINE);
        out.flush();
        
        java.io.BufferedInputStream bi = new java.io.BufferedInputStream(urlConn.getInputStream());
        java.io.ByteArrayOutputStream bo = new java.io.ByteArrayOutputStream();
        int tmp =0;
        
        while ((tmp = bi.read()) > -1 ){
            
            bo.write(tmp);
            
        }
        out.flush();
        out.close();
        
//        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
//        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
//        String objectReceived = in.readLine();
//        objectInputStream.close();
//        System.out.println(objectReceived);
        ((java.net.HttpURLConnection)urlConn).disconnect();
        
//        if (objectReceived.contains("\"type\":\"mensagem\"")) {
//            mensagem = mensMgr.parseMessage(objectReceived);
//            mensagem.setMessage(mensagem.getMessage().replaceAll("<br />", "\n"));
//            return mensagem;
//        }
//        
//        return null;
        
    }
    
}
