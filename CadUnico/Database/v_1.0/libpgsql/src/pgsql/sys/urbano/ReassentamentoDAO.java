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
public class ReassentamentoDAO {
    
    public ReassentamentoDAO() {
        
    }
    
    public int inserirReassentamento(com.sys.urbano.Reassentamento reassentamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_reassentamento(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, reassentamento.getIdAcao());
        stmt.setString(3, txtMgr.addSlashes(reassentamento.getEstimativaRemocao()));
        stmt.setInt(4, reassentamento.getNumeroAConstruir());
        stmt.setInt(5, reassentamento.getNumeroProvisorias());
        stmt.setString(6, txtMgr.addSlashes(reassentamento.getLocalDefinitivo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.Reassentamento selecionarReassentamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_reassentamento_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.Reassentamento selecionarReassentamentoPorIDAcao(long idAcao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_reassentamento_por_id_acao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idAcao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarReassentamento(com.sys.urbano.Reassentamento reassentamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_reassentamento(?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, reassentamento.getIdAcao());
        stmt.setString(3, txtMgr.addSlashes(reassentamento.getEstimativaRemocao()));
        stmt.setInt(4, reassentamento.getNumeroAConstruir());
        stmt.setInt(5, reassentamento.getNumeroProvisorias());
        stmt.setString(6, txtMgr.addSlashes(reassentamento.getLocalDefinitivo()));
        stmt.setLong(7, reassentamento.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirReassentamentoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_reassentamento(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.Reassentamento selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {            
            com.sys.urbano.Reassentamento reassentamento = new com.sys.urbano.Reassentamento();
            reassentamento.setId(rs.getLong("id"));
            reassentamento.setIdAcao(rs.getLong("id_acao"));
            reassentamento.setEstimativaRemocao(rs.getString("estimativa_remocao"));
            reassentamento.setNumeroAConstruir(rs.getInt("num_a_construir"));
            reassentamento.setNumeroProvisorias(rs.getInt("num_provisorias"));
            reassentamento.setLocalDefinitivo(rs.getString("local_definitivo"));
            return reassentamento;
        } else {
            return null;
        }
        
    }
    
}
