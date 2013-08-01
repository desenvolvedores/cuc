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
        stmt.setLong(2, institucional.getIdNucleo());
        stmt.setLong(3, institucional.getSocial().getId());
        stmt.setString(4, txtMgr.addSlashes(institucional.getNome()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public java.util.List<com.sys.urbano.InstitucionalSocial> procurarInstitucionalSocialPorIDNucleo(long idNucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_institucional_social_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idNucleo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.InstitucionalSocial> procurarInstitucionalSocialPorIDRecurso(com.sys.urbano.RecursoSocial recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_institucional_social_por_id_recurso(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, recurso.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarInstitucionalSocial(com.sys.urbano.InstitucionalSocial institucional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_institucional_social(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, institucional.getIdNucleo());
        stmt.setLong(3, institucional.getSocial().getId());
        stmt.setString(4, txtMgr.addSlashes(institucional.getNome()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirInstitucionalSocial(com.sys.urbano.InstitucionalSocial institucional) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_institucional_social(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, institucional.getIdNucleo());
        stmt.setLong(3, institucional.getSocial().getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.InstitucionalSocial selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.InstitucionalSocial institucional = new com.sys.urbano.InstitucionalSocial(recurso);
            institucional.setIdNucleo(rs.getLong("id_nucleo"));
            institucional.setSocial(recurso);
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
            com.sys.urbano.RecursoSocial recurso = new com.sys.urbano.RecursoSocial();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.InstitucionalSocial institucional = new com.sys.urbano.InstitucionalSocial(recurso);
            institucional.setIdNucleo(rs.getLong("id_nucleo"));
            institucional.setSocial(recurso);
            institucional.setNome(rs.getString("nome"));
            institucionais.add(institucional);
        }
        
        return institucionais;
        
    }
    
}
