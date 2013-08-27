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
public class MunicipioDAO {
    
    public MunicipioDAO() {
        
    }
    
    public com.common.Municipio selecionarIDMunicipio(String nome, long isEstado) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_municipio_id(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nome);
        stmt.setLong(2, isEstado);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        com.common.Municipio municipio = new com.common.Municipio();
        
        if (rs.next()) {
            
            municipio.setId(rs.getLong("id"));
            
        }
        
        return municipio;
        
    }
    
    public java.util.List<com.common.Municipio> procurarMunicipioPorIDEstado(long idPais) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_municipio_por_id_estado(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idPais);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.common.Municipio> listarMunicipios() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_municipios";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    private java.util.List<com.common.Municipio> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.common.Municipio> municipios = new java.util.ArrayList<>();
        
        while (rs.next()) {
            
            com.common.Municipio municipio = new com.common.Municipio();
            municipio.setId(rs.getLong("id"));
            municipio.setIdEstado(rs.getLong("id_estado"));
            municipio.setNome(rs.getString("nome"));
            municipios.add(municipio);
            
        }
        
        return municipios;
        
    }
    
}
