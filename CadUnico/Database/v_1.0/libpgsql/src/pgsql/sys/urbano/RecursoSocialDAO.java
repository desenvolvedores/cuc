/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.urbano;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class RecursoSocialDAO {
    
    public RecursoSocialDAO() {
        
    }
    
    public int inserirRecursoSocial(com.sys.urbano.RecursoSocial recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_recurso_social(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(recurso.getNome()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.RecursoSocial selecionarRecursoSocialPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_recurso_social_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.RecursoSocial selecionarRecursoSocialPorNome(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_recurso_social_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nome);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.RecursoSocial> listarRecursosSociais() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_recurso_sociais";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarRecursoSocial(com.sys.urbano.RecursoSocial recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_recurso_social(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(recurso.getNome()));
        stmt.setInt(3, recurso.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirRecursoSocialPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_recurso_social(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.RecursoSocial selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id"));
            recurso.setNome(rs.getString("nome"));
            return recurso;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.urbano.RecursoSocial> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.urbano.RecursoSocial> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id"));
            recurso.setNome(rs.getString("nome"));
            temp.add(recurso);
        }
        
        return temp;
        
    }
    
}
