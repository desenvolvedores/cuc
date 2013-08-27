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
public class ServicoImovelDAO {
    
    public ServicoImovelDAO() {
        
    }
    
    public int inserirServicoImovel(com.sys.habitacional.ServicoImovel servico) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_servicos_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, servico.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(servico.getExistePavimentacao()));
        stmt.setString(4, txtMgr.addSlashes(servico.getQualPavimentacao()));
        stmt.setString(5, txtMgr.addSlashes(servico.getIluminacaoUtilizada()));
        stmt.setString(6, txtMgr.addSlashes(servico.getEspecifiqueIluminacao()));
        stmt.setString(7, txtMgr.addSlashes(servico.getAbastecimentoAgua()));
        stmt.setString(8, txtMgr.addSlashes(servico.getTratamentoAgua()));
        stmt.setString(9, txtMgr.addSlashes(servico.getAguaEncanada()));
        stmt.setString(10, txtMgr.addSlashes(servico.getExisteBanheiro()));
        stmt.setString(11, txtMgr.addSlashes(servico.getEscoamentoSanitario()));
        stmt.setString(12, txtMgr.addSlashes(servico.getTratamentoLixo()));
        stmt.setString(13, txtMgr.addSlashes(servico.getCaes()));
        stmt.setString(14, txtMgr.addSlashes(servico.getGatos()));
        stmt.setString(15, txtMgr.addSlashes(servico.getAves()));
        stmt.setString(16, txtMgr.addSlashes(servico.getSuinos()));
        stmt.setString(17, txtMgr.addSlashes(servico.getInsetos()));
        stmt.setString(18, txtMgr.addSlashes(servico.getRatos()));
        stmt.setString(19, txtMgr.addSlashes(servico.getCobras()));
        stmt.execute();
        return stmt.getInt(1);
    }
    
    public com.sys.habitacional.ServicoImovel selecionarServicoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_servicos_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.habitacional.ServicoImovel selecionarServicoImovelPorIDImovel(long idImovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_servicos_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idImovel);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarServicoImovel(com.sys.habitacional.ServicoImovel servico) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_servicos_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, servico.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(servico.getExistePavimentacao()));
        stmt.setString(4, txtMgr.addSlashes(servico.getQualPavimentacao()));
        stmt.setString(5, txtMgr.addSlashes(servico.getIluminacaoUtilizada()));
        stmt.setString(6, txtMgr.addSlashes(servico.getEspecifiqueIluminacao()));
        stmt.setString(7, txtMgr.addSlashes(servico.getAbastecimentoAgua()));
        stmt.setString(8, txtMgr.addSlashes(servico.getTratamentoAgua()));
        stmt.setString(9, txtMgr.addSlashes(servico.getAguaEncanada()));
        stmt.setString(10, txtMgr.addSlashes(servico.getExisteBanheiro()));
        stmt.setString(11, txtMgr.addSlashes(servico.getEscoamentoSanitario()));
        stmt.setString(12, txtMgr.addSlashes(servico.getTratamentoLixo()));
        stmt.setString(13, txtMgr.addSlashes(servico.getCaes()));
        stmt.setString(14, txtMgr.addSlashes(servico.getGatos()));
        stmt.setString(15, txtMgr.addSlashes(servico.getAves()));
        stmt.setString(16, txtMgr.addSlashes(servico.getSuinos()));
        stmt.setString(17, txtMgr.addSlashes(servico.getInsetos()));
        stmt.setString(18, txtMgr.addSlashes(servico.getRatos()));
        stmt.setString(19, txtMgr.addSlashes(servico.getCobras()));
        stmt.setLong(20, servico.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirServicoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_servicos_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.habitacional.ServicoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            
            com.sys.habitacional.ServicoImovel servico = new com.sys.habitacional.ServicoImovel();
            servico.setId(rs.getLong("id"));
            servico.setIdImovel(rs.getLong("id_imovel"));
            servico.setExistePavimentacao(rs.getString("existe_pavimentacao"));
            servico.setQualPavimentacao(rs.getString("qual_pavimentacao"));
            servico.setIluminacaoUtilizada(rs.getString("iluminacao_utilizada"));
            servico.setEspecifiqueIluminacao(rs.getString("especifique_iluminacao"));
            servico.setAbastecimentoAgua(rs.getString("abastecimento_agua"));
            servico.setTratamentoAgua(rs.getString("tratamento_agua"));
            servico.setAguaEncanada(rs.getString("agua_encanada"));
            servico.setExisteBanheiro(rs.getString("existe_banheiro"));
            servico.setEscoamentoSanitario(rs.getString("escoamento_sanitario"));
            servico.setTratamentoLixo(rs.getString("tratamento_lixo"));
            servico.setCaes(rs.getString("caes"));
            servico.setGatos(rs.getString("gatos"));
            servico.setAves(rs.getString("aves"));
            servico.setSuinos(rs.getString("suinos"));
            servico.setInsetos(rs.getString("insetos"));
            servico.setRatos(rs.getString("ratos"));
            servico.setCobras(rs.getString("cobras"));
            return servico;
            
        } else {
            return null;
        }
        
    }
    
}
