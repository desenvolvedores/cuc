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
public class ObjectAtualizarFotoUsuario extends javax.servlet.http.HttpServlet {

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
                int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
                
                if (idUsuario > 0) {
                    
                    String pathDir = com.sys.SystemSettings.attachmentPath + "\\usuarios\\" + idUsuario;
                    com.upload.FileManager fileMgr = new com.upload.FileManager();
                    String fileName = fileMgr.salvar(pathDir, new java.io.BufferedInputStream(request.getInputStream()));
                    
                    if (! fileName.isEmpty()) {
                        
                        String[] array = fileName.split("\\.");
                        
                        if (array[array.length - 1].toUpperCase().equals("JPG") || array[array.length - 1].toUpperCase().equals("JPEG")
                                || array[array.length - 1].toUpperCase().equals("BMP") || array[array.length - 1].toUpperCase().equals("GIF")
                                || array[array.length - 1].toUpperCase().equals("PNG")) {
                            
                            com.access.Usuario usuario = new com.access.Usuario();
                            usuario.setId(idUsuario);
                            usuario.setFoto(fileName);

                            com.util.JsonManager jsonMgr = new com.util.JsonManager();
                            String input = jsonMgr.parseJson(usuario);

                            com.conn.ConnectionManager.connect("/usuario/foto/alterar?auth_token=" + token + "&auth_key=" + userKey, input);
                            
                        }
                        
                    }
                
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
