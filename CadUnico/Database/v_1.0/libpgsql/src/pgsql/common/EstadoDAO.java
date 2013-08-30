/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.common;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EstadoDAO {
    
    public EstadoDAO() {
        
    }
    
    public com.common.Estado selecionarEstadoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_estado_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.common.Estado selecionarIDEstado(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_estado_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nome);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        com.common.Estado estado = new com.common.Estado();
        
        if (rs.next()) {
            
            estado.setId(rs.getLong("id"));
            
        }
        
        return estado;
        
    }
    
    public java.util.List<com.common.Estado> procurarEstadoPorIDPais(long idPais) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_estado_por_id_pais(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idPais);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.common.Estado> listarEstados() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_estados";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    private com.common.Estado selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            
            com.common.Estado estado = new com.common.Estado();
            estado.setId(rs.getLong("id"));
            estado.setIdPais(rs.getLong("id_pais"));
            estado.setSigla(rs.getString("sigla"));
            estado.setNome(rs.getString("nome"));
            
            return estado;
            
        }
        
        return null;
        
    }
    
    private java.util.List<com.common.Estado> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.common.Estado> estados = new java.util.ArrayList<>();
        
        while (rs.next()) {
            
            com.common.Estado estado = new com.common.Estado();
            estado.setId(rs.getLong("id"));
            estado.setIdPais(rs.getLong("id_pais"));
            estado.setSigla(rs.getString("sigla"));
            estado.setNome(rs.getString("nome"));
            estados.add(estado);
            
        }
        
        return estados;
        
    }
    
}
