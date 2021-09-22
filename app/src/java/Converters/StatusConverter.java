package Converters;

import entities.Status;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.StatusFacade;

@FacesConverter(value = "statusConverter")
public class StatusConverter extends ManualCDILookup implements Converter {
 
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            StatusFacade facade = null;
            try {
                facade = getFacadeWithJNDI(StatusFacade.class);
            } catch (NamingException ex) {
                Logger.getLogger(StatusConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            Status val = facade.findByDescricao(value);
            return val;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Status val = (Status) value;
            return val.getDescricao();
        }
        return "";
    }
    
}
