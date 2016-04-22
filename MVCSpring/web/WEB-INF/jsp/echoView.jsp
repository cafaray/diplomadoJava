<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funci&oacute;n echo</title>
    </head>
    <body>
        <h1>Escribe el mensaje</h1>
        <spring:nestedPath path="mensaje">
            <form action="" method="post">
                Mensaje:
                <spring:bind path="value">
                    <input type="text" name="${status.expression}" value="${status.value}" />
                </spring:bind>
                <input type="submit" value="Enviar" />
            </form>
        </spring:nestedPath>

    </body>
</html>
