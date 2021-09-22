package Converters;

import entities.Pessoa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.PessoaFacade;

@FacesConverter(value = "pessoaConverter")
public class PessoaConverter extends ManualCDILookup implements Converter {

   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            PessoaFacade pessoaFacade = null;
            try {
                pessoaFacade = getFacadeWithJNDI(PessoaFacade.class);
            } catch (NamingException ex) {
                Logger.getLogger(PessoaConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            Pessoa pessoa = pessoaFacade.findPessoaById(Integer.parseInt(value));
            return pessoa;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Pessoa pessoa = (Pessoa) value;
            return String.valueOf(pessoa.getId());
            
        }
        return null;
    }
    
}
