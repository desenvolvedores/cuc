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
public class CertidaoIndividuoDAO {
    
    public CertidaoIndividuoDAO() {
        
    }
    
    public int inserirCertidaoIndividuo(com.sys.social.CertidaoIndividuo nascimento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_certidao_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, nascimento.getIndividuo().getId());
        stmt.setDate(3, dtMgr.parseDateToSQL(nascimento.getDataNascimento()));
        stmt.setString(4, txtMgr.addSlashes(nascimento.getOndeNasceu()));
        stmt.setString(5, txtMgr.addSlashes(nascimento.getNaturalidade()));
        stmt.setString(6, txtMgr.addSlashes(nascimento.getNascimentoRegistrado()));
        stmt.setString(7, txtMgr.addSlashes(nascimento.getCodigoCartorio()));
        stmt.setString(8, txtMgr.addSlashes(nascimento.getNomeCartorio()));
        stmt.setString(9, txtMgr.addSlashes(nascimento.getTipoCertidao()));
        stmt.setDate(10, dtMgr.parseDateToSQL(nascimento.getDataRegCertidao()));
        stmt.setString(11, txtMgr.addSlashes(nascimento.getMunicipioCertidao()));
        stmt.setString(12, txtMgr.addSlashes(nascimento.getUfCertidao()));
        stmt.setString(13, txtMgr.addSlashes(nascimento.getNumeroTermo()));
        stmt.setString(14, txtMgr.addSlashes(nascimento.getNumeroLivro()));
        stmt.setString(15, txtMgr.addSlashes(nascimento.getNumeroFolha()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.CertidaoIndividuo selecionarCertidaoIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_certidao_individuo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public com.sys.social.CertidaoIndividuo selecionarCertidaoIndividuoPorIDIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_certidao_individuo_por_id_individuo(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, individuo.getId());
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public int alterarCertidaoIndividuo(com.sys.social.CertidaoIndividuo nascimento) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.data.DateManager dtMgr = new com.data.DateManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_certidao_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, nascimento.getIndividuo().getId());
        stmt.setDate(3, dtMgr.parseDateToSQL(nascimento.getDataNascimento()));
        stmt.setString(4, txtMgr.addSlashes(nascimento.getOndeNasceu()));
        stmt.setString(5, txtMgr.addSlashes(nascimento.getNaturalidade()));
        stmt.setString(6, txtMgr.addSlashes(nascimento.getNascimentoRegistrado()));
        stmt.setString(7, txtMgr.addSlashes(nascimento.getCodigoCartorio()));
        stmt.setString(8, txtMgr.addSlashes(nascimento.getNomeCartorio()));
        stmt.setString(9, txtMgr.addSlashes(nascimento.getTipoCertidao()));
        stmt.setDate(10, dtMgr.parseDateToSQL(nascimento.getDataRegCertidao()));
        stmt.setString(11, txtMgr.addSlashes(nascimento.getMunicipioCertidao()));
        stmt.setString(12, txtMgr.addSlashes(nascimento.getUfCertidao()));
        stmt.setString(13, txtMgr.addSlashes(nascimento.getNumeroTermo()));
        stmt.setString(14, txtMgr.addSlashes(nascimento.getNumeroLivro()));
        stmt.setString(15, txtMgr.addSlashes(nascimento.getNumeroFolha()));
        stmt.setLong(16, nascimento.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirCertidaoIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_certidao_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.CertidaoIndividuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.data.DateManager dtMgr = new com.data.DateManager();
            
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id_individuo"));
            
            com.sys.social.CertidaoIndividuo certidao = new com.sys.social.CertidaoIndividuo(individuo);
            certidao.setId(rs.getLong("id"));
            certidao.setDataNascimento(dtMgr.parseDate(rs.getDate("dt_nascimento")));
            certidao.setOndeNasceu(rs.getString("onde_nasceu"));
            certidao.setNaturalidade(rs.getString("naturalidade"));
            certidao.setNascimentoRegistrado(rs.getString("nasc_registrado"));
            certidao.setCodigoCartorio(rs.getString("cd_cartorio"));
            certidao.setNomeCartorio(rs.getString("nm_cartorio"));
            certidao.setTipoCertidao(rs.getString("tipo_certidao"));
            certidao.setDataRegCertidao(dtMgr.parseDate(rs.getDate("dt_reg_certidao")));
            certidao.setMunicipioCertidao(rs.getString("municipio_certidao"));
            certidao.setUfCertidao(rs.getString("uf_certidao"));
            certidao.setNumeroTermo(rs.getString("num_termo"));
            certidao.setNumeroLivro(rs.getString("num_livro"));
            certidao.setNumeroFolha(rs.getString("num_folha"));
            
            return certidao;
        } else {
            return null;
        }
        
    }
    
}
