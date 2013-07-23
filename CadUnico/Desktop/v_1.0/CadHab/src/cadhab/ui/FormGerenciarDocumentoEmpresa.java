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
public class FormGerenciarDocumentoEmpresa extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormGerenciarDocumentoEmpresa
     */
    public FormGerenciarDocumentoEmpresa() {
        
        initComponents();
        
        try {
            
            com.sys.SystemSettings.setSystemThemeNimbus();
            
        } catch (java.lang.Exception ex) {
            
            ex.printStackTrace();
            
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

        jpnlPrincipal = new javax.swing.JPanel();
        jlblEmpresa = new javax.swing.JLabel();
        jtxtIdEmpresa = new javax.swing.JTextField();
        jtxtNomeEmpresa = new javax.swing.JTextField();
        jlblTipo = new javax.swing.JLabel();
        jcbbTipo = new javax.swing.JComboBox();
        jlblDataEmissao = new javax.swing.JLabel();
        jtxtDataEmissao = new javax.swing.JFormattedTextField();
        jlblNumero = new javax.swing.JLabel();
        jtxtNumero = new javax.swing.JFormattedTextField();
        jlblOrgaoEmissor = new javax.swing.JLabel();
        jcbbOrgaoEmissor = new javax.swing.JComboBox();
        jlblSerie = new javax.swing.JLabel();
        jtxtSerie = new javax.swing.JTextField();
        jlblCategoria = new javax.swing.JLabel();
        jcbbCategoria = new javax.swing.JComboBox();
        jlblZona = new javax.swing.JLabel();
        jtxtZona = new javax.swing.JTextField();
        jlblSecao = new javax.swing.JLabel();
        jtxtSecao = new javax.swing.JTextField();
        jlblValidade = new javax.swing.JLabel();
        jtxtValidade = new javax.swing.JTextField();
        jlblUf = new javax.swing.JLabel();
        jcbbUf = new javax.swing.JComboBox();
        jlblCidade = new javax.swing.JLabel();
        jtxtCidade = new javax.swing.JTextField();
        jlblStatus = new javax.swing.JLabel();
        jtxtStatus = new javax.swing.JTextField();
        jsepRodape = new javax.swing.JSeparator();
        jbtnNovo = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CadHab - Gerenciamento de Documentos da Empresa");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/document.png"))); // NOI18N

        jpnlPrincipal.setLayout(null);

        jlblEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblEmpresa.setText("Empresa:");
        jpnlPrincipal.add(jlblEmpresa);
        jlblEmpresa.setBounds(10, 10, 70, 25);

        jtxtIdEmpresa.setEditable(false);
        jtxtIdEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtIdEmpresa);
        jtxtIdEmpresa.setBounds(90, 10, 60, 25);

        jtxtNomeEmpresa.setEditable(false);
        jtxtNomeEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtNomeEmpresa);
        jtxtNomeEmpresa.setBounds(160, 10, 510, 25);

        jlblTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblTipo.setText("Tipo:");
        jpnlPrincipal.add(jlblTipo);
        jlblTipo.setBounds(10, 40, 70, 25);

        jcbbTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma opção", "Sim", "Não" }));
        jpnlPrincipal.add(jcbbTipo);
        jcbbTipo.setBounds(90, 40, 360, 25);

        jlblDataEmissao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblDataEmissao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblDataEmissao.setText("Data Emissão:");
        jpnlPrincipal.add(jlblDataEmissao);
        jlblDataEmissao.setBounds(460, 40, 90, 25);

        jtxtDataEmissao.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jtxtDataEmissao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtDataEmissao);
        jtxtDataEmissao.setBounds(560, 40, 110, 25);

        jlblNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblNumero.setText("Número:");
        jpnlPrincipal.add(jlblNumero);
        jlblNumero.setBounds(10, 70, 70, 25);

        jtxtNumero.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jtxtNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtNumero);
        jtxtNumero.setBounds(90, 70, 360, 25);

        jlblOrgaoEmissor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblOrgaoEmissor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblOrgaoEmissor.setText("Órgão Emissor:");
        jpnlPrincipal.add(jlblOrgaoEmissor);
        jlblOrgaoEmissor.setBounds(460, 70, 90, 25);

        jcbbOrgaoEmissor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbbOrgaoEmissor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Sim", "Não" }));
        jpnlPrincipal.add(jcbbOrgaoEmissor);
        jcbbOrgaoEmissor.setBounds(560, 70, 110, 25);

        jlblSerie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblSerie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSerie.setText("Série:");
        jpnlPrincipal.add(jlblSerie);
        jlblSerie.setBounds(10, 100, 70, 25);

        jtxtSerie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtSerie);
        jtxtSerie.setBounds(90, 100, 250, 25);

        jlblCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblCategoria.setText("Categoria:");
        jpnlPrincipal.add(jlblCategoria);
        jlblCategoria.setBounds(350, 100, 70, 25);

        jcbbCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma opção", "Sim", "Não" }));
        jpnlPrincipal.add(jcbbCategoria);
        jcbbCategoria.setBounds(430, 100, 240, 25);

        jlblZona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblZona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblZona.setText("Zona:");
        jpnlPrincipal.add(jlblZona);
        jlblZona.setBounds(10, 130, 70, 25);

        jtxtZona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtZona);
        jtxtZona.setBounds(90, 130, 250, 25);

        jlblSecao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblSecao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblSecao.setText("Seção:");
        jpnlPrincipal.add(jlblSecao);
        jlblSecao.setBounds(350, 130, 70, 25);

        jtxtSecao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtSecao);
        jtxtSecao.setBounds(430, 130, 240, 25);

        jlblValidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblValidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblValidade.setText("Validade:");
        jpnlPrincipal.add(jlblValidade);
        jlblValidade.setBounds(10, 160, 70, 25);

        jtxtValidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtValidade);
        jtxtValidade.setBounds(90, 160, 400, 25);

        jlblUf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblUf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblUf.setText("UF:");
        jpnlPrincipal.add(jlblUf);
        jlblUf.setBounds(500, 160, 50, 25);

        jcbbUf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Sim", "Não" }));
        jpnlPrincipal.add(jcbbUf);
        jcbbUf.setBounds(560, 160, 110, 25);

        jlblCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblCidade.setText("Cidade:");
        jpnlPrincipal.add(jlblCidade);
        jlblCidade.setBounds(10, 190, 70, 25);

        jtxtCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtCidade);
        jtxtCidade.setBounds(90, 190, 580, 25);

        jlblStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblStatus.setText("Status:");
        jpnlPrincipal.add(jlblStatus);
        jlblStatus.setBounds(10, 220, 70, 25);

        jtxtStatus.setEditable(false);
        jtxtStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jpnlPrincipal.add(jtxtStatus);
        jtxtStatus.setBounds(90, 220, 580, 25);
        jpnlPrincipal.add(jsepRodape);
        jsepRodape.setBounds(10, 320, 660, 2);

        jbtnNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/new.png"))); // NOI18N
        jbtnNovo.setText("Novo");
        jbtnNovo.setIconTextGap(10);
        jpnlPrincipal.add(jbtnNovo);
        jbtnNovo.setBounds(160, 330, 120, 30);

        jbtnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/save.png"))); // NOI18N
        jbtnSalvar.setText("Salvar");
        jbtnSalvar.setIconTextGap(10);
        jpnlPrincipal.add(jbtnSalvar);
        jbtnSalvar.setBounds(290, 330, 120, 30);

        jbtnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/edit.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setIconTextGap(10);
        jpnlPrincipal.add(jbtnEditar);
        jbtnEditar.setBounds(420, 330, 120, 30);

        jbtnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadhab/ui/icon/delete.png"))); // NOI18N
        jbtnExcluir.setText("Excluir");
        jbtnExcluir.setIconTextGap(10);
        jpnlPrincipal.add(jbtnExcluir);
        jbtnExcluir.setBounds(550, 330, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnNovo;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox jcbbCategoria;
    private javax.swing.JComboBox jcbbOrgaoEmissor;
    private javax.swing.JComboBox jcbbTipo;
    private javax.swing.JComboBox jcbbUf;
    private javax.swing.JLabel jlblCategoria;
    private javax.swing.JLabel jlblCidade;
    private javax.swing.JLabel jlblDataEmissao;
    private javax.swing.JLabel jlblEmpresa;
    private javax.swing.JLabel jlblNumero;
    private javax.swing.JLabel jlblOrgaoEmissor;
    private javax.swing.JLabel jlblSecao;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JLabel jlblTipo;
    private javax.swing.JLabel jlblUf;
    private javax.swing.JLabel jlblValidade;
    private javax.swing.JLabel jlblZona;
    private javax.swing.JPanel jpnlPrincipal;
    private javax.swing.JSeparator jsepRodape;
    private javax.swing.JTextField jtxtCidade;
    private javax.swing.JFormattedTextField jtxtDataEmissao;
    private javax.swing.JTextField jtxtIdEmpresa;
    private javax.swing.JTextField jtxtNomeEmpresa;
    private javax.swing.JFormattedTextField jtxtNumero;
    private javax.swing.JTextField jtxtSecao;
    private javax.swing.JTextField jtxtSerie;
    private javax.swing.JTextField jtxtStatus;
    private javax.swing.JTextField jtxtValidade;
    private javax.swing.JTextField jtxtZona;
    // End of variables declaration//GEN-END:variables
}