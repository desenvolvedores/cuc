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
public class AnexoTransporteDAO {
    
    public AnexoTransporteDAO() {
        
    }
    
    public int inserirAnexoTransporte(com.doc.AnexoTransporte anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_anexo_transporte(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.doc.AnexoTransporte selecionarAnexoTransportePorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_anexo_transporte_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoTransporte> procurarAnexoTransportePorIDNucleo(long idNucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_transporte_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idNucleo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoTransporte> procurarAnexoTransportePorTipo(long idNucleo, char tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_individuo_por_tipo(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idNucleo);
        stmt.setString(2, String.valueOf(tipo));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarAnexoTransporte(com.doc.AnexoTransporte anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_anexo_transporte(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.setLong(5, anexo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoTransportePorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_transporte(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoTransportePorIDNucleo(long idNucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_transporte_por_id_nucleo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, idNucleo);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.doc.AnexoTransporte selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.doc.AnexoTransporte anexo = new com.doc.AnexoTransporte();
            anexo.setId(rs.getLong("id"));
            anexo.setIdNucleo(rs.getLong("id_nucleo"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            
            return anexo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.doc.AnexoTransporte> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.doc.AnexoTransporte> anexos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.doc.AnexoTransporte anexo = new com.doc.AnexoTransporte();
            anexo.setId(rs.getLong("id"));
            anexo.setIdNucleo(rs.getLong("id_nucleo"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            anexos.add(anexo);
        }
        
        return anexos;
        
    }
    
}
