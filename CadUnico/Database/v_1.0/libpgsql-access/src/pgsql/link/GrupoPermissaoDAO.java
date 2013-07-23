/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql-access".
 */
package pgsql.link;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class GrupoPermissaoDAO {
    
    public GrupoPermissaoDAO() {
        
    }
    
    public int inserirGrupoPermissao(com.access.GrupoUsuario grupo, com.access.Permissao permissao, char permitido) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_grupo_permissao(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, grupo.getId());
        stmt.setInt(3, permissao.getId());
        stmt.setString(4, txtMgr.addSlashes(String.valueOf(permitido)));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int alterarGrupoPermissao(com.access.GrupoUsuario grupo, com.access.Permissao permissao, char permitido) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_grupo_permissao(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(String.valueOf(permitido)));
        stmt.setInt(3, grupo.getId());
        stmt.setInt(4, permissao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirGrupoPermissao(com.access.GrupoUsuario grupo, com.access.Permissao permissao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_grupo_permissao(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, grupo.getId());
        stmt.setInt(3, permissao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
}
