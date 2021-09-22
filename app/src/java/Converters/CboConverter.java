package Converters;

import entities.Cbo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.CboFacade;
import sessions.ModalidadeFacade;

@FacesConverter(value = "cboConverter")
public class CboConverter extends ManualCDILookup implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            CboFacade facade = null;
            try {
                    facade = getFacadeWithJNDI(CboFacade.class);
                } catch (NamingException ex) {
                    Logger.getLogger(CboConverter.class.getName()).log(Level.SEVERE, null, ex);
                }
            Cbo cbo = facade.findByCodigo(value);
            return cbo;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Cbo cbo = (Cbo) value;
            return cbo.getNome();
        }
        return "";
    }
    
}
