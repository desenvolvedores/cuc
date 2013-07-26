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
public class JsonInserirNucleoCompleto extends javax.servlet.http.HttpServlet {

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
        
        java.io.PrintWriter out = response.getWriter();
        
        try {
            
            String token = request.getParameter("auth_token");
            String userKey = request.getParameter("auth_key");
            
            if (com.settings.GerenciadorAcesso.checkAuthentication(token, userKey)) {
                
                com.settings.Configuracao.iniciarConfiguracoes();
                String json = request.getReader().readLine();

                com.utils.JsonManager jsonMgr = new com.utils.JsonManager();
                com.sys.urbano.Nucleo nucleo = jsonMgr.parseNucleo(json);
                
                if (! nucleo.getNome().isEmpty() && ! nucleo.getOrigem().isEmpty() && ! nucleo.getOcupacao().isEmpty() 
                        && ! nucleo.getPopFonteDados().isEmpty() && ! nucleo.getPopOutrasFontesDados().isEmpty() && ! nucleo.getSetorCadastral().isEmpty() 
                        && ! nucleo.getZona().isEmpty() && ! nucleo.getControleOcupacao().isEmpty() && ! nucleo.getPadraoConstrutivo().isEmpty() 
                        && ! nucleo.getTransportePublico().isEmpty() && ! nucleo.getAdensamento().isEmpty() && ! nucleo.getInfraestruturaUrbana().getAbastecimentoAgua().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getColetaEsgoto().isEmpty() && ! nucleo.getInfraestruturaUrbana().getServicosLimpeza().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getEnergiaEletrica().isEmpty() && ! nucleo.getInfraestruturaUrbana().getIluminacaoPublica().isEmpty() 
                        && ! nucleo.getInfraestruturaUrbana().getAguasPluviaisSuperficial().isEmpty() && ! nucleo.getInfraestruturaUrbana().getAguasPluviaisRede().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getMaterialConstrucao().isEmpty() && ! nucleo.getProgramaHabitacional().getProducaoMoradias().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getAssistenciaTecnica().isEmpty() && ! nucleo.getProgramaHabitacional().getUrbAssentamentosPrecarios().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getComplemInfraestrutura().isEmpty() && ! nucleo.getProgramaHabitacional().getRegularizacaoFundiaria().isEmpty() 
                        && ! nucleo.getProgramaHabitacional().getCdhu().isEmpty() && ! nucleo.getProgramaHabitacional().getPmcmv().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getPropriedade().isEmpty() && ! nucleo.getSituacaoFundiaria().getDecretoAprovacao().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getRegistrado().isEmpty() && ! nucleo.getSituacaoFundiaria().getDescEcologicoEconomico().isEmpty() 
                        && ! nucleo.getSituacaoFundiaria().getProcessosJudiciais().isEmpty() && ! nucleo.getSituacaoFundiaria().getExistenciaEmbargos().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getRemanejamento().isEmpty() && ! nucleo.getAcaoNucleo().getReassentamento().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getDesconstrucao().isEmpty() && ! nucleo.getAcaoNucleo().getMelhoriaHabitacional().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getRecuperacaoAmbiental().isEmpty() && ! nucleo.getAcaoNucleo().getAdequacaoInfraestrutura().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getOutros().isEmpty() && ! nucleo.getAcaoNucleo().getObjRemanejamento().getEstimativaRelocacao().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getObjReassentamento().getEstimativaRemocao().isEmpty() && ! nucleo.getAcaoNucleo().getObjReassentamento().getLocalDefinitivo().isEmpty() 
                        && ! nucleo.getAcaoNucleo().getObjDesconstrucao().getMotivo().isEmpty() && ! nucleo.getAcaoNucleo().getObjDesconstrucao().getProcessos().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getAreaRisco().isEmpty() && ! nucleo.getAspectoAmbiental().getAreaVerde().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getAreaAgricola().isEmpty() && ! nucleo.getAspectoAmbiental().getOutros().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getApp().getCorpoDagua().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getBrejoCharco().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getApp().getTopoMorro().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getEncosta().isEmpty() 
                        && ! nucleo.getAspectoAmbiental().getApp().getRestinga().isEmpty() && ! nucleo.getAspectoAmbiental().getApp().getOutros().isEmpty()) {
                    
                    pgsql.sys.urbano.NucleoDAO nucleoDAO = new pgsql.sys.urbano.NucleoDAO();

                    if (nucleoDAO.inserirNucleo(nucleo) > 0) {
                        
                        java.util.List<com.sys.urbano.Nucleo> nucleoTemp = nucleoDAO.procurarNucleoPorNome(nucleo.getNome());
                        
                        if (nucleoTemp.get(0) != null) {
                            
                            nucleo.setId(nucleoTemp.get(0).getId());
                            nucleo.getInfraestruturaUrbana().getNucleo().setId(nucleoTemp.get(0).getId());
                            nucleo.getProgramaHabitacional().getNucleo().setId(nucleoTemp.get(0).getId());
                            nucleo.getSituacaoFundiaria().getNucleo().setId(nucleoTemp.get(0).getId());
                            nucleo.getAcaoNucleo().getNucleo().setId(nucleoTemp.get(0).getId());
                            nucleo.getAspectoAmbiental().getNucleo().setId(nucleoTemp.get(0).getId());
                            
                            pgsql.sys.urbano.InfraestruturaUrbanaDAO infraestruturaDAO = new pgsql.sys.urbano.InfraestruturaUrbanaDAO();
                            
                            if (infraestruturaDAO.inserirInfraestruturaUrbana(nucleo.getInfraestruturaUrbana()) > 0) {
                                
                                pgsql.sys.urbano.ProgramaHabitacionalDAO programaDAO = new pgsql.sys.urbano.ProgramaHabitacionalDAO();
                                
                                if (programaDAO.inserirProgramaHabitacional(nucleo.getProgramaHabitacional()) > 0) {
                                    
                                    pgsql.sys.urbano.SituacaoFundiariaDAO fundiariaDAO = new pgsql.sys.urbano.SituacaoFundiariaDAO();
                                    
                                    if (fundiariaDAO.inserirSituacaoFundiaria(nucleo.getSituacaoFundiaria()) > 0) {
                                        
                                        pgsql.sys.urbano.AcaoNucleoDAO acaoDAO = new pgsql.sys.urbano.AcaoNucleoDAO();
                                        
                                        if (acaoDAO.inserirAcaoNucleo(nucleo.getAcaoNucleo()) > 0) {
                                            
                                            com.sys.urbano.AcaoNucleo acaoTemp = acaoDAO.selecionarAcaoNucleoPorIDNucleo(nucleo);
                                            
                                            if (acaoTemp != null) {
                                                
                                                nucleo.getAcaoNucleo().getObjRemanejamento().getAcao().setId(acaoTemp.getId());
                                                nucleo.getAcaoNucleo().getObjReassentamento().getAcao().setId(acaoTemp.getId());
                                                nucleo.getAcaoNucleo().getObjDesconstrucao().getAcao().setId(acaoTemp.getId());
                                                
                                                pgsql.sys.urbano.RemanejamentoDAO remanejamentoDAO = new pgsql.sys.urbano.RemanejamentoDAO();
                                                
                                                if (remanejamentoDAO.inserirRemanejamento(nucleo.getAcaoNucleo().getObjRemanejamento()) > 0) {
                                                    
                                                    pgsql.sys.urbano.ReassentamentoDAO reassentamentoDAO = new pgsql.sys.urbano.ReassentamentoDAO();
                                                    
                                                    if (reassentamentoDAO.inserirReassentamento(nucleo.getAcaoNucleo().getObjReassentamento()) > 0) {
                                                        
                                                        pgsql.sys.urbano.DesconstrucaoDAO desconstrucaoDAO = new pgsql.sys.urbano.DesconstrucaoDAO();
                                                        
                                                        if (desconstrucaoDAO.inserirDesconstrucao(nucleo.getAcaoNucleo().getObjDesconstrucao()) > 0) {
                            
                                                            pgsql.sys.urbano.AspectoAmbientalDAO ambientalDAO = new pgsql.sys.urbano.AspectoAmbientalDAO();
                                                            
                                                            if (ambientalDAO.inserirAspectoAmbiental(nucleo.getAspectoAmbiental()) > 0) {
                                                                
                                                                com.sys.urbano.AspectoAmbiental ambientalTemp = ambientalDAO.selecionarAspectoAmbientalPorIDNucleo(nucleo);
                                                                
                                                                if (ambientalTemp != null) {
                                                                    
                                                                    nucleo.getAspectoAmbiental().getApp().getAspecto().setId(ambientalTemp.getId());
                                                                    
                                                                    pgsql.sys.urbano.AppDAO appDAO = new pgsql.sys.urbano.AppDAO();
                                                                    
                                                                    if (appDAO.inserirApp(nucleo.getAspectoAmbiental().getApp()) > 0) {
                                                            
                                                                        com.db.DBConnection.getInstance().getConnection().commit();
                                                                        com.sys.Message message = new com.sys.Message();
                                                                        message.setCode(1);
                                                                        message.setMessage("Os dados do núcleo foram cadastrados com sucesso!");
                                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                                        out.print(messMgr.parseJson(message));
                                                                    
                                                                    }  else {
                            
                                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                                        com.sys.Message message = new com.sys.Message();
                                                                        message.setCode(0);
                                                                        message.setMessage("Não foi possível cadastrar os dados da APP do núcleo!");
                                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                                        out.print(messMgr.parseJson(message));

                                                                    }
                                                                
                                                                } else {
                            
                                                                    com.db.DBConnection.getInstance().getConnection().rollback();
                                                                    com.sys.Message message = new com.sys.Message();
                                                                    message.setCode(0);
                                                                    message.setMessage("Não foi possível continuar com o cadastro dos dados do núcleo!");
                                                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                                                    out.print(messMgr.parseJson(message));

                                                                }
                                                            
                                                            }  else {
                            
                                                                com.db.DBConnection.getInstance().getConnection().rollback();
                                                                com.sys.Message message = new com.sys.Message();
                                                                message.setCode(0);
                                                                message.setMessage("Não foi possível cadastrar os dados do aspecto ambiental do núcleo!");
                                                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                                                out.print(messMgr.parseJson(message));

                                                            }
                                                        
                                                        }  else {
                            
                                                            com.db.DBConnection.getInstance().getConnection().rollback();
                                                            com.sys.Message message = new com.sys.Message();
                                                            message.setCode(0);
                                                            message.setMessage("Não foi possível cadastrar os dados da desconstrução!");
                                                            com.data.MessageManager messMgr = new com.data.MessageManager();
                                                            out.print(messMgr.parseJson(message));

                                                        }
                                                    
                                                    }  else {
                            
                                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                                        com.sys.Message message = new com.sys.Message();
                                                        message.setCode(0);
                                                        message.setMessage("Não foi possível cadastrar os dados do reassentamento!");
                                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                                        out.print(messMgr.parseJson(message));

                                                    }
                                                
                                                }  else {
                            
                                                    com.db.DBConnection.getInstance().getConnection().rollback();
                                                    com.sys.Message message = new com.sys.Message();
                                                    message.setCode(0);
                                                    message.setMessage("Não foi possível cadastrar os dados do remanejamento!");
                                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                                    out.print(messMgr.parseJson(message));

                                                }
                                            
                                            } else {
                            
                                                com.db.DBConnection.getInstance().getConnection().rollback();
                                                com.sys.Message message = new com.sys.Message();
                                                message.setCode(0);
                                                message.setMessage("Não foi possível continuar com o cadastro dos dados do núcleo!");
                                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                                out.print(messMgr.parseJson(message));

                                            }
                                        
                                        }  else {
                            
                                            com.db.DBConnection.getInstance().getConnection().rollback();
                                            com.sys.Message message = new com.sys.Message();
                                            message.setCode(0);
                                            message.setMessage("Não foi possível cadastrar os dados das ações do núcleo!");
                                            com.data.MessageManager messMgr = new com.data.MessageManager();
                                            out.print(messMgr.parseJson(message));

                                        }
                                    
                                    }  else {
                            
                                        com.db.DBConnection.getInstance().getConnection().rollback();
                                        com.sys.Message message = new com.sys.Message();
                                        message.setCode(0);
                                        message.setMessage("Não foi possível cadastrar os dados da situação fundiária do núcleo!");
                                        com.data.MessageManager messMgr = new com.data.MessageManager();
                                        out.print(messMgr.parseJson(message));

                                    }
                                
                                }  else {
                            
                                    com.db.DBConnection.getInstance().getConnection().rollback();
                                    com.sys.Message message = new com.sys.Message();
                                    message.setCode(0);
                                    message.setMessage("Não foi possível cadastrar os dados dos programas habitacionais!");
                                    com.data.MessageManager messMgr = new com.data.MessageManager();
                                    out.print(messMgr.parseJson(message));

                                }
                            
                            }  else {
                            
                                com.db.DBConnection.getInstance().getConnection().rollback();
                                com.sys.Message message = new com.sys.Message();
                                message.setCode(0);
                                message.setMessage("Não foi possível cadastrar os dados da infraestrutura urbana!");
                                com.data.MessageManager messMgr = new com.data.MessageManager();
                                out.print(messMgr.parseJson(message));

                            }
                            
                        } else {
                            
                            com.db.DBConnection.getInstance().getConnection().rollback();
                            com.sys.Message message = new com.sys.Message();
                            message.setCode(0);
                            message.setMessage("Não foi possível continuar com o cadastro dos dados do núcleo!");
                            com.data.MessageManager messMgr = new com.data.MessageManager();
                            out.print(messMgr.parseJson(message));
                            
                        }

                    } else {

                        com.db.DBConnection.getInstance().getConnection().rollback();
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(0);
                        message.setMessage("Não foi possível cadastrar os dados do núcleo!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));

                    }
                    
                } else {

                    com.sys.Message message = new com.sys.Message();
                    message.setCode(2);
                    message.setMessage("Algumas das informações necessárias para o cadastro dos dados do núcleo não possuem valores definidos!");
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
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O servidor não pôde obter os dados do núcleo para efetuar o cadastro!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } catch (java.lang.ClassNotFoundException ex) {
            
            ex.printStackTrace();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("Não foi possível encontrar as configurações do banco de dados do CadÚnico.<br />Contate o administrador do sistema!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
            
        } catch (java.sql.SQLException ex) {
            
            ex.printStackTrace();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O banco de dados retornou um erro durante o cadastro dos dados do núcleo.<br />Contate o administrador do sistema!");
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
