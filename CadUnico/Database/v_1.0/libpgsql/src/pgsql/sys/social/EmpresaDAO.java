/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.social;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EmpresaDAO {
    
    public EmpresaDAO() {
        
    }
    
    public int inserirEmpresa(com.sys.social.Empresa empresa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_empresa(?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(empresa.getRazaoSocial()));
        stmt.setString(3, txtMgr.addSlashes(empresa.getNomeFantasia()));
        stmt.setString(4, txtMgr.addSlashes(empresa.getFundador()));
        stmt.setDate(5, dtMgr.parseDateToSQL(empresa.getDataFundacao()));
        stmt.setString(6, txtMgr.addSlashes(empresa.getLocalOrigem()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.Empresa selecionarEmpresaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_empresa_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.social.Empresa> procurarEmpresaPorRazaoSocial(java.lang.String razaoSocial) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_empresa_por_razao_social(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, razaoSocial);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.social.Empresa> procurarEmpresaPorFantasia(java.lang.String fantasia) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_procurar_empresa_por_fantasia(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setString(1, fantasia);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return listar(rs);
        
    }
    
    public java.util.List<com.sys.social.Empresa> listarEmpresas() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_empresas";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarEmpresa(com.sys.social.Empresa empresa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_empresa(?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setString(2, txtMgr.addSlashes(empresa.getRazaoSocial()));
        stmt.setString(3, txtMgr.addSlashes(empresa.getNomeFantasia()));
        stmt.setString(4, txtMgr.addSlashes(empresa.getFundador()));
        stmt.setDate(5, dtMgr.parseDateToSQL(empresa.getDataFundacao()));
        stmt.setString(6, txtMgr.addSlashes(empresa.getLocalOrigem()));
        stmt.setLong(7, empresa.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirEmpresaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_empresa(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.Empresa selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dtMgr = new com.data.DateManager();
            
            com.sys.social.Empresa empresa = new com.sys.social.Empresa();
            empresa.setId(rs.getLong("id"));
            empresa.setRazaoSocial(rs.getString("razao_social"));
            empresa.setNomeFantasia(rs.getString("nm_fantasia"));
            empresa.setFundador(rs.getString("fundador"));
            empresa.setDataFundacao(dtMgr.parseDate(rs.getDate("dt_fundacao")));
            empresa.setLocalOrigem(rs.getString("local_origem"));
            
            return empresa;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.social.Empresa> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        com.data.DateManager dtMgr = new com.data.DateManager();
        java.util.List<com.sys.social.Empresa> empresas = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.social.Empresa empresa = new com.sys.social.Empresa();
            empresa.setId(rs.getLong("id"));
            empresa.setRazaoSocial(rs.getString("razao_social"));
            empresa.setNomeFantasia(rs.getString("nm_fantasia"));
            empresa.setFundador(rs.getString("fundador"));
            empresa.setDataFundacao(dtMgr.parseDate(rs.getDate("dt_fundacao")));
            empresa.setLocalOrigem(rs.getString("local_origem"));
            empresas.add(empresa);
        }
        
        return empresas;
        
    }
    
}
