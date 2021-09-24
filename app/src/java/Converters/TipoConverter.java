package Converters;

import entities.Tipo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.ModalidadeFacade;
import sessions.TipoFacade;

@FacesConverter(value = "tipoConverter")
public class TipoConverter extends ManualCDILookup implements Converter {

    @EJB
    private TipoFacade facade;
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            TipoFacade facade = null;
            try {
                facade = getFacadeWithJNDI(TipoFacade.class);
            } catch (NamingException ex) {
                Logger.getLogger(TipoConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            Tipo tipo = facade.findByDescricao(value);
            return tipo;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Tipo tipo = (Tipo) value;
            return tipo.getDescricao();
        }
        return "";
    }
    
}
