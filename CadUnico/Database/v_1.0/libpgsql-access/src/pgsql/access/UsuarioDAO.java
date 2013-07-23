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
public class UsuarioDAO {
    
    public UsuarioDAO() {
        
    }
    
    public int inserirUsuario(com.access.Usuario usuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_usuario(?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, usuario.getGrupo().getId());
        stmt.setInt(3, usuario.getDepartamento().getId());
        stmt.setString(4, txtMgr.addSlashes(usuario.getUsuario()));
        stmt.setString(5, txtMgr.addSlashes(usuario.getSenha()));
        stmt.setString(6, txtMgr.addSlashes(usuario.getFoto()));
        stmt.setString(7, txtMgr.addSlashes(usuario.getNome()));
        stmt.setString(8, txtMgr.addSlashes(usuario.getEmail()));
        stmt.setString(9, txtMgr.addSlashes(usuario.getAtivo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.access.Usuario selecionarUsuarioPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_usuario_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.access.Usuario selecionarUsuarioPorNomeUsuario(String nomeUsuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_usuario_por_nomeusuario(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nomeUsuario));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.access.Usuario selecionarUsuarioCompletoPorNomeUsuario(String nomeUsuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_usuario_completo_por_nomeusuario(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nomeUsuario));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionarCompleto(rs);
        
    }
    
    public java.util.List<com.access.Usuario> procurarUsuariosCompletosPorNomeUsuario(String nomeUsuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_procurar_usuario_completo_por_nomeusuario(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nomeUsuario));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listarCompleto(rs);
        
    }
    
    public java.util.List<com.access.Usuario> procurarUsuariosCompletosPorNome(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_procurar_usuario_completo_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nome));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listarCompleto(rs);
        
    }
    
    public java.util.List<com.access.Usuario> procurarUsuariosCompletosPorEmail(String email) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_procurar_usuario_completo_por_email(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(email));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listarCompleto(rs);
        
    }
    
    public java.util.List<com.access.Usuario> listarUsuarios() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_usuarios";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.access.Usuario> listarUsuariosCompletos() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_usuarios_completos";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listarCompleto(rs);
        
    }
    
    public com.access.Usuario logarUsuario(com.access.Usuario usuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_logon_usuario(?, ?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(usuario.getUsuario()));
        stmt.setString(2, txtMgr.addSlashes(usuario.getSenha()));
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return selecionar(rs);
        
    }
    
    public int alterarUsuario(com.access.Usuario usuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_usuario(?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, usuario.getGrupo().getId());
        stmt.setInt(3, usuario.getDepartamento().getId());
        stmt.setString(4, txtMgr.addSlashes(usuario.getUsuario()));
        stmt.setString(5, txtMgr.addSlashes(usuario.getFoto()));
        stmt.setString(6, txtMgr.addSlashes(usuario.getNome()));
        stmt.setString(7, txtMgr.addSlashes(usuario.getEmail()));
        stmt.setString(8, txtMgr.addSlashes(usuario.getAtivo()));
        stmt.setInt(9, usuario.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int alterarFotoUsuario(com.access.Usuario usuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_foto_usuario(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(usuario.getFoto()));
        stmt.setInt(3, usuario.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int alterarSenhaUsuarioPorNomeUsuario(com.access.Usuario usuario) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_senha_usuario(?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(usuario.getSenha()));
        stmt.setString(3, txtMgr.addSlashes(usuario.getUsuario()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirUsuarioPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_usuario(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.access.Usuario selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("id_grupo"));
            
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("id_departamento"));
            
            com.access.Usuario usuario = new com.access.Usuario(grupo, departamento);
            usuario.setId(rs.getInt("id"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setFoto(rs.getString("foto"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setAtivo(rs.getString("ativo"));
            return usuario;
        } else {
            return null;
        }
        
    }
    
    private com.access.Usuario selecionarCompleto(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("d_id"));
            departamento.setSigla(rs.getString("d_sigla"));
            departamento.setNome(rs.getString("d_nome"));
            departamento.setDescricao(rs.getString("d_descricao"));
            departamento.setAtivo(rs.getString("d_ativo"));
            
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("g_id"));
            grupo.setNome(rs.getString("g_nome"));
            grupo.setDescricao(rs.getString("g_descricao"));
            grupo.setAtivo(rs.getString("g_ativo"));
            
            com.access.Usuario usuario = new com.access.Usuario(grupo, departamento);
            usuario.setId(rs.getInt("u_id"));
            usuario.setUsuario(rs.getString("u_usuario"));
            usuario.setSenha(rs.getString("u_senha"));
            usuario.setFoto(rs.getString("u_foto"));
            usuario.setNome(rs.getString("u_nome"));
            usuario.setEmail(rs.getString("u_email"));
            usuario.setAtivo(rs.getString("u_ativo"));
            return usuario;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.access.Usuario> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.access.Usuario> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("id_grupo"));
            
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("id_departamento"));
            
            com.access.Usuario usuario = new com.access.Usuario(grupo, departamento);
            usuario.setId(rs.getInt("id"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setFoto(rs.getString("foto"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setAtivo(rs.getString("ativo"));
            temp.add(usuario);
        }
        
        return temp;
        
    }
    
    private java.util.List<com.access.Usuario> listarCompleto(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.access.Usuario> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("d_id"));
            departamento.setSigla(rs.getString("d_sigla"));
            departamento.setNome(rs.getString("d_nome"));
            departamento.setDescricao(rs.getString("d_descricao"));
            departamento.setAtivo(rs.getString("d_ativo"));
            
            com.access.GrupoUsuario grupo = new com.access.GrupoUsuario();
            grupo.setId(rs.getInt("g_id"));
            grupo.setNome(rs.getString("g_nome"));
            grupo.setDescricao(rs.getString("g_descricao"));
            grupo.setAtivo(rs.getString("g_ativo"));
            
            com.access.Usuario usuario = new com.access.Usuario(grupo, departamento);
            usuario.setId(rs.getInt("u_id"));
            usuario.setUsuario(rs.getString("u_usuario"));
            usuario.setSenha(rs.getString("u_senha"));
            usuario.setFoto(rs.getString("u_foto"));
            usuario.setNome(rs.getString("u_nome"));
            usuario.setEmail(rs.getString("u_email"));
            usuario.setAtivo(rs.getString("u_ativo"));
            temp.add(usuario);
        }
        
        return temp;
        
    }
    
}
