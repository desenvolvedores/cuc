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
public class DocumentoEmpresaDAO {
    
    public DocumentoEmpresaDAO() {
        
    }
    
    public int inserirDocumentoEmpresa(com.sys.social.DocumentoEmpresa documento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_documentos_empresa(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, documento.getEmpresa().getId());
        stmt.setString(3, txtMgr.addSlashes(documento.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(documento.getNumero()));
        stmt.setString(5, txtMgr.addSlashes(documento.getSerie()));
        stmt.setDate(6, dtMgr.parseDateToSQL(documento.getDataEmissao()));
        stmt.setString(7, txtMgr.addSlashes(documento.getUf()));
        stmt.setString(8, txtMgr.addSlashes(documento.getCidade()));
        stmt.setString(9, txtMgr.addSlashes(documento.getOrgaoEmissor()));
        stmt.setString(10, txtMgr.addSlashes(documento.getZona()));
        stmt.setString(11, txtMgr.addSlashes(documento.getSecao()));
        stmt.setString(12, txtMgr.addSlashes(documento.getCategoria()));
        stmt.setString(13, txtMgr.addSlashes(documento.getValidade()));
        stmt.setString(14, txtMgr.addSlashes(documento.getStatus()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.DocumentoEmpresa selecionarDocumentoEmpresaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_documentos_empresa_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.social.DocumentoEmpresa selecionarDocumentoEmpresaPorIDEmpresa(com.sys.social.Empresa empresa) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_documentos_empresa_por_id_empresa(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, empresa.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarDocumentoEmpresa(com.sys.social.DocumentoEmpresa documento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_documentos_empresa(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, documento.getEmpresa().getId());
        stmt.setString(3, txtMgr.addSlashes(documento.getTipo()));
        stmt.setString(4, txtMgr.addSlashes(documento.getNumero()));
        stmt.setString(5, txtMgr.addSlashes(documento.getSerie()));
        stmt.setDate(6, dtMgr.parseDateToSQL(documento.getDataEmissao()));
        stmt.setString(7, txtMgr.addSlashes(documento.getUf()));
        stmt.setString(8, txtMgr.addSlashes(documento.getCidade()));
        stmt.setString(9, txtMgr.addSlashes(documento.getOrgaoEmissor()));
        stmt.setString(10, txtMgr.addSlashes(documento.getZona()));
        stmt.setString(11, txtMgr.addSlashes(documento.getSecao()));
        stmt.setString(12, txtMgr.addSlashes(documento.getCategoria()));
        stmt.setString(13, txtMgr.addSlashes(documento.getValidade()));
        stmt.setString(14, txtMgr.addSlashes(documento.getStatus()));
        stmt.setLong(15, documento.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirDocumentoEmpresaPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_documentos_empresa(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.DocumentoEmpresa selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dtMgr = new com.data.DateManager();
            com.sys.social.Empresa empresa = new com.sys.social.Empresa();
            empresa.setId(rs.getLong("id_empresa"));
            
            com.sys.social.DocumentoEmpresa documento = new com.sys.social.DocumentoEmpresa(empresa);
            documento.setId(rs.getLong("id"));
            documento.setTipo(rs.getString("tipo"));
            documento.setNumero(rs.getString("numero"));
            documento.setSerie(rs.getString("serie"));
            documento.setDataEmissao(dtMgr.parseDate(rs.getDate("data_emissao")));
            documento.setUf(rs.getString("uf_emissao"));
            documento.setCidade(rs.getString("cidade"));
            documento.setOrgaoEmissor(rs.getString("orgao_emissor"));
            documento.setZona(rs.getString("zona"));
            documento.setSecao(rs.getString("secao"));
            documento.setCategoria(rs.getString("categoria"));
            documento.setValidade(rs.getString("validade"));
            documento.setStatus(rs.getString("sts_documento"));
            
            return documento;
        } else {
            return null;
        }
        
    }
    
}
