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
public class EscolaridadeIndividuoDAO {
    
    public EscolaridadeIndividuoDAO() {
        
    }
    
    public int inserirEscolaridadeIndividuo(com.sys.social.EscolaridadeIndividuo escolaridade) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_escolaridade_individuo(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, escolaridade.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(escolaridade.getLeEscreve()));
        stmt.setString(4, txtMgr.addSlashes(escolaridade.getGrauEscolaridade()));
        stmt.setString(5, txtMgr.addSlashes(escolaridade.getUnidadeEducacional()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.EscolaridadeIndividuo selecionarEscolaridadeIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_escolaridade_individuo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.social.EscolaridadeIndividuo selecionarEscolaridadeIndividuoPorIDIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_escolaridade_individuo_por_id_individuo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, individuo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarEscolaridadeIndividuo(com.sys.social.EscolaridadeIndividuo escolaridade) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_escolaridade_individuo(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, escolaridade.getIndividuo().getId());
        stmt.setString(3, txtMgr.addSlashes(escolaridade.getLeEscreve()));
        stmt.setString(4, txtMgr.addSlashes(escolaridade.getGrauEscolaridade()));
        stmt.setString(5, txtMgr.addSlashes(escolaridade.getUnidadeEducacional()));
        stmt.setLong(6, escolaridade.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirEscolaridadeIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_escolaridade_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.EscolaridadeIndividuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id_individuo"));
            
            com.sys.social.EscolaridadeIndividuo escolaridade = new com.sys.social.EscolaridadeIndividuo(individuo);
            escolaridade.setId(rs.getLong("id"));
            escolaridade.setLeEscreve(rs.getString("le_escreve"));
            escolaridade.setGrauEscolaridade(rs.getString("grau_escolaridade"));
            escolaridade.setUnidadeEducacional(rs.getString("unidade_educacional"));
            
            return escolaridade;
        } else {
            return null;
        }
        
    }
    
}
