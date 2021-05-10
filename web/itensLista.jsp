<%-- 
    Document   : itens
    Created on : 22/10/2020, 22:47:04
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.itensEstoqueDAO"%>
<%@page import="model.itensestoque"%>

<!DOCTYPE html>

<%@ page language="java"%>

<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
        <link href="https://fonts.googleapis.com/css2?family=PT+Sans+Narrow:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="styles/itenstyle.css" />
        <title>Itens</title>
    </head>

    <body>
        <form action='controller_manteritens' method='post'>
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
                    <img src= "img\DuckFundo2.png" alt="" class="bg-img">
                    <div class="inputcontainer">
                        <div>
                            <table class="FormatTable">
                                <%
                                    List<itensestoque> itens = (List<itensestoque>) request.getAttribute("listaitens");
                                %><tr><th class="FormatTable">CODIGO BARRAS</th><%
                                    %><th class="FormatTable">GRUPO ESTOQUE</th><%
                                    %><th class="FormatTable">MARCA</th><%
                                    %><th class="FormatTable">DESCRICAO</th><%
                                    %><th class="FormatTable">DESCRICAO LONGA</th><% for (itensestoque it : itens) {
                                %><tr><%
                                    %><td class="FormatTable"><%out.print(it.getId_ie());%></td><%
                                    %><td class="FormatTable"><%out.print(it.getCodigogp_id());%></td><%
                                    %><td class="FormatTable"><%out.print(it.getMarca_id());%></td><%
                                    %><td class="FormatTable"><%out.print(it.getDescricaocurta());%></td><%
                                    %><td class="FormatTable"><%out.print(it.getDescricaodetalhada());%></td><%
                                    %></tr><%
                                        }
                                    %>                            
                            </table>
                        </div>
                    </div>
                </div>
                <div>
                    <div>
                        <%
                            String m1 = (String) request.getAttribute("Mensagem");
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