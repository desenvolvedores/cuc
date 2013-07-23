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
public class RecursoMobilidadeDAO {
    
    public RecursoMobilidadeDAO() {
        
    }
    
    public int inserirRecursoMobilidade(com.sys.urbano.RecursoMobilidade recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_recurso_mobilidade(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(recurso.getNome()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.RecursoMobilidade selecionarRecursoMobilidadePorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_recurso_mobilidade_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.RecursoMobilidade selecionarRecursoMobilidadePorNome(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_recurso_mobilidade_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nome);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.RecursoMobilidade> listarRecursosMobilidades() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_recurso_mobilidades";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarRecursoMobilidade(com.sys.urbano.RecursoMobilidade recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_recurso_mobilidade(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(recurso.getNome()));
        stmt.setInt(3, recurso.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirRecursoMobilidadePorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_recurso_mobilidade(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.RecursoMobilidade selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.RecursoMobilidade recurso = new com.sys.urbano.RecursoMobilidade();
            recurso.setId(rs.getInt("id"));
            recurso.setNome(rs.getString("nome"));
            return recurso;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.urbano.RecursoMobilidade> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.urbano.RecursoMobilidade> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.urbano.RecursoMobilidade recurso = new com.sys.urbano.RecursoMobilidade();
            recurso.setId(rs.getInt("id"));
            recurso.setNome(rs.getString("nome"));
            temp.add(recurso);
        }
        
        return temp;
        
    }
    
}
