/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.control.json.access;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class JsonAutenticarUsuario extends javax.servlet.http.HttpServlet {

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
            
            com.settings.Configuracao.iniciarConfiguracoes();
            String json = request.getReader().readLine();

            com.util.JsonManager jsonMgr = new com.util.JsonManager();
            com.access.Usuario usuario = jsonMgr.parseUsuario(json);
            
            if (! usuario.getUsuario().isEmpty() && ! usuario.getSenha().isEmpty()) {
                
                pgsql.access.UsuarioDAO usuarioDAO = new pgsql.access.UsuarioDAO();
                usuario = usuarioDAO.logarUsuario(usuario);
                
                if (usuario != null && usuario.getId() > 0) {
                    
                    usuario = usuarioDAO.selecionarUsuarioPorID(usuario.getId());
                    
                    if (com.settings.GerenciadorAcesso.setAuthentication(usuario)) {
                        
                        usuario.setToken(com.settings.GerenciadorAcesso.getUserToken(usuario.getId()));
                        usuario.setUserKey(com.settings.GerenciadorAcesso.getUserKey(usuario.getId()));
                        out.print(jsonMgr.parseJson(usuario));
                        
                    } else {
                        
                        com.sys.Message message = new com.sys.Message();
                        message.setCode(0);
                        message.setMessage("Não foi possível fazer a autenticação do usuário no sistema!");
                        com.data.MessageManager messMgr = new com.data.MessageManager();
                        out.print(messMgr.parseJson(message));
                        
                    }
                    
                } else {
                    
                    com.sys.Message message = new com.sys.Message();
                    message.setCode(2);
                    message.setMessage("Nome de usuário e/ou senha inválidos!");
                    com.data.MessageManager messMgr = new com.data.MessageManager();
                    out.print(messMgr.parseJson(message));
                    
                }
                
            } else {
                
                com.sys.Message message = new com.sys.Message();
                message.setCode(2);
                message.setMessage("Você precisa informar o seu nome de usuário e/ou a sua senha para ter acesso ao sistema!");
                com.data.MessageManager messMgr = new com.data.MessageManager();
                out.print(messMgr.parseJson(message));
                
            }
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O servidor não pôde obter os dados do usuário para efetuar o acesso ao sistema!");
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
            message.setMessage("O banco de dados retornou um erro durante o acesso do usuário ao sistema.<br />Contate o administrador do sistema!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
        
        } catch (java.lang.NullPointerException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("O servidor não pode encontrar valores necessários para realizar a operação.<br />Contate o administrador do sistema!");
            com.data.MessageManager messMgr = new com.data.MessageManager();
            out.print(messMgr.parseJson(message));
        
        } catch (java.security.NoSuchAlgorithmException ex) {
            
            ex.printStackTrace();
            com.settings.Configuracao.releaseDatabase();
            com.sys.Message message = new com.sys.Message();
            message.setCode(0);
            message.setMessage("Não foi possível fazer a autenticação do usuário no sistema.<br />Contate o administrador do sistema!");
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
