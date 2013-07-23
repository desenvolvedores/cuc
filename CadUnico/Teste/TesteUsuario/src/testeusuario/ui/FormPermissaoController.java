/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testeusuario.ui;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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
public class FormPermissaoController implements Initializable {
    
    @FXML
    private javafx.scene.control.TextField txtNome;
    @FXML
    private javafx.scene.control.TextArea txtaDescricao;
    @FXML
    private javafx.scene.control.Button btnCadastrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void handleBtnCadastrarAction(javafx.event.ActionEvent event) {
        
        try {
        
            String nome = txtNome.getText();
            String descricao = txtaDescricao.getText();
            if (! nome.isEmpty() && ! descricao.isEmpty()) {

                com.access.Permissao permissao = new com.access.Permissao();
                permissao.setNome(nome);
                permissao.setDescricao(descricao);

                String urlServlet = "http://127.0.0.1:8080/CadUnico/inserir_permissao.aspx";  
                URL url = new URL(urlServlet);  
                URLConnection urlConn = url.openConnection();  
                urlConn.setDoInput(true);  
                urlConn.setDoOutput(true);  
                urlConn.setUseCaches(false);  
                urlConn.setDefaultUseCaches(false);  
                urlConn.setRequestProperty("content-type", "text/plain");

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(urlConn.getOutputStream());
                com.util.JsonManager jsonMgr = new com.util.JsonManager();
                String s = jsonMgr.parseJson(permissao);
                System.out.println(s);
                objectOutputStream.writeChars(s);
                objectOutputStream.flush();  
                objectOutputStream.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));  
                DataInputStream objectInputStream = new DataInputStream(urlConn.getInputStream());
                String objectReceived = objectInputStream.readLine();
                objectInputStream.close();

                com.data.MessageManager messMgr = new com.data.MessageManager();
                com.sys.Message message = messMgr.parseMessage(objectReceived);
                System.out.println(message.getCode());
                System.out.println(message.getMessage());

            }
        
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
}
