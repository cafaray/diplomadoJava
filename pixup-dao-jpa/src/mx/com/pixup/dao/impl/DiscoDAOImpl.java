package mx.com.pixup.dao.impl;

import mx.com.pixup.dao.DiscoDAO;
import mx.com.pixup.model.jpa.Disco;

public class DiscoDAOImpl extends GenericDAOImpl<Disco, Integer> implements DiscoDAO {

    public DiscoDAOImpl(Class<Disco> clase) {
        super(clase);
    }
    
}
