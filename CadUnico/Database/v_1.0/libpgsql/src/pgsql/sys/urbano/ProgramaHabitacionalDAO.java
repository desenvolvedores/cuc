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
public class ProgramaHabitacionalDAO {
    
    public ProgramaHabitacionalDAO() {
        
    }
    
    public int inserirProgramaHabitacional(com.sys.urbano.ProgramaHabitacional programa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_programa_habitacional(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, programa.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(programa.getMaterialConstrucao()));
        stmt.setString(4, txtMgr.addSlashes(programa.getProducaoMoradias()));
        stmt.setString(5, txtMgr.addSlashes(programa.getAssistenciaTecnica()));
        stmt.setString(6, txtMgr.addSlashes(programa.getUrbAssentamentosPrecarios()));
        stmt.setString(7, txtMgr.addSlashes(programa.getComplemInfraestrutura()));
        stmt.setString(8, txtMgr.addSlashes(programa.getRegularizacaoFundiaria()));
        stmt.setString(9, txtMgr.addSlashes(programa.getCdhu()));
        stmt.setString(10, txtMgr.addSlashes(programa.getPmcmv()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.ProgramaHabitacional selecionarProgramaHabitacionalPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_programa_habitacional_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.ProgramaHabitacional selecionarProgramaHabitacionalPorIDNucleo(long idNucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_programa_habitacional_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idNucleo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarProgramaHabitacional(com.sys.urbano.ProgramaHabitacional programa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_programa_habitacional(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, programa.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(programa.getMaterialConstrucao()));
        stmt.setString(4, txtMgr.addSlashes(programa.getProducaoMoradias()));
        stmt.setString(5, txtMgr.addSlashes(programa.getAssistenciaTecnica()));
        stmt.setString(6, txtMgr.addSlashes(programa.getUrbAssentamentosPrecarios()));
        stmt.setString(7, txtMgr.addSlashes(programa.getComplemInfraestrutura()));
        stmt.setString(8, txtMgr.addSlashes(programa.getRegularizacaoFundiaria()));
        stmt.setString(9, txtMgr.addSlashes(programa.getCdhu()));
        stmt.setString(10, txtMgr.addSlashes(programa.getPmcmv()));
        stmt.setLong(11, programa.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirProgramaHabitacionalPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_programa_habitacional(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.ProgramaHabitacional selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {            
            com.sys.urbano.ProgramaHabitacional programa = new com.sys.urbano.ProgramaHabitacional();
            programa.setId(rs.getLong("id"));
            programa.setIdNucleo(rs.getLong("id_nucleo"));
            programa.setMaterialConstrucao(rs.getString("material_construcao"));
            programa.setProducaoMoradias(rs.getString("producao_moradias"));
            programa.setAssistenciaTecnica(rs.getString("assistencia_tecnica"));
            programa.setUrbAssentamentosPrecarios(rs.getString("urb_assentamentos_precarios"));
            programa.setComplemInfraestrutura(rs.getString("complementacao_infraestrutura"));
            programa.setRegularizacaoFundiaria(rs.getString("regularizacao_fundiaria"));
            programa.setCdhu(rs.getString("cdhu"));
            programa.setPmcmv(rs.getString("pmcmv"));
            return programa;
        } else {
            return null;
        }
        
    }
    
}
