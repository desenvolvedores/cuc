/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.social;

import pgsql.common.TelefoneDAO;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class TelefoneEmpresaDAO extends TelefoneDAO {
    
    public TelefoneEmpresaDAO() {
        
    }
    
    public int inserirTelefone(com.sys.social.TelefoneEmpresa telefone) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_telefone_empresa(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, telefone.getIdEmpresa());
        stmt.setString(3, txtMgr.addSlashes(telefone.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(telefone.getNumero()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.TelefoneEmpresa selecionarTelefonePorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_telefone_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.social.TelefoneEmpresa> procurarTelefonesPorIDEmpresa(long idEmpresa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_telefone_por_id_empresa(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idEmpresa);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int excluirTelefonesPorIDEmpresa(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_telefone_por_id_empresa(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.TelefoneEmpresa selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.social.TelefoneEmpresa telefone = new com.sys.social.TelefoneEmpresa();
            telefone.setId(rs.getLong("id"));
            telefone.setIdEmpresa(rs.getLong("id_empresa"));
            telefone.setTipo(rs.getString("tipo_telefone"));
            telefone.setNumero(rs.getString("num_telefone"));
            
            return telefone;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.social.TelefoneEmpresa> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.social.TelefoneEmpresa> telefones = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.social.TelefoneEmpresa telefone = new com.sys.social.TelefoneEmpresa();
            telefone.setId(rs.getLong("id"));
            telefone.setIdEmpresa(rs.getLong("id_empresa"));
            telefone.setTipo(rs.getString("tipo_telefone"));
            telefone.setNumero(rs.getString("num_telefone"));
            telefones.add(telefone);
        }
        
        return telefones;
        
    }
    
}
