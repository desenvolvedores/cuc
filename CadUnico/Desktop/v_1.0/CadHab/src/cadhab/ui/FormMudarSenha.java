/*
 * Classe pertencente ao módulo de GUI do sistema "CadHab".
 */
package cadhab.ui;

/**
 *
 * @author 14145
 */
public class FormMudarSenha extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormMudarSenha
     */
    public FormMudarSenha() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPrincipal = new javax.swing.JPanel();
        jlblSenhaAtual = new javax.swing.JLabel();
        jpwdSenhaAtual = new javax.swing.JPasswordField();
        jlblNovaSenha = new javax.swing.JLabel();
        jpwdNovaSenha = new javax.swing.JPasswordField();
        jlblConfirmeSenha = new javax.swing.JLabel();
        jpwdConfirmeSenha = new javax.swing.JPasswordField();
        jsepRodape = new javax.swing.JSeparator();
        jbtnTrocar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("CadHab - Mudança de Senha");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/password.png"))); // NOI18N

        jpnlPrincipal.setLayout(null);

        jlblSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblSenhaAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSenhaAtual.setText("Senha Atual:");
        jpnlPrincipal.add(jlblSenhaAtual);
        jlblSenhaAtual.setBounds(10, 10, 110, 25);

        jpwdSenhaAtual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jpwdSenhaAtual);
        jpwdSenhaAtual.setBounds(130, 10, 240, 25);

        jlblNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblNovaSenha.setText("Nova Senha:");
        jpnlPrincipal.add(jlblNovaSenha);
        jlblNovaSenha.setBounds(10, 40, 110, 25);

        jpwdNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jpwdNovaSenha);
        jpwdNovaSenha.setBounds(130, 40, 240, 25);

        jlblConfirmeSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblConfirmeSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblConfirmeSenha.setText("Confirme a Senha:");
        jpnlPrincipal.add(jlblConfirmeSenha);
        jlblConfirmeSenha.setBounds(10, 70, 110, 25);

        jpwdConfirmeSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jpwdConfirmeSenha);
        jpwdConfirmeSenha.setBounds(130, 70, 240, 25);
        jpnlPrincipal.add(jsepRodape);
        jsepRodape.setBounds(10, 120, 360, 2);

        jbtnTrocar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnTrocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/password.png"))); // NOI18N
        jbtnTrocar.setText("Trocar");
        jbtnTrocar.setIconTextGap(10);
        jpnlPrincipal.add(jbtnTrocar);
        jbtnTrocar.setBounds(120, 130, 120, 30);

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/cancel.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setIconTextGap(10);
        jpnlPrincipal.add(jbtnCancelar);
        jbtnCancelar.setBounds(250, 130, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnTrocar;
    private javax.swing.JLabel jlblConfirmeSenha;
    private javax.swing.JLabel jlblNovaSenha;
    private javax.swing.JLabel jlblSenhaAtual;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPasswordField jpwdConfirmeSenha;
    private javax.swing.JPasswordField jpwdNovaSenha;
    private javax.swing.JPasswordField jpwdSenhaAtual;
    private javax.swing.JSeparator jsepRodape;
    // End of variables declaration//GEN-END:variables
}
