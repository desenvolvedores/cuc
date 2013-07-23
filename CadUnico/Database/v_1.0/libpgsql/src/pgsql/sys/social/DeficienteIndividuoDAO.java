/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.social;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DeficienteIndividuoDAO {
    
    public DeficienteIndividuoDAO() {
        
    }
    
    public int inserirDeficienteIndividuo(com.sys.social.DeficienteIndividuo deficiente) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_deficiente_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, deficiente.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(deficiente.getDeficiente()));
        stmt.setString(4, txtMgr.addSlashes(deficiente.getDeficienciaFisica()));
        stmt.setString(5, txtMgr.addSlashes(deficiente.getDeficienciaMental()));
        stmt.setString(6, txtMgr.addSlashes(deficiente.getTranstornoMental()));
        stmt.setString(7, txtMgr.addSlashes(deficiente.getSindromeDown()));
        stmt.setString(8, txtMgr.addSlashes(deficiente.getCegueira()));
        stmt.setString(9, txtMgr.addSlashes(deficiente.getBaixaVisao()));
        stmt.setString(10, txtMgr.addSlashes(deficiente.getSurdezSevera()));
        stmt.setString(11, txtMgr.addSlashes(deficiente.getSurdezModerada()));
        stmt.setString(12, txtMgr.addSlashes(deficiente.getObsTipoDeficiencia()));
        stmt.setString(13, txtMgr.addSlashes(deficiente.getCausaDeficiencia()));
        stmt.setString(14, txtMgr.addSlashes(deficiente.getObsCausaDeficiencia()));
        stmt.setString(15, txtMgr.addSlashes(deficiente.getQuandoAdquiriu()));
        stmt.setString(16, txtMgr.addSlashes(deficiente.getCuidadosFamilia()));
        stmt.setString(17, txtMgr.addSlashes(deficiente.getCuidadosEspecializado()));
        stmt.setString(18, txtMgr.addSlashes(deficiente.getCuidadosVizinho()));
        stmt.setString(19, txtMgr.addSlashes(deficiente.getCuidadosInstituicao()));
        stmt.setString(20, txtMgr.addSlashes(deficiente.getCuidadosOutros()));
        stmt.setString(21, txtMgr.addSlashes(deficiente.getCadastroSepedi()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.DeficienteIndividuo selecionarDeficienteIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_deficiente_individuo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.social.DeficienteIndividuo selecionarDeficienteIndividuoPorIDIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_deficiente_individuo_por_id_individuo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, individuo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarDeficienteIndividuo(com.sys.social.DeficienteIndividuo deficiente) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_deficiente_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, deficiente.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(deficiente.getDeficiente()));
        stmt.setString(4, txtMgr.addSlashes(deficiente.getDeficienciaFisica()));
        stmt.setString(5, txtMgr.addSlashes(deficiente.getDeficienciaMental()));
        stmt.setString(6, txtMgr.addSlashes(deficiente.getTranstornoMental()));
        stmt.setString(7, txtMgr.addSlashes(deficiente.getSindromeDown()));
        stmt.setString(8, txtMgr.addSlashes(deficiente.getCegueira()));
        stmt.setString(9, txtMgr.addSlashes(deficiente.getBaixaVisao()));
        stmt.setString(10, txtMgr.addSlashes(deficiente.getSurdezSevera()));
        stmt.setString(11, txtMgr.addSlashes(deficiente.getSurdezModerada()));
        stmt.setString(12, txtMgr.addSlashes(deficiente.getObsTipoDeficiencia()));
        stmt.setString(13, txtMgr.addSlashes(deficiente.getCausaDeficiencia()));
        stmt.setString(14, txtMgr.addSlashes(deficiente.getObsCausaDeficiencia()));
        stmt.setString(15, txtMgr.addSlashes(deficiente.getQuandoAdquiriu()));
        stmt.setString(16, txtMgr.addSlashes(deficiente.getCuidadosFamilia()));
        stmt.setString(17, txtMgr.addSlashes(deficiente.getCuidadosEspecializado()));
        stmt.setString(18, txtMgr.addSlashes(deficiente.getCuidadosVizinho()));
        stmt.setString(19, txtMgr.addSlashes(deficiente.getCuidadosInstituicao()));
        stmt.setString(20, txtMgr.addSlashes(deficiente.getCuidadosOutros()));
        stmt.setString(21, txtMgr.addSlashes(deficiente.getCadastroSepedi()));
        stmt.setLong(22, deficiente.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirDeficienteIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_deficiente_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.DeficienteIndividuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id_individuo"));
            
            com.sys.social.DeficienteIndividuo deficiente = new com.sys.social.DeficienteIndividuo(individuo);
            deficiente.setId(rs.getLong("id"));
            deficiente.setDeficiente(rs.getString("deficiente"));
            deficiente.setDeficienciaFisica(rs.getString("deficiencia_fisica"));
            deficiente.setDeficienciaMental(rs.getString("deficiencia_mental"));
            deficiente.setTranstornoMental(rs.getString("transtorno_mental"));
            deficiente.setSindromeDown(rs.getString("sindrome_down"));
            deficiente.setCegueira(rs.getString("cegueira"));
            deficiente.setBaixaVisao(rs.getString("baixa_visao"));
            deficiente.setSurdezSevera(rs.getString("surdez_severa"));
            deficiente.setSurdezModerada(rs.getString("surdez_moderada"));
            deficiente.setObsTipoDeficiencia(rs.getString("obs_tipo_deficiencia"));
            deficiente.setCausaDeficiencia(rs.getString("causa_deficiencia"));
            deficiente.setObsCausaDeficiencia(rs.getString("obs_causa_deficiencia"));
            deficiente.setQuandoAdquiriu(rs.getString("quando_adquiriu"));
            deficiente.setCuidadosFamilia(rs.getString("cuidados_familia"));
            deficiente.setCuidadosEspecializado(rs.getString("cuidados_especializado"));
            deficiente.setCuidadosVizinho(rs.getString("cuidados_vizinho"));
            deficiente.setCuidadosInstituicao(rs.getString("cuidados_instituicao"));
            deficiente.setCuidadosOutros(rs.getString("cuidados_outros"));
            deficiente.setCadastroSepedi(rs.getString("cadastro_sepedi"));
            
            return deficiente;
        } else {
            return null;
        }
        
    }
    
}
