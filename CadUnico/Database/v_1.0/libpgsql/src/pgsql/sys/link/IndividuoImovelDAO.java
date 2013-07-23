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
public class IndividuoImovelDAO {
    
    public IndividuoImovelDAO() {
        
    }
    
    public int inserirIndividuoImovel(com.sys.social.Individuo individuo, com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_inserir_individuo_imovel(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, individuo.getId());
        stmt.setLong(3, imovel.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirIndividuoImovel(com.sys.social.Individuo individuo, com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_individuo_imovel(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, individuo.getId());
        stmt.setLong(3, imovel.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
}
