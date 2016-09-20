package mx.com.pixup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pixup.services.FuncionEco;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class EcoController extends SimpleFormController {
    
    private FuncionEco funcionEco;
    
    public EcoController() {

        setCommandClass(Mensaje.class);
        setCommandName("mensaje");
        setSuccessView("messageView");
        setFormView("echoView");
    }
    
    
     @Override
     protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) 
             throws Exception {
        Mensaje mensaje = (Mensaje)command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("echoMessage", funcionEco.echo(mensaje.getValue()));
        return mv;
     }
     
     public void setFuncionEco(FuncionEco funcionEco){
         this.funcionEco = funcionEco;
     }
     
}
