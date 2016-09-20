<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Rellena el formulario</h1>
        <form action="controller.do" method="POST">
            <label for="nombre">Nombre: </label><input type="text" name="nombre" />
            <label for="edad">Edad: </label><input type="text" name="edad" />
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
