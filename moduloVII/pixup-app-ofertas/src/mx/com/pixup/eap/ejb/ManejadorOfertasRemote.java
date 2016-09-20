package mx.com.pixup.eap.ejb;

import java.util.List;
import javax.ejb.Remote;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

@Remote
public interface ManejadorOfertasRemote {
    
    Oferta registrar(Oferta oferta) throws PixUpBOException;
    void eliminar(int identificador) throws PixUpBOException;
    List<OfertaWrapper> ofertasDisponibles() throws PixUpBOException;
    
}
