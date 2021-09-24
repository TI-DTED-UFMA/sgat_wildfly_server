package Converters;

import entities.Funcionario;
import entities.Pessoa;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;
import jsf.util.ManualCDILookup;
import sessions.FuncionarioFacade;
import sessions.ModalidadeFacade;
import sessions.PessoaFacade;

@FacesConverter(value = "funcionarioConverter")
public class FuncionarioConverter extends ManualCDILookup implements Converter {

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()){
            
            FuncionarioFacade facade = null;
             PessoaFacade pessoaFacade = null;
            try {
                facade = getFacadeWithJNDI(FuncionarioFacade.class);
                pessoaFacade = getFacadeWithJNDI(PessoaFacade.class);
                
            } catch (NamingException ex) {
                Logger.getLogger(FuncionarioConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            Pessoa pessoa = pessoaFacade.findByCompleteName(value);
            List<Funcionario> funcionarios = facade.findByPessoa(pessoa);
            if(funcionarios!=null && !funcionarios.isEmpty()){
                return funcionarios.get(funcionarios.size()-1);
            }
            return null;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Funcionario funcionario = (Funcionario) value;
            return funcionario.getPessoa().getNome() + " " + funcionario.getPessoa().getSobrenome();
        }
        return "";
    }
    
}
