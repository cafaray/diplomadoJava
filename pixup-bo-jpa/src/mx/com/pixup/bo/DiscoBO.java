package mx.com.pixup.bo;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.jpa.Disco;

public interface DiscoBO {
    Disco agregar(Disco disco) throws PixUpBOException; 
    List<Disco> listar() throws PixUpBOException;
    Disco encuentraPorId(Integer id) throws PixUpBOException;
    
}
