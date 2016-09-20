<%@page import="mx.com.pixup.eap.ejb.ManejadorUsuarioLocal"%>
<%@page import="mx.com.pixup.eap.ejb.ManejadorUsuario"%>
<%@page import="java.util.Calendar"%>
<%@page import="mx.com.pixup.bo.exception.PixUpBOException"%>
<%@page import="mx.com.pixup.model.Usuario"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="mx.com.pixup.eap.ejb.FacadeWebLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            private Context getContext() throws NamingException {
                java.util.Properties props = new java.util.Properties();
                props.put(Context.INITIAL_CONTEXT_FACTORY,
                        "org.jnp.interfaces.NamingContextFactory");
                props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
                props.put(InitialContext.URL_PKG_PREFIXES,
                        "org.jboss.naming:org.jnp.interfaces");
                Context ctx = new InitialContext(props);
                return ctx;
            }
        %> 
        <%
            try {
                // Generar contexto con Jboss
                Context context = getContext();
                // Enlazar la interfaz ManejaUsuarioLocal
                //ManejadorUsuarioLocal manejaUsuario = (ManejadorUsuarioLocal) context.lookup("pixup-eap/pixup-eap-ejb.jar/ManejadorUsuario!local");
                FacadeWebLocal manejaUsuario = (FacadeWebLocal) context.lookup("pixup-eap/pixup-eap-ejb.jar/FacadeWeb!local");
                Usuario usuario1 = new Usuario();
                usuario1.setNombre("Alberto");
                usuario1.setApellidoPaterno("Ruiz");
                usuario1.setApellidoMaterno("Vazquez");
                usuario1.setEmail("alberto.ruiz.vazquez@gmail.com");
                Calendar fechaNacimiento = Calendar.getInstance();
                fechaNacimiento.set(Calendar.YEAR, 1979);
                fechaNacimiento.set(Calendar.MONTH, 9);
                fechaNacimiento.set(Calendar.DATE, 19);
                usuario1.setFechaNacimiento(fechaNacimiento.getTime());
                usuario1.setGenero("H");
                usuario1.setNumeroTelefonico("5560121201");
                usuario1.setPassword("elPaso");
                try {
                    usuario1 = manejaUsuario.ingresaUsuario(usuario1);
                    out.print("Usuario generado: " + usuario1.getNombre());
                } catch (PixUpBOException e) {
                    e.printStackTrace(System.out);
                    out.print(e.getMessage());
                }
            } catch (NamingException e) {
                out.println(e);
                e.printStackTrace(System.out);
            }
        %>
    </body>
</html>
