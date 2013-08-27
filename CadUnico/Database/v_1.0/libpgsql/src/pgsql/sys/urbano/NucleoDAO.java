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
public class NucleoDAO {
    
    public NucleoDAO() {
        
    }
    
    public int inserirNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_nucleo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(nucleo.getNome()));
        stmt.setString(3, txtMgr.addSlashes(nucleo.getOrigem()));
        stmt.setString(4, txtMgr.addSlashes(nucleo.getOcupacao()));
        stmt.setDouble(5, nucleo.getAreaTotal());
        stmt.setDouble(6, nucleo.getAreaOcupada());
        stmt.setInt(7, nucleo.getNumeroDomicilios());
        stmt.setInt(8, nucleo.getPopulacaoEstimada());
        stmt.setString(9, txtMgr.addSlashes(nucleo.getPopFonteDados()));
        stmt.setString(10, txtMgr.addSlashes(nucleo.getPopOutrasFontesDados()));
        stmt.setString(11, txtMgr.addSlashes(nucleo.getRendaPopulacao()));
        stmt.setString(12, txtMgr.addSlashes(nucleo.getInicioOcupacao()));
        stmt.setString(13, txtMgr.addSlashes(nucleo.getSetorCadastral()));
        stmt.setString(14, txtMgr.addSlashes(nucleo.getZona()));
        stmt.setString(15, txtMgr.addSlashes(nucleo.getControleOcupacao()));
        stmt.setString(16, txtMgr.addSlashes(nucleo.getObsControleOcupacao()));
        stmt.setString(17, txtMgr.addSlashes(nucleo.getPadraoConstrutivo()));
        stmt.setString(18, txtMgr.addSlashes(nucleo.getTransportePublico()));
        stmt.setString(19, txtMgr.addSlashes(nucleo.getAdensamento()));
        stmt.setString(20, txtMgr.addSlashes(nucleo.getAdensFonteDados()));
        stmt.setString(21, txtMgr.addSlashes(nucleo.getObsAdensamento()));
        stmt.setString(22, txtMgr.addSlashes(nucleo.getUsoIncompativel()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.Nucleo selecionarNucleoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_nucleo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorNome(java.lang.String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nome);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorSetor(java.lang.String setor) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_setor(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, setor);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorZona(java.lang.String zona) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_zona(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, zona);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorOrigem(java.lang.String origem) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_origem(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, origem);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorOcupacao(java.lang.String ocupacao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_ocupacao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, ocupacao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorPadraoConstrutivo(java.lang.String padraoConstrutivo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_padrao_construtivo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, padraoConstrutivo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoPorRendaPopulacao(java.lang.String rendaPopulacao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_por_renda_populacao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, rendaPopulacao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> procurarNucleoExistentePorNome(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_nucleo_existente_por_nome(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, nucleo.getNome());
        stmt.setLong(2, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> listarNucleos() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_nucleos";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_nucleo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(nucleo.getNome()));
        stmt.setString(3, txtMgr.addSlashes(nucleo.getOrigem()));
        stmt.setString(4, txtMgr.addSlashes(nucleo.getOcupacao()));
        stmt.setDouble(5, nucleo.getAreaTotal());
        stmt.setDouble(6, nucleo.getAreaOcupada());
        stmt.setInt(7, nucleo.getNumeroDomicilios());
        stmt.setInt(8, nucleo.getPopulacaoEstimada());
        stmt.setString(9, txtMgr.addSlashes(nucleo.getPopFonteDados()));
        stmt.setString(10, txtMgr.addSlashes(nucleo.getPopOutrasFontesDados()));
        stmt.setString(11, txtMgr.addSlashes(nucleo.getRendaPopulacao()));
        stmt.setString(12, txtMgr.addSlashes(nucleo.getInicioOcupacao()));
        stmt.setString(13, txtMgr.addSlashes(nucleo.getSetorCadastral()));
        stmt.setString(14, txtMgr.addSlashes(nucleo.getZona()));
        stmt.setString(15, txtMgr.addSlashes(nucleo.getControleOcupacao()));
        stmt.setString(16, txtMgr.addSlashes(nucleo.getObsControleOcupacao()));
        stmt.setString(17, txtMgr.addSlashes(nucleo.getPadraoConstrutivo()));
        stmt.setString(18, txtMgr.addSlashes(nucleo.getTransportePublico()));
        stmt.setString(19, txtMgr.addSlashes(nucleo.getAdensamento()));
        stmt.setString(20, txtMgr.addSlashes(nucleo.getAdensFonteDados()));
        stmt.setString(21, txtMgr.addSlashes(nucleo.getObsAdensamento()));
        stmt.setString(22, txtMgr.addSlashes(nucleo.getUsoIncompativel()));
        stmt.setLong(23, nucleo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirNucleoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_nucleo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.Nucleo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id"));
            nucleo.setNome(rs.getString("nome"));
            nucleo.setOrigem(rs.getString("origem"));
            nucleo.setOcupacao(rs.getString("ocupacao"));
            nucleo.setAreaTotal(rs.getDouble("area_total"));
            nucleo.setAreaOcupada(rs.getDouble("area_ocupada"));
            nucleo.setNumeroDomicilios(rs.getInt("num_domicilios"));
            nucleo.setPopulacaoEstimada(rs.getInt("populacao_estimada"));
            nucleo.setPopFonteDados(rs.getString("pop_fonte_dados"));
            nucleo.setPopOutrasFontesDados(rs.getString("pop_outra_fonte_dados"));
            nucleo.setRendaPopulacao(rs.getString("renda_populacao"));
            nucleo.setInicioOcupacao(rs.getString("inicio_ocupacao"));
            nucleo.setSetorCadastral(rs.getString("setor_cadastral"));
            nucleo.setZona(rs.getString("zona"));
            nucleo.setControleOcupacao(rs.getString("controle_ocupacao"));
            nucleo.setObsControleOcupacao(rs.getString("obs_controle_ocupacao"));
            nucleo.setPadraoConstrutivo(rs.getString("padrao_construtivo"));
            nucleo.setTransportePublico(rs.getString("transporte_coletivo"));
            nucleo.setAdensamento(rs.getString("adensamento"));
            nucleo.setAdensFonteDados(rs.getString("adens_fonte_dados"));
            nucleo.setObsAdensamento(rs.getString("obs_adensamento"));
            nucleo.setUsoIncompativel(rs.getString("uso_incompativel"));
            return nucleo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.urbano.Nucleo> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.urbano.Nucleo> nucleos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id"));
            nucleo.setNome(rs.getString("nome"));
            nucleo.setOrigem(rs.getString("origem"));
            nucleo.setOcupacao(rs.getString("ocupacao"));
            nucleo.setAreaTotal(rs.getDouble("area_total"));
            nucleo.setAreaOcupada(rs.getDouble("area_ocupada"));
            nucleo.setNumeroDomicilios(rs.getInt("num_domicilios"));
            nucleo.setPopulacaoEstimada(rs.getInt("populacao_estimada"));
            nucleo.setPopFonteDados(rs.getString("pop_fonte_dados"));
            nucleo.setPopOutrasFontesDados(rs.getString("pop_outra_fonte_dados"));
            nucleo.setRendaPopulacao(rs.getString("renda_populacao"));
            nucleo.setInicioOcupacao(rs.getString("inicio_ocupacao"));
            nucleo.setSetorCadastral(rs.getString("setor_cadastral"));
            nucleo.setZona(rs.getString("zona"));
            nucleo.setControleOcupacao(rs.getString("controle_ocupacao"));
            nucleo.setObsControleOcupacao(rs.getString("obs_controle_ocupacao"));
            nucleo.setPadraoConstrutivo(rs.getString("padrao_construtivo"));
            nucleo.setTransportePublico(rs.getString("transporte_coletivo"));
            nucleo.setAdensamento(rs.getString("adensamento"));
            nucleo.setAdensFonteDados(rs.getString("adens_fonte_dados"));
            nucleo.setObsAdensamento(rs.getString("obs_adensamento"));
            nucleo.setUsoIncompativel(rs.getString("uso_incompativel"));
            nucleos.add(nucleo);
        }
        
        return nucleos;
        
    }
    
}
