<%@page import="mx.com.pixup.model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ventana en caso de exito</h1>
        Datos recibidos.
        <%
            Persona persona = (Persona)request.getSession().getAttribute("persona");
        %>
        <p>Nombre: <%=persona.getNombre() %></p>
        <p>Edad: <%=persona.getEdad() %></p>
    </body>
</html>
