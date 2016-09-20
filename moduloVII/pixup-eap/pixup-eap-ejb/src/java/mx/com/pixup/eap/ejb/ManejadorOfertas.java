package mx.com.pixup.eap.ejb;

import java.util.List;
import javax.ejb.Stateful;
import mx.com.pixup.bo.OfertaBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.OfertaBOImpl;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

@Stateful
public class ManejadorOfertas implements ManejadorOfertasRemote {

    private static final OfertaBO bo = new OfertaBOImpl();

    @Override
    public void eliminar(int identificador) throws PixUpBOException {
        bo.eliminar(identificador);
    }

    @Override
    public List<OfertaWrapper> ofertasDisponibles() throws PixUpBOException {
        return bo.listarVigentes();
    }

    @Override
    public Oferta registrar(Oferta oferta) throws PixUpBOException {
        return bo.agregar(oferta);
    }
    
}
