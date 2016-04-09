package mx.com.pixup.bo.impl;

import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.dao.DiscoDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.impl.DiscoDAOImpl;
import mx.com.pixup.model.jpa.Disco;

public class DiscoBOImpl implements DiscoBO {

    private final DiscoDAO dao = new DiscoDAOImpl(Disco.class);
            
            
    @Override
    public Disco agregar(Disco disco) throws PixUpBOException {
        try {
            return dao.save(disco);
        } catch (PixUpDAOException ex) {
            ex.printStackTrace(System.out);
            throw new PixUpBOException("No se logro registar el disco");
        }
    }
    
}
