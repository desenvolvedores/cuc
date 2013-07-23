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
public class AnexoJudicialDAO {
    
    public AnexoJudicialDAO() {
        
    }
    
    public int inserirAnexoJudicial(com.doc.AnexoJudicial anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_anexo_judicial(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdFundiaria());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.doc.AnexoJudicial selecionarAnexoJudicialPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_anexo_judicial_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoJudicial> procurarAnexoJudicialPorIDFundiaria(long idFundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_judicial_por_id_fundiaria(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idFundiaria);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoJudicial> procurarAnexoJudicialPorTipo(long idFundiaria, char tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_judicial_por_tipo(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idFundiaria);
        stmt.setString(2, String.valueOf(tipo));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarAnexoJudicial(com.doc.AnexoJudicial anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_anexo_judicial(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdFundiaria());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.setLong(5, anexo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoJudicialPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_judicial(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoJudicialPorIDFundiaria(long idFundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_judicial_por_id_fundiaria(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, idFundiaria);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.doc.AnexoJudicial selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.doc.AnexoJudicial anexo = new com.doc.AnexoJudicial();
            anexo.setId(rs.getLong("id"));
            anexo.setIdFundiaria(rs.getLong("id_fundiaria"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            
            return anexo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.doc.AnexoJudicial> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.doc.AnexoJudicial> anexos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.doc.AnexoJudicial anexo = new com.doc.AnexoJudicial();
            anexo.setId(rs.getLong("id"));
            anexo.setIdFundiaria(rs.getLong("id_fundiaria"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            anexos.add(anexo);
        }
        
        return anexos;
        
    }
    
}
