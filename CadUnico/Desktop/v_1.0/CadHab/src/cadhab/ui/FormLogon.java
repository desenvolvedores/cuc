/*
 * Classe pertencente ao módulo de GUI do sistema "CadHab".
 */
package cadhab.ui;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class FormLogon extends javax.swing.JDialog {

    /**
     * Creates new form FormLogon
     */
    public FormLogon(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        try {
            
            com.sys.SystemSettings.setSystemThemeNimbus();
            
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
        }
        
        setLocationRelativeTo(null);
        
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
        jlblTitulo = new javax.swing.JLabel();
        jsepCabecalho = new javax.swing.JSeparator();
        jlblImagem = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jlblSenha = new javax.swing.JLabel();
        jpwdSenha = new javax.swing.JPasswordField();
        jlblMensagem = new javax.swing.JLabel();
        jsepRodape = new javax.swing.JSeparator();
        jbtnLogar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CadHab - Logon");
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jpnlPrincipal.setLayout(null);

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitulo.setText("CadHab - Logon");
        jpnlPrincipal.add(jlblTitulo);
        jlblTitulo.setBounds(10, 10, 380, 25);

        jsepCabecalho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jsepCabecalho);
        jsepCabecalho.setBounds(10, 40, 380, 2);

        jlblImagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/img/user.png"))); // NOI18N
        jpnlPrincipal.add(jlblImagem);
        jlblImagem.setBounds(10, 50, 50, 50);

        jlblUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblUsuario.setText("Usuário:");
        jpnlPrincipal.add(jlblUsuario);
        jlblUsuario.setBounds(70, 50, 70, 25);

        jtxtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtUsuario.setNextFocusableComponent(jpwdSenha);
        jtxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jtxtUsuario);
        jtxtUsuario.setBounds(150, 50, 230, 25);

        jlblSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSenha.setText("Senha:");
        jpnlPrincipal.add(jlblSenha);
        jlblSenha.setBounds(70, 80, 70, 25);

        jpwdSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpwdSenha.setNextFocusableComponent(jbtnLogar);
        jpwdSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpwdSenhaKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jpwdSenha);
        jpwdSenha.setBounds(150, 80, 230, 25);

        jlblMensagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMensagem.setText("Informe o seu nome de usuário e a sua senha!");
        jpnlPrincipal.add(jlblMensagem);
        jlblMensagem.setBounds(30, 110, 340, 25);
        jpnlPrincipal.add(jsepRodape);
        jsepRodape.setBounds(10, 140, 380, 2);

        jbtnLogar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/logon.png"))); // NOI18N
        jbtnLogar.setText("Logar");
        jbtnLogar.setIconTextGap(10);
        jbtnLogar.setNextFocusableComponent(jbtnCancelar);
        jbtnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogarActionPerformed(evt);
            }
        });
        jbtnLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnLogarKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnLogar);
        jbtnLogar.setBounds(130, 150, 120, 30);

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/cancel.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setIconTextGap(10);
        jbtnCancelar.setNextFocusableComponent(jtxtUsuario);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jbtnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnCancelarKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnCancelar);
        jbtnCancelar.setBounds(260, 150, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogarActionPerformed
        
        logon();
        
    }//GEN-LAST:event_jbtnLogarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        
        fechar();
        
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jtxtUsuarioKeyPressed

    private void jpwdSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpwdSenhaKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jpwdSenhaKeyPressed

    private void jbtnLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnLogarKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnLogarKeyPressed

    private void jbtnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnCancelarKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnCancelarKeyPressed

    private void logon() {
        
        try {
            
            java.lang.String usuario = jtxtUsuario.getText().trim();
            java.lang.String senha = new java.lang.String(jpwdSenha.getPassword()).trim();

            if (! usuario.isEmpty() && ! senha.isEmpty()) {
                
                com.access.Usuario user = new com.access.Usuario();
                user.setUsuario(usuario);
                user.setSenha(senha);
                
                com.util.JsonManager jsonMgr = new com.util.JsonManager();
                String input = jsonMgr.parseJson(user);
                
                java.lang.Object output = cadhab.conn.ConnectionManager.connect("/usuario/autenticar", input);
                
                if (output instanceof com.access.Usuario) {
                    
                    cadhab.CadHab.usuario = (com.access.Usuario) output;
                    javax.swing.JOptionPane.showMessageDialog(this, "Seja bem-vindo ao CadHab, " + cadhab.CadHab.usuario.getNome() + "!", "CadHab", 1);
                    this.dispose();
                    
                } else if (output instanceof com.sys.Message) {
                    
                    com.sys.Message mensagem = (com.sys.Message) output;
                    javax.swing.JOptionPane.showMessageDialog(this, mensagem.getMessage(), "CadHab", mensagem.getCode());
                    
                }

            } else {
                
                jlblMensagem.setText("Informe o seu nome de usuário e a sua senha!");
                jlblMensagem.setForeground(java.awt.Color.red);

            }
        
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar as informações para o servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void fechar() {
        
        java.lang.Object[] options = {"Sim", "Não"};
        java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente sair do sistema?", "CadHab",
                javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                options, options[1]);
            
        if (opcao.toString().equals("0")) {
                
            System.exit(0);
            
        }
        
    }
    
    private void atalho(java.awt.event.KeyEvent evt) {
        
        switch (evt.getKeyChar()) {
            
            case java.awt.event.KeyEvent.VK_ENTER: logon();
                break;
            case java.awt.event.KeyEvent.VK_ESCAPE: fechar();
                break;
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnLogar;
    private javax.swing.JLabel jlblImagem;
    private javax.swing.JLabel jlblMensagem;
    private javax.swing.JLabel jlblSenha;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPasswordField jpwdSenha;
    private javax.swing.JSeparator jsepCabecalho;
    private javax.swing.JSeparator jsepRodape;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}