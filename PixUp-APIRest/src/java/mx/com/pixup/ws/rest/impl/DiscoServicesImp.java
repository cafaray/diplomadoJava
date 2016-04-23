package mx.com.pixup.ws.rest.impl;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.DiscoBOImpl;
import mx.com.pixup.model.Disco;
import mx.com.pixup.ws.rest.DiscoServices;

@Path("/discos")
public class DiscoServicesImp implements DiscoServices {

    private final static DiscoBO bo = new DiscoBOImpl();
    
    @Override
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)    
    public List<Disco> listar() throws PixUpBOException {
        return bo.listar();
    }

    @Override
    public Disco agregar(Disco disco) throws PixUpBOException {
        return bo.agregar(disco);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public String echo(String mensaje) {
        mensaje = "WS_REST: echo ".concat(mensaje);
        System.out.println(mensaje);
        return mensaje;
    }
    
}
