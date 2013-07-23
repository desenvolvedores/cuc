/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.link;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class AmbientalAreaRiscoDAO {
    
    public AmbientalAreaRiscoDAO() {
        
    }
    
    public int inserirAmbientalAreaRisco(com.sys.urbano.AspectoAmbiental aspecto, com.sys.urbano.AreaRisco area) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_inserir_ambiental_area_risco(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, aspecto.getId());
        stmt.setLong(3, area.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAmbientalAreaRisco(com.sys.urbano.AspectoAmbiental aspecto, com.sys.urbano.AreaRisco area) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_ambiental_area_risco(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, aspecto.getId());
        stmt.setLong(3, area.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
}
