/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.pixup.eap.ejb;

import javax.ejb.Local;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

/**
 *
 * @author omash
 */
@Local
public interface ManejadorUsuarioLocal {

    Usuario ingresaUsuario(Usuario usuario) throws PixUpBOException;

    Usuario validaUsuario(String cuenta, String contrasenia) throws PixUpBOException;
    
}
