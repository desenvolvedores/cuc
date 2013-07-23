/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql-access".
 */
package pgsql.common;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DepartamentoDAO {
    
    public DepartamentoDAO() {
        
    }
    
    public int inserirDepartamento(com.common.Departamento departamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_departamento(?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(departamento.getSigla()));
        stmt.setString(3, txtMgr.addSlashes(departamento.getNome()));
        stmt.setString(4, txtMgr.addSlashes(departamento.getDescricao()));
        stmt.setString(5, txtMgr.addSlashes(departamento.getAtivo()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.common.Departamento selecionarDepartamentoPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_departamento_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setInt(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.common.Departamento selecionarDepartamentoPorSigla(String sigla) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_departamento_por_sigla(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(sigla));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.common.Departamento> procurarDepartamentoPorNome(String nome) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "SELECT * FROM fn_procurar_departamento_por_nome(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, txtMgr.addSlashes(nome));
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.common.Departamento> listarDepartamentos() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_departamentos";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarDepartamento(com.common.Departamento departamento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_departamento(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(departamento.getSigla()));
        stmt.setString(3, txtMgr.addSlashes(departamento.getNome()));
        stmt.setString(4, txtMgr.addSlashes(departamento.getDescricao()));
        stmt.setString(5, txtMgr.addSlashes(departamento.getAtivo()));
        stmt.setInt(6, departamento.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirDepartamentoPorID(int id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_departamento(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setInt(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.common.Departamento selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("id"));
            departamento.setSigla(rs.getString("sigla"));
            departamento.setNome(rs.getString("nome"));
            departamento.setDescricao(rs.getString("descricao"));
            departamento.setAtivo(rs.getString("ativo"));
            return departamento;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.common.Departamento> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.common.Departamento> temp = new java.util.ArrayList<>();
        while (rs.next()) {
            com.common.Departamento departamento = new com.common.Departamento();
            departamento.setId(rs.getInt("id"));
            departamento.setSigla(rs.getString("sigla"));
            departamento.setNome(rs.getString("nome"));
            departamento.setDescricao(rs.getString("descricao"));
            departamento.setAtivo(rs.getString("ativo"));
            temp.add(departamento);
        }
        
        return temp;
        
    }
    
}
