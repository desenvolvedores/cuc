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
public class RemanejamentoDAO {
    
    public RemanejamentoDAO() {
        
    }
    
    public int inserirRemanejamento(com.sys.urbano.Remanejamento remanejamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_remanejamento(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, remanejamento.getIdAcao());
        stmt.setString(3, txtMgr.addSlashes(remanejamento.getEstimativaRelocacao()));
        stmt.setInt(4, remanejamento.getNumeroRemocaoDefinitiva());
        stmt.setInt(5, remanejamento.getNumeroRemocaoProvisoria());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.Remanejamento selecionarRemanejamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_remanejamento_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.Remanejamento selecionarRemanejamentoPorIDAcao(long idAcao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_remanejamento_por_id_acao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idAcao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarRemanejamento(com.sys.urbano.Remanejamento remanejamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_remanejamento(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, remanejamento.getIdAcao());
        stmt.setString(3, txtMgr.addSlashes(remanejamento.getEstimativaRelocacao()));
        stmt.setInt(4, remanejamento.getNumeroRemocaoDefinitiva());
        stmt.setInt(5, remanejamento.getNumeroRemocaoProvisoria());
        stmt.setLong(6, remanejamento.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirRemanejamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_remanejamento(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.Remanejamento selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {            
            com.sys.urbano.Remanejamento remanejamento = new com.sys.urbano.Remanejamento();
            remanejamento.setId(rs.getLong("id"));
            remanejamento.setIdAcao(rs.getLong("id_acao"));
            remanejamento.setEstimativaRelocacao(rs.getString("estimativa_relocacao"));
            remanejamento.setNumeroRemocaoDefinitiva(rs.getInt("num_remocao_definitiva"));
            remanejamento.setNumeroRemocaoProvisoria(rs.getInt("num_remocao_provisoria"));
            return remanejamento;
        } else {
            return null;
        }
        
    }
    
}
