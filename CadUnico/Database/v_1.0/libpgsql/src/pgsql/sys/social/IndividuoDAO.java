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
public class IndividuoDAO {
    
    public IndividuoDAO() {
        
    }
    
    public int inserirIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_inserir_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, individuo.getIdFamilia());
        stmt.setString(3, txtMgr.addSlashes(individuo.getResponsavelFamilia()));
        stmt.setString(4, txtMgr.addSlashes(individuo.getNome()));
        stmt.setString(5, txtMgr.addSlashes(individuo.getApelido()));
        stmt.setString(6, txtMgr.addSlashes(individuo.getIdade()));
        stmt.setString(7, txtMgr.addSlashes(individuo.getSexo()));
        stmt.setString(8, txtMgr.addSlashes(individuo.getEtnia()));
        stmt.setString(9, txtMgr.addSlashes(individuo.getEstadoCivil()));
        stmt.setString(10, txtMgr.addSlashes(individuo.getNomeMae()));
        stmt.setString(11, txtMgr.addSlashes(individuo.getNomePai()));
        stmt.setString(12, txtMgr.addSlashes(individuo.getResponsavel()));
        stmt.setString(13, txtMgr.addSlashes(individuo.getGrauParentesco()));
        stmt.setString(15, txtMgr.addSlashes(individuo.getObservacoes()));
        stmt.setString(14, txtMgr.addSlashes(individuo.getQuemPrestouInformacao()));
        stmt.setString(16, txtMgr.addSlashes(individuo.getCpfInformante()));
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public com.sys.social.Individuo selecionarIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM fn_selecionar_individuo_por_id(?)";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.setLong(1, id);
        java.sql.ResultSet rs = stmt.executeQuery();
        
        return selecionar(rs);
        
    }
    
    public java.util.List<com.sys.social.Individuo> listarIndividuos() 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "SELECT * FROM vw_individuos";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        java.sql.ResultSet rs = stmt.executeQuery();
        com.db.DBConnection.getInstance().getConnection().commit();
        
        return listar(rs);
        
    }
    
    public int alterarIndividuo(com.sys.social.Individuo individuo) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        
        java.lang.String sql = "{ ? = CALL fn_alterar_individuo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, individuo.getIdFamilia());
        stmt.setString(3, txtMgr.addSlashes(individuo.getResponsavelFamilia()));
        stmt.setString(4, txtMgr.addSlashes(individuo.getNome()));
        stmt.setString(5, txtMgr.addSlashes(individuo.getApelido()));
        stmt.setString(6, txtMgr.addSlashes(individuo.getIdade()));
        stmt.setString(7, txtMgr.addSlashes(individuo.getSexo()));
        stmt.setString(8, txtMgr.addSlashes(individuo.getEtnia()));
        stmt.setString(9, txtMgr.addSlashes(individuo.getEstadoCivil()));
        stmt.setString(10, txtMgr.addSlashes(individuo.getNomeMae()));
        stmt.setString(11, txtMgr.addSlashes(individuo.getNomePai()));
        stmt.setString(12, txtMgr.addSlashes(individuo.getResponsavel()));
        stmt.setString(13, txtMgr.addSlashes(individuo.getGrauParentesco()));
        stmt.setString(14, txtMgr.addSlashes(individuo.getObservacoes()));
        stmt.setString(15, txtMgr.addSlashes(individuo.getQuemPrestouInformacao()));
        stmt.setString(16, txtMgr.addSlashes(individuo.getCpfInformante()));
        stmt.setLong(17, individuo.getId());
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    public int excluirIndividuoPorID(long id) 
            throws java.lang.ClassNotFoundException, java.sql.SQLException {
        
        java.lang.String sql = "{ ? = CALL fn_excluir_individuo(?) }";
        java.sql.CallableStatement stmt = com.db.DBConnection.getInstance().getConnection().prepareCall(sql);
        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.setLong(2, id);
        stmt.execute();
        return stmt.getInt(1);
        
    }
    
    private com.sys.social.Individuo selecionar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        if (rs.next()) {
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id"));
            individuo.setIdFamilia(rs.getLong("id_familia"));
            individuo.setResponsavelFamilia(rs.getString("responsavel_familia"));
            individuo.setNome(rs.getString("nome"));
            individuo.setApelido(rs.getString("apelido"));
            individuo.setIdade(rs.getString("idade"));
            individuo.setSexo(rs.getString("sexo"));
            individuo.setEtnia(rs.getString("etnia"));
            individuo.setEstadoCivil(rs.getString("estado_civil"));
            individuo.setNomeMae(rs.getString("nome_mae"));
            individuo.setNomePai(rs.getString("nome_pai"));
            individuo.setResponsavel(rs.getString("responsavel"));
            individuo.setGrauParentesco(rs.getString("grau_parentesco"));
            individuo.setObservacoes(rs.getString("observacoes"));
            individuo.setQuemPrestouInformacao(rs.getString("prestou_informacao"));
            individuo.setCpfInformante(rs.getString("cpf_informante"));
            
            return individuo;
        } else {
            return null;
        }
        
    }
    
    private java.util.List<com.sys.social.Individuo> listar(java.sql.ResultSet rs) 
            throws java.sql.SQLException {
        
        java.util.List<com.sys.social.Individuo> individuos = new java.util.ArrayList<>();
        while (rs.next()) {
            com.sys.social.Individuo individuo = new com.sys.social.Individuo();
            individuo.setId(rs.getLong("id"));
            individuo.setIdFamilia(rs.getLong("id_familia"));
            individuo.setResponsavelFamilia(rs.getString("responsavel_familia"));
            individuo.setNome(rs.getString("nome"));
            individuo.setApelido(rs.getString("apelido"));
            individuo.setIdade(rs.getString("idade"));
            individuo.setSexo(rs.getString("sexo"));
            individuo.setEtnia(rs.getString("etnia"));
            individuo.setEstadoCivil(rs.getString("estado_civil"));
            individuo.setNomeMae(rs.getString("nome_mae"));
            individuo.setNomePai(rs.getString("nome_pai"));
            individuo.setResponsavel(rs.getString("responsavel"));
            individuo.setGrauParentesco(rs.getString("grau_parentesco"));
            individuo.setObservacoes(rs.getString("observacoes"));
            individuo.setQuemPrestouInformacao(rs.getString("prestou_informacao"));
            individuo.setCpfInformante(rs.getString("cpf_informante"));
            individuos.add(individuo);
        }
        
        return individuos;
        
    }
    
}
