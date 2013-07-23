/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeusuario.ui;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author 14145
 */
public class FormFamiliaController implements Initializable {
    
    @FXML
    private javafx.scene.control.TextField txtCodigo;
    @FXML
    private javafx.scene.control.TextField txtRemocaoFamilia;
    @FXML
    private javafx.scene.control.TextField txtSituacaoRemocao;
    @FXML
    private javafx.scene.control.TextField txtEspecifiqueRemocao;
    @FXML
    private javafx.scene.control.Button btnObterDados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handleBtnObterDadosAction(javafx.event.ActionEvent event) {
        
        try {
            
            String codigo = txtCodigo.getText();
            
            if (! codigo.isEmpty()) {
                
                com.sys.social.Familia fam = new com.sys.social.Familia();
                fam.setRemocaoFamilia(codigo);
                
                String urlServlet = "http://127.0.0.1:8080/cadunico/procurar_familia_por_remocao.aspx";  
                URL url = new URL(urlServlet);  
                URLConnection urlConn = url.openConnection();  
                urlConn.setDoInput(true);  
                urlConn.setDoOutput(true);  
                urlConn.setUseCaches(false);  
                urlConn.setDefaultUseCaches(false);  
                urlConn.setRequestProperty("content-type", "text/plain");

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(urlConn.getOutputStream());
                com.utils.JsonManager jsonMgr = new com.utils.JsonManager();
                String s = jsonMgr.parseJson(fam);
                objectOutputStream.writeChars(s);
                objectOutputStream.flush();  
                objectOutputStream.close();
                
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));  
                DataInputStream objectInputStream = new DataInputStream(urlConn.getInputStream());
                String objectReceived = objectInputStream.readLine();
                System.out.println(objectReceived);
                objectInputStream.close();
                

//                com.data.MessageManager messMgr = new com.data.MessageManager();
//                com.sys.Message message = messMgr.parseMessage(objectReceived);
//                System.out.println(message.getCode());
//                System.out.println(message.getMessage());
                
            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}
