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
public class FormGerenciarDepartamento extends javax.swing.JInternalFrame {
    
    private char acao = ' ';

    /**
     * Creates new form FormGerenciarDepartamento
     */
    public FormGerenciarDepartamento() {
        
        initComponents();
        
        try {
            
            com.sys.SystemSettings.setSystemThemeNimbus();
            
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
        }
        
        limparCampos();
        desabilitarCampos();
        desabilitarBotoes();
        jbtnNovo.setEnabled(true);
        
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
        jpnlTabelaPesquisa = new javax.swing.JPanel();
        jscpTabelaPesquisa = new javax.swing.JScrollPane();
        jtblPesquisa = new javax.swing.JTable();
        jlblNome = new javax.swing.JLabel();
        jtxtNome = new javax.swing.JTextField();
        jlblDescricao = new javax.swing.JLabel();
        jpnlTextAreaDescricao = new javax.swing.JPanel();
        jscpTextAreaDescricao = new javax.swing.JScrollPane();
        jtxtaDescricao = new javax.swing.JTextArea();
        jlblAtivo = new javax.swing.JLabel();
        jcbbAtivo = new javax.swing.JComboBox();
        jsepRodape = new javax.swing.JSeparator();
        jbtnNovo = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();
        jlblSigla = new javax.swing.JLabel();
        jtxtSigla = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("CadHab - Gerenciamento de Secretarias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/secretary.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jpnlPrincipal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.setLayout(null);

        jtblPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Sigla", "Nome", "Descrição", "Ativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblPesquisa.setNextFocusableComponent(jtxtSigla);
        jtblPesquisa.getTableHeader().setReorderingAllowed(false);
        jtblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblPesquisaMouseClicked(evt);
            }
        });
        jtblPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblPesquisaKeyPressed(evt);
            }
        });
        jscpTabelaPesquisa.setViewportView(jtblPesquisa);
        jtblPesquisa.getColumnModel().getColumn(0).setResizable(false);
        jtblPesquisa.getColumnModel().getColumn(0).setMinWidth(0);
        jtblPesquisa.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtblPesquisa.getColumnModel().getColumn(0).setMaxWidth(0);
        jtblPesquisa.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtblPesquisa.getColumnModel().getColumn(2).setPreferredWidth(300);
        jtblPesquisa.getColumnModel().getColumn(3).setPreferredWidth(400);
        jtblPesquisa.getColumnModel().getColumn(4).setPreferredWidth(100);

        javax.swing.GroupLayout jpnlTabelaPesquisaLayout = new javax.swing.GroupLayout(jpnlTabelaPesquisa);
        jpnlTabelaPesquisa.setLayout(jpnlTabelaPesquisaLayout);
        jpnlTabelaPesquisaLayout.setHorizontalGroup(
            jpnlTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscpTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jpnlTabelaPesquisaLayout.setVerticalGroup(
            jpnlTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscpTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jpnlPrincipal.add(jpnlTabelaPesquisa);
        jpnlTabelaPesquisa.setBounds(10, 10, 760, 300);

        jlblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblNome.setText("Nome:");
        jpnlPrincipal.add(jlblNome);
        jlblNome.setBounds(10, 350, 70, 25);

        jtxtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtNome.setNextFocusableComponent(jtxtaDescricao);
        jtxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNomeKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jtxtNome);
        jtxtNome.setBounds(90, 350, 680, 25);

        jlblDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblDescricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblDescricao.setText("Descrição:");
        jpnlPrincipal.add(jlblDescricao);
        jlblDescricao.setBounds(10, 380, 70, 25);

        jtxtaDescricao.setColumns(20);
        jtxtaDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtaDescricao.setRows(5);
        jtxtaDescricao.setNextFocusableComponent(jcbbAtivo);
        jtxtaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtaDescricaoKeyPressed(evt);
            }
        });
        jscpTextAreaDescricao.setViewportView(jtxtaDescricao);

        javax.swing.GroupLayout jpnlTextAreaDescricaoLayout = new javax.swing.GroupLayout(jpnlTextAreaDescricao);
        jpnlTextAreaDescricao.setLayout(jpnlTextAreaDescricaoLayout);
        jpnlTextAreaDescricaoLayout.setHorizontalGroup(
            jpnlTextAreaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscpTextAreaDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jpnlTextAreaDescricaoLayout.setVerticalGroup(
            jpnlTextAreaDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscpTextAreaDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jpnlPrincipal.add(jpnlTextAreaDescricao);
        jpnlTextAreaDescricao.setBounds(90, 380, 680, 100);

        jlblAtivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblAtivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblAtivo.setText("Ativo:");
        jpnlPrincipal.add(jlblAtivo);
        jlblAtivo.setBounds(10, 485, 70, 25);

        jcbbAtivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbbAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma opção", "Sim", "Não" }));
        jcbbAtivo.setNextFocusableComponent(jbtnNovo);
        jcbbAtivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbbAtivoKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jcbbAtivo);
        jcbbAtivo.setBounds(90, 485, 680, 25);
        jpnlPrincipal.add(jsepRodape);
        jsepRodape.setBounds(10, 520, 760, 2);

        jbtnNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/new.png"))); // NOI18N
        jbtnNovo.setText("Novo");
        jbtnNovo.setIconTextGap(10);
        jbtnNovo.setNextFocusableComponent(jbtnSalvar);
        jbtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNovoActionPerformed(evt);
            }
        });
        jbtnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnNovoKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnNovo);
        jbtnNovo.setBounds(130, 530, 120, 30);

        jbtnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/save.png"))); // NOI18N
        jbtnSalvar.setText("Salvar");
        jbtnSalvar.setIconTextGap(10);
        jbtnSalvar.setNextFocusableComponent(jbtnEditar);
        jbtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalvarActionPerformed(evt);
            }
        });
        jbtnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnSalvarKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnSalvar);
        jbtnSalvar.setBounds(260, 530, 120, 30);

        jbtnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/edit.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setIconTextGap(10);
        jbtnEditar.setNextFocusableComponent(jbtnLimpar);
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jbtnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnEditarKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnEditar);
        jbtnEditar.setBounds(390, 530, 120, 30);

        jbtnLimpar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/clear.png"))); // NOI18N
        jbtnLimpar.setText("Limpar");
        jbtnLimpar.setIconTextGap(10);
        jbtnLimpar.setNextFocusableComponent(jbtnExcluir);
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });
        jbtnLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnLimparKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnLimpar);
        jbtnLimpar.setBounds(520, 530, 120, 30);

        jbtnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/delete.png"))); // NOI18N
        jbtnExcluir.setText("Excluir");
        jbtnExcluir.setIconTextGap(10);
        jbtnExcluir.setNextFocusableComponent(jtblPesquisa);
        jbtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirActionPerformed(evt);
            }
        });
        jbtnExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtnExcluirKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jbtnExcluir);
        jbtnExcluir.setBounds(650, 530, 120, 30);

        jlblSigla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblSigla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSigla.setText("Sigla:");
        jpnlPrincipal.add(jlblSigla);
        jlblSigla.setBounds(10, 320, 70, 25);

        jtxtSigla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtSigla.setNextFocusableComponent(jtxtNome);
        jtxtSigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtSiglaKeyPressed(evt);
            }
        });
        jpnlPrincipal.add(jtxtSigla);
        jtxtSigla.setBounds(90, 320, 190, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNovoActionPerformed
        
        criarNovo();
        
    }//GEN-LAST:event_jbtnNovoActionPerformed

    private void jbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalvarActionPerformed
        
        salvar();
        
    }//GEN-LAST:event_jbtnSalvarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        
        editar();
        
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        
        limparCampos();
        
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        
        excluir();
        
    }//GEN-LAST:event_jbtnExcluirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        
        preencherTabelaPesquisa();
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void jtblPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblPesquisaMouseClicked
        
        if (evt.getClickCount() == 2) {
                
            carregarDados();
            
        }
        
    }//GEN-LAST:event_jtblPesquisaMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
        resetarForm();
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void jtblPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblPesquisaKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jtblPesquisaKeyPressed

    private void jtxtSiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSiglaKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jtxtSiglaKeyPressed

    private void jtxtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNomeKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jtxtNomeKeyPressed

    private void jtxtaDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtaDescricaoKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jtxtaDescricaoKeyPressed

    private void jcbbAtivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbbAtivoKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jcbbAtivoKeyPressed

    private void jbtnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnNovoKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnNovoKeyPressed

    private void jbtnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnSalvarKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnSalvarKeyPressed

    private void jbtnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnEditarKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnEditarKeyPressed

    private void jbtnLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnLimparKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnLimparKeyPressed

    private void jbtnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtnExcluirKeyPressed
        
        atalho(evt);
        
    }//GEN-LAST:event_jbtnExcluirKeyPressed

    private void preencherTabelaPesquisa() {
        
        try {
            
            java.lang.Object output = cadhab.conn.ConnectionManager.connect("/departamentos?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), "");
                    
            if (output != null) {
                
                if (output instanceof java.util.List) {

                    java.util.List<com.common.Departamento> departamentos = (java.util.List<com.common.Departamento>) output;
                    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jtblPesquisa.getModel();
                    modelo.setNumRows(0);
                    
                    for (com.common.Departamento cursor : departamentos) {
                        
                        modelo.addRow(new java.lang.Object[] { cursor.getId(), cursor.getSigla(), cursor.getNome(), cursor.getDescricao(), cursor.getAtivo() });
                        
                    }

                }
                
            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar/obter as informações para/do servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void criarNovo() {
        
        limparCampos();
        habilitarCampos();
        desabilitarBotoes();
        jbtnNovo.setEnabled(true);
        jbtnSalvar.setEnabled(true);
        acao = 'N';
        
    }
    
    private void salvar() {
        
        try {
            
            String sigla = jtxtSigla.getText().toUpperCase();
            String nome = jtxtNome.getText();
            String descricao = jtxtaDescricao.getText();
            String ativo = jcbbAtivo.getSelectedItem().toString();
            
            if (! sigla.isEmpty() && ! nome.isEmpty() && jcbbAtivo.getSelectedIndex() > 0) {
                
                com.common.Departamento departamento = new com.common.Departamento();
                departamento.setSigla(sigla);
                departamento.setNome(nome);
                departamento.setDescricao(descricao);
                departamento.setAtivo(ativo);
                
                com.util.JsonManager jsonMgr = new com.util.JsonManager();
                String input = jsonMgr.parseJson(departamento);
                
                java.lang.Object output = cadhab.conn.ConnectionManager.connect("/departamento/sigla?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);
                    
                if (output == null) {
                    
                    java.lang.Object[] options = {"Sim", "Não"};
                    java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente inserir a nova secretaria no sistema?", "CadHab",
                            javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                            options, options[1]);

                    if (opcao.toString().equals("0")) {
                    
                        output = cadhab.conn.ConnectionManager.connect("/departamento/salvar?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);

                        if (output instanceof com.sys.Message) {

                            com.sys.Message mensagem = (com.sys.Message) output;
                            javax.swing.JOptionPane.showMessageDialog(this, mensagem.getMessage(), "CadHab", mensagem.getCode());
                            limparCampos();
                            desabilitarCampos();
                            desabilitarBotoes();
                            jbtnNovo.setEnabled(true);
                            preencherTabelaPesquisa();
                            acao = ' ';

                        }
                    
                    }
                    
                } else {
                        
                    javax.swing.JOptionPane.showMessageDialog(this, "Já existe uma secretaria com esta sigla cadastrada no sistema!", "CadHab", 2);
                        
                }
                
            } else {
                
                javax.swing.JOptionPane.showMessageDialog(this, "Verifique se todos os campos obrigatórios se encontram preenchidos e/ou selecionados!", "CadHab", 2);
                
            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar/obter as informações para/do servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void editar() {
        
        try {
            
            String sigla = jtxtSigla.getText().toUpperCase();
            String nome = jtxtNome.getText();
            String descricao = jtxtaDescricao.getText();
            String ativo = jcbbAtivo.getSelectedItem().toString();
            
            if (! sigla.isEmpty() && ! nome.isEmpty() && jcbbAtivo.getSelectedIndex() > 0) {
                
                com.common.Departamento departamento = new com.common.Departamento();
                departamento.setId(Integer.parseInt(jtblPesquisa.getModel().getValueAt(jtblPesquisa.getSelectedRow(), 0).toString()));
                departamento.setSigla(sigla);
                departamento.setNome(nome);
                departamento.setDescricao(descricao);
                departamento.setAtivo(ativo);
                
                com.util.JsonManager jsonMgr = new com.util.JsonManager();
                String input = jsonMgr.parseJson(departamento);
                
                java.lang.Object output = cadhab.conn.ConnectionManager.connect("/departamento/id?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);
                
                if (output != null) {
                    
                    java.lang.Object[] options = {"Sim", "Não"};
                    java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente atualizar os dados da secretaria no sistema?", "CadHab",
                            javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                            options, options[1]);

                    if (opcao.toString().equals("0")) {
                        
                        output = cadhab.conn.ConnectionManager.connect("/departamento/atualizar?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);

                        if (output instanceof com.sys.Message) {

                            com.sys.Message mensagem = (com.sys.Message) output;
                            javax.swing.JOptionPane.showMessageDialog(this, mensagem.getMessage(), "CadHab", mensagem.getCode());
                            limparCampos();
                            desabilitarCampos();
                            desabilitarBotoes();
                            jbtnNovo.setEnabled(true);
                            preencherTabelaPesquisa();
                            acao = ' ';

                        }
                        
                    }
                    
                } else {
                        
                    javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar o registro da secretaria no sistema!", "CadHab", 2);
                        
                }
                
            } else {
                
                javax.swing.JOptionPane.showMessageDialog(this, "Verifique se todos os campos obrigatórios se encontram preenchidos e/ou selecionados!", "CadHab", 2);
                
            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar/obter as informações para/do servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void excluir() {
        
        try {
            
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(Integer.parseInt(jtblPesquisa.getModel().getValueAt(jtblPesquisa.getSelectedRow(), 0).toString()));
            
            com.util.JsonManager jsonMgr = new com.util.JsonManager();
            String input = jsonMgr.parseJson(departamento);
                
            java.lang.Object output = cadhab.conn.ConnectionManager.connect("/departamento/id?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);
            
            if (output != null) {
                
                java.lang.Object[] options = {"Sim", "Não"};
                java.lang.Object opcao = javax.swing.JOptionPane.showOptionDialog(this, "Deseja realmente excluir esta secretaria do sistema?", "CadHab",
                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null,
                        options, options[1]);

                if (opcao.toString().equals("0")) {
                        
                    output = cadhab.conn.ConnectionManager.connect("/departamento/excluir?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);

                    if (output instanceof com.sys.Message) {

                        com.sys.Message mensagem = (com.sys.Message) output;
                        javax.swing.JOptionPane.showMessageDialog(this, mensagem.getMessage(), "CadHab", mensagem.getCode());
                        limparCampos();
                        desabilitarCampos();
                        desabilitarBotoes();
                        jbtnNovo.setEnabled(true);
                        preencherTabelaPesquisa();
                        acao = ' ';

                    }
                        
                }
                
            } else {
                        
                javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar o registro da secretaria no sistema!", "CadHab", 2);
                        
            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar/obter as informações para/do servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void carregarDados() {
        
        try {

            if (jtblPesquisa.getSelectedRow() >= 0) {

                com.common.Departamento departamento = new com.common.Departamento();
                departamento.setId(Integer.parseInt(jtblPesquisa.getModel().getValueAt(jtblPesquisa.getSelectedRow(), 0).toString()));
                    
                com.util.JsonManager jsonMgr = new com.util.JsonManager();
                String input = jsonMgr.parseJson(departamento);
                    
                java.lang.Object output = cadhab.conn.ConnectionManager.connect("/departamento/id?auth_token=" + cadhab.CadHab.usuario.getToken() + "&auth_key=" + cadhab.CadHab.usuario.getUserKey(), input);
                    
                if (output != null) {
                        
                    if (output instanceof com.common.Departamento) {
                            
                        departamento = (com.common.Departamento) output;
                        jtxtSigla.setText(departamento.getSigla());
                        jtxtNome.setText(departamento.getNome());
                        jtxtaDescricao.setText(departamento.getDescricao());
                        jcbbAtivo.setSelectedItem(departamento.getAtivo());
                            
                        habilitarCampos();
                        habilitarBotoes();
                        jbtnSalvar.setEnabled(false);
                        acao = 'U';
                           
                    } else if (output instanceof com.sys.Message) {
                            
                        com.sys.Message mensagem = (com.sys.Message) output;
                        javax.swing.JOptionPane.showMessageDialog(this, mensagem.getMessage(), "CadHab", mensagem.getCode());
                            
                    }
                        
                } else {
                        
                    javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar a secretaria selecionada!", "CadHab", 0);
                        
                }

            }
            
        } catch (java.net.MalformedURLException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível encontrar um caminho até o servidor!Verifique se as configurações do servidor estão corretas.", "CadHab", 0);
            
        } catch (java.net.ConnectException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "O servidor do CadHab está temporariamente fora do ar!\nTente novamente mais tarde.", "CadHab", 0);
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Não foi possível enviar/obter as informações para/do servidor!", "CadHab", 0);
            
        } catch (java.lang.Exception ex) {
            
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "CadHab", 0);
            
        }
        
    }
    
    private void atalho(java.awt.event.KeyEvent evt) {
        
        if (evt.isControlDown()) {
        
            switch (evt.getKeyCode()) {
                
                case java.awt.event.KeyEvent.VK_D: {
                    if (acao == 'U')
                        excluir();
                }
                    break;
                    
                case java.awt.event.KeyEvent.VK_E: {
                    if (acao == 'U')
                        editar();
                }
                    break;
                    
                case java.awt.event.KeyEvent.VK_L: {
                    if (acao == 'N' || acao == 'U')
                        limparCampos();
                }
                    break;

                case java.awt.event.KeyEvent.VK_N: {
                    criarNovo();
                }
                    break;
                    
                case java.awt.event.KeyEvent.VK_S: {
                    if (acao == 'N')
                        salvar();
                }
                    break;

            }
        
        } else {
            
            switch (evt.getKeyCode()) {
                
                case java.awt.event.KeyEvent.VK_ESCAPE: {
                    resetarForm();
                    this.doDefaultCloseAction();
                }
                    break;
                
                case java.awt.event.KeyEvent.VK_F5: {
                    preencherTabelaPesquisa();
                }
                    break;
                    
                case java.awt.event.KeyEvent.VK_F6: {
                    carregarDados();
                }
                    break;
                
            }
            
        }
        
    }
    
    private void limparCampos() {
        
        jtxtSigla.setText("");
        jtxtNome.setText("");
        jtxtaDescricao.setText("");
        jcbbAtivo.setSelectedIndex(0);
        
    }
    
    private void habilitarCampos() {
        
        jtxtSigla.setEnabled(true);
        jtxtNome.setEnabled(true);
        jtxtaDescricao.setEnabled(true);
        jcbbAtivo.setEnabled(true);
        
    }
    
    private void desabilitarCampos() {
        
        jtxtSigla.setEnabled(false);
        jtxtNome.setEnabled(false);
        jtxtaDescricao.setEnabled(false);
        jcbbAtivo.setEnabled(false);
        
    }
    
    private void habilitarBotoes() {
        
        jbtnNovo.setEnabled(true);
        jbtnSalvar.setEnabled(true);
        jbtnEditar.setEnabled(true);
        jbtnLimpar.setEnabled(true);
        jbtnExcluir.setEnabled(true);
        
    }
    
    private void desabilitarBotoes() {
        
        jbtnNovo.setEnabled(false);
        jbtnSalvar.setEnabled(false);
        jbtnEditar.setEnabled(false);
        jbtnLimpar.setEnabled(false);
        jbtnExcluir.setEnabled(false);
        
    }
    
    private void resetarForm() {
        
        limparCampos();
        desabilitarCampos();
        desabilitarBotoes();
        jbtnNovo.setEnabled(true);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnNovo;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox jcbbAtivo;
    private javax.swing.JLabel jlblAtivo;
    private javax.swing.JLabel jlblDescricao;
    private javax.swing.JLabel jlblNome;
    private javax.swing.JLabel jlblSigla;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JPanel jpnlTabelaPesquisa;
    private javax.swing.JPanel jpnlTextAreaDescricao;
    private javax.swing.JScrollPane jscpTabelaPesquisa;
    private javax.swing.JScrollPane jscpTextAreaDescricao;
    private javax.swing.JSeparator jsepRodape;
    private javax.swing.JTable jtblPesquisa;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JTextField jtxtSigla;
    private javax.swing.JTextArea jtxtaDescricao;
    // End of variables declaration//GEN-END:variables
}