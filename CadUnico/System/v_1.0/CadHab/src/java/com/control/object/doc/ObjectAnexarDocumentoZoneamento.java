/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.control.object.doc;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class ObjectAnexarDocumentoZoneamento extends javax.servlet.http.HttpServlet {
    
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
                long idFundiaria = Integer.parseInt(request.getParameter("id_fundiaria"));
                
                if (idFundiaria > 0) {
                    
                    String pathDir = com.sys.SystemSettings.attachmentPath + "\\documentos\\nucleos\\anexos\\zoneamento\\" + idFundiaria;
                    com.upload.FileManager fileMgr = new com.upload.FileManager();
                    String fileName = fileMgr.salvar(pathDir, new java.io.BufferedInputStream(request.getInputStream()));
                    
                    if (! fileName.isEmpty()) {
                        
                        String[] array = fileName.split("\\.");
                        char tipo = ' ';
                        
                        if (array[array.length - 1].toUpperCase().equals("JPG") || array[array.length - 1].toUpperCase().equals("JPEG")
                                || array[array.length - 1].toUpperCase().equals("BMP") || array[array.length - 1].toUpperCase().equals("GIF")
                                || array[array.length - 1].toUpperCase().equals("PNG")) {
                            
                            tipo = 'I';
                            
                        } else if (array[array.length - 1].toUpperCase().equals("DOC") || array[array.length - 1].toUpperCase().equals("DOCX")
                                || array[array.length - 1].toUpperCase().equals("XLS") || array[array.length - 1].toUpperCase().equals("XLSX")
                                || array[array.length - 1].toUpperCase().equals("ODT") || array[array.length - 1].toUpperCase().equals("ODS")
                                || array[array.length - 1].toUpperCase().equals("PDF") || array[array.length - 1].toUpperCase().equals("TXT")
                                || array[array.length - 1].toUpperCase().equals("RTF") || array[array.length - 1].toUpperCase().equals("KMZ")) {
                            
                            tipo = 'D';
                            
                        }
                        
                        com.doc.AnexoZoneamento anexo = new com.doc.AnexoZoneamento();
                        anexo.setIdFundiaria(idFundiaria);
                        anexo.setCaminho(fileName);
                        anexo.setTipo(tipo);
                        
                        com.utils.JsonManager jsonMgr = new com.utils.JsonManager();
                        String input = jsonMgr.parseJson(anexo);
                        
                        com.conn.ConnectionManager.connect("/anexo_zoneamento/salvar?auth_token=" + token + "&auth_key=" + userKey, input);
                        
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
