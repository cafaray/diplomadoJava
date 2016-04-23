package mx.com.pixup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pixup.model.Usuario;
import mx.com.pixup.services.LoguearUsuario;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController {
    
    private LoguearUsuario loguearUsuario;
    
    public LoginController() {
        setCommandClass(Usuario.class);
        setCommandName("beanUsuario");
        setSuccessView("indexView");
        setFormView("loginView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public LoguearUsuario getLoguearUsuario() {
        return loguearUsuario;
    }
    
    public void setLoguearUsuario(LoguearUsuario loguearUsuario){
        this.loguearUsuario = loguearUsuario;
    }
    
     @Override
     protected ModelAndView onSubmit(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Object command, 
        BindException errors) throws Exception {
        Usuario usuario = (Usuario)command;
         
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("mensajeLogin", loguearUsuario.login(usuario));
     
        return mv;
     }
     
}
