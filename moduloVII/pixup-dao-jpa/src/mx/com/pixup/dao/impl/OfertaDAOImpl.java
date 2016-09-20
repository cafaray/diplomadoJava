package mx.com.pixup.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import mx.com.pixup.dao.OfertaDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import static mx.com.pixup.dao.impl.GenericDAOImpl.factory;
import mx.com.pixup.model.jpa.Oferta;

public class OfertaDAOImpl extends GenericDAOImpl<Oferta, Integer> implements OfertaDAO {

    public OfertaDAOImpl(Class<Oferta> clase) {
        super(clase);
    }

    @Override
    public List<Oferta> ofertas(Date inicio, Date fin) throws PixUpDAOException {
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try{
            TypedQuery<Oferta> query = em.createNamedQuery("Oferta.findByFechas", Oferta.class);
            query.setParameter("fechainicio", inicio);
            query.setParameter("fechafinal", fin);
            List<Oferta> ofertas = query.getResultList();
            if(ofertas.size()>0){
                return ofertas;
            } else {
                return new ArrayList<>();
            }
        } catch(NullPointerException e){
            e.printStackTrace(System.out);			            
            throw new PixUpDAOException("Ocurrió un error al consultar los datos, se genero un resultado nulo.");
        } catch(PersistenceException e){				
            e.printStackTrace(System.out);			
            throw new PixUpDAOException("Imposible obtener el resultado de ofertas disponibles.");
        }finally{				
            em.close();
        }	                
    }
    
    
    
}
