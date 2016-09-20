<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Realiza el login para iniciar una sesi&oacute;n</h1>
        <spring:nestedPath path="beanUsuario">
 
            <form action="" method="post">
                <label for="usuario">Cuenta de usuario/Correo electr&oacute;nico:</label>
                <spring:bind path="cuenta">
                    <input type="text" name="${status.expression}" value="${status.value}" id="usuario" />
                </spring:bind>
                
                    <label for="contrasenia">Contrase&ntilde;a:</label>
                <spring:bind path="contrasenia">
                    <input type="password" name="${status.expression}" value="${status.value}" id = "contrasenia" />
                </spring:bind>
                    
                <input type="submit" value="Enviar"> 
            </form>
 
        </spring:nestedPath>
    </body>
</html>
