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
public class AspectoAmbientalDAO {
    
    public AspectoAmbientalDAO() {
        
    }
    
    public int inserirAspectoAmbiental(com.sys.urbano.AspectoAmbiental aspecto) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_aspecto_ambiental(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, aspecto.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(aspecto.getAreaRisco()));
        stmt.setString(4, txtMgr.addSlashes(aspecto.getApp()));
        stmt.setString(5, txtMgr.addSlashes(aspecto.getAreaVerde()));
        stmt.setString(6, txtMgr.addSlashes(aspecto.getAreaAgricola()));
        stmt.setString(7, txtMgr.addSlashes(aspecto.getOutros()));
        stmt.setString(8, txtMgr.addSlashes(aspecto.getOutrosEspecifique()));
        stmt.setDouble(9, aspecto.getLatitude());
        stmt.setDouble(10, aspecto.getLongitude());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.AspectoAmbiental selecionarAspectoAmbientalPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_aspecto_ambiental_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.AspectoAmbiental selecionarAspectoAmbientalPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_aspecto_ambiental_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarAspectoAmbiental(com.sys.urbano.AspectoAmbiental aspecto) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_aspecto_ambiental(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, aspecto.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(aspecto.getAreaRisco()));
        stmt.setString(4, txtMgr.addSlashes(aspecto.getApp()));
        stmt.setString(5, txtMgr.addSlashes(aspecto.getAreaVerde()));
        stmt.setString(6, txtMgr.addSlashes(aspecto.getAreaAgricola()));
        stmt.setString(7, txtMgr.addSlashes(aspecto.getOutros()));
        stmt.setString(8, txtMgr.addSlashes(aspecto.getOutrosEspecifique()));
        stmt.setDouble(9, aspecto.getLatitude());
        stmt.setDouble(10, aspecto.getLongitude());
        stmt.setLong(11, aspecto.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAspectoAmbientalPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_aspecto_ambiental(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.AspectoAmbiental selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.AspectoAmbiental aspecto = new com.sys.urbano.AspectoAmbiental(nucleo);
            aspecto.setId(rs.getLong("id"));
            aspecto.setAreaRisco(rs.getString("area_risco"));
            aspecto.setApp(rs.getString("app"));
            aspecto.setAreaVerde(rs.getString("area_verde"));
            aspecto.setAreaAgricola(rs.getString("area_agricola"));
            aspecto.setOutros(rs.getString("outros"));
            aspecto.setOutrosEspecifique(rs.getString("outros_especifique"));
            aspecto.setLatitude(rs.getDouble("latitude"));
            aspecto.setLongitude(rs.getDouble("longitude"));
            return aspecto;
        } else {
            return null;
        }
        
    }
    
}
