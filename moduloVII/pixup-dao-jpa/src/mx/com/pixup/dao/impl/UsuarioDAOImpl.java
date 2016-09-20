package mx.com.pixup.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import mx.com.pixup.dao.UsuarioDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import static mx.com.pixup.dao.impl.GenericDAOImpl.factory;
import mx.com.pixup.model.jpa.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

    
    public UsuarioDAOImpl(){
        super(Usuario.class);
    }
    
    public UsuarioDAOImpl(Class<Usuario> clase) {
        super(clase);
    }
    
    @Override
    public Usuario validaAcceso(String cuenta, String contrasenia) throws PixUpDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try{
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmailPassword", Usuario.class);
            query.setParameter("cuenta", cuenta);
            query.setParameter("contrasenia", contrasenia);
            List<Usuario> usuarios = query.getResultList();
            if(usuarios.size()>0){
                return usuarios.get(0);
            } else {
                return null;
            }
        } catch(NullPointerException e){
            e.printStackTrace(System.out);			            
            throw new PixUpDAOException("Ocurrió un error al consultar los datos, se genero un resultado nulo.");
        } catch(PersistenceException e){				
            e.printStackTrace(System.out);			
            throw new PixUpDAOException("Ocurrió un error al guardar, causado por: "+e.getCause());
        }finally{				
            em.close();
        }	                
        
    }
    
    @Override
    public Usuario findByEMail(String email) throws PixUpDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try{
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmail", Usuario.class);
            query.setParameter("email", email);
            List<Usuario> usuarios = query.getResultList();
//            return query.getSingleResult();
            if(usuarios.size()>0){
                return usuarios.get(0);
            } else {
                return null;
            }
        } catch(NullPointerException e){
            e.printStackTrace(System.out);			            
            throw new PixUpDAOException("Ocurrió un error al consultar los datos, se genero un resultado nulo.");
        } catch(PersistenceException e){				
            e.printStackTrace(System.out);			
            throw new PixUpDAOException("Ocurrió un error al guardar, causado por: "+e.getCause());
        }finally{				
            em.close();
        }	                
        
    }

    @Override
    public Usuario save(Usuario objeto) throws PixUpDAOException {
        Usuario user = super.save(objeto);
        return user;
    }

    @Override
    public Usuario update(Usuario objeto) throws PixUpDAOException {
        super.update(objeto);
        return objeto;
    }

    @Override
    public void delete(Usuario objeto) throws PixUpDAOException {
        super.delete(objeto);
    }

    @Override
    public boolean contains(Usuario objeto) throws PixUpDAOException {
        return super.contains(objeto);
    }

    @Override
    public List<Usuario> findAll() throws PixUpDAOException {
        return super.findAll();
    }

    @Override
    public Usuario findById(Integer id) throws PixUpDAOException {
        return super.findById(id);
    }

    @Override
    public List<Usuario> findByNombreCompleto(String nombre, String paterno, String materno) throws PixUpDAOException {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        try{
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByNombreCompleto", Usuario.class);
            query.setParameter("nombre", "%"+nombre+"%");
            query.setParameter("paterno", "%"+paterno+"%");
            query.setParameter("materno","%"+ materno+"%");
            List<Usuario> usuarios = query.getResultList();
            return usuarios;

        } catch(NullPointerException e){
            e.printStackTrace(System.out);			            
            throw new PixUpDAOException("Ocurrió un error al consultar los datos, se genero un resultado nulo.");
        } catch(PersistenceException e){				
            e.printStackTrace(System.out);			
            throw new PixUpDAOException("Ocurrió un error al guardar, causado por: "+e.getCause());
        }finally{				
            em.close();
        }	                
                
    }
    
}
