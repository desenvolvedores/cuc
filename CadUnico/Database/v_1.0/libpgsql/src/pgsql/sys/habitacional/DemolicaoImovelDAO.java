/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.habitacional;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DemolicaoImovelDAO {
    
    public DemolicaoImovelDAO() {
        
    }
    
    public int inserirDemolicaoImovel(com.sys.habitacional.DemolicaoImovel demolicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dateMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_demolicao_imovel(?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, demolicao.getImovel().getId());
        stmt.setDate(3, dateMgr.parseDateToSQL(demolicao.getDataDemolicao()));
        stmt.setString(4, txtMgr.addSlashes(demolicao.getHorarioDemolicao()));
        stmt.setString(5, txtMgr.addSlashes(demolicao.getNumeroProcesso()));
        stmt.setString(6, txtMgr.addSlashes(demolicao.getMotivo()));
        stmt.setString(7, txtMgr.addSlashes(demolicao.getExecutadoPor()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.habitacional.DemolicaoImovel selecionarDemolicaoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_demolicao_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.habitacional.DemolicaoImovel selecionarDemolicaoImovelPorIDImovel(com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_demolicao_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, imovel.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarDemolicaoImovel(com.sys.habitacional.DemolicaoImovel demolicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dateMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_demolicao_imovel(?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, demolicao.getImovel().getId());
        stmt.setDate(3, dateMgr.parseDateToSQL(demolicao.getDataDemolicao()));
        stmt.setString(4, txtMgr.addSlashes(demolicao.getHorarioDemolicao()));
        stmt.setString(5, txtMgr.addSlashes(demolicao.getNumeroProcesso()));
        stmt.setString(6, txtMgr.addSlashes(demolicao.getMotivo()));
        stmt.setString(7, txtMgr.addSlashes(demolicao.getExecutadoPor()));
        stmt.setLong(8, demolicao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirDemolicaoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_demolicao_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.habitacional.DemolicaoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dateMgr = new com.data.DateManager();
            com.sys.habitacional.Imovel imovel = new com.sys.habitacional.Imovel();
            imovel.setId(rs.getLong("id_imovel"));
            
            com.sys.habitacional.DemolicaoImovel demolicao = new com.sys.habitacional.DemolicaoImovel(imovel);
            demolicao.setId(rs.getLong("id"));
            demolicao.setDataDemolicao(dateMgr.parseDate(rs.getDate("dt_demolicao")));
            demolicao.setHorarioDemolicao(rs.getString("horario_demolicao"));
            demolicao.setNumeroProcesso(rs.getString("num_processo"));
            demolicao.setMotivo(rs.getString("motivo"));
            demolicao.setExecutadoPor(rs.getString("executada_por"));
            return demolicao;
        } else {
            return null;
        }
        
    }
    
}
