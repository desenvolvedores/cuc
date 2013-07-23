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
public class DesconstrucaoDAO {
    
    public DesconstrucaoDAO() {
        
    }
    
    public int inserirDesconstrucao(com.sys.urbano.Desconstrucao desconstrucao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_desconstrucao(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, desconstrucao.getAcao().getId());
        stmt.setInt(3, desconstrucao.getNumeroADemolir());
        stmt.setString(4, txtMgr.addSlashes(desconstrucao.getMotivo()));
        stmt.setString(5, txtMgr.addSlashes(desconstrucao.getProcessos()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.Desconstrucao selecionarDesconstrucaoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_desconstrucao_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.Desconstrucao selecionarDesconstrucaoPorIDAcao(com.sys.urbano.AcaoNucleo acao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_desconstrucao_por_id_acao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, acao.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarDesconstrucao(com.sys.urbano.Desconstrucao desconstrucao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_desconstrucao(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, desconstrucao.getAcao().getId());
        stmt.setInt(3, desconstrucao.getNumeroADemolir());
        stmt.setString(4, txtMgr.addSlashes(desconstrucao.getMotivo()));
        stmt.setString(5, txtMgr.addSlashes(desconstrucao.getProcessos()));
        stmt.setLong(6, desconstrucao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirDesconstrucaoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_desconstrucao(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.Desconstrucao selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.AcaoNucleo acao = new com.sys.urbano.AcaoNucleo();
            acao.setId(rs.getLong("id_acao"));
            
            com.sys.urbano.Desconstrucao desconstrucao = new com.sys.urbano.Desconstrucao(acao);
            desconstrucao.setId(rs.getLong("id"));
            desconstrucao.setNumeroADemolir(rs.getInt("num_a_demolir"));
            desconstrucao.setMotivo(rs.getString("motivo"));
            desconstrucao.setProcessos(rs.getString("processos"));
            return desconstrucao;
        } else {
            return null;
        }
        
    }
    
}
