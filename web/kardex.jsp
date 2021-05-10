<%-- 
    Document   : itens
    Created on : 22/10/2020, 22:47:04
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.kardexDAO"%>
<%@page import="model.itensestoque"%>
<%@page import="model.marca"%>

<!DOCTYPE html>

<%@ page language="java"%>

<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
        <link href="https://fonts.googleapis.com/css2?family=PT+Sans+Narrow:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="styles/itenstyle.css" />
        <title>Kardex</title>
    </head>

    <body>
        <form action='controller_kardex' method='post'>
            <div class="container-fluid home-banner">
                <img src="img\Logo - Duck Coffee.png" alt="" class="img-responsive logo img-border">
                <div class="nav-itens center-block">
                    <nav class="row text-center">
                        <a class="nav-itens__spacing nav-itens-formart" href="kardex.jsp">Movimento</a>
                        <a class="nav-itens__spacing nav-itens-formart" href="itens.jsp">Itens</a>                    
                        <a class="nav-itens__spacing nav-itens-formart" href="relatoriosMenu.jsp">Relatórios</a>
                        <a class="nav-itens__spacing nav-itens-formart" href="img\Diagramas.pdf">Documentos</a>
                    </nav>                                      
                </div>
            </div>
            <div class="format-border">
                <div class="mainbg container-fluid">
                    <div class="text-primary">
                        <h4>MOVIMENTAÇÃO DE ITENS</h4>
                    </div>
                    <img src= "img\DuckFundo2.png" alt="" class="bg-img">
                    <div class="inputcontainer">                     
                        <div class="textinput"><input type="text" placeholder="CODIGO" class="text-box" name="codigo"></div>
                        <div class="textinput"><input type="text" placeholder="CODIGO DO USUÁRIO" class="text-box" name="codigo_user"></div>
                        <div class="textinput"><input type="date"  class="text-box" name="datamovimento"></div>
                        <div class="textinput"><input type="text" placeholder="TIPO MOVIMENTO" class="text-box" name="tipomovimento_id"></div>
                        <div class="textinput"><input type="text" placeholder="CODIGO DE BARRAS" class="text-box" name="codigoproduto_id"></div>
                        <div class="textinput"><input type="text" placeholder="QTD. DO PRODUTO" class="text-box" name="qtdproduto"></div>
                        <div class="textinput"><input type="text" placeholder="VALOR DO PRODUTO" class="text-box" name="vlrproduto"></div>
                        <div class="textinput"><input type="text" placeholder="VALOR MOVIMENTO" class="text-box" name="vlrmovimento"></div>
                    </div>
                </div>
                <div class="format-border">
                    <div class="mainbg container-fluid">                                    
                        <div class="inputcontainer">
                            <button class="btn center-block btn-block bnt-format" name="bntkardex" value='Cadastrar'>Gravar</button>
                            <button class="btn btn-block bnt-format" name="bntkardex" value='Alterar'>Alterar</button>
                            <!--<button class="btn btn-block bnt-format" name="bntkardex" value='Listar'>Listar</button>-->
                            <button class="btn btn-block bnt-format" name="bntkardex" value='Deletar'>Deletar</button>
                        </div>
                    </div>
                </div>
                <div>
                    <div>
                        <%
                            String m1 = (String) request.getAttribute("MensagemKardex");
                        %>
                        <h5>
                            <%out.println(m1);%>:
                        </h5>
                    </div>
                </div>
            </div>
        </form>

        <div class="footer container-fluid">
            <img src="img\PequenoDuck.png" alt="" class="footer-logo">
            <p class="footer-text text-center">Desenvolvido por:</p>
            <p class="subtitle text-center">Duck Labs</p>
        </div>

    </body>
</html>