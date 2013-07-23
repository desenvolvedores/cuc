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
public class InfraestruturaUrbanaDAO {
    
    public InfraestruturaUrbanaDAO() {
        
    }
    
    public int inserirInfraestruturaUrbana(com.sys.urbano.InfraestruturaUrbana infraestrutura) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_infraestrutura_urbana(?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, infraestrutura.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(infraestrutura.getAbastecimentoAgua()));
        stmt.setString(4, txtMgr.addSlashes(infraestrutura.getColetaEsgoto()));
        stmt.setString(5, txtMgr.addSlashes(infraestrutura.getServicosLimpeza()));
        stmt.setString(6, txtMgr.addSlashes(infraestrutura.getAguasPluviaisSuperficial()));
        stmt.setString(7, txtMgr.addSlashes(infraestrutura.getAguasPluviaisRede()));
        stmt.setString(8, txtMgr.addSlashes(infraestrutura.getEnergiaEletrica()));
        stmt.setString(9, txtMgr.addSlashes(infraestrutura.getIluminacaoPublica()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.InfraestruturaUrbana selecionarInfraestruturaUrbanaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_infraestrutura_urbana_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.urbano.InfraestruturaUrbana selecionarInfraestruturaUrbanaPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_infraestrutura_urbana_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarInfraestruturaUrbana(com.sys.urbano.InfraestruturaUrbana infraestrutura) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_infraestrutura_urbana(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, infraestrutura.getNucleo().getId());
        stmt.setString(3, txtMgr.addSlashes(infraestrutura.getAbastecimentoAgua()));
        stmt.setString(4, txtMgr.addSlashes(infraestrutura.getColetaEsgoto()));
        stmt.setString(5, txtMgr.addSlashes(infraestrutura.getServicosLimpeza()));
        stmt.setString(6, txtMgr.addSlashes(infraestrutura.getAguasPluviaisSuperficial()));
        stmt.setString(7, txtMgr.addSlashes(infraestrutura.getAguasPluviaisRede()));
        stmt.setString(8, txtMgr.addSlashes(infraestrutura.getEnergiaEletrica()));
        stmt.setString(9, txtMgr.addSlashes(infraestrutura.getIluminacaoPublica()));
        stmt.setLong(10, infraestrutura.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirInfraestruturaUrbanaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_infraestrutura_urbana(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.InfraestruturaUrbana selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.InfraestruturaUrbana infraestrutura = new com.sys.urbano.InfraestruturaUrbana(nucleo);
            infraestrutura.setId(rs.getLong("id"));
            infraestrutura.setAbastecimentoAgua(rs.getString("abastecimento_agua"));
            infraestrutura.setColetaEsgoto(rs.getString("coleta_esgoto"));
            infraestrutura.setServicosLimpeza(rs.getString("servicos_limpeza"));
            infraestrutura.setAguasPluviaisSuperficial(rs.getString("aguas_pluviais_superficial"));
            infraestrutura.setAguasPluviaisRede(rs.getString("aguas_pluviais_rede"));
            infraestrutura.setEnergiaEletrica(rs.getString("energia_eletrica"));
            infraestrutura.setIluminacaoPublica(rs.getString("iluminacao_publica"));
            return infraestrutura;
        } else {
            return null;
        }
        
    }
    
}
