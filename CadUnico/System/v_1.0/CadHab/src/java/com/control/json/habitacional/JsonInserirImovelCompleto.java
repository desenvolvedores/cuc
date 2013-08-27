/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.control.json.habitacional;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class JsonInserirImovelCompleto extends javax.servlet.http.HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        
        request.setCharacterEncoding("UTF-8");
        java.io.PrintWriter out = response.getWriter();
        
        try {
            
            String token = request.getParameter("auth_token");
            String userKey = request.getParameter("auth_key");
            
            if (com.settings.GerenciadorAcesso.checkAuthentication(token, userKey)) {
                
                com.settings.Configuracao.iniciarConfiguracoes();
                String json = request.getReader().readLine();

                com.utils.JsonManager jsonMgr = new com.utils.JsonManager();
                com.sys.habitacional.Imovel imovel = jsonMgr.parseImovel(json);
                
                if (imovel.getIdNucleo() > 0 
                        & ! imovel.getTipo().isEmpty() 
                        & ! imovel.getTipoPropriedade().isEmpty() 
                        & ! imovel.getDocPropriedade().isEmpty() 
                        & ! imovel.getPagaIPTU().isEmpty() 
                        & ! imovel.getComposicao().getConstrucao().isEmpty() 
                        & ! imovel.getComposicao().getMaterialParede().isEmpty() 
                        & ! imovel.getComposicao().getMaterialPiso().isEmpty() 
                        & ! imovel.getComposicao().getMaterialCobertura().isEmpty() 
                        & ! imovel.getEndereco().getLogradouro().isEmpty() 
                        & ! imovel.getEndereco().getNumero().isEmpty() 
                        & ! imovel.getEndereco().getBairro().isEmpty() 
                        & ! imovel.getEndereco().getTipoLogradouro().isEmpty() 
                        & ! imovel.getEndereco().getTipoArea().isEmpty() 
                        & imovel.getEndereco().getIdMunicipio() > 0 
                        & ! imovel.getServico().getExistePavimentacao().isEmpty() 
                        & ! imovel.getServico().getQualPavimentacao().isEmpty() 
                        & ! imovel.getServico().getIluminacaoUtilizada().isEmpty() 
                        & ! imovel.getServico().getAbastecimentoAgua().isEmpty() 
                        & ! imovel.getServico().getTratamentoAgua().isEmpty() 
                        & ! imovel.getServico().getAguaEncanada().isEmpty() 
                        & ! imovel.getServico().getExisteBanheiro().isEmpty() 
                        & ! imovel.getServico().getEscoamentoSanitario().isEmpty() 
                        & ! imovel.getServico().getTratamentoLixo().isEmpty()) {
                    
                    pgsql.sys.habitacional.ImovelDAO imovelDAO = new pgsql.sys.habitacional.ImovelDAO();

                    long idImovel = imovelDAO.inserirImovel(imovel);
                    
                    if (idImovel > 0) {
                        
                        imovel.setId(idImovel);
                        imovel.getComposicao().setIdImovel(idImovel);
                        imovel.getEndereco().setIdImovel(idImovel);
                        imovel.getServico().setIdImovel(idImovel);
                        imovel.getDemolicao().setIdImovel(idImovel);
                        
                        pgsql.sys.habitacional.ComposicaoImovelDAO composicaoDAO = new pgsql.sys.habitacional.ComposicaoImovelDAO();
                        
                        if (composicaoDAO.inserirComposicaoImovel(imovel.getComposicao()) > 0) {
                            
                            pgsql.sys.habitacional.EnderecoImovelDAO enderecoDAO = new pgsql.sys.habitacional.EnderecoImovelDAO();
                            
                            if (enderecoDAO.inserirEnderecoImovel(imovel.getEndereco()) > 0) {
                                
                                pgsql.sys.habitacional.ServicoImovelDAO servicoDAO = new pgsql.sys.habitacional.ServicoImovelDAO();
                                
                                if (servicoDAO.inserirServicoImovel(imovel.getServico()) > 0) {
                                    
                                    pgsql.sys.habitacional.DemolicaoImovelDAO demolicaoDAO = new pgsql.sys.habitacional.DemolicaoImovelDAO();
                                    
                                    if (demolicaoDAO.inserirDemolicaoImovel(imovel.getDemolicao()) <= 0) {
                                        
                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                        com.sys.Message message = new com.sys.Message();
                                        message.setCode(0);
                                        message.setMessage("Não foi possível cadastrar os dados da demolição do imóvel!");
                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                        out.print(messMgr.parseJson(message));
                                        return;
                                        
                                    }
                                    
                                    com.db.DBConnection.getInstance().getConnection().commit();
                                    com.sys.Message message = new com.sys.Message();
                                    message.setCode(1);
                                    message.setMessage("Os dados do imóvel foram cadastrados com sucesso!");
                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                    out.print(messMgr.parseJson(message));
                                    
                                } else {
                            
                                    com.db.DBConnection.getInstance().getConnection().rollback();
                                    com.sys.Message message = new com.sys.Message();
                                    message.setCode(0);
                                    message.setMessage("Não foi possível cadastrar os dados do serviço do imóvel!");
                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                    out.print(messMgr.parseJson(message));

                                }
                                
                            } else {
                            
                                com.db.DBConnection.getInstance().getConnection().rollback();
                                com.sys.Message message = new com.sys.Message();
                                message.setCode(0);
                                message.setMessage("Não foi possível cadastrar os dados do endereço do imóvel!");
                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                out.print(messMgr.parseJson(message));

                            }
                            
                        } else {
                            
                            com.db.DBConnection.getInstance().getConnection().rollback();
                            com.sys.Message message = new com.sys.Message();
                            message.setCode(0);
                            message.setMessage("Não foi possível cadastrar os dados da composição do imóvel!");
                            com.data.MessageManager messMgr = new com.data.MessageManager();
                            out.print(messMgr.parseJson(message));

                        }
                        
                    } else {

                        com.db.DBConnection.getInstance().getConnection().rollback();
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(0);
                        message.setMessage("Não foi possível cadastrar os dados do imóvel!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));

                    }
                    
                } else {

                    com.sys.Message message = new com.sys.Message();
                    message.setCode(2);
                    message.setMessage("Algumas das informações necessárias para o cadastro dos dados do imóvel não possuem valores definidos!");
                    com.data.MessageManager messMgr = new com.data.MessageManager();
                    out.print(messMgr.parseJson(message));

                }
                
            } else {
                
                com.sys.Message message = new com.sys.Message();
                message.setCode(0);
                message.setMessage("O servidor não pôde obter os dados da autenticação do usuário para completar a requisição!");
                com.data.MessageManager messMgr = new com.data.MessageManager();
                out.print(messMgr.parseJson(message));
                
            }
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O servidor não pôde obter os dados do imóvel para efetuar o cadastro!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } catch (java.lang.ClassNotFoundException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("Não foi possível encontrar as configurações do banco de dados do CadHab.<br />Contate o administrador do sistema!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } catch (java.sql.SQLException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O banco de dados retornou um erro durante o cadastro dos dados do imóvel.<br />Contate o administrador do sistema!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } catch (java.lang.NullPointerException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage(ex.getMessage());
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } finally {       
            
            out.close();
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}