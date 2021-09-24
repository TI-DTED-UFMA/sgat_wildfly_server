package Converters;

import entities.Local;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.LocalFacade;
import sessions.ModalidadeFacade;

@FacesConverter(value = "localConverter")
public class LocalConverter extends ManualCDILookup implements Converter {


        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            LocalFacade facade = null;
            try {
                facade = getFacadeWithJNDI(LocalFacade.class);
            } catch (NamingException ex) {
                Logger.getLogger(LocalConverter.class.getName()).log(Level.SEVERE, null, ex);
            }

            Local local = facade.findByDescricao(value);
            return local;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Local local = (Local) value;
            return local.getDescricao();
        }
        return "";
    }
    
}
