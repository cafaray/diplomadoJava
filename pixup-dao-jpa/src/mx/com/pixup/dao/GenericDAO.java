package mx.com.pixup.dao;

import java.io.Serializable;
import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;

public interface GenericDAO <T, Id extends Serializable> {
	

    /**
     * Crea una instancia a ser gestionada y persistida
     *
     * @param objeto Objeto a persistir
     * @return Objeto persistido
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public T save(T objeto) throws PixUpDAOException;

    /**
     * Actualiza una instancia gestionada y persistida
     *
     * @param objeto Objeto a actualizar
     * @return Objeto actualizado
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public T update(T objeto) throws PixUpDAOException;

    /**
     * Borra una instancia gestionada y deja de ser persistida
     *
     * @param objeto Objeto a borrar
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public void delete(T objeto) throws PixUpDAOException;

    /**
     * Verifica que la instancia de un Objeto se encuentre gestionada y persistida
     *
     * @param objeto Objeto a verificar
     * @return True si esta gestionada y persistida, False de lo contario
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public boolean contains(T objeto) throws PixUpDAOException;

    /**
     * Busca todas las instancias que se encuentran gestionadas y persistidas
     *
     * @return Lista con todas las instancias
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public List<T> findAll()throws PixUpDAOException;

    /**
     * Busca una Instancia gestionada y persistida por su Id
     *
     * @param id Id de la Instancia
     * @return Instancia
     * @throws mx.com.pixup.dao.exception.PixUpDAOException
     */
    public T findById(String id)throws PixUpDAOException;


}
