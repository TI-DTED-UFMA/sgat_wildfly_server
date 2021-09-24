package beans;

import Validators.LoginValidator;

import entities.Funcionario;
import entities.Pessoa;
import entities.Usuario;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jsf.util.JsfUtil;
import jsf.util.NivelAcesso;
import service.SessionContext;
import sessions.FuncionarioFacade;
import sessions.PessoaFacade;
import sessions.UsuarioFacade;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController  implements Serializable{
    
    private Usuario usuario = new Usuario();
    private Usuario usuarioEdit = new Usuario();
    private Funcionario funcionario = new Funcionario();
    private Pessoa pessoa =  new Pessoa();
    private String email ="";
    private String password = "";
    private String password2 = "";
    private String currentPassword = "";
    private boolean loggedIn;
    private NivelAcesso niveis[] = {new NivelAcesso(1, "Administrador"), new NivelAcesso(2, "Leitor")};
    private int nivel;
    private boolean passwordError = true;
    
    @EJB
    private UsuarioFacade ebjUsuario;
    @EJB
    private FuncionarioFacade ejbFuncionario;
    @EJB
    private PessoaFacade ejbPessoa;
    
    //GETTERS AND SETTERS
    
    public Usuario getUsuarioEdit()
    {
        return usuarioEdit;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    
    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }

    public List<Usuario> getListUsuario() {
        return ebjUsuario.findAll();
    }
    
    public String getPassword2() {   
        return password2;
    }
     
    public void setPassword2(String password2) {    
        this.password2 = password2;
    }

    public boolean isPasswordError() {
        return passwordError;
    }

    public void setPasswordError(boolean passwordError) {
        this.passwordError = passwordError;
    }

    public NivelAcesso[] getNiveis() {
        return niveis;
    }
    
    public int getNivel() {    
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;    
    }

    public void setNiveis(NivelAcesso[] niveis) {
        this.niveis = niveis;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public UsuarioFacade getEbjUsuario() {
        return ebjUsuario;
    }

    public void setEbjUsuario(UsuarioFacade ebjUsuario) {
        this.ebjUsuario = ebjUsuario;
    }

    public FuncionarioFacade getEjbFuncionario() {
        return ejbFuncionario;
    }

    public void setEjbFuncionario(FuncionarioFacade ejbFuncionario) {
        this.ejbFuncionario = ejbFuncionario;
    }

    public PessoaFacade getEjbPessoa() {
        return ejbPessoa;
    }

    public void setEjbPessoa(PessoaFacade ejbPessoa) {
        this.ejbPessoa = ejbPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String logIn()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pessoa = getEjbPessoa().getByEmail(email);  
            System.out.println(pessoa);
            if (pessoa != null){
                List<Funcionario> funcionarios = getEjbFuncionario().findByPessoa(pessoa);
                System.out.println(funcionarios);
                if(funcionarios!=null && !funcionarios.isEmpty()){
                    funcionario = funcionarios.get(funcionarios.size()-1);
                    System.out.println(funcionario);
                }
                if (funcionario != null)
                {
                    usuario = getEbjUsuario().getByFuncionario(funcionario);
                    System.out.println(usuario);
                    if(usuario != null)
                    {
                        if(LoginValidator.validLogin(usuario, password))
                        {
                            System.out.println("logging " + context.toString());
                            loggedIn = true;
                            SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
                            password = "";
                            return "/public/home.xhtml?faces-redirect=true";
                        }
                        else {
                            JsfUtil.addErrorMessage(ResourceBundle.getBundle("/resources/BundleLogin").getString("UserPasswordIncorrect"));
                            FacesContext.getCurrentInstance().validationFailed();
                        }
                    }
                }
            } 
        }
        catch(Exception ex){
            FacesContext.getCurrentInstance().validationFailed();
        }
        
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/resources/BundleLogin").getString("UserNotFound"));
        return null;
    }
    
    public String logOut()
    {
        return prepareNewLogin();
    }
    
    
    private String prepareNewLogin()
    {
        SessionContext.getInstance().encerrarSessao();
        this.loggedIn = false;
        JsfUtil.addErrorMessage(ResourceBundle.getBundle("/resources/BundleLogin").getString("SuccessfullLogOut"));
        return "/index" + "?faces-redirect=true";
    }
    
    public String persistUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        Usuario user = new Usuario();
        if(ebjUsuario.getByFuncionario(funcionario) == null)
        {
        
            user.setFuncionario(funcionario);
            if(password.equals(password2))
            {
               user.setSenha(LoginValidator.encryptPassword(password));
               user.setNivel(nivel);
               user.setAtivo(true);
               user.setDtCadastro(new Date());

               try{
                   ebjUsuario.create(user);
                   JsfUtil.addSuccessMessage("Usuário cadastrado com sucesso!");
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
            }
            JsfUtil.addErrorMessage("Atenção! As senhas não coincidem.");
            password = "";
            password2 = "";
        }else
            JsfUtil.addErrorMessage("O funcionário selecionado já possui um usuário");
        return null;
    }
    
    
    public String prepareUpdateUsuario(Usuario user)
    {
        usuarioEdit = user;
        return "view_edit_usuario.xhtml";
    }
    
    public String prepareUpdatePerfil(Pessoa pessoa)
    {
        this.pessoa = pessoa;
        Funcionario func = null;
        List<Funcionario> funcionarios = getEjbFuncionario().findByPessoa(pessoa);
        System.out.println(funcionarios);
        if(funcionarios!=null && !funcionarios.isEmpty()){
            func = funcionarios.get(funcionarios.size()-1);
        }
        System.out.println("usuario " + func.getPessoa().getNome());
        usuarioEdit = ebjUsuario.getByFuncionario(func);
        return "/usuarios/view_edit_perfil.xhtml";
    }
    
    public String updatePerfil() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        System.out.println(usuarioEdit.getSenha());
        if(usuarioEdit.getSenha().equals(LoginValidator.encryptPassword(currentPassword)))
        {
            if(password.equals(password2))
            {
                usuarioEdit.setSenha(LoginValidator.encryptPassword(password));
                try{
                    ebjUsuario.edit(usuarioEdit);
                    ejbPessoa.edit(pessoa);
                    JsfUtil.addSuccessMessage("Usuário atualizado com sucesso!");
                    return null;
                }catch(Exception e)
                {
                    JsfUtil.addErrorMessage("Houve um problema na atualização dos dados. Tente novamente.");
                    e.printStackTrace();
                }
            }
            JsfUtil.addErrorMessage("Atenção! As senhas não coincidem.");
        }
        else
        {
            JsfUtil.addErrorMessage("Atenção! A senha atual não coincide.");
        }
         password = "";
        password2 = ""; 
        return null;
    }
    
    public String updateUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        if(password.equals(password2))
        {
            usuarioEdit.setSenha(LoginValidator.encryptPassword(password));
            usuarioEdit.setNivel(nivel);
            try{
                ebjUsuario.edit(usuarioEdit);
                JsfUtil.addSuccessMessage("Usuário atualizado com sucesso!");
                return null;
            }catch(Exception e)
            {
                JsfUtil.addErrorMessage("Houve um problema na atualização dos dados. Tente novamente.");
                e.printStackTrace();
            }
        }
        JsfUtil.addErrorMessage("Atenção! As senhas não coincidem.");
        password = "";
        password2 = ""; 
        return null;
    }
}
