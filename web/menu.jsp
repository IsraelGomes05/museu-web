<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/estilo.css" type="text/css"/>

        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="CabecalhoMaster.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col col-12">
                    <div class="fundo-menu jumbotron">
                        <button class="btn btn-primary">
                            <a href="http://localhost:8080/WebII/LIstarObrasDeArte.jsp" class="link-padrao">
                                Listar Obras de arte
                            </a>
                        </button>
                        <button class="btn btn-primary">
                            <a href="http://localhost:8080/WebII/CadastrarObrasDeArtes.jsp" class="link-padrao">
                                Cadastrar Obras de arte
                            </a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
