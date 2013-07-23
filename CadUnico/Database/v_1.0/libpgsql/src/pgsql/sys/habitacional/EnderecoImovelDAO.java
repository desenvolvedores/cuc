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
    
    public int inserirEnderecoImovel(com.common.EnderecoImovel endereco) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_endereco_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, endereco.getImovel().getId());
        stmt.setString(3, txtMgr.addSlashes(endereco.getTipoLogradouro()));
        stmt.setString(4, txtMgr.addSlashes(endereco.getLogradouro()));
        stmt.setString(5, txtMgr.addSlashes(endereco.getNumero()));
        stmt.setString(6, txtMgr.addSlashes(endereco.getComplemento()));
        stmt.setString(7, txtMgr.addSlashes(endereco.getCEP()));
        stmt.setString(8, txtMgr.addSlashes(endereco.getBairro()));
        stmt.setString(9, txtMgr.addSlashes(endereco.getMunicipio()));
        stmt.setString(10, txtMgr.addSlashes(endereco.getUF()));
        stmt.setString(11, txtMgr.addSlashes(endereco.getTipoArea()));
        stmt.setDouble(12, endereco.getLatitude());
        stmt.setDouble(13, endereco.getLongitude());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.common.EnderecoImovel selecionarEnderecoImovelPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_endereco_imovel_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.common.EnderecoImovel selecionarEnderecoImovelPorIDImovel(com.sys.habitacional.Imovel imovel) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_endereco_imovel_por_id_imovel(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, imovel.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarEnderecoImovel(com.common.EnderecoImovel endereco) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_endereco_imovel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, endereco.getImovel().getId());
        stmt.setString(3, txtMgr.addSlashes(endereco.getTipoLogradouro()));
        stmt.setString(4, txtMgr.addSlashes(endereco.getLogradouro()));
        stmt.setString(5, txtMgr.addSlashes(endereco.getNumero()));
        stmt.setString(6, txtMgr.addSlashes(endereco.getComplemento()));
        stmt.setString(7, txtMgr.addSlashes(endereco.getCEP()));
        stmt.setString(8, txtMgr.addSlashes(endereco.getBairro()));
        stmt.setString(9, txtMgr.addSlashes(endereco.getMunicipio()));
        stmt.setString(10, txtMgr.addSlashes(endereco.getUF()));
        stmt.setString(11, txtMgr.addSlashes(endereco.getTipoArea()));
        stmt.setDouble(12, endereco.getLatitude());
        stmt.setDouble(13, endereco.getLongitude());
        stmt.setLong(14, endereco.getId());
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
    
    private com.common.EnderecoImovel selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.habitacional.Imovel imovel = new com.sys.habitacional.Imovel();
            imovel.setId(rs.getLong("id_imovel"));
            
            com.common.EnderecoImovel endereco = new com.common.EnderecoImovel(imovel);
            endereco.setId(rs.getLong("id"));
            endereco.setTipoLogradouro(rs.getString("tipo_logradouro"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setCEP(rs.getString("cep"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setMunicipio(rs.getString("municipio"));
            endereco.setUF(rs.getString("uf"));
            endereco.setTipoArea(rs.getString("tipo_area"));
            endereco.setLatitude(rs.getDouble("latitude"));
            endereco.setLongitude(rs.getDouble("longitude"));
            return endereco;
        } else {
            return null;
        }
        
    }
    
}
