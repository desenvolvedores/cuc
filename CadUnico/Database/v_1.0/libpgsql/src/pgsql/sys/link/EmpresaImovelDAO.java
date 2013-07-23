/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.link;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EmpresaImovelDAO {
    
    public EmpresaImovelDAO() {
        
    }
    
    public int inserirEmpresaImovel(com.sys.social.Empresa empresa, com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_inserir_empresa_imovel(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, empresa.getId());
        stmt.setLong(3, imovel.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirEmpresaImovel(com.sys.social.Empresa empresa, com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_empresa_imovel(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, empresa.getId());
        stmt.setLong(3, imovel.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
}
