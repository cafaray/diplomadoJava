package mx.com.pixup.bo.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mx.com.pixup.bo.OfertaBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.dao.OfertaDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.impl.OfertaDAOImpl;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public class OfertaBOImpl implements OfertaBO {
    
    private static OfertaDAO dao;

    public OfertaBOImpl() {
        dao = new OfertaDAOImpl();
    }

    @Override
    public Oferta agregar(Oferta oferta) throws PixUpBOException {
        try{
            Oferta ofertaVuelta = dao.inserta(oferta);
            return ofertaVuelta;
        } catch (NullPointerException e){
            throw new PixUpBOException("No ha sído posible agregar la oferta.");
        }catch(PixUpDAOException e){
            throw new PixUpBOException(e.getMessage());
        }
    }

    @Override
    public Oferta actualizar(Oferta oferta) throws PixUpBOException {
        try{
            return dao.actualiza(oferta);
        } catch (NullPointerException e){
            throw new PixUpBOException("No ha sído posible actualizar la oferta.");
        }catch(PixUpDAOException e){
            throw new PixUpBOException(e.getMessage());
        }
    }

    @Override
    public List<OfertaWrapper> listarVigentes() throws PixUpBOException {
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2001);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DATE, 1);
            Date fechaInicio = calendar.getTime();
            Date fechaFinal = new Date();
            return dao.listar(fechaInicio, fechaFinal);
        } catch (NullPointerException e){
            throw new PixUpBOException("No ha sído posible listar las ofertas vigentes.");
        }catch(PixUpDAOException e){
            throw new PixUpBOException(e.getMessage());
        }
    }

    @Override
    public void eliminar(int identificador) throws PixUpBOException {
        try{
            dao.eliminaPorId(identificador);
        } catch (NullPointerException e){
            throw new PixUpBOException("No ha sído posible eliminar la oferta.");
        }catch(PixUpDAOException e){
            throw new PixUpBOException(e.getMessage());
        }
    }

    @Override
    public List<Oferta> listar() throws PixUpBOException {
        try{
            return dao.lista();
        } catch (NullPointerException e){
            throw new PixUpBOException("No ha sído posible listar las ofertas.");
        }catch(PixUpDAOException e){
            throw new PixUpBOException(e.getMessage());
        }
    }
    
}
