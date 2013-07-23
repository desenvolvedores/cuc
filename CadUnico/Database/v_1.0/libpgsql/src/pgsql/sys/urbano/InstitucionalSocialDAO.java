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
public class InstitucionalSocialDAO {
    
    public InstitucionalSocialDAO() {
        
    }
    
    public int inserirInstitucionalSocial(com.sys.urbano.InstitucionalSocial institucional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_institucional_social(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, institucional.getSocial().getId());
        stmt.setLong(3, institucional.getNucleo().getId());
        stmt.setString(4, txtMgr.addSlashes(institucional.getNome()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.InstitucionalSocial selecionarInstitucionalSocialPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_institucional_social_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.InstitucionalSocial> procurarInstitucionalSocialPorIDRecurso(com.sys.urbano.RecursoSocial recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_institucional_social_por_id_recurso(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, recurso.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.InstitucionalSocial> procurarInstitucionalSocialPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_institucional_social_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarInstitucionalSocial(com.sys.urbano.InstitucionalSocial institucional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_institucional_social(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, institucional.getSocial().getId());
        stmt.setLong(3, institucional.getNucleo().getId());
        stmt.setString(4, txtMgr.addSlashes(institucional.getNome()));
        stmt.setLong(5, institucional.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirInstitucionalSocialPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_institucional_social(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.InstitucionalSocial selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.InstitucionalSocial institucional = new com.sys.urbano.InstitucionalSocial(nucleo, recurso);
            institucional.setId(rs.getLong("id"));
            institucional.setNome(rs.getString("nome"));
            return institucional;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.urbano.InstitucionalSocial> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.urbano.InstitucionalSocial> institucionais = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.InstitucionalSocial institucional = new com.sys.urbano.InstitucionalSocial(nucleo, recurso);
            institucional.setId(rs.getLong("id"));
            institucional.setNome(rs.getString("nome"));
            institucionais.add(institucional);
        }
        
        return institucionais;
        
    }
    
}