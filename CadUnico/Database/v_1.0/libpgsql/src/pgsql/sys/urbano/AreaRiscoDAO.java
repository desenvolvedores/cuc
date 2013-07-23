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
public class AreaRiscoDAO {
    
    public AreaRiscoDAO() {
        
    }
    
    public int inserirAreaRisco(com.sys.urbano.AreaRisco area) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_area_risco(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(area.getCodigoSetor()));
        stmt.setString(3, txtMgr.addSlashes(area.getGrauRisco()));
        stmt.setString(4, txtMgr.addSlashes(area.getVegetacao()));
        stmt.setString(5, txtMgr.addSlashes(area.getProcessoInstabilizacao()));
        stmt.setString(6, txtMgr.addSlashes(area.getCondicoesSolo()));
        stmt.setString(7, txtMgr.addSlashes(area.getExistePavimentacao()));
        stmt.setString(8, txtMgr.addSlashes(area.getObsPavimentacao()));
        stmt.setDouble(9, area.getLatitude());
        stmt.setDouble(10, area.getLongitude());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.AreaRisco selecionarAreaRiscoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_area_risco_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarAreaRisco(com.sys.urbano.AreaRisco area) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_area_risco(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(area.getCodigoSetor()));
        stmt.setString(3, txtMgr.addSlashes(area.getGrauRisco()));
        stmt.setString(4, txtMgr.addSlashes(area.getVegetacao()));
        stmt.setString(5, txtMgr.addSlashes(area.getProcessoInstabilizacao()));
        stmt.setString(6, txtMgr.addSlashes(area.getCondicoesSolo()));
        stmt.setString(7, txtMgr.addSlashes(area.getExistePavimentacao()));
        stmt.setString(8, txtMgr.addSlashes(area.getObsPavimentacao()));
        stmt.setDouble(9, area.getLatitude());
        stmt.setDouble(10, area.getLongitude());
        stmt.setLong(11, area.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAreaRiscoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_area_risco(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.AreaRisco selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.AreaRisco area = new com.sys.urbano.AreaRisco();
            area.setId(rs.getLong("id"));
            area.setCodigoSetor(rs.getString("cd_setor"));
            area.setGrauRisco(rs.getString("grau_risco"));
            area.setVegetacao(rs.getString("vegetacao"));
            area.setProcessoInstabilizacao(rs.getString("processo_instabilizacao"));
            area.setCondicoesSolo(rs.getString("condicoes_solo"));
            area.setExistePavimentacao(rs.getString("existe_pavimentacao"));
            area.setObsPavimentacao(rs.getString("obs_pavimentacao"));
            area.setLatitude(rs.getDouble("latitude"));
            area.setLongitude(rs.getDouble("longitude"));
            return area;
        } else {
            return null;
        }
        
    }
    
}
