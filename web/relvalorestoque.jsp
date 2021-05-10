<%-- 
    Document   : relvalorestoque
    Created on : 22/10/2020, 22:47:30
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/itenstyle.css" />
        <title>Itens de bairo giro</title>
    </head>

    <body>
        <form action='controller_relatorios' method='post'>
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
                <div class="mainbg container-fluid" id="conteudo">

                    <div class="text-primary">
                        <h4>RELATÓRIO DE VALORES DE ESTOQUE</h4>
                    </div>

                    <img src="img\DuckFundo2.png" alt="" class="bg-img">          

                    <div>
                        <button class="btnCadastrar btn center-block btn-block bnt-format" name="btnListaRel" value='vlrestoque'>Gerar Relatório</button>
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
        </form>

        <div class="footer container-fluid">
            <img src="img\PequenoDuck.png" alt="" class="footer-logo">
            <p class="footer-text text-center">Desenvolvido por:</p>
            <p class="subtitle text-center">Duck Labs</p>
        </div>

    </body>

</html>
