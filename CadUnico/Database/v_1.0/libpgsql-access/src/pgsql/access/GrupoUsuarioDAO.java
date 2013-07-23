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
public class GrupoUsuarioDAO {
    
    public GrupoUsuarioDAO() {
        
    }
    
    public int inserirGrupoUsuario(com.access.GrupoUsuario grupo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_grupo(?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(grupo.getNome()));
        stmt.setString(3, txtMgr.addSlashes(grupo.getDescricao()));
        stmt.setString(4, txtMgr.addSlashes(grupo.getAtivo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.access.GrupoUsuario selecionarGrupoUsuarioPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_grupo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.access.GrupoUsuario selecionarGrupoUsuarioPorNome(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_grupo_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nome));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.access.GrupoUsuario> listarGruposUsuario() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_grupos";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarGrupoUsuario(com.access.GrupoUsuario grupo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_grupo(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(grupo.getNome()));
        stmt.setString(3, txtMgr.addSlashes(grupo.getDescricao()));
        stmt.setString(4, txtMgr.addSlashes(grupo.getAtivo()));
        stmt.setInt(5, grupo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirGrupoUsuarioPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_grupo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.access.GrupoUsuario selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("id"));
            grupo.setNome(rs.getString("nome"));
            grupo.setDescricao(rs.getString("descricao"));
            grupo.setAtivo(rs.getString("ativo"));
            return grupo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.access.GrupoUsuario> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.access.GrupoUsuario> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("id"));
            grupo.setNome(rs.getString("nome"));
            grupo.setDescricao(rs.getString("descricao"));
            grupo.setAtivo(rs.getString("ativo"));
            temp.add(grupo);
        }
        
        return temp;
        
    }
    
}
