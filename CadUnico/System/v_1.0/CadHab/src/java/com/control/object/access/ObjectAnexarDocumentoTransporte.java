/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.control.object.access;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class ObjectAnexarDocumentoTransporte extends javax.servlet.http.HttpServlet {

    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    
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
                long idNucleo = Integer.parseInt(request.getParameter("id_nucleo"));
                
                if (idNucleo > 0) {
                    
                    String pathDir = com.sys.SystemSettings.attachmentPath + "\\nucleos\\anexos\\" + idNucleo;
                    com.upload.FileManager fileMgr = new com.upload.FileManager();
                    fileMgr.salvar(pathDir, new java.io.BufferedInputStream(request.getInputStream()));
                
                }
            
            }
            
        } catch (java.io.IOException ex) {
            
            ex.printStackTrace();
            
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
