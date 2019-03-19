<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="assets/css/mensagens.css"> 
        <!-- Font Awesome -->
        <link rel="stylesheet" type="text/css" href="assets/fontawesome-free-5.7.2-web/css/all.css">
        <title>Erro</title>
    </head>

    <body>
        <div class='msg msg-erro'>
            <p class="p-icon"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></p>
            <p class="p-msg">
                <b>Erro</b><br>
                <c:out value="${mensagem}" />
            </p>
        </div>
        <div class='links'>
            <a href="index.jsp">Voltar</a>
        </div>
    </body>
</html>