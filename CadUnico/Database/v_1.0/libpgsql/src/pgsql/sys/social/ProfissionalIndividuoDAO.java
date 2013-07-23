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
public class ProfissionalIndividuoDAO {
    
    public ProfissionalIndividuoDAO() {
        
    }
    
    public int inserirProfissionalIndividuo(com.sys.social.ProfissionalIndividuo profissional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_profissional_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, profissional.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(profissional.getSituacaoTrabalhista()));
        stmt.setString(4, txtMgr.addSlashes(profissional.getObsSituacaoTrabalhista()));
        stmt.setString(5, txtMgr.addSlashes(profissional.getTipoTrabalho()));
        stmt.setString(6, txtMgr.addSlashes(profissional.getObsTipoTrabalho()));
        stmt.setString(7, txtMgr.addSlashes(profissional.getNomeTrabalho()));
        stmt.setString(8, txtMgr.addSlashes(profissional.getPossuiRenda()));
        stmt.setDouble(9, profissional.getRenda());
        stmt.setDouble(10, profissional.getOutrasRendas());
        stmt.setString(11, txtMgr.addSlashes(profissional.getTipoBeneficio()));
        stmt.setDouble(12, profissional.getDoacaoRegular());
        stmt.setDouble(13, profissional.getAposentadoriaPensao());
        stmt.setDouble(14, profissional.getSeguroDesemprego());
        stmt.setDouble(15, profissional.getPensaoAlimentar());
        stmt.setDouble(16, profissional.getOutrosBeneficios());
        stmt.setString(17, txtMgr.addSlashes(profissional.getNumeroBpcloas()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.ProfissionalIndividuo selecionarProfissionalIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_profissional_individuo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.social.ProfissionalIndividuo selecionarProfissionalIndividuoPorIDIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_profissional_individuo_por_id_individuo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, individuo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarProfissionalIndividuo(com.sys.social.ProfissionalIndividuo profissional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_profissional_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, profissional.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(profissional.getSituacaoTrabalhista()));
        stmt.setString(4, txtMgr.addSlashes(profissional.getObsSituacaoTrabalhista()));
        stmt.setString(5, txtMgr.addSlashes(profissional.getTipoTrabalho()));
        stmt.setString(6, txtMgr.addSlashes(profissional.getObsTipoTrabalho()));
        stmt.setString(7, txtMgr.addSlashes(profissional.getNomeTrabalho()));
        stmt.setString(8, txtMgr.addSlashes(profissional.getPossuiRenda()));
        stmt.setDouble(9, profissional.getRenda());
        stmt.setDouble(10, profissional.getOutrasRendas());
        stmt.setString(11, txtMgr.addSlashes(profissional.getTipoBeneficio()));
        stmt.setDouble(12, profissional.getDoacaoRegular());
        stmt.setDouble(13, profissional.getAposentadoriaPensao());
        stmt.setDouble(14, profissional.getSeguroDesemprego());
        stmt.setDouble(15, profissional.getPensaoAlimentar());
        stmt.setDouble(16, profissional.getOutrosBeneficios());
        stmt.setString(17, txtMgr.addSlashes(profissional.getNumeroBpcloas()));
        stmt.setLong(18, profissional.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirProfissionalIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_profissional_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.ProfissionalIndividuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id_individuo"));
            
            com.sys.social.ProfissionalIndividuo profissional = new com.sys.social.ProfissionalIndividuo(individuo);
            profissional.setId(rs.getLong("id"));
            profissional.setSituacaoTrabalhista(rs.getString("situacao_trabalhista"));
            profissional.setObsSituacaoTrabalhista(rs.getString("obs_situacao_trabalhista"));
            profissional.setTipoTrabalho(rs.getString("tipo_trabalho"));
            profissional.setObsTipoTrabalho(rs.getString("obs_tipo_trabalho"));
            profissional.setNomeTrabalho(rs.getString("nm_trabalho"));
            profissional.setPossuiRenda(rs.getString("possui_renda"));
            profissional.setRenda(rs.getDouble("renda"));
            profissional.setOutrasRendas(rs.getDouble("outras_rendas"));
            profissional.setTipoBeneficio(rs.getString("tipo_beneficio"));
            profissional.setDoacaoRegular(rs.getDouble("doacao_regular"));
            profissional.setAposentadoriaPensao(rs.getDouble("aposentadoria_pensao"));
            profissional.setSeguroDesemprego(rs.getDouble("seg_desemprego"));
            profissional.setPensaoAlimentar(rs.getDouble("pensao_alimentar"));
            profissional.setOutrosBeneficios(rs.getDouble("outros_beneficios"));
            profissional.setNumeroBpcloas(rs.getString("num_bpcloas"));
            
            return profissional;
        } else {
            return null;
        }
        
    }
    
}
