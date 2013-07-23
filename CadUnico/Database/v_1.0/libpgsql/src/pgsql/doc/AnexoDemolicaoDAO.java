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
public class AnexoDemolicaoDAO {
    
    public AnexoDemolicaoDAO() {
        
    }
    
    public int inserirAnexoDemolicao(com.doc.AnexoDemolicao anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_anexo_demolicao(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdDemolicao());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.doc.AnexoDemolicao selecionarAnexoDemolicaoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_anexo_demolicao_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoDemolicao> procurarAnexoDemolicaoPorIDDemolicao(long idDemolicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_demolicao_por_id_demolicao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idDemolicao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.doc.AnexoDemolicao> procurarAnexoDemolicaoPorTipo(long idDemolicao, char tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_anexo_demolicao_por_tipo(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idDemolicao);
        stmt.setString(2, String.valueOf(tipo));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarAnexoDemolicao(com.doc.AnexoDemolicao anexo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_anexo_demolicao(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, anexo.getIdDemolicao());
        stmt.setString(3, txtMgr.addSlashes(anexo.getCaminho()));
        stmt.setString(4, String.valueOf(anexo.getTipo()));
        stmt.setLong(5, anexo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoDemolicaoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_demolicao(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAnexoDemolicaoPorIDDemolicao(long idDemolicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_anexo_demolicao_por_id_demolicao(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, idDemolicao);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.doc.AnexoDemolicao selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.doc.AnexoDemolicao anexo = new com.doc.AnexoDemolicao();
            anexo.setId(rs.getLong("id"));
            anexo.setIdDemolicao(rs.getLong("id_demolicao"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            
            return anexo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.doc.AnexoDemolicao> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.doc.AnexoDemolicao> anexos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.doc.AnexoDemolicao anexo = new com.doc.AnexoDemolicao();
            anexo.setId(rs.getLong("id"));
            anexo.setIdDemolicao(rs.getLong("id_demolicao"));
            anexo.setCaminho(rs.getString("caminho"));
            anexo.setTipo(rs.getString("tipo").charAt(0));
            anexos.add(anexo);
        }
        
        return anexos;
        
    }
    
}
