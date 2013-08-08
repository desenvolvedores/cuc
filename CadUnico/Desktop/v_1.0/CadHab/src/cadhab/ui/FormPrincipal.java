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
public class FormPrincipal extends javax.swing.JFrame {
    
    private FormGerenciarGrupo fGerenciarGrupo;
    private FormGerenciarUsuario fGerenciarUsuario;
    private FormGerenciarEmpresa fGerenciarEmpresa;
    private FormGerenciarFamilia fGerenciarFamilia;
    private FormGerenciarIndividuo fGerenciarIndividuo;
    private FormGerenciarImovel fGerenciarImovel;
    private FormGerenciarNucleo fGerenciarNucleo;
    private FormGerenciarRecursoMobilidade fGerenciarRecursoMobilidade;
    private FormGerenciarRecursoSocial fGerenciarRecursoSocial;
    private FormGerenciarDepartamento fGerenciarSecretaria;
    private FormFerramentaConfigurarServidor fFerramentaConfigurarServidor;

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        
        initComponents();
        
        try {
            
            com.sys.SystemSettings.setSystemThemeNimbus();
            
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
        }
        
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/img/logo.png"));
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        
        if (cadhab.CadHab.usuario == null) {
            
            FormLogon logon = new FormLogon(this, true);
            logon.setVisible(true);
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdktDesktop = new javax.swing.JDesktopPane();
        jpnlBarraStatus = new javax.swing.JPanel();
        jsepStatusServidor = new javax.swing.JSeparator();
        jlblStatusServidor = new javax.swing.JLabel();
        jmbarSuperior = new javax.swing.JMenuBar();
        jmenPrincipal = new javax.swing.JMenu();
        jmitPrincipalTrocarSenha = new javax.swing.JMenuItem();
        jsepPrincipal = new javax.swing.JPopupMenu.Separator();
        jmitPrincipalLogoff = new javax.swing.JMenuItem();
        jmitPrincipalSair = new javax.swing.JMenuItem();
        jmenGerenciamento = new javax.swing.JMenu();
        jmenGerenciamentoAcesso = new javax.swing.JMenu();
        jmitAcessoGrupo = new javax.swing.JMenuItem();
        jmitAcessoUsuario = new javax.swing.JMenuItem();
        jmenGerenciamentoCadHab = new javax.swing.JMenu();
        jmitCadHabEmpresa = new javax.swing.JMenuItem();
        jmitCadHabFamilia = new javax.swing.JMenuItem();
        jmitCadHabIndividuo = new javax.swing.JMenuItem();
        jmitCadHabImovel = new javax.swing.JMenuItem();
        jmitCadHabNucleo = new javax.swing.JMenuItem();
        jmenGerenciamentoRecurso = new javax.swing.JMenu();
        jmitRecursoMobilidade = new javax.swing.JMenuItem();
        jmitRecursoSocial = new javax.swing.JMenuItem();
        jmitRecursoSecretaria = new javax.swing.JMenuItem();
        jmenRelatorio = new javax.swing.JMenu();
        jmenFerramenta = new javax.swing.JMenu();
        jmitFerramentaConfigurarServidor = new javax.swing.JMenuItem();
        jmenJanela = new javax.swing.JMenu();
        jmitJanelaCascata = new javax.swing.JMenuItem();
        jsepJanelas = new javax.swing.JPopupMenu.Separator();
        jmitJanelaFecharTodas = new javax.swing.JMenuItem();
        jmenSobre = new javax.swing.JMenu();
        jmenAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CadHab - Cadastro Habitacional");

        jdktDesktop.setBackground(new java.awt.Color(240, 240, 240));

        jpnlBarraStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlBarraStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlBarraStatus.setLayout(null);

        jsepStatusServidor.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jsepStatusServidor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnlBarraStatus.add(jsepStatusServidor);
        jsepStatusServidor.setBounds(0, 0, 25, 25);

        jlblStatusServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/server.png"))); // NOI18N
        jpnlBarraStatus.add(jlblStatusServidor);
        jlblStatusServidor.setBounds(2, 2, 20, 20);

        jmbarSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jmenPrincipal.setText("Principal");
        jmenPrincipal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitPrincipalTrocarSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitPrincipalTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/password.png"))); // NOI18N
        jmitPrincipalTrocarSenha.setText("Mudar Minha Senha");
        jmenPrincipal.add(jmitPrincipalTrocarSenha);
        jmenPrincipal.add(jsepPrincipal);

        jmitPrincipalLogoff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jmitPrincipalLogoff.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitPrincipalLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/logoff.png"))); // NOI18N
        jmitPrincipalLogoff.setText("Logoff");
        jmitPrincipalLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitPrincipalLogoffActionPerformed(evt);
            }
        });
        jmenPrincipal.add(jmitPrincipalLogoff);

        jmitPrincipalSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmitPrincipalSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitPrincipalSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/exit.png"))); // NOI18N
        jmitPrincipalSair.setText("Sair");
        jmitPrincipalSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitPrincipalSairActionPerformed(evt);
            }
        });
        jmenPrincipal.add(jmitPrincipalSair);

        jmbarSuperior.add(jmenPrincipal);

        jmenGerenciamento.setText("Gerenciamento");
        jmenGerenciamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmenGerenciamentoAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/door.png"))); // NOI18N
        jmenGerenciamentoAcesso.setText("Acesso");
        jmenGerenciamentoAcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitAcessoGrupo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jmitAcessoGrupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitAcessoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/group.png"))); // NOI18N
        jmitAcessoGrupo.setText("Grupo");
        jmitAcessoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitAcessoGrupoActionPerformed(evt);
            }
        });
        jmenGerenciamentoAcesso.add(jmitAcessoGrupo);

        jmitAcessoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jmitAcessoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitAcessoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/user.png"))); // NOI18N
        jmitAcessoUsuario.setText("Usuário");
        jmitAcessoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitAcessoUsuarioActionPerformed(evt);
            }
        });
        jmenGerenciamentoAcesso.add(jmitAcessoUsuario);

        jmenGerenciamento.add(jmenGerenciamentoAcesso);

        jmenGerenciamentoCadHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/cadhab.png"))); // NOI18N
        jmenGerenciamentoCadHab.setText("CadHab");
        jmenGerenciamentoCadHab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitCadHabEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmitCadHabEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitCadHabEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/building.png"))); // NOI18N
        jmitCadHabEmpresa.setText("Empresa");
        jmitCadHabEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitCadHabEmpresaActionPerformed(evt);
            }
        });
        jmenGerenciamentoCadHab.add(jmitCadHabEmpresa);

        jmitCadHabFamilia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmitCadHabFamilia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitCadHabFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/family.png"))); // NOI18N
        jmitCadHabFamilia.setText("Família");
        jmitCadHabFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitCadHabFamiliaActionPerformed(evt);
            }
        });
        jmenGerenciamentoCadHab.add(jmitCadHabFamilia);

        jmitCadHabIndividuo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jmitCadHabIndividuo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitCadHabIndividuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/subject.png"))); // NOI18N
        jmitCadHabIndividuo.setText("Indivíduo");
        jmitCadHabIndividuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitCadHabIndividuoActionPerformed(evt);
            }
        });
        jmenGerenciamentoCadHab.add(jmitCadHabIndividuo);

        jmitCadHabImovel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmitCadHabImovel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitCadHabImovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/house.png"))); // NOI18N
        jmitCadHabImovel.setText("Imóvel");
        jmitCadHabImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitCadHabImovelActionPerformed(evt);
            }
        });
        jmenGerenciamentoCadHab.add(jmitCadHabImovel);

        jmitCadHabNucleo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmitCadHabNucleo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitCadHabNucleo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/centre.png"))); // NOI18N
        jmitCadHabNucleo.setText("Núcleo");
        jmitCadHabNucleo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitCadHabNucleoActionPerformed(evt);
            }
        });
        jmenGerenciamentoCadHab.add(jmitCadHabNucleo);

        jmenGerenciamento.add(jmenGerenciamentoCadHab);

        jmenGerenciamentoRecurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/brick.png"))); // NOI18N
        jmenGerenciamentoRecurso.setText("Recursos");
        jmenGerenciamentoRecurso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitRecursoMobilidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitRecursoMobilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/ways.png"))); // NOI18N
        jmitRecursoMobilidade.setText("Recurso de Acesso");
        jmitRecursoMobilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitRecursoMobilidadeActionPerformed(evt);
            }
        });
        jmenGerenciamentoRecurso.add(jmitRecursoMobilidade);

        jmitRecursoSocial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitRecursoSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/building.png"))); // NOI18N
        jmitRecursoSocial.setText("Recurso Social");
        jmitRecursoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitRecursoSocialActionPerformed(evt);
            }
        });
        jmenGerenciamentoRecurso.add(jmitRecursoSocial);

        jmitRecursoSecretaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitRecursoSecretaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/secretary.png"))); // NOI18N
        jmitRecursoSecretaria.setText("Secretaria");
        jmitRecursoSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitRecursoSecretariaActionPerformed(evt);
            }
        });
        jmenGerenciamentoRecurso.add(jmitRecursoSecretaria);

        jmenGerenciamento.add(jmenGerenciamentoRecurso);

        jmbarSuperior.add(jmenGerenciamento);

        jmenRelatorio.setText("Relatórios");
        jmenRelatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmbarSuperior.add(jmenRelatorio);

        jmenFerramenta.setText("Ferramentas");
        jmenFerramenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitFerramentaConfigurarServidor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitFerramentaConfigurarServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/server.png"))); // NOI18N
        jmitFerramentaConfigurarServidor.setText("Configurações do Servidor");
        jmitFerramentaConfigurarServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitFerramentaConfigurarServidorActionPerformed(evt);
            }
        });
        jmenFerramenta.add(jmitFerramentaConfigurarServidor);

        jmbarSuperior.add(jmenFerramenta);

        jmenJanela.setText("Janelas");
        jmenJanela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jmitJanelaCascata.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitJanelaCascata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/cascade.png"))); // NOI18N
        jmitJanelaCascata.setText("Organizar em Cascata");
        jmitJanelaCascata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitJanelaCascataActionPerformed(evt);
            }
        });
        jmenJanela.add(jmitJanelaCascata);
        jmenJanela.add(jsepJanelas);

        jmitJanelaFecharTodas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmitJanelaFecharTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/windowclose.png"))); // NOI18N
        jmitJanelaFecharTodas.setText("Fechar Todas as Janelas");
        jmitJanelaFecharTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitJanelaFecharTodasActionPerformed(evt);
            }
        });
        jmenJanela.add(jmitJanelaFecharTodas);

        jmbarSuperior.add(jmenJanela);

        jmenSobre.setText("Sobre");
        jmenSobre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmbarSuperior.add(jmenSobre);

        jmenAjuda.setText("Ajuda");
        jmenAjuda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jmbarSuperior.add(jmenAjuda);

        setJMenuBar(jmbarSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdktDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(jpnlBarraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdktDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmitCadHabNucleoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitCadHabNucleoActionPerformed
        
        if (fGerenciarNucleo == null)
            fGerenciarNucleo = new FormGerenciarNucleo();
        
        if (fGerenciarNucleo.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarNucleo);
            fGerenciarNucleo.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitCadHabNucleoActionPerformed

    private void jmitCadHabImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitCadHabImovelActionPerformed
        
        if (fGerenciarImovel == null)
            fGerenciarImovel = new FormGerenciarImovel();
        
        if (fGerenciarImovel.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarImovel);
            fGerenciarImovel.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitCadHabImovelActionPerformed

    private void jmitCadHabIndividuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitCadHabIndividuoActionPerformed
        
        if (fGerenciarIndividuo == null)
            fGerenciarIndividuo = new FormGerenciarIndividuo();
        
        if (fGerenciarIndividuo.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarIndividuo);
            fGerenciarIndividuo.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitCadHabIndividuoActionPerformed

    private void jmitRecursoMobilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitRecursoMobilidadeActionPerformed
        
        if (fGerenciarRecursoMobilidade == null)
            fGerenciarRecursoMobilidade = new FormGerenciarRecursoMobilidade();
        
        if (fGerenciarRecursoMobilidade.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarRecursoMobilidade);
            fGerenciarRecursoMobilidade.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitRecursoMobilidadeActionPerformed

    private void jmitRecursoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitRecursoSocialActionPerformed
        
        if (fGerenciarRecursoSocial == null)
            fGerenciarRecursoSocial = new FormGerenciarRecursoSocial();
        
        if (fGerenciarRecursoSocial.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarRecursoSocial);
            fGerenciarRecursoSocial.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitRecursoSocialActionPerformed

    private void jmitCadHabFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitCadHabFamiliaActionPerformed
        
        if (fGerenciarFamilia == null)
            fGerenciarFamilia = new FormGerenciarFamilia();
        
        if (fGerenciarFamilia.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarFamilia);
            fGerenciarFamilia.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitCadHabFamiliaActionPerformed

    private void jmitCadHabEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitCadHabEmpresaActionPerformed
        
        if (fGerenciarEmpresa == null)
            fGerenciarEmpresa = new FormGerenciarEmpresa();
        
        if (fGerenciarEmpresa.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarEmpresa);
            fGerenciarEmpresa.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitCadHabEmpresaActionPerformed

    private void jmitJanelaCascataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitJanelaCascataActionPerformed
        
        try {
            
            javax.swing.JInternalFrame[] frames = jdktDesktop.getAllFrames();
            int width = 0;
            int height = 0;

            for (short i = 0; i < frames.length; i++) {
                if (frames[i].isIcon())
                    frames[i].setIcon(false);
                frames[i].setBounds(width, height, frames[i].getWidth(), frames[i].getHeight());
                frames[i].moveToFront();
                width = height += 25;
            }
        
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
        }
        
    }//GEN-LAST:event_jmitJanelaCascataActionPerformed

    private void jmitAcessoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitAcessoGrupoActionPerformed
        
        if (fGerenciarGrupo == null)
            fGerenciarGrupo = new FormGerenciarGrupo();
        
        if (fGerenciarGrupo.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarGrupo);
            fGerenciarGrupo.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitAcessoGrupoActionPerformed

    private void jmitAcessoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitAcessoUsuarioActionPerformed
        
        if (fGerenciarUsuario == null)
            fGerenciarUsuario = new FormGerenciarUsuario();
        
        if (fGerenciarUsuario.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarUsuario);
            fGerenciarUsuario.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitAcessoUsuarioActionPerformed

    private void jmitRecursoSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitRecursoSecretariaActionPerformed
        
        if (fGerenciarSecretaria == null)
            fGerenciarSecretaria = new FormGerenciarDepartamento();
        
        if (fGerenciarSecretaria.getDesktopPane() == null) {
            jdktDesktop.add(fGerenciarSecretaria);
            fGerenciarSecretaria.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitRecursoSecretariaActionPerformed

    private void jmitFerramentaConfigurarServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitFerramentaConfigurarServidorActionPerformed
        
        if (fFerramentaConfigurarServidor == null)
            fFerramentaConfigurarServidor = new FormFerramentaConfigurarServidor();
        
        if (fFerramentaConfigurarServidor.getDesktopPane() == null) {
            jdktDesktop.add(fFerramentaConfigurarServidor);
            fFerramentaConfigurarServidor.setVisible(true);
        }
        
    }//GEN-LAST:event_jmitFerramentaConfigurarServidorActionPerformed

    private void jmitPrincipalSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitPrincipalSairActionPerformed
        
        java.lang.Object[] options = {"Sim", "Não"};
        java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente sair do sistema?", "Confirmação",
                javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                options, options[1]);
            
        if (opcao.toString().equals("0")) {
                
            System.exit(0);
            
        }
        
    }//GEN-LAST:event_jmitPrincipalSairActionPerformed

    private void jmitPrincipalLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitPrincipalLogoffActionPerformed
        
        java.lang.Object[] options = {"Sim", "Não"};
        java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente fazer logoff do sistema?", "Confirmação",
                javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                options, options[1]);
            
        if (opcao.toString().equals("0")) {
                
            javax.swing.JInternalFrame[] frames = jdktDesktop.getAllFrames();
            
            for (int i = 0; i < frames.length; i++) {
                
                frames[i].dispose();
                
            }
            
            cadhab.CadHab.usuario = null;
            FormLogon logon = new FormLogon(this, true);
            logon.setVisible(true);
            
        }
        
    }//GEN-LAST:event_jmitPrincipalLogoffActionPerformed

    private void jmitJanelaFecharTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitJanelaFecharTodasActionPerformed
        
        javax.swing.JInternalFrame[] janelas = jdktDesktop.getAllFrames();
        
        for (int i = 0; i < janelas.length; i++)
            janelas[i].dispose();
        
    }//GEN-LAST:event_jmitJanelaFecharTodasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jdktDesktop;
    private javax.swing.JLabel jlblStatusServidor;
    private javax.swing.JMenuBar jmbarSuperior;
    private javax.swing.JMenu jmenAjuda;
    private javax.swing.JMenu jmenFerramenta;
    private javax.swing.JMenu jmenGerenciamento;
    private javax.swing.JMenu jmenGerenciamentoAcesso;
    private javax.swing.JMenu jmenGerenciamentoCadHab;
    private javax.swing.JMenu jmenGerenciamentoRecurso;
    private javax.swing.JMenu jmenJanela;
    private javax.swing.JMenu jmenPrincipal;
    private javax.swing.JMenu jmenRelatorio;
    private javax.swing.JMenu jmenSobre;
    private javax.swing.JMenuItem jmitAcessoGrupo;
    private javax.swing.JMenuItem jmitAcessoUsuario;
    private javax.swing.JMenuItem jmitCadHabEmpresa;
    private javax.swing.JMenuItem jmitCadHabFamilia;
    private javax.swing.JMenuItem jmitCadHabImovel;
    private javax.swing.JMenuItem jmitCadHabIndividuo;
    private javax.swing.JMenuItem jmitCadHabNucleo;
    private javax.swing.JMenuItem jmitFerramentaConfigurarServidor;
    private javax.swing.JMenuItem jmitJanelaCascata;
    private javax.swing.JMenuItem jmitJanelaFecharTodas;
    private javax.swing.JMenuItem jmitPrincipalLogoff;
    private javax.swing.JMenuItem jmitPrincipalSair;
    private javax.swing.JMenuItem jmitPrincipalTrocarSenha;
    private javax.swing.JMenuItem jmitRecursoMobilidade;
    private javax.swing.JMenuItem jmitRecursoSecretaria;
    private javax.swing.JMenuItem jmitRecursoSocial;
    private javax.swing.JPanel jpnlBarraStatus;
    private javax.swing.JPopupMenu.Separator jsepJanelas;
    private javax.swing.JPopupMenu.Separator jsepPrincipal;
    private javax.swing.JSeparator jsepStatusServidor;
    // End of variables declaration//GEN-END:variables
}
