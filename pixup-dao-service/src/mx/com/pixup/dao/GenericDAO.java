package mx.com.pixup.dao;

import java.io.Serializable;
import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;

public interface GenericDAO<T, Id extends Serializable> {

    T inserta(T objeto) throws PixUpDAOException;
    T actualiza(T objeto) throws PixUpDAOException;
    void elimina(T objeto) throws PixUpDAOException;
    void eliminaPorId(Integer identificador) throws PixUpDAOException;
    T encuentraPorId(Integer identificador) throws PixUpDAOException;
    List<T> lista() throws PixUpDAOException;
    
}
