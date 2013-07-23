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
public class AnexoImovelDAO {
    
    public AnexoImovelDAO() {
        
    }
    
    public int inserirAnexoImovel(com.doc.AnexoImovel anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_anexo_imovel(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.doc.AnexoImovel selecionarAnexoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_anexo_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoImovel> procurarAnexoImovelPorIDImovel(long idImovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idImovel);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoImovel> procurarAnexoImovelPorTipo(long idImovel, char tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_imovel_por_tipo(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idImovel);
        stmt.setString(2, String.valueOf(tipo));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarAnexoImovel(com.doc.AnexoImovel anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_anexo_imovel(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.setLong(5, anexo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoImovelPorIDImovel(long idImovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_imovel_por_id_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, idImovel);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.doc.AnexoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.doc.AnexoImovel anexo = new com.doc.AnexoImovel();
            anexo.setId(rs.getLong("id"));
            anexo.setIdImovel(rs.getLong("id_imovel"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            
            return anexo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.doc.AnexoImovel> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.doc.AnexoImovel> anexos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.doc.AnexoImovel anexo = new com.doc.AnexoImovel();
            anexo.setId(rs.getLong("id"));
            anexo.setIdImovel(rs.getLong("id_imovel"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            anexos.add(anexo);
        }
        
        return anexos;
        
    }
    
}
