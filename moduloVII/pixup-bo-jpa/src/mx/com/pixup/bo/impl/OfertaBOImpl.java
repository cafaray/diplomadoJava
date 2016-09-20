package mx.com.pixup.bo.impl;

import java.util.Date;
import java.util.List;
import mx.com.pixup.bo.OfertaBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.dao.OfertaDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.impl.OfertaDAOImpl;
import mx.com.pixup.model.jpa.Oferta;

public class OfertaBOImpl implements OfertaBO {

    private static final OfertaDAO dao = new OfertaDAOImpl(Oferta.class);
    
    @Override
    public List<Oferta> ofertasDisponibles() throws PixUpBOException {
        try {
            return dao.ofertas(new Date(), new Date());
        } catch (PixUpDAOException ex) {
            ex.printStackTrace(System.out);
            throw new PixUpBOException("No se logro consultar las ofertas disponibles. Revise el log para más detalles.");
        }
    }
    
    
    
}
