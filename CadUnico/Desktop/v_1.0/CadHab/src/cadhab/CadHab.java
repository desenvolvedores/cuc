/*
 * Classe pertencente ao módulo de GUI do sistema "CadÚnico".
 */
package cadhab;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class CadHab {
    
    public static com.access.Usuario usuario;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        com.sys.SystemSettings.systemPath = "C:\\Arquivos de Programas\\CadHab";
        com.sys.SystemSettings.systemName = "cadhab";
        usuario = null;
        
        java.lang.Thread thread = new java.lang.Thread(new cadhab.ui.FormSplash());
        thread.start();
        
    }
}
