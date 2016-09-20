package mx.com.pixup.bo;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Disco;

public interface DiscoBO {

    List<Disco> listar() throws PixUpBOException;
    Disco agregar(Disco disco) throws PixUpBOException;
}
