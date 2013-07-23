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
public class ViaPublicaDAO {
    
    public ViaPublicaDAO() {
        
    }
    
    public int inserirViaPublica(com.sys.urbano.ViaPublica via) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_via_publica(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, via.getMobilidade().getId());
        stmt.setLong(3, via.getNucleo().getId());
        stmt.setString(4, txtMgr.addSlashes(via.getDescricao()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.urbano.ViaPublica selecionarViaPublicaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_via_publica_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.ViaPublica> procurarViaPublicaPorIDRecurso(com.sys.urbano.RecursoMobilidade recurso) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_via_publica_por_id_recurso(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, recurso.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.urbano.ViaPublica> procurarViaPublicaPorIDNucleo(com.sys.urbano.Nucleo nucleo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_via_publica_por_id_nucleo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, nucleo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int alterarViaPublica(com.sys.urbano.ViaPublica via) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_via_publica(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, via.getMobilidade().getId());
        stmt.setLong(3, via.getNucleo().getId());
        stmt.setString(4, txtMgr.addSlashes(via.getDescricao()));
        stmt.setLong(5, via.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirViaPublicaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_via_publica(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.urbano.ViaPublica selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.RecursoMobilidade recurso = new com.sys.urbano.RecursoMobilidade();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.ViaPublica via = new com.sys.urbano.ViaPublica(nucleo, recurso);
            via.setId(rs.getLong("id"));
            via.setDescricao(rs.getString("descricao"));
            return via;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.urbano.ViaPublica> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.urbano.ViaPublica> vias = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.urbano.Nucleo nucleo = new com.sys.urbano.Nucleo();
            nucleo.setId(rs.getLong("id_nucleo"));
            
            com.sys.urbano.RecursoMobilidade recurso = new com.sys.urbano.RecursoMobilidade();
            recurso.setId(rs.getInt("id_recurso"));
            
            com.sys.urbano.ViaPublica via = new com.sys.urbano.ViaPublica(nucleo, recurso);
            via.setId(rs.getLong("id"));
            via.setDescricao(rs.getString("descricao"));
            vias.add(via);
        }
        
        return vias;
        
    }
    
}
