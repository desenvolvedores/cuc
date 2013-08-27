/*
 * Classe pertencente a API de acesso ao SGBD PostgreSQL "libpgsql".
 */
package pgsql.sys.habitacional;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class EnderecoImovelDAO {
    
    public EnderecoImovelDAO() {
        
    }
    
    public int inserirEnderecoImovel(com.sys.habitacional.EnderecoImovel endereco) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_endereco_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, endereco.getIdImovel());
        stmt.setLong(3, endereco.getIdMunicipio());
        stmt.setString(4, txtMgr.addSlashes(endereco.getTipoLogradouro()));
        stmt.setString(5, txtMgr.addSlashes(endereco.getLogradouro()));
        stmt.setString(6, txtMgr.addSlashes(endereco.getNumero()));
        stmt.setString(7, txtMgr.addSlashes(endereco.getComplemento()));
        stmt.setString(8, txtMgr.addSlashes(endereco.getCEP()));
        stmt.setString(9, txtMgr.addSlashes(endereco.getBairro()));
        stmt.setString(10, txtMgr.addSlashes(endereco.getTipoArea()));
        stmt.setString(11, endereco.getLatitude());
        stmt.setString(12, endereco.getLongitude());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.habitacional.EnderecoImovel selecionarEnderecoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_endereco_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.habitacional.EnderecoImovel selecionarEnderecoImovelPorIDImovel(long idImovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_endereco_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, idImovel);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarEnderecoImovel(com.sys.habitacional.EnderecoImovel endereco) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_endereco_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, endereco.getIdImovel());
        stmt.setLong(3, endereco.getIdMunicipio());
        stmt.setString(4, txtMgr.addSlashes(endereco.getTipoLogradouro()));
        stmt.setString(5, txtMgr.addSlashes(endereco.getLogradouro()));
        stmt.setString(6, txtMgr.addSlashes(endereco.getNumero()));
        stmt.setString(7, txtMgr.addSlashes(endereco.getComplemento()));
        stmt.setString(8, txtMgr.addSlashes(endereco.getCEP()));
        stmt.setString(9, txtMgr.addSlashes(endereco.getBairro()));
        stmt.setString(10, txtMgr.addSlashes(endereco.getTipoArea()));
        stmt.setString(11, endereco.getLatitude());
        stmt.setString(12, endereco.getLongitude());
        stmt.setLong(13, endereco.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirEnderecoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_endereco_imovel(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.habitacional.EnderecoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            
            com.sys.habitacional.EnderecoImovel endereco = new com.sys.habitacional.EnderecoImovel();
            endereco.setId(rs.getLong("id"));
            endereco.setIdImovel(rs.getLong("id_imovel"));
            endereco.setIdMunicipio(rs.getLong("id_municipio"));
            endereco.setTipoLogradouro(rs.getString("tipo_logradouro"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setCEP(rs.getString("cep"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setTipoArea(rs.getString("tipo_area"));
            endereco.setLatitude(rs.getString("latitude"));
            endereco.setLongitude(rs.getString("longitude"));
            return endereco;
            
        } else {
            return null;
        }
        
    }
    
}
