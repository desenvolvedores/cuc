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
public class ImovelDAO {
    
    public ImovelDAO() {
        
    }
    
    public int inserirImovel(com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, imovel.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(imovel.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(imovel.getSituacao()));
        stmt.setDouble(5, imovel.getValorAluguel());
        stmt.setString(6, txtMgr.addSlashes(imovel.getTipoPropriedade()));
        stmt.setString(7, txtMgr.addSlashes(imovel.getDocPropriedade()));
        stmt.setString(8, txtMgr.addSlashes(imovel.getNumDocPropriedade()));
        stmt.setString(9, txtMgr.addSlashes(imovel.getConstrucao()));
        stmt.setString(10, txtMgr.addSlashes(imovel.getLocalidade()));
        stmt.setString(11, txtMgr.addSlashes(imovel.getPagaIPTU()));
        stmt.setString(12, txtMgr.addSlashes(imovel.getIc()));
        stmt.setString(13, txtMgr.addSlashes(imovel.getSelagem()));
        stmt.setString(14, txtMgr.addSlashes(imovel.getAtendente()));
        stmt.setString(15, txtMgr.addSlashes(imovel.getAtendenteAtualizacao()));
        stmt.setDate(16, dtMgr.parseDateToSQL(imovel.getDataAtualizacao()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.habitacional.Imovel selecionarImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorTipo(java.lang.String tipo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_tipo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, tipo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorSituacao(java.lang.String situacao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_situacao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, situacao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorNumDocumento(java.lang.String numDocumento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_num_documento(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, numDocumento);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorLocalidade(java.lang.String localidade) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_localidade(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, localidade);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorLogradouro(java.lang.String logradouro) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_logradouro(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, logradouro);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorCEP(java.lang.String cep) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_cep(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, cep);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> procurarImovelPorBairro(java.lang.String bairro) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_imovel_por_bairro(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, bairro);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> listarImoveis() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_imoveis";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarImovel(com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, imovel.getIdNucleo());
        stmt.setString(3, txtMgr.addSlashes(imovel.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(imovel.getSituacao()));
        stmt.setDouble(5, imovel.getValorAluguel());
        stmt.setString(6, txtMgr.addSlashes(imovel.getTipoPropriedade()));
        stmt.setString(7, txtMgr.addSlashes(imovel.getDocPropriedade()));
        stmt.setString(8, txtMgr.addSlashes(imovel.getNumDocPropriedade()));
        stmt.setString(9, txtMgr.addSlashes(imovel.getConstrucao()));
        stmt.setString(10, txtMgr.addSlashes(imovel.getLocalidade()));
        stmt.setString(11, txtMgr.addSlashes(imovel.getPagaIPTU()));
        stmt.setString(12, txtMgr.addSlashes(imovel.getIc()));
        stmt.setString(13, txtMgr.addSlashes(imovel.getSelagem()));
        stmt.setString(14, txtMgr.addSlashes(imovel.getAtendente()));
        stmt.setString(15, txtMgr.addSlashes(imovel.getAtendenteAtualizacao()));
        stmt.setDate(16, dtMgr.parseDateToSQL(imovel.getDataAtualizacao()));
        stmt.setLong(17, imovel.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.habitacional.Imovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dtMgr = new com.data.DateManager();
            
            com.sys.habitacional.Imovel imovel = new com.sys.habitacional.Imovel();
            imovel.setId(rs.getLong("id"));
            imovel.setIdNucleo(rs.getLong("id_nucleo"));
            imovel.setTipo(rs.getString("tipo_imovel"));
            imovel.setSituacao(rs.getString("situacao_imovel"));
            imovel.setValorAluguel(rs.getDouble("valor_aluguel"));
            imovel.setTipoPropriedade(rs.getString("tipo_propriedade"));
            imovel.setDocPropriedade(rs.getString("doc_propriedade"));
            imovel.setNumDocPropriedade(rs.getString("num_doc_propriedade"));
            imovel.setConstrucao(rs.getString("construcao"));
            imovel.setLocalidade(rs.getString("localidade"));
            imovel.setPagaIPTU(rs.getString("paga_iptu"));
            imovel.setIc(rs.getString("ic"));
            imovel.setSelagem(rs.getString("selagem"));
            imovel.setAtendente(rs.getString("atendente"));
            imovel.setAtendenteAtualizacao(rs.getString("atendente_atualizacao"));
            imovel.setDataAtualizacao(dtMgr.parseDate(rs.getDate("dt_atualizacao")));
            return imovel;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.habitacional.Imovel> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        com.data.DateManager dtMgr = new com.data.DateManager();
        java.util.List<com.sys.habitacional.Imovel> imoveis = new java.util.ArrayList<>();
        
        while (rs.next()) {
            com.sys.habitacional.Imovel imovel = new com.sys.habitacional.Imovel();
            imovel.setId(rs.getLong("id"));
            imovel.setIdNucleo(rs.getLong("id_nucleo"));
            imovel.setTipo(rs.getString("tipo_imovel"));
            imovel.setSituacao(rs.getString("situacao_imovel"));
            imovel.setValorAluguel(rs.getDouble("valor_aluguel"));
            imovel.setTipoPropriedade(rs.getString("tipo_propriedade"));
            imovel.setDocPropriedade(rs.getString("doc_propriedade"));
            imovel.setNumDocPropriedade(rs.getString("num_doc_propriedade"));
            imovel.setConstrucao(rs.getString("construcao"));
            imovel.setLocalidade(rs.getString("localidade"));
            imovel.setPagaIPTU(rs.getString("paga_iptu"));
            imovel.setIc(rs.getString("ic"));
            imovel.setSelagem(rs.getString("selagem"));
            imovel.setAtendente(rs.getString("atendente"));
            imovel.setAtendenteAtualizacao(rs.getString("atendente_atualizacao"));
            imovel.setDataAtualizacao(dtMgr.parseDate(rs.getDate("dt_atualizacao")));
            imoveis.add(imovel);
        }
        
        return imoveis;
        
    }
    
}
