/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.doc;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class AnexoZoneamentoDAO {
    
    public AnexoZoneamentoDAO() {
        
    }
    
    public int inserirAnexoZoneamento(com.doc.AnexoZoneamento anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_anexo_zoneamento(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdFundiaria());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.doc.AnexoZoneamento selecionarAnexoZoneamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_anexo_zoneamento_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoZoneamento> procurarAnexoZoneamentoPorIDFundiaria(long idFundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_zoneamento_por_id_fundiaria(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idFundiaria);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoZoneamento> procurarAnexoZoneamentoPorTipo(long idFundiaria, char tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_zoneamento_por_tipo(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idFundiaria);
        stmt.setString(2, String.valueOf(tipo));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarAnexoZoneamento(com.doc.AnexoZoneamento anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_anexo_zoneamento(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdFundiaria());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.setLong(5, anexo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoZoneamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_zoneamento(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoZoneamentoPorIDFundiaria(long idFundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_zoneamento_por_id_fundiaria(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, idFundiaria);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.doc.AnexoZoneamento selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.doc.AnexoZoneamento anexo = new com.doc.AnexoZoneamento();
            anexo.setId(rs.getLong("id"));
            anexo.setIdFundiaria(rs.getLong("id_fundiaria"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            
            return anexo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.doc.AnexoZoneamento> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.doc.AnexoZoneamento> anexos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.doc.AnexoZoneamento anexo = new com.doc.AnexoZoneamento();
            anexo.setId(rs.getLong("id"));
            anexo.setIdFundiaria(rs.getLong("id_fundiaria"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            anexos.add(anexo);
        }
        
        return anexos;
        
    }
    
}
