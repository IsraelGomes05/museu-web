<%-- 
    Document   : CadastrarObrasDeArtes
    Created on : 13/03/2019, 21:40:21
    Author     : Israel 1846
--%>

<%@page import="br.edu.ifmt.java.main.obradearte.TipoObraDeArte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifmt.java.main.services.ObraDeArteServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Obras de Arte</title>
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css">
    </head>
    <body>
        <%@include file="CabecalhoMaster.jsp"%>
        <div class="row justify-content-center">
            <div class="jumbotron">
                <div class="col col-md-12">
                    <h5 class="card-title">Cadastro de Obras de arte</h5>
                    <hr>
                    <form action="ObraDeArteServlet" method="POST">
                        <div class="form-group">
                            <label for="titulo">Titulo</label>
                            <input type="text" class="form-control" id="titulo" name="titulo">
                        </div>
                        <div class="form-group">
                            <label for="data">Data</label>
                            <input type="date" class="form-control" id="data" name="data">
                        </div>
                        <div class="form-group">
                            <label for="tecnica">Técnica</label>
                            <input type="text" class="form-control" id="tecnica" name="tecnica">
                        </div>
                        <div class="form-group">
                            <label for="autor">Autor</label>
                            <input type="text" class="form-control" id="autor" name="autor">
                        </div>
                        <div class="form-group">
                            <label for="procedencia">Procedencia</label>
                            <input type="text" class="form-control" id="procedencia" name="procedencia">
                        </div>
                        <div class="form-group">
                            <label for="tipo">Tipo</label>
                            <select class="form-control" id="tipo" name="tipo">
                                <%
                                    ObraDeArteServico obraDeArteServico = new ObraDeArteServico();
                                    ArrayList<TipoObraDeArte> tipos = obraDeArteServico.getTiposObrasDeArte();
                                    for (TipoObraDeArte tipo : tipos) {
                                        out.print(String.format("<option value=\"%s\">%s</option>", tipo.getId(), tipo.getDescricao()));
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="imagem">Imagem da Obra de arte</label>
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="imagem" name="imagem">
                                <label class="custom-file-label" for="imagem">Selecione</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success justify-content-center">Cadastrar</button>
                    </form>
                    <div> <%
                        String secesso = request.getParameter("sucesso");
                        if (secesso != null) {
                            if ("true".equals(secesso)) {
                                out.print("<div class=\"alert alert-danger\"><strong>Falha!</strong> ao tentar cadastrar obra de arte</div>");
                            } else {
                                out.print("<div class=\"alert alert-danger\"><strong>Sucesso!</strong> obra de arte cadastrada com sucesso</div>");
                            }
                        }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
