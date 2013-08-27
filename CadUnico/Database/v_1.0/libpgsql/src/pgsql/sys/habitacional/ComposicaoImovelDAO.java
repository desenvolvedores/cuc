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
public class ComposicaoImovelDAO {
    
    public ComposicaoImovelDAO() {
        
    }
    
    public int inserirComposicaoImovel(com.sys.habitacional.ComposicaoImovel composicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_composicao_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, composicao.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(composicao.getConstrucao()));
        stmt.setString(4, txtMgr.addSlashes(composicao.getMaterialParede()));
        stmt.setString(5, txtMgr.addSlashes(composicao.getEspecifiqueParede()));
        stmt.setString(6, txtMgr.addSlashes(composicao.getMaterialPiso()));
        stmt.setString(7, txtMgr.addSlashes(composicao.getEspecifiquePiso()));
        stmt.setString(8, txtMgr.addSlashes(composicao.getMaterialCobertura()));
        stmt.setString(9, txtMgr.addSlashes(composicao.getEspecifiqueCobertura()));
        stmt.setInt(10, composicao.getNumeroComodos());
        stmt.setInt(11, composicao.getNumeroSalas());
        stmt.setInt(12, composicao.getNumeroCozinhas());
        stmt.setInt(13, composicao.getNumeroQuartos());
        stmt.setInt(14, composicao.getNumeroBanheiros());
        stmt.setInt(15, composicao.getNumeroAreasServicos());
        stmt.setInt(16, composicao.getNumeroAnexos());
        stmt.setInt(17, composicao.getNumeroOutrosComodos());
        stmt.setInt(18, composicao.getNumeroServemDormitorio());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.habitacional.ComposicaoImovel selecionarComposicaoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_composicao_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.habitacional.ComposicaoImovel selecionarComposicaoImovelPorIDImovel(long idImovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_composicao_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idImovel);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarComposicaoImovel(com.sys.habitacional.ComposicaoImovel composicao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_composicao_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, composicao.getIdImovel());
        stmt.setString(3, txtMgr.addSlashes(composicao.getConstrucao()));
        stmt.setString(4, txtMgr.addSlashes(composicao.getMaterialParede()));
        stmt.setString(5, txtMgr.addSlashes(composicao.getEspecifiqueParede()));
        stmt.setString(6, txtMgr.addSlashes(composicao.getMaterialPiso()));
        stmt.setString(7, txtMgr.addSlashes(composicao.getEspecifiquePiso()));
        stmt.setString(8, txtMgr.addSlashes(composicao.getMaterialCobertura()));
        stmt.setString(9, txtMgr.addSlashes(composicao.getEspecifiqueCobertura()));
        stmt.setInt(10, composicao.getNumeroComodos());
        stmt.setInt(11, composicao.getNumeroSalas());
        stmt.setInt(12, composicao.getNumeroCozinhas());
        stmt.setInt(13, composicao.getNumeroQuartos());
        stmt.setInt(14, composicao.getNumeroBanheiros());
        stmt.setInt(15, composicao.getNumeroAreasServicos());
        stmt.setInt(16, composicao.getNumeroAnexos());
        stmt.setInt(17, composicao.getNumeroOutrosComodos());
        stmt.setInt(18, composicao.getNumeroServemDormitorio());
        stmt.setLong(19, composicao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirComposicaoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_composicao_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.habitacional.ComposicaoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            
            com.sys.habitacional.ComposicaoImovel composicao = new com.sys.habitacional.ComposicaoImovel();
            composicao.setId(rs.getLong("id"));
            composicao.setIdImovel(rs.getLong("id_imovel"));
            composicao.setConstrucao(rs.getString("construcao"));
            composicao.setMaterialParede(rs.getString("material_parede"));
            composicao.setEspecifiqueParede(rs.getString("especifique_parede"));
            composicao.setMaterialPiso(rs.getString("material_piso"));
            composicao.setEspecifiquePiso(rs.getString("especifique_piso"));
            composicao.setMaterialCobertura(rs.getString("material_cobertura"));
            composicao.setEspecifiqueCobertura(rs.getString("especifique_cobertura"));
            composicao.setNumeroComodos(rs.getInt("num_comodos"));
            composicao.setNumeroSalas(rs.getInt("num_salas"));
            composicao.setNumeroCozinhas(rs.getInt("num_cozinhas"));
            composicao.setNumeroQuartos(rs.getInt("num_quartos"));
            composicao.setNumeroBanheiros(rs.getInt("num_banheiros"));
            composicao.setNumeroAreasServicos(rs.getInt("num_areas_servicos"));
            composicao.setNumeroAnexos(rs.getInt("num_anexos"));
            composicao.setNumeroOutrosComodos(rs.getInt("num_outros_comodos"));
            composicao.setNumeroServemDormitorio(rs.getInt("num_servem_dormitorio"));
            return composicao;
            
        } else {
            return null;
        }
        
    }
    
}
