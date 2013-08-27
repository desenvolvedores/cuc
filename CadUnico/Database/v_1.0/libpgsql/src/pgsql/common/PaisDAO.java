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
public class PaisDAO {
    
    public PaisDAO() {
        
    }
    
    public java.util.List<com.common.Pais> listarPaises() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_paises";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    private java.util.List<com.common.Pais> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.common.Pais> paises = new java.util.ArrayList<>();
        
        while (rs.next()) {
            
            com.common.Pais pais = new com.common.Pais();
            pais.setId(rs.getLong("id"));
            pais.setSigla(rs.getString("sigla"));
            pais.setNome(rs.getString("nome"));
            paises.add(pais);
            
        }
        
        return paises;
        
    }
    
}
