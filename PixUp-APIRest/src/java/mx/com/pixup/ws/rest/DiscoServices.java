package mx.com.pixup.ws.rest;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Disco;

public interface DiscoServices {

    String echo(String mensaje);
    List<Disco> listar() throws PixUpBOException;
    Disco agregar(Disco disco) throws PixUpBOException;
    
}
