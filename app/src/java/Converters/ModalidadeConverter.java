package Converters;

import entities.Modalidade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;

import sessions.ModalidadeFacade;

@FacesConverter(value="modalidadeConverter")
public class ModalidadeConverter extends ManualCDILookup implements Converter {

//    @EJB
//    private ModalidadeFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null){
            if(!value.isEmpty()){
                ModalidadeFacade facade = null;
                try {
                    facade = getFacadeWithJNDI(ModalidadeFacade.class);
                } catch (NamingException ex) {
                    Logger.getLogger(ModalidadeConverter.class.getName()).log(Level.SEVERE, null, ex);
                }
                Modalidade modalidade = facade.findByDescricao(value);
                return modalidade;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            try {
                Modalidade modalidade = (Modalidade) value;
                return modalidade.getDescricao();
            }
            catch(Exception ex){
                return ex.toString();
            }
        }
        return "";
    }
    
}
