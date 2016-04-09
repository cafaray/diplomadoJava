package mx.com.pixup.bo;

import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.jpa.Disco;

public interface DiscoBO {
    Disco agregar(Disco disco) throws PixUpBOException; 
}
