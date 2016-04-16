package mx.com.pixup.dao;

import java.util.Date;
import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.model.jpa.Oferta;

public interface OfertaDAO extends GenericDAO<Oferta, Integer> {
    
    List<Oferta> ofertas(Date inicio, Date fin) throws PixUpDAOException;
    
}
