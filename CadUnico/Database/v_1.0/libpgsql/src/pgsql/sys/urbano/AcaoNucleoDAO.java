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
public class AcaoNucleoDAO {
    
    public AcaoNucleoDAO() {
        
    }
    
    public int inserirAcaoNucleo(com.sys.urbano.AcaoNucleo acao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_acoes_nucleo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, acao.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(acao.getRemanejamento()));
        stmt.setString(4, txtMgr.addSlashes(acao.getReassentamento()));
        stmt.setString(5, txtMgr.addSlashes(acao.getDesconstrucao()));
        stmt.setString(6, txtMgr.addSlashes(acao.getMelhoriaHabitacional()));
        stmt.setString(7, txtMgr.addSlashes(acao.getFonteMelhoria()));
        stmt.setString(8, txtMgr.addSlashes(acao.getRecuperacaoAmbiental()));
        stmt.setString(9, txtMgr.addSlashes(acao.getPrad()));
        stmt.setString(10, txtMgr.addSlashes(acao.getAdequacaoInfraestrutura()));
        stmt.setString(11, txtMgr.addSlashes(acao.getFonteAdequacao()));
        stmt.setString(12, txtMgr.addSlashes(acao.getOutros()));
        stmt.setString(13, txtMgr.addSlashes(acao.getDescricaoOutros()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.AcaoNucleo selecionarAcaoNucleoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_acoes_nucleo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.AcaoNucleo selecionarAcaoNucleoPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_acoes_nucleo_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarAcaoNucleo(com.sys.urbano.AcaoNucleo acao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_acoes_nucleo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, acao.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(acao.getRemanejamento()));
        stmt.setString(4, txtMgr.addSlashes(acao.getReassentamento()));
        stmt.setString(5, txtMgr.addSlashes(acao.getDesconstrucao()));
        stmt.setString(6, txtMgr.addSlashes(acao.getMelhoriaHabitacional()));
        stmt.setString(7, txtMgr.addSlashes(acao.getFonteMelhoria()));
        stmt.setString(8, txtMgr.addSlashes(acao.getRecuperacaoAmbiental()));
        stmt.setString(9, txtMgr.addSlashes(acao.getPrad()));
        stmt.setString(10, txtMgr.addSlashes(acao.getAdequacaoInfraestrutura()));
        stmt.setString(11, txtMgr.addSlashes(acao.getFonteAdequacao()));
        stmt.setString(12, txtMgr.addSlashes(acao.getOutros()));
        stmt.setString(13, txtMgr.addSlashes(acao.getDescricaoOutros()));
        stmt.setLong(14, acao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirAcaoNucleoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_acoes_nucleo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.AcaoNucleo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.AcaoNucleo acao = new com.sys.urbano.AcaoNucleo(nucleo);
            acao.setId(rs.getLong("id"));
            acao.setRemanejamento(rs.getString("remanejamento"));
            acao.setReassentamento(rs.getString("reassentamento"));
            acao.setDesconstrucao(rs.getString("desconstrucao"));
            acao.setMelhoriaHabitacional(rs.getString("melhoria_habitacional"));
            acao.setFonteMelhoria(rs.getString("fonte_melhoria"));
            acao.setRecuperacaoAmbiental(rs.getString("recuperacao_ambiental"));
            acao.setPrad(rs.getString("prad"));
            acao.setAdequacaoInfraestrutura(rs.getString("adequacao_infraestrutura"));
            acao.setFonteAdequacao(rs.getString("fonte_adequacao"));
            acao.setOutros(rs.getString("outros"));
            acao.setDescricaoOutros(rs.getString("desc_outros"));
            return acao;
        } else {
            return null;
        }
        
    }
    
}
