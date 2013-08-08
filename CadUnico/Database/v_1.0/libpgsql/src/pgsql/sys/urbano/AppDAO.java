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
public class AppDAO {
    
    public AppDAO() {
        
    }
    
    public int inserirApp(com.sys.urbano.App app) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_app(?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, app.getIdAmbiental());
        stmt.setString(3, txtMgr.addSlashes(app.getCorpoDagua()));
        stmt.setString(4, txtMgr.addSlashes(app.getBrejoCharco()));
        stmt.setString(5, txtMgr.addSlashes(app.getTopoMorro()));
        stmt.setString(6, txtMgr.addSlashes(app.getEncosta()));
        stmt.setString(7, txtMgr.addSlashes(app.getRestinga()));
        stmt.setString(8, txtMgr.addSlashes(app.getOutros()));
        stmt.setString(9, txtMgr.addSlashes(app.getEspecifiqueOutros()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.App selecionarAppPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_app_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.App selecionarAppPorIDAspectoAmbiental(long idAmbiental) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_app_por_id_aspecto_ambiental(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idAmbiental);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarApp(com.sys.urbano.App app) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_app(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, app.getIdAmbiental());
        stmt.setString(3, txtMgr.addSlashes(app.getCorpoDagua()));
        stmt.setString(4, txtMgr.addSlashes(app.getBrejoCharco()));
        stmt.setString(5, txtMgr.addSlashes(app.getTopoMorro()));
        stmt.setString(6, txtMgr.addSlashes(app.getEncosta()));
        stmt.setString(7, txtMgr.addSlashes(app.getRestinga()));
        stmt.setString(8, txtMgr.addSlashes(app.getOutros()));
        stmt.setString(9, txtMgr.addSlashes(app.getEspecifiqueOutros()));
        stmt.setLong(10, app.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAppPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_app(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.App selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {            
            com.sys.urbano.App app = new com.sys.urbano.App();
            app.setId(rs.getLong("id"));
            app.setIdAmbiental(rs.getLong("id_ambiental"));
            app.setCorpoDagua(rs.getString("corpo_dagua"));
            app.setBrejoCharco(rs.getString("brejo_charco"));
            app.setTopoMorro(rs.getString("topo_morro"));
            app.setEncosta(rs.getString("enconsta"));
            app.setRestinga(rs.getString("restinga"));
            app.setOutros(rs.getString("outros"));
            app.setEspecifiqueOutros(rs.getString("especifique_outros"));
            return app;
        } else {
            return null;
        }
        
    }
    
}
