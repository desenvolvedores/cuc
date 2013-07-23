/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.social;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class FamiliaDAO {
    
    public FamiliaDAO() {
        
    }
    
    public int inserirFamilia(com.sys.social.Familia familia) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_familia(?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(familia.getRemocaoFamilia()));
        stmt.setString(3, txtMgr.addSlashes(familia.getSituacaoRemocao()));
        stmt.setString(4, txtMgr.addSlashes(familia.getEspecifiqueRemocao()));
        stmt.setString(5, txtMgr.addSlashes(familia.getAtendente()));
        stmt.setDate(6, dtMgr.parseDateToSQL(familia.getDataAtendimento()));
        stmt.setString(7, txtMgr.addSlashes(familia.getAtendenteAtualizacao()));
        stmt.setDate(8, dtMgr.parseDateToSQL(familia.getDataAtualizacao()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.Familia selecionarFamiliaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_familia_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.social.Familia> procurarFamiliaPorRemocao(java.lang.String remocao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_familia_por_remocao_familia(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, remocao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.social.Familia> procurarFamiliaPorSituacaoRemocao(java.lang.String situacao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_familia_por_situacao_remocao(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, situacao);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.social.Familia> listarFamilias() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_familias";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarFamilia(com.sys.social.Familia familia) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_familia(?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(familia.getRemocaoFamilia()));
        stmt.setString(3, txtMgr.addSlashes(familia.getSituacaoRemocao()));
        stmt.setString(4, txtMgr.addSlashes(familia.getEspecifiqueRemocao()));
        stmt.setString(5, txtMgr.addSlashes(familia.getAtendente()));
        stmt.setDate(6, dtMgr.parseDateToSQL(familia.getDataAtendimento()));
        stmt.setString(7, txtMgr.addSlashes(familia.getAtendenteAtualizacao()));
        stmt.setDate(8, dtMgr.parseDateToSQL(familia.getDataAtualizacao()));
        stmt.setLong(9, familia.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirFamiliaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_familia(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.Familia selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dtMgr = new com.data.DateManager();
            
            com.sys.social.Familia familia = new com.sys.social.Familia();
            familia.setId(rs.getLong("id"));
            familia.setRemocaoFamilia(rs.getString("remocao_familia"));
            familia.setSituacaoRemocao(rs.getString("situacao_remocao"));
            familia.setEspecifiqueRemocao(rs.getString("especifique_remocao"));
            familia.setAtendente(rs.getString("atendente"));
            familia.setDataAtendimento(dtMgr.parseDate(rs.getDate("dt_atendimento")));
            familia.setAtendenteAtualizacao(rs.getString("atendente_atualizacao"));
            familia.setDataAtualizacao(dtMgr.parseDate(rs.getDate("dt_atualizacao")));
            
            return familia;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.social.Familia> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        com.data.DateManager dtMgr = new com.data.DateManager();
        java.util.List<com.sys.social.Familia> familias = new java.util.ArrayList<>();
        
        while (rs.next()) {
            com.sys.social.Familia familia = new com.sys.social.Familia();
            familia.setId(rs.getLong("id"));
            familia.setRemocaoFamilia(rs.getString("remocao_familia"));
            familia.setSituacaoRemocao(rs.getString("situacao_remocao"));
            familia.setEspecifiqueRemocao(rs.getString("especifique_remocao"));
            familia.setAtendente(rs.getString("atendente"));
            familia.setDataAtendimento(dtMgr.parseDate(rs.getDate("dt_atendimento")));
            familia.setAtendenteAtualizacao(rs.getString("atendente_atualizacao"));
            familia.setDataAtualizacao(dtMgr.parseDate(rs.getDate("dt_atualizacao")));
            familias.add(familia);
        }
        
        return familias;
        
    }
    
}
