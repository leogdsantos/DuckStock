<%-- 
    Document   : Login
    Created on : 22/10/2020, 22:46:40
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="styles/loginstyeles.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
        
        <link rel="stylesheet" href="styles/loginstyles.css" />
        <title>Login</title>
    </head>

    <body>
        <div class="container-fluid center-block container-login">
            <div class="well ">
                <img class="img-responsive img-border-index" src="img\Logo - Duck Coffee.png" alt=" ">
                <div class="row ">
                    <input class="input-width input-spacing center-block " placeholder="Nome de Usuário ou Email " type="text" />
                </div>
                <div class="row ">
                    <input class="input-width input-spacing center-block " placeholder="Senha " type="password " />
                </div>
                <div class="row ">
                    <a class="center-block text-center " href=" https://www.google.com/search?sxsrf=ALeKk01bH18MdKlKRzN6qRCxjfqTooLXag%3A1600532856337&source=hp&ei=eDFmX6STEoi25OUPjYmZGA&q=como+n%C3%A3o+ser+mongol%C3%A3o&oq=como+n%C3%A3o+ser+mongol%C3%A3o&gs_lcp=CgZwc3ktYWIQAzIHCCEQChCgAToECCMQJzoFCAAQsQM6AggAOggIABCxAxCDAToGCAAQFhAeULElWLpUYIhcaAJwAHgBgAG2BogBsyCSAQ42LjEyLjEuMC4xLjAuMpgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwikr-fC0fXrAhUIG7kGHY1EBgMQ4dUDCAc&uact=5 ">Esqueci minha senha</a>
                </div>
                <div class="row ">
                    <button class="input-width input-spacing__btn center-block btn-block bnt-format btn">
                        Login
                    </button>
                </div>
            </div>
        </div>
    </body>

</html>
