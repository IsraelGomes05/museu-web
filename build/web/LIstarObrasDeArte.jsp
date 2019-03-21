<%-- 
    Document   : LIstarObrasDeArte
    Created on : 13/03/2019, 19:39:22
    Author     : Israel 1846
--%>

<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="br.edu.ifmt.java.main.obradearte.ObraDeArte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifmt.java.main.services.ObraDeArteServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obras de arte - DigMuseum</title>
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css">
    </head>
    <body>
        <%@include file="CabecalhoMaster.jsp"%>
        
        <div class="container jumbotron">
            <%@include file="CabecalhoObrasDeArte.jsp"%>
            <div class="row">
                <div class="col col-md-12">

                </div>
            </div>
            <div class="row">
                <div class="col col-md-12">
                    <div class="row">
                        <%
                            try {

                                ObraDeArteServico obraDeArteServico = new ObraDeArteServico();
                                ArrayList<ObraDeArte> obrasDeArte = obraDeArteServico.getObraDeArtes();
                                String template = ""
                                        + "<div class=\"col col-4 \">"
                                        + " <div class=\"card card-obra-arte\">"
                                        + "     <img class=\"card-img-top img-card\" src=\"%s\" alt=\"imagem\">"
                                        + "     <div class=\"card-body\">"
                                        + "         <h5 class=\"card-title\">%s</h5>"
                                        + "         <p class=\"card-text\"><b>Autor:</b> %s <b>Data:</b> %s <br><b>Técnica:</b> %s</p>"
                                        + "     </div>"
                                        + " </div>"
                                        + "</div>"
                                        + "<br>";
                                String saida = "";
                                for (ObraDeArte obraDeArte : obrasDeArte) {
                                    saida = saida.concat(String.format(
                                            template,
                                            obraDeArte.getImagem(),
                                            obraDeArte.getTitulo(),
                                            obraDeArte.getAutor(),
                                            obraDeArte.printData(),
                                            obraDeArte.getTecnica())
                                    );
                                }
                                out.print(saida);
                            } catch (Exception e) {
                                Logger.getLogger(ObraDeArteServico.class.getName()).log(Level.SEVERE, null, e);
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
