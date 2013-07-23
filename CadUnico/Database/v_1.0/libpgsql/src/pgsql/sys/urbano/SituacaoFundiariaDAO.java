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
public class SituacaoFundiariaDAO {
    
    public SituacaoFundiariaDAO() {
        
    }
    
    public int inserirSituacaoFundiaria(com.sys.urbano.SituacaoFundiaria fundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_situacao_fundiaria(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, fundiaria.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(fundiaria.getPropriedade()));
        stmt.setString(4, txtMgr.addSlashes(fundiaria.getProprietario()));
        stmt.setString(5, txtMgr.addSlashes(fundiaria.getObsPropriedade()));
        stmt.setString(6, txtMgr.addSlashes(fundiaria.getDecretoAprovacao()));
        stmt.setString(7, txtMgr.addSlashes(fundiaria.getRegistrado()));
        stmt.setString(8, txtMgr.addSlashes(fundiaria.getNumeroMatricula()));
        stmt.setDouble(9, fundiaria.getDestinacaoAreas());
        stmt.setString(10, txtMgr.addSlashes(fundiaria.getDescDestinacaoAreas()));
        stmt.setString(11, txtMgr.addSlashes(fundiaria.getDescZonasSolo()));
        stmt.setString(12, txtMgr.addSlashes(fundiaria.getDescEcologicoEconomico()));
        stmt.setString(13, txtMgr.addSlashes(fundiaria.getProcessosJudiciais()));
        stmt.setString(14, txtMgr.addSlashes(fundiaria.getNumeroProcesso()));
        stmt.setString(15, txtMgr.addSlashes(fundiaria.getNumeroOrdem()));
        stmt.setString(16, txtMgr.addSlashes(fundiaria.getVara()));
        stmt.setString(17, txtMgr.addSlashes(fundiaria.getExistenciaEmbargos()));
        stmt.setString(18, txtMgr.addSlashes(fundiaria.getObsJudiciais()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.SituacaoFundiaria selecionarSituacaoFundiariaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_situacao_fundiaria_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.SituacaoFundiaria selecionarSituacaoFundiariaPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_situacao_fundiaria_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarSituacaoFundiaria(com.sys.urbano.SituacaoFundiaria fundiaria) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_situacao_fundiaria(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, fundiaria.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(fundiaria.getPropriedade()));
        stmt.setString(4, txtMgr.addSlashes(fundiaria.getProprietario()));
        stmt.setString(5, txtMgr.addSlashes(fundiaria.getObsPropriedade()));
        stmt.setString(6, txtMgr.addSlashes(fundiaria.getDecretoAprovacao()));
        stmt.setString(7, txtMgr.addSlashes(fundiaria.getRegistrado()));
        stmt.setString(8, txtMgr.addSlashes(fundiaria.getNumeroMatricula()));
        stmt.setDouble(9, fundiaria.getDestinacaoAreas());
        stmt.setString(10, txtMgr.addSlashes(fundiaria.getDescDestinacaoAreas()));
        stmt.setString(11, txtMgr.addSlashes(fundiaria.getDescZonasSolo()));
        stmt.setString(12, txtMgr.addSlashes(fundiaria.getDescEcologicoEconomico()));
        stmt.setString(13, txtMgr.addSlashes(fundiaria.getProcessosJudiciais()));
        stmt.setString(14, txtMgr.addSlashes(fundiaria.getNumeroProcesso()));
        stmt.setString(15, txtMgr.addSlashes(fundiaria.getNumeroOrdem()));
        stmt.setString(16, txtMgr.addSlashes(fundiaria.getVara()));
        stmt.setString(17, txtMgr.addSlashes(fundiaria.getExistenciaEmbargos()));
        stmt.setString(18, txtMgr.addSlashes(fundiaria.getObsJudiciais()));
        stmt.setLong(19, fundiaria.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirSituacaoFundiariaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_situacao_fundiaria(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.SituacaoFundiaria selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.SituacaoFundiaria fundiaria = new com.sys.urbano.SituacaoFundiaria(nucleo);
            fundiaria.setId(rs.getLong("id"));
            fundiaria.setPropriedade(rs.getString("propriedade"));
            fundiaria.setProprietario(rs.getString("proprietario"));
            fundiaria.setObsPropriedade(rs.getString("obs_propriedade"));
            fundiaria.setDecretoAprovacao(rs.getString("decreto_aprovacao"));
            fundiaria.setRegistrado(rs.getString("registrado"));
            fundiaria.setNumeroMatricula(rs.getString("num_matricula"));
            fundiaria.setDestinacaoAreas(rs.getDouble("destinacao_areas"));
            fundiaria.setDescDestinacaoAreas(rs.getString("desc_destinacao_areas"));
            fundiaria.setDescZonasSolo(rs.getString("desc_zonas_solo"));
            fundiaria.setDescEcologicoEconomico(rs.getString("desc_ecologico_economico"));
            fundiaria.setProcessosJudiciais(rs.getString("processos_judiciais"));
            fundiaria.setNumeroProcesso(rs.getString("num_processo"));
            fundiaria.setNumeroOrdem(rs.getString("num_ordem"));
            fundiaria.setVara(rs.getString("vara"));
            fundiaria.setExistenciaEmbargos(rs.getString("existencia_embargos"));
            fundiaria.setObsJudiciais(rs.getString("obs_judiciais"));
            return fundiaria;
        } else {
            return null;
        }
        
    }
    
}
