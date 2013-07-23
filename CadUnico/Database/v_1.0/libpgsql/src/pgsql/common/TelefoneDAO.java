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
public class TelefoneDAO {
    
    public TelefoneDAO() {
        
    }
    
    public int alterarTelefone(com.common.Telefone telefone) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_telefone(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(telefone.getTipo()));
        stmt.setString(3, txtMgr.addSlashes(telefone.getNumero()));
        stmt.setLong(4, telefone.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirTelefonePorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_telefone(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
}
