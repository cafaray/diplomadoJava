package mx.com.pixup.bo;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.jpa.Oferta;


public interface OfertaBO {

    List<Oferta> ofertasDisponibles() throws PixUpBOException;
    
}
