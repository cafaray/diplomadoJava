package mx.com.pixup.bo;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public interface OfertaBO {
    
    Oferta agregar(Oferta oferta) throws PixUpBOException;
    Oferta actualizar(Oferta oferta) throws PixUpBOException;
    List<OfertaWrapper> listarVigentes()throws PixUpBOException;
    void eliminar(int identificador) throws PixUpBOException;
    List<Oferta> listar() throws PixUpBOException;
    
}
