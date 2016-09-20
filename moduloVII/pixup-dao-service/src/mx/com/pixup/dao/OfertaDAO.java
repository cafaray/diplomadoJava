package mx.com.pixup.dao;

import java.util.Date;
import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public interface OfertaDAO extends GenericDAO<Oferta, Integer>{
    
    OfertaWrapper buscarPorIdentificador(int identificador) throws PixUpDAOException;
    
    List<OfertaWrapper> listar(Date fechaInicio, Date fechaFinal) throws PixUpDAOException;
    
}
