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
public class JsonAtualizarAcaoNucleo extends javax.servlet.http.HttpServlet {

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
                com.sys.urbano.AcaoNucleo acao = jsonMgr.parseAcaoNucleo(json);

                if (! acao.getRemanejamento().isEmpty() && ! acao.getReassentamento().isEmpty() && ! acao.getDesconstrucao().isEmpty() 
                        && ! acao.getMelhoriaHabitacional().isEmpty() && ! acao.getRecuperacaoAmbiental().isEmpty() && ! acao.getAdequacaoInfraestrutura().isEmpty() 
                        && ! acao.getOutros().isEmpty() && acao.getNucleo().getId() > 0 && acao.getId() > 0) {

                    pgsql.sys.urbano.AcaoNucleoDAO acaoDAO = new pgsql.sys.urbano.AcaoNucleoDAO();

                    if (acaoDAO.alterarAcaoNucleo(acao) > 0) {

                        com.db.DBConnection.getInstance().getConnection().commit();
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(1);
                        message.setMessage("Os dados da ação foram atualizados com sucesso!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));

                    } else {

                        com.db.DBConnection.getInstance().getConnection().rollback();
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(0);
                        message.setMessage("Não foi possível atualizar os dados da ação!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));

                    }

                } else {

                    com.sys.Message message = new com.sys.Message();
                    message.setCode(2);
                    message.setMessage("Algumas das informações necessárias para a atualização dos dados da ação não possuem valores definidos!");
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
            message.setMessage("O servidor não pôde obter os dados da ação para efetuar a atualização!");
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
            message.setMessage("O banco de dados retornou um erro durante a atualização dos dados da ação.<br />Contate o administrador do sistema!");
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
