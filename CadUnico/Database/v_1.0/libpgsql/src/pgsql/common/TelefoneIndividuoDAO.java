/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.common;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class TelefoneIndividuoDAO extends TelefoneDAO {
    
    public TelefoneIndividuoDAO() {
        
    }
    
    public int inserirTelefone(com.common.TelefoneIndividuo telefone) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_telefone_individuo(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, telefone.getIdIndividuo());
        stmt.setString(3, txtMgr.addSlashes(telefone.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(telefone.getNumero()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.common.TelefoneIndividuo selecionarTelefonePorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_telefone_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.common.TelefoneIndividuo> procurarTelefonesPorIDIndividuo(long idIndividuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_telefone_por_id_individuo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idIndividuo);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public int excluirTelefonesPorIDIndividuo(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_telefone_por_id_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.common.TelefoneIndividuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.common.TelefoneIndividuo telefone = new com.common.TelefoneIndividuo();
            telefone.setId(rs.getLong("id"));
            telefone.setIdIndividuo(rs.getLong("id_individuo"));
            telefone.setTipo(rs.getString("tipo_telefone"));
            telefone.setNumero(rs.getString("num_telefone"));
            
            return telefone;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.common.TelefoneIndividuo> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.common.TelefoneIndividuo> telefones = new java.util.ArrayList<>();
        while (rs.next()) {
            com.common.TelefoneIndividuo telefone = new com.common.TelefoneIndividuo();
            telefone.setId(rs.getLong("id"));
            telefone.setIdIndividuo(rs.getLong("id_individuo"));
            telefone.setTipo(rs.getString("tipo_telefone"));
            telefone.setNumero(rs.getString("num_telefone"));
            telefones.add(telefone);
        }
        
        return telefones;
        
    }
    
}
