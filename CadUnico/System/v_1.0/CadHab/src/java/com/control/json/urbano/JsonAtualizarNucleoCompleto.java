/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.control.json.urbano;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class JsonAtualizarNucleoCompleto extends javax.servlet.http.HttpServlet {

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
                System.out.println(json);
                com.sys.urbano.Nucleo nucleo = jsonMgr.parseNucleo(json);
                
                if (! String.valueOf(nucleo.getId()).isEmpty() && nucleo.getId() > 0
                        && ! nucleo.getNome().isEmpty() 
                        && ! nucleo.getOrigem().isEmpty() 
                        && ! nucleo.getOcupacao().isEmpty() 
                        && ! String.valueOf(nucleo.getNumeroDomicilios()).isEmpty() 
                        && ! String.valueOf(nucleo.getPopulacaoEstimada()).isEmpty() 
                        && ! nucleo.getControleOcupacao().isEmpty() 
                        && ! nucleo.getRendaPopulacao().isEmpty() 
                        && ! nucleo.getPadraoConstrutivo().isEmpty() 
                        && ! nucleo.getTransportePublico().isEmpty() 
                        && ! nucleo.getPopFonteDados().isEmpty() 
                        && ! nucleo.getAdensamento().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getAbastecimentoAgua().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getColetaEsgoto().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getServicosLimpeza().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getEnergiaEletrica().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getIluminacaoPublica().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getAguasPluviaisSuperficial().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getAguasPluviaisRede().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getMaterialConstrucao().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getProducaoMoradias().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getAssistenciaTecnica().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getUrbAssentamentosPrecarios().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getComplemInfraestrutura().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getRegularizacaoFundiaria().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getCdhu().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getPmcmv().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getPropriedade().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getDecretoAprovacao().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getRegistrado().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getDescEcologicoEconomico().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getProcessosJudiciais().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getExistenciaEmbargos().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getRemanejamento().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getReassentamento().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getDesconstrucao().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getMelhoriaHabitacional().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getRecuperacaoAmbiental().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getAdequacaoInfraestrutura().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getOutros().isEmpty()  
                        && ! nucleo.getAspectoAmbiental().getAreaVerde().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getAreaAgricola().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getOutros().isEmpty()) {
                    
                    pgsql.sys.urbano.NucleoDAO nucleoDAO = new pgsql.sys.urbano.NucleoDAO();
                    
                    java.util.List<com.sys.urbano.Nucleo> nucleoTemp = nucleoDAO.procurarNucleoExistentePorNome(nucleo);
                    
                    if (nucleoTemp.size() <= 0) {

                        if (nucleoDAO.alterarNucleo(nucleo) > 0) {

                            pgsql.sys.urbano.InfraestruturaUrbanaDAO infraestruturaDAO = new pgsql.sys.urbano.InfraestruturaUrbanaDAO();
                            
                            if (infraestruturaDAO.alterarInfraestruturaUrbana(nucleo.getInfraestruturaUrbana()) > 0) {
                                
                                pgsql.sys.urbano.ProgramaHabitacionalDAO programaDAO = new pgsql.sys.urbano.ProgramaHabitacionalDAO();
                                
                                if (programaDAO.alterarProgramaHabitacional(nucleo.getProgramaHabitacional()) > 0) {
                                    
                                    pgsql.sys.urbano.SituacaoFundiariaDAO fundiariaDAO = new pgsql.sys.urbano.SituacaoFundiariaDAO();
                                    
                                    if (fundiariaDAO.alterarSituacaoFundiaria(nucleo.getSituacaoFundiaria()) > 0) {
                                        
                                        pgsql.sys.urbano.AcaoNucleoDAO acaoDAO = new pgsql.sys.urbano.AcaoNucleoDAO();
                                        
                                        if (acaoDAO.alterarAcaoNucleo(nucleo.getAcaoNucleo()) > 0) {
                                            
                                            if (! nucleo.getAcaoNucleo().getObjRemanejamento().getEstimativaRelocacao().isEmpty() 
                                                    && ! String.valueOf(nucleo.getAcaoNucleo().getObjRemanejamento().getNumeroRemocaoDefinitiva()).isEmpty()
                                                    && ! String.valueOf(nucleo.getAcaoNucleo().getObjRemanejamento().getNumeroRemocaoProvisoria()).isEmpty()) {
                                                    
                                                pgsql.sys.urbano.RemanejamentoDAO remanejamentoDAO = new pgsql.sys.urbano.RemanejamentoDAO();
                                                
                                                if (nucleo.getAcaoNucleo().getObjRemanejamento().getId() > 0) {
                                                    
                                                    if (remanejamentoDAO.alterarRemanejamento(nucleo.getAcaoNucleo().getObjRemanejamento()) <= 0) {

                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados do remanejamento!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;

                                                    }
                                                
                                                } else {
                                                    
                                                    if (remanejamentoDAO.inserirRemanejamento(nucleo.getAcaoNucleo().getObjRemanejamento()) <= 0) {

                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados do remanejamento!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;

                                                    }
                                                    
                                                }
                                                
                                            }
                                            
                                            if (! nucleo.getAcaoNucleo().getObjReassentamento().getEstimativaRemocao().isEmpty() 
                                                    && ! nucleo.getAcaoNucleo().getObjReassentamento().getLocalDefinitivo().isEmpty() 
                                                    && ! String.valueOf(nucleo.getAcaoNucleo().getObjReassentamento().getNumeroAConstruir()).isEmpty() 
                                                    && ! String.valueOf(nucleo.getAcaoNucleo().getObjReassentamento().getNumeroProvisorias()).isEmpty()) {
                                                    
                                                pgsql.sys.urbano.ReassentamentoDAO reassentamentoDAO = new pgsql.sys.urbano.ReassentamentoDAO();
                                                
                                                if (nucleo.getAcaoNucleo().getObjReassentamento().getId() > 0) {
                                                    
                                                    if (reassentamentoDAO.alterarReassentamento(nucleo.getAcaoNucleo().getObjReassentamento()) <= 0) {
                                                        
                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados do reassentamento!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;
                                                        
                                                    }
                                                    
                                                } else {
                                                    
                                                    if (reassentamentoDAO.inserirReassentamento(nucleo.getAcaoNucleo().getObjReassentamento()) <= 0) {
                                                        
                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados do reassentamento!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;
                                                        
                                                    }
                                                    
                                                }
                                                    
                                            }
                                            
                                            if (! nucleo.getAcaoNucleo().getObjDesconstrucao().getMotivo().isEmpty() 
                                                    && ! nucleo.getAcaoNucleo().getObjDesconstrucao().getProcessos().isEmpty() 
                                                    && ! String.valueOf(nucleo.getAcaoNucleo().getObjDesconstrucao().getNumeroADemolir()).isEmpty()) {
                                                    
                                                pgsql.sys.urbano.DesconstrucaoDAO desconstrucaoDAO = new pgsql.sys.urbano.DesconstrucaoDAO();
                                                
                                                if (nucleo.getAcaoNucleo().getObjDesconstrucao().getId() > 0) {
                                                    
                                                    if (desconstrucaoDAO.alterarDesconstrucao(nucleo.getAcaoNucleo().getObjDesconstrucao()) <= 0) {
                                                        
                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados da desconstrução!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;
                                                        
                                                    }
                                                    
                                                } else {
                                                    
                                                    if (desconstrucaoDAO.inserirDesconstrucao(nucleo.getAcaoNucleo().getObjDesconstrucao()) <= 0) {
                                                        
                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível atualizar os dados da desconstrução!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));
                                                        return;
                                                        
                                                    }
                                                    
                                                }
                                                    
                                            }
                                            
                                            pgsql.sys.urbano.AspectoAmbientalDAO ambientalDAO = new pgsql.sys.urbano.AspectoAmbientalDAO();
                                                            
                                            if (ambientalDAO.alterarAspectoAmbiental(nucleo.getAspectoAmbiental()) > 0) {
                                                
                                                if (! nucleo.getAspectoAmbiental().getApp().getCorpoDagua().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getBrejoCharco().isEmpty() 
                                                        && ! nucleo.getAspectoAmbiental().getApp().getTopoMorro().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getEncosta().isEmpty() 
                                                        && ! nucleo.getAspectoAmbiental().getApp().getRestinga().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getOutros().isEmpty()) {
                                                            
                                                    pgsql.sys.urbano.AppDAO appDAO = new pgsql.sys.urbano.AppDAO();
                                                    
                                                    if (nucleo.getAspectoAmbiental().getApp().getId() > 0) {
                                                            
                                                        if (appDAO.alterarApp(nucleo.getAspectoAmbiental().getApp()) <= 0) {

                                                            com.db.DBConnection.getInstance().getConnection().rollback();
                                                            com.sys.Message message = new com.sys.Message();
                                                            message.setCode(0);
                                                            message.setMessage("Não foi possível atualizar os dados da APP!");
                                                            com.data.MessageManager messMgr = new com.data.MessageManager();
                                                            out.print(messMgr.parseJson(message));
                                                            return;

                                                        }
                                                    
                                                    } else {
                                                        
                                                        if (appDAO.inserirApp(nucleo.getAspectoAmbiental().getApp()) <= 0) {

                                                            com.db.DBConnection.getInstance().getConnection().rollback();
                                                            com.sys.Message message = new com.sys.Message();
                                                            message.setCode(0);
                                                            message.setMessage("Não foi possível atualizar os dados da APP!");
                                                            com.data.MessageManager messMgr = new com.data.MessageManager();
                                                            out.print(messMgr.parseJson(message));
                                                            return;

                                                        }
                                                        
                                                    }
                                                            
                                                }
                                                
                                                com.db.DBConnection.getInstance().getConnection().commit();
                                                com.sys.Message message = new com.sys.Message();
                                                message.setCode(1);
                                                message.setMessage("Os dados do núcleo foram atualizados com sucesso!");
                                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                                out.print(messMgr.parseJson(message));
                                                
                                            }  else {
                            
                                                com.db.DBConnection.getInstance().getConnection().rollback();
                                                com.sys.Message message = new com.sys.Message();
                                                message.setCode(0);
                                                message.setMessage("Não foi possível atualizar os dados do aspecto ambiental do núcleo!");
                                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                                out.print(messMgr.parseJson(message));

                                            }
                                            
                                        }  else {
                            
                                            com.db.DBConnection.getInstance().getConnection().rollback();
                                            com.sys.Message message = new com.sys.Message();
                                            message.setCode(0);
                                            message.setMessage("Não foi possível atualizar os dados das ações do núcleo!");
                                            com.data.MessageManager messMgr = new com.data.MessageManager();
                                            out.print(messMgr.parseJson(message));

                                        }
                                        
                                    }  else {
                            
                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                        com.sys.Message message = new com.sys.Message();
                                        message.setCode(0);
                                        message.setMessage("Não foi possível atualizar os dados da situação fundiária do núcleo!");
                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                        out.print(messMgr.parseJson(message));

                                    }
                                    
                                }  else {
                            
                                    com.db.DBConnection.getInstance().getConnection().rollback();
                                    com.sys.Message message = new com.sys.Message();
                                    message.setCode(0);
                                    message.setMessage("Não foi possível atualizar os dados dos programas habitacionais!");
                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                    out.print(messMgr.parseJson(message));

                                }
                                
                            }  else {
                            
                                com.db.DBConnection.getInstance().getConnection().rollback();
                                com.sys.Message message = new com.sys.Message();
                                message.setCode(0);
                                message.setMessage("Não foi possível atualizar os dados da infraestrutura urbana!");
                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                out.print(messMgr.parseJson(message));

                            }

                        } else {

                            com.db.DBConnection.getInstance().getConnection().rollback();
                            com.sys.Message message = new com.sys.Message();
                            message.setCode(0);
                            message.setMessage("Não foi possível atualizar os dados do núcleo!");
                            com.data.MessageManager messMgr = new com.data.MessageManager();
                            out.print(messMgr.parseJson(message));

                        }
                    
                    } else {
                            
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(2);
                        message.setMessage("Já existe um outro núcleo com este nome cadastrado no sistema!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));
                            
                    }
                    
                } else {

                    com.sys.Message message = new com.sys.Message();
                    message.setCode(2);
                    message.setMessage("Algumas das informações necessárias para a atualização dos dados do núcleo não possuem valores definidos!");
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
            message.setMessage("O servidor não pôde obter os dados do núcleo para efetuar o cadastro!");
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
            message.setMessage("O banco de dados retornou um erro durante o cadastro dos dados do núcleo.<br />Contate o administrador do sistema!");
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
