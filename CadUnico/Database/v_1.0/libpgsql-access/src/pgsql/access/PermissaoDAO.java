/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql-access".
 */
package pgsql.access;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class PermissaoDAO {
    
    public PermissaoDAO() {
        
    }
    
    public int inserirPermissao(com.access.Permissao permissao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_permissao(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(permissao.getNome()));
        stmt.setString(3, txtMgr.addSlashes(permissao.getDescricao()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.access.Permissao selecionarPermissaoPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_permissao_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.access.Permissao> listarPermissoes() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_permissoes";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarPermissao(com.access.Permissao permissao) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_permissao(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(permissao.getNome()));
        stmt.setString(3, txtMgr.addSlashes(permissao.getDescricao()));
        stmt.setInt(4, permissao.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirPermissaoPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_permissao(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.access.Permissao selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.access.Permissao permissao = new com.access.Permissao();
            permissao.setId(rs.getInt("id"));
            permissao.setNome(rs.getString("nome"));
            permissao.setDescricao(rs.getString("descricao"));
            return permissao;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.access.Permissao> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.access.Permissao> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.access.Permissao permissao = new com.access.Permissao();
            permissao.setId(rs.getInt("id"));
            permissao.setNome(rs.getString("nome"));
            permissao.setDescricao(rs.getString("descricao"));
            temp.add(permissao);
        }
        
        return temp;
        
    }
    
}
