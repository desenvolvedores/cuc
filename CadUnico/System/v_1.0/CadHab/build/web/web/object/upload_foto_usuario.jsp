<%-- 
    Document   : upload_foto_usuario
    Created on : 19/07/2013, 17:04:17
    Author     : William Oliveira
    Version    : 1.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    
    <head>
        
        <title></title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    
    <body>
        
        <%
            
            String id = request.getParameter("id"); 
            String token = request.getParameter("auth_token");
            String userKey = request.getParameter("auth_key");
            
            out.println("<form action=\"http://localhost:8080/cadhab/usuario/foto/atualizar\" method=\"post\" enctype=\"multipart/form-data\">");
            out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\" />");
            out.println("<input type=\"hidden\" name=\"auth_token\" value=\"" + token + "\" />");
            out.println("<input type=\"hidden\" name=\"auth_key\" value=\"" + userKey + "\" />");
            out.println("<input type=\"file\" name=\"file\" />");
            out.println("<input type=\"submit\" name=\"\" value=\"Enviar\" />");
            out.println("</form>");
            
        %>
        
    </body>
    
</html>
