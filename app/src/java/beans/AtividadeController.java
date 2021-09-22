package beans;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entities.AtaNts;
import sessions.AtividadeFacade;
import entities.Atividade;
import entities.AtividadeTbr;
import entities.Certificados;
import entities.Conexao;
import entities.EdicaoVideo;
import entities.Funcionario;
import entities.Instituicao;
import entities.Local;
import entities.Modalidade;
import entities.Municipio;
import entities.Palestras;
import entities.ParticipacaoInstituicao;
import entities.ParticipacaoIp;
import entities.ParticipacaoLocal;
import entities.ParticipacaoPessoa;
import entities.Pessoa;
import entities.Presenca;
import entities.ProfGeral;
import entities.Solicitacao;
import entities.Tipo;
import entities.Usuario;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import jsf.util.DateUtils;

import jsf.util.JsfUtil;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import service.CadastroAtividade;
import service.TipoModalidadeRelationship;
import sessions.AtaNtsFacade;
import sessions.AtividadeTbrFacade;
import sessions.CertificadosFacade;
//import sessions.AtividadeFacade;
import sessions.ConexaoFacade;
import sessions.EdicaoVideoFacade;
import sessions.FuncionarioFacade;
import sessions.InstituicaoFacade;
import sessions.LocalFacade;
import sessions.ModalidadeFacade;
import sessions.PalestrasFacade;
import sessions.ParticipacaoInstituicaoFacade;
import sessions.ParticipacaoIpFacade;
import sessions.ParticipacaoLocalFacade;
import sessions.ParticipacaoPessoaFacade;
import sessions.PresencaFacade;
import sessions.ProfGeralFacade;
import sessions.SolicitacaoFacade;
import sessions.TipoFacade;


@ManagedBean(name = "atividadeController")
@SessionScoped
public class AtividadeController implements Serializable {
    
    //ATTRIBUTES NECESSARY FOR PERSISTENCE
    private Atividade atividade;
    private Atividade current;
    private Atividade selectedAtividade;
    private List<Atividade> atvidadesRelacionadas;
    private Pessoa atvResponsavel;
    private AtividadeTbr atividadeTbr;
    private Conexao conexao;
    private Conexao currentCon;
    private List<Conexao> conexoes = new ArrayList();
    private Solicitacao solicitacao;
    private AtaNts ata;
    private CadastroAtividade cadastro;
    private int qtdPresentes;
    private Instituicao instituicao;
    private List<Funcionario> funcionarios;
    private List<Tipo> tipos;
    private List<Palestras> palestras = new ArrayList<>();
    private Palestras palestra = new Palestras();
    private Certificados cert;
    private EdicaoVideo edicao;
    
    
    //Atributos auxiliares
    private boolean isAtividadeTBR;
    private boolean enviarCert;
    private boolean isThereManySubjects = false;
    private String finalidade;
    private Integer instituicaoId;
    private Integer atividadeEdicaoId;
    
    private Date data;
    private List<Date> moreDates = new ArrayList<>();    
    private boolean isThereManyDates = false;
    
    
        
    //ATTRIBUTES ENTERPRISE JAVA BEAN FOR COMMUNICATION WITH DB
    @EJB
    private AtividadeFacade ejbAtividade;
    @EJB
    private TipoFacade ejbTipo;
    @EJB
    private ModalidadeFacade ejbModalidade;
    @EJB
    private InstituicaoFacade ejbInstituicao;
    @EJB
    private FuncionarioFacade ejbFuncionario;
    @EJB
    private ConexaoFacade ejbConexao;
    @EJB
    private SolicitacaoFacade ejbSolicitacao;
    @EJB
    private PalestrasFacade ejbPalestras;
    @EJB
    private LocalFacade ejbLocal;
    @EJB
    private AtividadeTbrFacade ejbAtividadeTbr;
    @EJB
    private ParticipacaoInstituicaoFacade ejbPI;
    @EJB
    private CertificadosFacade ejbCerts;
    @EJB
    private AtaNtsFacade ejbAta;
    @EJB
    private ParticipacaoPessoaFacade ejbParticipacaoPessoa;
    @EJB
    private PresencaFacade ejbPresenca;
    @EJB
    private ParticipacaoIpFacade ejbParticipacaoIP;
    @EJB
    private ParticipacaoLocalFacade ejbParticipacaoLocal;
    @EJB
    private EdicaoVideoFacade ejbEdicaoVideo;
    
    @EJB
    private ProfGeralFacade ejbProfGeral;
    
    

    //GETTERS AND SETTERS
    public void setAtvidadesRelacionadas(List<Atividade> atvidadesRelacionadas) {    
        this.atvidadesRelacionadas = atvidadesRelacionadas;
    }
    public List<Atividade> getAtvidadesRelacionadas() {
        return atvidadesRelacionadas;
    }
    public void setAtividadeEdicaoId(Integer atividadeEdicaoId) {
        this.atividadeEdicaoId = atividadeEdicaoId;
    }
    
    public Integer getAtividadeEdicaoId() {
        return atividadeEdicaoId;
    }
    public EdicaoVideo getEdicao() {
        return edicao;
    }

    public void setEdicao(EdicaoVideo edicao) {
        this.edicao = edicao;
    }

    public Atividade getSelectedAtividade() {
        return selectedAtividade;
    }

    public void setSelectedAtividade(Atividade selectedAtividade) {
        this.selectedAtividade = selectedAtividade;
    }
    
    public Integer getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(Integer instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getFinalidade() {   
        return finalidade;
    }

    public boolean isIsThereManySubjects() {
        return isThereManySubjects;
    }

    public void setIsThereManySubjects(boolean isThereManySubjects) {
        this.isThereManySubjects = isThereManySubjects;
    }

    public boolean isIsThereManyDates() {
        return isThereManyDates;
    }

    public void setIsThereManyDates(boolean isThereManyDates) {
        this.isThereManyDates = isThereManyDates;
    }    
    
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Pessoa getAtvResponsavel() {
        return atvResponsavel;
    }

    public void setAtvResponsavel(Pessoa atvResponsavel) {
        this.atvResponsavel = atvResponsavel;
    }

    public boolean isIsAtividadeTBR() {
        return isAtividadeTBR;
    }

    public void setIsAtividadeTBR(boolean isAtividadeTBR) {
        this.isAtividadeTBR = isAtividadeTBR;
    }
    
     
    public AtividadeTbr getAtividadeTbr() {
        return atividadeTbr;
    }

    public void setAtividadeTbr(AtividadeTbr atividadeTbr) {
        this.atividadeTbr = atividadeTbr;
    }

    public Atividade getCurrent() {
        return current;
    }

    public void setCurrent(Atividade current) {
        this.current = current;
    }
    
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Conexao getConexao() {
        return conexao;
    }

    public void setConexao(Conexao conexao) {
        this.conexao = conexao;
    }

    public Conexao getCurrentCon() {
        return currentCon;
    }

    public void setCurrentCon(Conexao currentCon) {
        this.currentCon = currentCon;
    }

    public List<Conexao> getConexoes() {
        return conexoes;
    }

    public void setConexoes(List<Conexao> conexoes) {
        this.conexoes = conexoes;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public AtaNts getAta() {
        return ata;
    }

    public void setAta(AtaNts ata) {
        this.ata = ata;
    }
    
    public int getQtdPresentes() {
        return qtdPresentes;
    }

    public void setQtdPresentes(int qtdPresentes) {
        this.qtdPresentes = qtdPresentes;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public CadastroAtividade getCadastro() {
        return cadastro;
    }

    public void setCadastro(CadastroAtividade cadastro) {
        this.cadastro = cadastro;
    }
    
    public List<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }    

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Certificados getCert() {
        return cert;
    }

    public void setCert(Certificados cert) {
        this.cert = cert;
    }

    public CertificadosFacade getEjbCerts() {
        return ejbCerts;
    }

    public void setEjbCerts(CertificadosFacade ejbCerts) {
        this.ejbCerts = ejbCerts;
    }

    public AtividadeFacade getEjbAtividade() {
        return ejbAtividade;
    }

    public void setEjbAtividade(AtividadeFacade ejbAtividade) {
        this.ejbAtividade = ejbAtividade;
    }

    public TipoFacade getEjbTipo() {
        return ejbTipo;
    }

    public void setEjbTipo(TipoFacade ejbTipo) {
        this.ejbTipo = ejbTipo;
    }

    public ModalidadeFacade getEjbModalidade() {
        return ejbModalidade;
    }

    public void setEjbModalidade(ModalidadeFacade ejbModalidade) {
        this.ejbModalidade = ejbModalidade;
    }

    public InstituicaoFacade getEjbInstituicao() {
        return ejbInstituicao;
    }

    public void setEjbInstituicao(InstituicaoFacade ejbInstituicao) {
        this.ejbInstituicao = ejbInstituicao;
    }

    public FuncionarioFacade getEjbFuncionario() {
        return ejbFuncionario;
    }

    public void setEjbFuncionario(FuncionarioFacade ejbFuncionario) {
        this.ejbFuncionario = ejbFuncionario;
    }

    public ConexaoFacade getEjbConexao() {
        return ejbConexao;
    }

    public void setEjbConexao(ConexaoFacade ejbConexao) {
        this.ejbConexao = ejbConexao;
    }

    public SolicitacaoFacade getEjbSolicitacao() {
        return ejbSolicitacao;
    }

    public void setEjbSolicitacao(SolicitacaoFacade ejbSolicitacao) {
        this.ejbSolicitacao = ejbSolicitacao;
    }

    public LocalFacade getEjbLocal() {
        return ejbLocal;
    }

    public void setEjbLocal(LocalFacade ejbLocal) {
        this.ejbLocal = ejbLocal;
    }
    public PalestrasFacade getEjbPalestras() {
        return ejbPalestras;
    }

    public void setEjbPalestras(PalestrasFacade ejbPalestras) {
        this.ejbPalestras = ejbPalestras;
    }

    public AtividadeTbrFacade getEjbAtividadeTbr() {
        return ejbAtividadeTbr;
    }

    public void setEjbAtividadeTbr(AtividadeTbrFacade ejbAtividadeTbr) {
        this.ejbAtividadeTbr = ejbAtividadeTbr;
    }      

    public List<Palestras> getPalestras() {
        return palestras;
    }

    public void setPalestras(List<Palestras> palestras) {
        this.palestras = palestras;
    }

    public Palestras getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestras palestra) {
        this.palestra = palestra;
    }

    public boolean isEnviarCert() {
        return enviarCert;
    }

    public void setEnviarCert(boolean enviarCert) {
        this.enviarCert = enviarCert;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Date> getMoreDates() {
        return moreDates;
    }

    public void setMoreDates(List<Date> moreDates) {
        this.moreDates = moreDates;
    }
    
    //GET LIST OF modalidades FROM DATABASE
    public List<Modalidade> getModalidades(){
        return getEjbModalidade().findAll();
    }
    
    //GET LIST OF locais FROM DATABASE
    public List<Local> getLocais(){
        return getEjbLocal().findAll();
    }
    
    //GET LIST OF institucoes FROM DATABASE
    public List<Instituicao> getInstituicoes(){
        return getEjbInstituicao().findAll();
    }
    
    //GET LIST OF tipos FROM DATABASE BY A SELECTED modalidade
    public void setTipoByModalidadeNoEvent(Modalidade mod){
        Modalidade modal = mod;
        List<Integer> ids = TipoModalidadeRelationship.chooseModalidade(modal);
        setTipos(new ArrayList<Tipo>());
        for(Integer id : ids){
            tipos.add(getEjbTipo().findById(id));
        }
    }
    
    public void setTipoByModalidade(ValueChangeEvent event){
        Modalidade modal = (Modalidade) event.getNewValue();
        setTipoByModalidadeNoEvent(modal);
    }
    
    
    //GET LIST OF funcionarios FROM DATABASE FROM PARTICULAR instituicao
    public void setFuncionariosByInstituicao(){   
        //Instituicao inst = (Instituicao) event.getNewValue();
        
        if(instituicaoId != null)
        {
            Instituicao inst = getEjbInstituicao().findById(instituicaoId);
            setFuncionarios(getEjbFuncionario().findByInstituicao(inst));
            if(getFuncionarios().isEmpty()){
                Pessoa p = new Pessoa(0, ResourceBundle.getBundle("/resources/ValidationMessages").getString("NoFuncionarioFound"), null, null, null, null, null);
                Funcionario f = new Funcionario();
                f.setPessoa(p);
                funcionarios.add(f);
            }
        }
    }
    
    //GET LAST DESCRIPTION OF CONNECTIONS
    public void setConexaoByFuncionario(ValueChangeEvent event){
        Funcionario funcionario = (Funcionario) event.getNewValue();
        Conexao con = getEjbConexao().getLastDescription(funcionario);
        if(con!=null)
            setConexao(con);
    }
    
    //SET ATTRIBUTES TO DEFAULT AND RETURN PATH TO THE FORM
    public String prepareCreate(){
        setQtdPresentes(0);
        setAtividade(new Atividade());
        setAtividadeEdicaoId(0);
        setAtvidadesRelacionadas(new ArrayList<Atividade>());
        setAtividadeTbr(new AtividadeTbr());
        setConexao(new Conexao());
        conexoes = new ArrayList();
        data = null;
        setPalestras(new ArrayList<Palestras>());
        setMoreDates(new ArrayList<Date>());
        setIsAtividadeTBR(false);
        return ResourceBundle.getBundle("/resources/BundlePaths").getString("Create_Ativdiade_Form"); 
    }
    
    //GET NEXT PATH FORM
    public String nextForm(){
        String path = guardarAtividade();        
        if(isVideo() || isWeb() || isVideoEditing()){
            if(isVideoEditing())
            {
                if(getEjbAtividade().findById(atividadeEdicaoId) == null)
                {
                    FacesContext.getCurrentInstance().addMessage("formAtividade:tema_central", new FacesMessage("Não existe atividade relacionada ao ID "+atividadeEdicaoId+" informado"));
                    return null;
                }
            }
            setConexao(new Conexao());
            setEdicao(new EdicaoVideo());
            return path;
            
        }
        
        return persist();//ResourceBundle.getBundle("/resources/BundlePaths").getString("Index");
    }
    
    //SAVE atividade IN THE SESSION
    public String guardarAtividade(){
        try {
            setCadastro(new CadastroAtividade());
            getCadastro().guardar(getAtividade()); 
            guardarSolicitacao();
            
            //JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/BundleAtividade").getString("Atividade_Saved"), "formAtividade");
            if(isVideoEditing())
                return ResourceBundle.getBundle("/resources/BundlePaths").getString("Create_EdicaoDeVideo_Form");
            else
                return ResourceBundle.getBundle("/resources/BundlePaths").getString("Create_Conexao_Form");
        }
        catch(Exception e){
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/BundleAtividade").getString("ErroDeNegocio"), "formAtividade");
            return null;
        }
    }
    
    //SAVE solicitacao in the session
    public void guardarSolicitacao(){
        FacesContext context = FacesContext.getCurrentInstance();
        LoginController log = (LoginController) context.getExternalContext().getSessionMap().get("loginController");
        Usuario user = log.getUsuario();
        solicitacao = new Solicitacao();
        solicitacao.setAtividade(getAtividade());
        solicitacao.setQtdLugares(getQtdPresentes());
        solicitacao.setUsuario(user);
        solicitacao.setResponsavel(atvResponsavel);
        solicitacao.setData(new Date());        
    }
    
    //SAVE atividade and edicao de video details IN DATABASE
    public String persistAtividadeAndEdicaoVideo()
    {
        String path;
        if(getEjbAtividade().findById(atividadeEdicaoId) != null)
        {
            try{
                path = persist();
                edicao.setAtividade(getAtividade());
                ejbEdicaoVideo.create(edicao);
                return path;
            }
            catch(Exception e)
            {
                ejbAtividade.remove(getAtividade());
                ejbEdicaoVideo.remove(edicao);
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/BundleAtividade").getString("Atividade_Error"), "idAtividadeRelacionada");
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("formEdicaoVideo:idAtividadeRelacionada", new FacesMessage("Não existe atividade relacionada ao ID informado"));
            //JsfUtil.addErrorMessage("Não existe atividade relacionada ao ID informado", "idAtividadeRelacionada");
        }
        
        return null;
    }
    
    public void findAtividadesRelacionadas()
    {
        atvidadesRelacionadas = new ArrayList();
        
        Atividade main = ejbAtividade.findById(atividadeEdicaoId);
        if(main == null)
            return;
        atvidadesRelacionadas.add(main);
        
        for(Palestras pal : ejbPalestras.findByAtividade(main))
        {
            Atividade aux = new Atividade();
            aux.setModerador(pal.getPessoa());
            aux.setTema(pal.getTema());
            atvidadesRelacionadas.add(aux);
        }
    }
    
    public void onRowSelect(SelectEvent event) {
        this.atividade  = ((Atividade)event.getObject());
    }
    
    //SAVE atividade IN DATABASE
    public String persist(){
        try {
            moreDates.add(getAtividade().getDt());
            
            for(Date d: moreDates){
                Atividade atv = getAtividade();
                atv.setDt(d);
            
                getEjbAtividade().create(atv);
                sendCert(atv);
                
                if(isAtividadeTBR){
                    atividadeTbr.setAtividade(atv);
                    getEjbAtividadeTbr().create(atividadeTbr);
                }
                
                try {
                    if(isVideo() || isWeb()) 
                    {
                        persistConexao(atv);
                    }
                    if(isMesaRedonda())
                    {
                        try
                        {
                            persistPalestras(atv);
                        }
                        catch(Exception e)
                        {
                            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/BundleAtividade").getString("Atividade_Error"), "formAtividade");
                        }
                    }
                    getEjbSolicitacao().create(getSolicitacao());
                    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/BundleAtividade").getString("Atividade_Saved"), "formAtividade");                    
                }  
                catch(Exception e){
                    getEjbAtividade().remove(getAtividade());
                    getEjbAtividadeTbr().remove(atividadeTbr);
                    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/BundleAtividade").getString("Conexao_Error"), "formConexao");
                }
                
            }          
            
            return ResourceBundle.getBundle("/resources/BundlePaths").getString("View_Solicitacao");
            
        }
        catch(Exception e){
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/BundleAtividade").getString("Atividade_Error"), "formAtividade");
        }
        
        return null;
    }
    
    //PERSIST conexao
    private void persistConexao(Atividade atv)
    {
        for(Conexao c : conexoes )
        {
            c.setAtividade(atv);
            getEjbConexao().create(c);
        }
        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/BundleAtividade").getString("Conexao_Saved"), "formConexao");
    }
    
    //PREPARE Atividade Edit
    public String prepareEditAtividade(){
        String path = "/forms/view_edit_atividade";
        atividadeTbr = ejbAtividadeTbr.findByAtividade(current);
        solicitacao = ejbSolicitacao.findByAtividade(current);
        conexao = ejbConexao.findByAtividade(current);
        if(solicitacao != null)
            atvResponsavel = solicitacao.getResponsavel();
        if(atividadeTbr != null)
            isAtividadeTBR = true;
        else
        {
            isAtividadeTBR = false;
            atividadeTbr = new AtividadeTbr();
        }
        palestras = ejbPalestras.findByAtividade(current);
        return path;
    }
    
    //PREPARE Atividade Edit
    public String prepareEditAtividade(Atividade atv){
        String path = "/forms/view_edit_atividade";
        current = atv;
        atividadeTbr = ejbAtividadeTbr.findByAtividade(current);
        solicitacao = ejbSolicitacao.findByAtividade(current);
        conexao = ejbConexao.findByAtividade(current);
        if(solicitacao != null)
            atvResponsavel = solicitacao.getResponsavel();
        if(atividadeTbr != null)
            isAtividadeTBR = true;
        else
        {
            isAtividadeTBR = false;
            atividadeTbr = new AtividadeTbr();
        }
        palestras = ejbPalestras.findByAtividade(current);
        return path;
    }
    
    //EDIT Atividade
    public String updateAtividade()
    {
        try{
            ejbAtividade.edit(current);
            if(isAtividadeTBR != false)
            {
                atividadeTbr.setAtividade(current);
                ejbAtividadeTbr.edit(atividadeTbr);
            }
            if(solicitacao != null){
                solicitacao.setResponsavel(atvResponsavel);
                ejbSolicitacao.edit(solicitacao);     
            }
            if(palestras != null)
                for(Palestras p : palestras)
                {
                    p.setAtividade(current);
                    ejbPalestras.edit(p);
                }
            JsfUtil.addSuccessMessage("Atividade atualizada com sucesso!");
        }
        catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
        return "/atividades/view_atividade";
    }
    
    
    //prepare EDIT CONEXAO
    public String prepareEditConexao(Conexao c)
    {
        currentCon = c;
        instituicaoId = currentCon.getResponsavel().getInstituicao().getId();
        current = currentCon.getAtividade();
        return "/forms/view_edit_conexao";
    }
    
    //EDIT conexao
    public String updateConexao()
    {
        try{
            ejbConexao.edit(currentCon);
        }
        catch(Exception e)
        {
            System.out.println("Erro de update na conexao");
        }
        return "/atividades/view_atividade";
    }
    
    public String prepareEditConexaoList()
    {   
        conexao = new Conexao();
        conexoes = ejbConexao.findListByAtividade(current);
        setAtividade(current);
        return "/forms/view_edit_conexao_list";
    }
    
    public String updateConexaoList()
    {
        for(Conexao c : conexoes)
        {
            if(ejbConexao.find(c.getId()) == null)
            {
                c.setId(null);
                c.setAtividade(current);
                ejbConexao.create(c);
            }
        }
        return "/atividades/view_atividade";   
    }
    
    //TESTING IF atividade IS VIDEOCONFERENCE
    public boolean isVideo(){
        return getAtividade().getModalidade().getId() == 1;
    }
    
    public boolean isCurrentVideo()
    {
        return current.getModalidade().getId() == 1;
    }
    
    //TESTING IF atividade IS WEBCONFERENCE
    public boolean isWeb(){
        return getAtividade().getModalidade().getId() == 2;
    }
    
    //TESTING IF atividade IS WEBCONFERENCE
    public boolean isVideoEditing(){
        return getAtividade().getTipo().getId() == 23;
    }
    
    public boolean isCurrentWeb()
    {
        return current.getModalidade().getId() == 2;
    }
    
    
    //TESTING IF atividade CONTAINS MORE THAN ONE SUBJECT
    public boolean isMesaRedonda(){
        return isThereManySubjects;
    }
    
    public boolean isPendente(Atividade atv)
    {
        current = atv;
        Date today = new Date();
        boolean pendente = false;
        if(!DateUtils.ingnoreTime(current.getDt()).before(DateUtils.ingnoreTime(today))){
            if (DateUtils.ingnoreTime(current.getDt()).equals(DateUtils.ingnoreTime(today))){
                if(DateUtils.ingnoreDate(today, today).before(DateUtils.ingnoreDate(current.getHrTermino(), today))){
                    pendente = true;
                }
            }
            else if(DateUtils.ingnoreDate(current.getHrTermino(), today).after(DateUtils.ingnoreDate(today, today))){
                pendente = true;
            }
        }
        return current.getStatus().getId() == 2  && pendente;
    }
    
    public boolean conexaoExistente()
    {
        if(getConexao().getAtividade() == null)
            return false;
        else
            return true;
    }
    
    //Saving the actual palestra object to the list
    public void guardarPalestra()
    {   
        if(palestra.getTema() != null && palestra.getPessoa() != null)
        {
            palestra.setId(Integer.MAX_VALUE - palestras.size());
            palestras.add(palestra);
            palestra = new Palestras();
        }        
    }
    
    //Saving the current date to the list
    public void guardarData()
    {   
        System.out.println("Saving data .. " + data);
        moreDates.add(data);
        System.out.println("moreDates [");
        for(Date d : moreDates){
            System.out.println(d + ";");
        }
        System.out.println("]");
    }
    
    public void removePalestra(Palestras p)
    {
        //System.out.println(p);
        try{
            ejbPalestras.remove(p);
        }
        catch(Exception e)
        {
            System.out.println("Remove failed");
        }
        palestras.remove(p);
        palestra = new Palestras();
    }
    
    public void removeData(Date d)
    {
        moreDates.remove(d);
    }
    
    //Adiciona conexao à lista de conexoes
    public void guardarPoloRemoto()
    {   
        System.out.println("vem, doido");
        if(conexao != null)
        {
            System.out.println("Conexao existente");
            conexao.setId(Integer.MAX_VALUE - conexoes.size());
            conexoes.add(conexao);
            conexao = new Conexao();
        }
    }
    
    public void removerPoloRemoto(Conexao c)
    {
       //System.out.println(p);
        try{
            ejbConexao.remove(c);
        }
        catch(Exception e)
        {
            System.out.println("Remove failed");
        }
        conexoes.remove(c);
       
        conexao = new Conexao();
    }
    
    private void persistPalestras(Atividade atv)
    {        
        for(Palestras palestra : palestras)
        {
            palestra.setId(null);
            palestra.setAtividade(atv);
            getEjbPalestras().create(palestra);
        }
    }
    
    public List<Palestras> findPalestras(Atividade atv)
    {
        return getEjbPalestras().findByAtividade(atv);
    }
    
    public void setSelectedData(){
        String idKeyString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAtividade");
        if(idKeyString!=null){
            int idKey = Integer.parseInt(idKeyString);
            this.current = getEjbAtividade().findById(idKey);
            //this.currentCon = getEjbConexao().findByAtividade(this.current);
            this.conexoes = getEjbConexao().findListByAtividade(this.current);   
            this.solicitacao = getEjbSolicitacao().findByAtividade(current);
        }
    }
    
    public List<AtividadeTbr> getAtividadesTbr(){
        return getEjbAtividadeTbr().findAll();
    }
    
    public DefaultStreamedContent getTermoImgVozPDF(Atividade atv){
        return getTermoImgVozPDF(null, atv);
    }
    
    public DefaultStreamedContent getTermoImgVozPDF(Pessoa pessoa, Atividade atv)
    {
        try {
            
            //pdfContent = new Streamed
            ByteArrayOutputStream output = new ByteArrayOutputStream();  
            output.reset();
            Font fontHeader = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontLine = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font fontLineBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            
            //FileOutputStream file = new FileOutputStream("template.pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, output);  
            document.open(); 
            
            //Writing document
            String contextPath =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img/header.png");
            
            Image image1 = Image.getInstance(contextPath);
            image1.scaleToFit(document.getPageSize());
            image1.setAlignment(Element.ALIGN_CENTER);
            
            document.add(image1);
            document.add( Chunk.NEWLINE );
            Paragraph headerTitle =  new Paragraph("TERMO DE AUTORIZAÇÃO DE USO DE IMAGEM E VOZ PARA ATIVIDADE Nº " + atv.getId(), fontHeader);
            headerTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(headerTitle);
            document.add( new Paragraph());
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            
            Paragraph p = new Paragraph("Pelo presente termo particular de autorização de uso de imagem e voz eu,", fontLine);
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p);
            
            if(pessoa == null)
            {
            
                p = new Paragraph("_________________________________________________________________________", fontLine);
                p.setAlignment(Element.ALIGN_CENTER);
                document.add(p);

                p = new Paragraph("Nacionalidade: __________________ "
                        + "Profissão:________________ CPF nº: _______________ "
                        + "Residente e domiciliado na", fontLine);
                p.setAlignment(Element.ALIGN_LEFT);
                document.add(p);
            }
            else
            {
                ProfGeral prof = ejbProfGeral.getByPessoa(pessoa);
                p = new Paragraph(pessoa.getNome() + " " + pessoa.getSobrenome(), fontLine);
                p.add(new Phrase(", CPF nº: " + pessoa.getCpf(), fontLine));
                p.add(new Phrase(", Nacionalidade: BRASILEIRO(A), ", fontLine));
                if(prof != null)
                {
                    p.add(new Phrase("Profissão: " + prof.getCbo().getNome().trim(), fontLine));
                }
                else
                {
                    p.add(new Phrase("Profissão: ________________", fontLine));
                }
                p.add(new Phrase(", Residente e domiciliado na", fontLine));
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(p);
            }
            
            p = new Paragraph("_________________________________________________________________________", fontLine);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            
            p = new Paragraph("denominado doravante ");
            p.add(new Phrase("AUTORIZANTE", fontLineBold));
            p.add(new Phrase(", neste ato, e para todos os fins em direito admitidos, autorizo expressamente ao ", fontLine));
            p.add(new Phrase("MINISTÉRIO DA SAÚDE/UNIVERSIDADE ABERTA DO SISTEMA ÚNICO DE SAÚDE – UNA-SUS", fontLineBold));
            p.add(new Phrase(", situado na Esplanada dos Ministérios, Bloco “G”, Edifício-anexo, 2º andar, "
                            + "Brasília – DF, inscrito no CNPJ sob nº 00.530.493/0001-71, e à ", fontLine));
            p.add(new Phrase("NÚCLEO DE TELESSAÚDE DO HOSPITAL UNIVERSITÁRIO DA UNIVERSIDADE FEDERAL DO MARANHAO – (NTS-HUUFMA)", fontLineBold));
            p.add(new Phrase(", situada na ", fontLine));
            p.add(new Phrase("rua Barão de Itapry 227, Cento, São Luís (MA)", fontLineBold));
            p.add(new Phrase(", inscrita no CNPJ sob nº  06.279.103/0001-19, doravante denominadas ", fontLine));
            p.add(new Phrase("AUTORIZADAS, a captação, uso, guarda e exibição/execução", fontLineBold));
            p.add(new Phrase(" da minha imagem, em caráter ", fontLine));
            p.add(new Phrase("definitivo e gratuito, na filmagem/gravação/filme, realizada para ATIVIDADES de "
                            + "Tele-educação do Programa Telessaúde Brasil Redes", fontLineBold));
            p.add(new Phrase(", produzido(s) pelo NTS-HUUFMA, para fins exclusivamente educacionais, podendo ser utilizadas a qualquer tempo pelas ", fontLine));
            p.add(new Phrase("AUTORIZADAS.", fontLineBold));
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph("A presente autorização abrange todas as formas de uso e modalidades de utilização "
                            + "permitidas, conhecidas ou que venham a ser conhecidas, incluindo, mas não se "
                            + "limitando, as seguintes situações:");
            p.setFirstLineIndent(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("a) ", fontLineBold));
            p.add(new Phrase("as imagens e a voz poderão ser usadas através de todos e quaisquer meios de "
                            + "comunicação ao público ficando, desde já, autorizadas a serem disponibilizadas "
                            + "(inclusive para download e em repositórios digitais) e/ou veiculadas/executadas "
                            + "em local aberto ao público na internet (incluindo uso em cursos EAD), intranet, "
                            + "rádio, TV aberta e/ou fechada ou cinema, com todas suas ferramentas e tecnologias "
                            + "existentes e que venham a existir, por todo território nacional e internacional,"
                            + " no todo ou em parte;", fontLine));
            p.setIndentationLeft(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("b) ", fontLineBold));
            p.add(new Phrase("também fica autorizado, exemplificativamente, o uso das imagens e voz em "
                            + "apresentações públicas em vídeo e/ou áudio, publicações e divulgações acadêmicas, "
                            + "exibições/execuções em festivais e premiações nacionais e internacionais;", fontLine));
            p.setIndentationLeft(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("c) ", fontLineBold));
            p.add(new Phrase("a presente autorização também inclui a possibilidade de distribuição ao "
                            + "público das imagens e voz, exemplificativamente, em DVDs, CDs, Blu-rays, Pen Drives, "
                            + "Discos Virtuais ou quaisquer outras mídias similares que vierem a existir, em todo o "
                            + "território nacional e internacional, no todo ou em parte;", fontLine));
            p.setIndentationLeft(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("d) ", fontLineBold));
            p.add(new Phrase("fica autorizada a reprodução parcial ou integral e impressão, em qualquer tipo de"
                            + " material, incluindo folhetos, anúncios, material promocional, banners, brochuras, intranet, "
                            + "mídia escrita ou eletrônica, painéis ou outras formas similares que envolvam ações de "
                            + "merchandising e divulgação do Projeto UNA-SUS em todo o território nacional e internacional, "
                            + "no todo ou em parte;", fontLine));
            p.setIndentationLeft(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph("As ");
            p.add(new Phrase("AUTORIZADAS", fontLineBold));
            p.add(new Phrase(", desde já, podem executar a edição e montagem de todos os materiais dos quais eu "
                    + "participo (filmagens, fotos, gravações de áudio etc.), conduzindo as reproduções que "
                    + "entenderem necessárias (sem limitação), bem como podendo arquivá-los em quaisquer meios "
                    + "disponíveis para tanto.", fontLine));
            p.setFirstLineIndent(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph("O presente instrumento particular de autorização é celebrado em caráter ");
            p.add(new Phrase("DEFINITIVO, GRATUITO, IRRETRATÁVEL e IRREVOGÁVEL", fontLineBold));
            p.add(new Phrase(", obrigando as partes por si e por seus sucessores a qualquer título, a "
                    + "respeitarem integralmente os termos e condições estipuladas no presente instrumento.", fontLine));
            p.setFirstLineIndent(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            
            p = new Paragraph("Por esta ser a expressão da minha vontade declaro que autorizo o uso acima "
                    + "descrito sem que nada haja a ser reclamado a título de direitos conexos à imagem e "
                    + "voz ou a qualquer outro, e assino a presente autorização em 02 vias de igual teor e forma. ", fontLine);
            p.setFirstLineIndent(30);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(p);
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            p = new Paragraph("São Luís (MA), ______ de ________________ de ______.", fontLine);
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p);
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );

            p = new Paragraph("______________________________________");
            p.add(new Phrase("\nAUTORIZANTE", fontLineBold));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            
            document.close();
            output.flush();
            output.close();
            
            return new DefaultStreamedContent(new ByteArrayInputStream(output.toByteArray()), "application/pdf", "TERMO_AUTORIZACAO" +".pdf");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
    }
    
    public DefaultStreamedContent getPdfDocument(){
        return getPdfDocument(null);
    }
    
    //Building pdf document
    public DefaultStreamedContent getPdfDocument(Atividade atv)
    {
        try {
            if(atv!=null)
                current = atv;
                        
            solicitacao = ejbSolicitacao.findByAtividade(current);
            conexao = ejbConexao.findByAtividade(current);
            conexoes = ejbConexao.findListByAtividade(current);
            palestras = ejbPalestras.findByAtividade(current);
            ata = ejbAta.findByAtividade(current);
            atividadeTbr = ejbAtividadeTbr.findByAtividade(current);
            edicao = null;
            if(current.getTipo().getId()  == 23)
                edicao = ejbEdicaoVideo.findByAtividade(current);
            //pdfContent = new Streamed
            ByteArrayOutputStream output = new ByteArrayOutputStream();  
            output.reset();
            Font fontHeader = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontLine = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font fontLineBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            
            //FileOutputStream file = new FileOutputStream("template.pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, output);  
            document.open(); 
            
            //Writing document
            String contextPath =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img/header.png");
            
            Image image1 = Image.getInstance(contextPath);
            image1.scaleToFit(document.getPageSize());
            image1.setAlignment(Element.ALIGN_CENTER);
            
            document.add(image1);
            document.add( Chunk.NEWLINE );
            Paragraph headerTitle =  new Paragraph(chooseHeaderDocumentTitle(current), fontHeader);
            headerTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(headerTitle);
            document.add( new Paragraph());
            document.add( Chunk.NEWLINE );
            
            Chunk preface = new Chunk("GERAL", fontHeader);
            document.add(preface);  
            
            if(solicitacao != null)
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(solicitacao.getData());
                int year = cal.get(Calendar.YEAR);
                int month = 1 + cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                
                cal.setTime(solicitacao.getData());
                
                int hour = cal.get(Calendar.HOUR_OF_DAY );
                int min = cal.get(Calendar.MINUTE);
                
                String dateStr = day+"/"+month+"/"+year + " " + hour+":"+((min < 10)? "0" : "")+min;
                Paragraph dataAndHour = new Paragraph(dateStr, fontLine);
                document.add(dataAndHour);
            }
            
            Paragraph p = new Paragraph();
            p.add(new Phrase("Modalidade: ", fontLineBold));
            p.add(new Chunk(current.getModalidade().getDescricao(), fontLine));
            document.add(p);
            
            if(solicitacao != null)           
            {
                document.add( Chunk.NEWLINE );
                Pessoa solicitante = solicitacao.getResponsavel();
                document.add(new Chunk("DADOS DO SOLICITANTE", fontHeader));
                p = new Paragraph();
                p.add(new Phrase("Nome: ", fontLineBold));
                p.add(new Chunk(solicitante.getNome() +" "+solicitante.getSobrenome(), fontLine));
                document.add(p);
                
                
                
//                p = new Paragraph();
//                p.add(new Phrase("Instituição: ", fontLineBold));
//                p.add(new Chunk(solicitacao.getUsuario().getFuncionario().getInstituicao().getDescricao(), fontLine));
//                document.add(p);
                
//                p = new Paragraph();
//                p.add(new Phrase("Setor: ", fontLineBold));
//                p.add(new Chunk(solicitacao.getUsuario().getFuncionario().getSetor(), fontLine));
//                document.add(p);
                
                p = new Paragraph();
                p.add(new Phrase("Celular: ", fontLineBold));
                p.add(new Chunk(solicitante.getCelular(), fontLine));
//                p.add(new Phrase("       Fone do Setor: ", fontLineBold));
//                p.add(new Phrase(solicitacao.getUsuario().getFuncionario().getRamal(), fontLine));
                document.add(p);
                
                p = new Paragraph();
                p.add(new Phrase("E-mail: ", fontLineBold));
                p.add(new Chunk(solicitante.getEmail(), fontLine));
                document.add(p);
                
                
                document.add( Chunk.NEWLINE );
                p = new Paragraph();
                document.add(new Chunk("RESPONSÁVEL PELO AGENDAMENTO", fontHeader));
                p = new Paragraph();
                p.add(new Phrase("Nome: ", fontLineBold));
                Pessoa tecnico = solicitacao.getUsuario().getFuncionario().getPessoa(); 
                p.add(new Chunk(tecnico.getNome() + " " + tecnico.getSobrenome(), fontLine));
                document.add(p);
                
            }
            
            
            if(!conexoes.isEmpty())
            {
                document.add( Chunk.NEWLINE );
                document.add(new Chunk("INSTITUIÇÕES REMOTAS", fontHeader));
                
                for(Conexao c : conexoes)
                {
                    p = new Paragraph();
                    p.add(new Phrase("Instituição: ", fontLineBold));
                    Instituicao tmp = c.getResponsavel().getInstituicao();
                    p.add(new Chunk(tmp.getSigla()+" - "+ tmp.getDescricao(), fontLine));
                    document.add(p);
                    p = new Paragraph();
                    p.add(new Phrase("Responsável: ", fontLineBold));
                    p.add(new Chunk(c.getResponsavel().getPessoa().getNome(), fontLine));
                    p.add(new Chunk(" "+c.getResponsavel().getPessoa().getSobrenome(), fontLine));
                    p.add(new Chunk("    Telefone: ", fontLineBold));
                    p.add(new Chunk(c.getResponsavel().getRamal() +" / " + c.getResponsavel().getPessoa().getCelular(), fontLine));
                    document.add(p);
                    p = new Paragraph();
                    p.add(new Phrase("Conexão: ", fontLineBold));
                    p.add(new Chunk(c.getDescricao(), fontLine));
                    document.add(p);
                    if(c.getSala() != null)
                    {
                        p = new Paragraph();
                        p.add(new Phrase("Sala: ", fontLineBold));
                        p.add(new Chunk(c.getSala(), fontLine));
                        document.add(p);
                    }
                }
            }
            
            document.add( Chunk.NEWLINE );
            document.add(new Chunk("DADOS DA ATIVIDADE", fontHeader));
            p = new Paragraph();
            p.add(new Phrase("Tipo: ", fontLineBold));
            p.add(new Chunk(current.getTipo().getDescricao(), fontLine));
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("Tema: ", fontLineBold));
            p.add(new Chunk(current.getTema(), fontLine));
            document.add(p);
            
            p = new Paragraph();
            p.add(new Phrase("Descrição: ", fontLineBold));
            p.add(new Chunk(current.getDescricao(), fontLine));
            document.add(p);
            
            if(atividadeTbr != null)
            {
                p = new Paragraph();
                p.add(new Phrase("Finalidade: ", fontLineBold));
                p.add(new Chunk(atividadeTbr.getFinalidade(), fontLine));
                document.add(p);
            }
            
            if(current.getModerador() != null)
            {
                p = new Paragraph();
                p.add(new Phrase("Palestrante / Moderador: ", fontLineBold));
                p.add(new Chunk(current.getModerador().getNome() +" "+current.getModerador().getSobrenome(), fontLine));
                document.add(p);
            }
            
            
            if(solicitacao != null)
            {
                p = new Paragraph();
                p.add(new Phrase("Nº de participantes esperados: ", fontLineBold));
                p.add(new Chunk(""+solicitacao.getQtdLugares(), fontLine));
                document.add(p);
            }
            
            if(ata != null)
            {
                document.add( Chunk.NEWLINE );
                document.add(new Chunk("ATA DA ATIVIDADE", fontHeader));
                p = new Paragraph();
                p.add(new Phrase("Nº de presentes: ", fontLineBold));
                p.add(new Chunk(""+ata.getQtdPresentes(), fontLine));
                document.add(p);
                p = new Paragraph();
                p.add(new Phrase("Nº de pontos ", fontLineBold));
                p.add(new Chunk(""+ata.getQtdPontos(), fontLine));
                document.add(p);
                p = new Paragraph();
                p.add(new Phrase("Informações adicionais: ", fontLineBold));
                p.add(new Chunk(""+ata.getMaisInfo(), fontLine));
                document.add(p);
            }
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDt());
            int year = cal.get(Calendar.YEAR);
            int month = 1 + cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(current.getHrInicio());
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);            
            cal.setTime(current.getHrTermino());
            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
            int min2 = cal.get(Calendar.MINUTE);
            p = new Paragraph();
            p.add(new Chunk(day+"/"+month+"/"+year+"  "+hour+":"+((min < 10)? "0" : "")+min + " às " + hour2+":"+((min2 < 10)? "0" : "")+min2, fontLine));
            document.add(p);
            
            List<ParticipacaoInstituicao> insts = ejbPI.findByAtividade(current);
            
            if(!insts.isEmpty() && current.getStatus().getId() == 4)
            {
                Font fontInst = new Font(Font.FontFamily.TIMES_ROMAN, 12);
                document.add( Chunk.NEWLINE );
                document.add(new Chunk("INSTITUIÇÕES PARTICIPANTES", fontHeader));
                int j = 1;
                for(ParticipacaoInstituicao i : insts)
                {
                    Paragraph pi = new Paragraph(j+": "+ i.getInstituicao().getDescricao() +" - "+ i.getInstituicao().getSigla(),
                                                fontInst);
                    document.add(pi);
                    j++;
                }
            }
            
            document.close();
            output.flush();
            output.close();
            
            return new DefaultStreamedContent(new ByteArrayInputStream(output.toByteArray()), "application/pdf", "ID_" + current.getId()+"_COMPROVANTE" +".pdf");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null; 
    }
    
    
    public DefaultStreamedContent getPdfTableForName(){
        return getPdfTableForName(null);
    }
    
    public DefaultStreamedContent getPdfTableForName(Atividade atv)
    {
        try{
            
            if(atv!=null)
                current = atv;
            
            solicitacao = ejbSolicitacao.findByAtividade(current);
            conexao = ejbConexao.findByAtividade(current);
            conexoes = ejbConexao.findListByAtividade(current);
            palestras = ejbPalestras.findByAtividade(current);
            
            //pdfContent = new Streamed
            ByteArrayOutputStream output = new ByteArrayOutputStream();  
            output.reset();
            Font fontHeader = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontLine = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font fontLineBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

            //FileOutputStream file = new FileOutputStream("template.pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, output);  
            document.open(); 
            
            //Writing document
            String contextPath =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img/header.png");
            
            Image image1 = Image.getInstance(contextPath);
            image1.scaleToFit(document.getPageSize());
            image1.setAlignment(Element.ALIGN_CENTER);
            document.add(image1);
            Paragraph headerTitle =  new Paragraph("Ata de Atividade", fontHeader);
            headerTitle.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            document.add(headerTitle);
            
            //
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDt());
            int year = cal.get(Calendar.YEAR);
            int month = 1 + cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
            cal.setTime(current.getHrInicio());
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            cal.setTime(current.getHrTermino());
            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
            int min2 = cal.get(Calendar.MINUTE);
            Paragraph p = new Paragraph();
            p.add(new Chunk(day+"/"+month+"/"+year+"  "+hour+":"+((min < 10)? "0" : "")+min + " às " + hour2+":"+((min2 < 10)? "0" : "")+min2, fontLine));
            document.add(p);
            
            //
            p = new Paragraph();
            p.add(new Chunk(current.getModalidade().getDescricao(), fontLine));
            p.add(new Chunk(" - "));
            p.add(new Chunk(current.getTipo().getDescricao(), fontLine));
            document.add(p);
            
            p = new Paragraph();
            p.add(new Chunk(current.getTema(), fontLine));
            document.add(p);
            if(!conexoes.isEmpty())
            {
                for(Conexao c : conexoes)
                {
                    p = new Paragraph();
                    p.add(new Phrase("\nInstituição Remota: ", fontLineBold));
                    p.add(new Chunk(c.getResponsavel().getInstituicao().getSigla(), fontLine));
                    p.add(new Phrase(" Conexão: ", fontLineBold));
                    p.add(new Chunk(c.getDescricao(), fontLine));
                    if(c.getSala() != null)
                    {
                        p.add(new Phrase(" - Sala: ", fontLineBold));
                        p.add(new Chunk(c.getSala(), fontLine));
                    }
                    Pessoa resp = c.getResponsavel().getPessoa();
                    p.add(new Phrase(" Responsável: ", fontLineBold));
                    p.add(new Phrase(resp.getNome().trim() + " " + resp.getSobrenome().trim() + " : " + c.getResponsavel().getRamal(), fontLine));
                    document.add(p);
                }
            }
            
            p = new Paragraph();
            p.add(new Phrase("Local: ", fontLineBold));
            p.add(new Chunk(current.getLocal().getDescricao(), fontLine));
            document.add(new Phrase("Instituições participantes: ", fontLineBold));
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            
            p = new Paragraph();
            p.add(new Phrase("Senha para registro de presença: ", fontLineBold));
            p.add(new Chunk(current.getId().toString(), fontLine));
            document.add(p);
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            p = new Paragraph();
            p.add(new Phrase("Participantes", fontLineBold));
            
            document.add(p);
            document.add( Chunk.NEWLINE );
            
            PdfPTable table = new PdfPTable(6); // 3 columns.
            table.setWidthPercentage(100);
            PdfPCell cellTitle = new PdfPCell(new Paragraph("Nome"));
            cellTitle.setColspan(3);
            cellTitle.setFixedHeight(20f);
            
            PdfPCell cellTitle2 = new PdfPCell(new Paragraph("Email"));
            cellTitle2.setColspan(3);
            cellTitle2.setFixedHeight(20f);
            
            table.addCell(cellTitle);
            table.addCell(cellTitle2);
            
            for(int i = 1; i <51; i++)
            {
                PdfPCell cell1 = new PdfPCell(new Paragraph(""+i));
                cell1.setColspan(3);
                cell1.setFixedHeight(30f);
                
                PdfPCell cell2 = new PdfPCell();
                cell2.setColspan(3);
                cell2.setFixedHeight(30f);
                
                table.addCell(cell1);
                table.addCell(cell2);
            }
            
            document.add(table);
            
            
            document.close();
            output.flush();
            output.close();
            return new DefaultStreamedContent(new ByteArrayInputStream(output.toByteArray()), "application/pdf", "ID_" + current.getId() +"_ATA"+".pdf");  
        }
        catch (Exception e) {  
            e.printStackTrace(); 
        }
        return null;
    }
    
    
    
    public int getQtdParticipantes(List<ParticipacaoPessoa> list) { 
        int qtdPessoas = 0;
        if(list!=null)
            qtdPessoas = list.size();
        
        return qtdPessoas;
    }
    
    public int getQtdPolos(List<ParticipacaoPessoa> list) {
        List<String> ips = new ArrayList<>();
        boolean novo = true;
        for(ParticipacaoPessoa p : list){
            System.out.println("Procurando ip da participacao de ..." + p.getPessoa().getNome());
            ParticipacaoIp partIp = ejbParticipacaoIP.findByParticipacao(p);
            for(String i : ips){
                if(partIp.getIp().equalsIgnoreCase(i))
                    novo = false;
            }
            if(novo&&partIp!=null)
                ips.add(partIp.getIp());
        }
        return ips.size();
    }
    
    public DefaultStreamedContent getPdfListaDePresentes(){
        return getPdfListaDePresentes(null);
    }
    
    public DefaultStreamedContent getPdfListaDePresentes(Atividade atv)
    {
        try{
            
            if(atv!=null)
                current = atv;
            
            solicitacao = ejbSolicitacao.findByAtividade(current);
            conexao = ejbConexao.findByAtividade(current);
            conexoes = ejbConexao.findListByAtividade(current);
            palestras = ejbPalestras.findByAtividade(current);
            
            List<Presenca> partAuxList = ejbPresenca.findByArividadeInOrderedLocation(current);            
            List<Presenca> partPessoaList = new ArrayList();
            Map usedLocals = new Hashtable();
            
            for(Presenca p : partAuxList)
            {
                int ibge = p.getLocal().getIbge();
                if(!usedLocals.containsKey(ibge))
                {
                    usedLocals.put(ibge, 0);
                    List<Presenca> tmp = new ArrayList();
                    
                    for(Presenca i : partAuxList)
                    {
                        if(p.getLocal().getIbge() == i.getLocal().getIbge())
                        {
                            int index = Collections.binarySearch(tmp, i, 
                                new Comparator<Presenca>() {
                                    public int compare(Presenca p1, Presenca p2) {
                                        return p1.getPessoa().getNome()
                                               .compareToIgnoreCase(p2.getPessoa().getNome());
                                    }
                                });

                            if (index < 0) {
                                index = (index * -1) - 1;
                            }

                            tmp.add(index, i);
                        }
                    }
                    for(Presenca k : tmp)
                        partPessoaList.add(k);
                }
            }
            
            
            //pdfContent = new Streamed
            ByteArrayOutputStream output = new ByteArrayOutputStream();  
            output.reset();
            Font fontHeader = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font fontLine = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font fontLineBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

            //FileOutputStream file = new FileOutputStream("template.pdf");
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, output);  
            document.open(); 
            
            //Writing document
            String contextPath =  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/img/header.png");
            
            Image image1 = Image.getInstance(contextPath);
            image1.scaleToFit(document.getPageSize());
            image1.setAlignment(Element.ALIGN_CENTER);
            document.add(image1);
            Paragraph headerTitle =  new Paragraph("Ata de Registro de Presença", fontHeader);
            headerTitle.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            document.add(headerTitle);
            
            //
            Calendar cal = Calendar.getInstance();
            cal.setTime(current.getDt());
            int year = cal.get(Calendar.YEAR);
            int month = 1 + cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
            cal.setTime(current.getHrInicio());
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            cal.setTime(current.getHrTermino());
            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
            int min2 = cal.get(Calendar.MINUTE);
            Paragraph p = new Paragraph();
            p.add(new Chunk(day+"/"+month+"/"+year+"  "+hour+":"+((min < 10)? "0" : "")+min + " às " + hour2+":"+((min2 < 10)? "0" : "")+min2, fontLine));
            document.add(p);
            
            //
            p = new Paragraph();
            p.add(new Chunk(current.getModalidade().getDescricao(), fontLine));
            p.add(new Chunk(" - "));
            p.add(new Chunk(current.getTipo().getDescricao(), fontLine));
            document.add(p);
            
            p = new Paragraph();
            p.add(new Chunk(current.getTema(), fontLine));
            document.add(p);
            if(!conexoes.isEmpty())
            {
                for(Conexao c : conexoes)
                {
                    p = new Paragraph();
                    p.add(new Phrase("Instituição Remota: ", fontLineBold));
                    p.add(new Chunk(c.getResponsavel().getInstituicao().getSigla(), fontLine));
                    p.add(new Phrase(" Conexão: ", fontLineBold));
                    p.add(new Chunk(c.getDescricao(), fontLine));
                    if(c.getSala() != null)
                    {
                        p.add(new Phrase(" - Sala: ", fontLineBold));
                        p.add(new Chunk(c.getSala(), fontLine));
                    }
                    document.add(p);
                }
            }
            
            p = new Paragraph();
            p.add(new Phrase("Senha para registro de presença: ", fontLineBold));
            p.add(new Chunk(current.getId().toString(), fontLine));
            document.add(p);
            document.add( Chunk.NEWLINE );
            
            PdfPTable table = new PdfPTable(6); // 3 columns.
            table.setWidthPercentage(100);
            PdfPCell cellTitle = new PdfPCell(new Paragraph("Nome"));
            cellTitle.setColspan(2);
            cellTitle.setFixedHeight(20f);
            
            PdfPCell cellTitle2 = new PdfPCell(new Paragraph("Email"));
            cellTitle2.setColspan(2);
            cellTitle2.setFixedHeight(20f);
            
            PdfPCell cellTitle3 = new PdfPCell(new Paragraph("Local"));
            cellTitle3.setColspan(2);
            cellTitle3.setFixedHeight(20f);
            
            table.addCell(cellTitle);
            table.addCell(cellTitle2);
            table.addCell(cellTitle3);
            
            int index = 1;
            for(Presenca part : partPessoaList){
                String nome = part.getPessoa().getNome().trim().toUpperCase();
                String sobrenome = part.getPessoa().getSobrenome().trim().toUpperCase();
                String email = part.getPessoa().getEmail().trim().toLowerCase();
                Municipio local = part.getLocal();
                String cidade = "";
                String estado = "";
                if(local!=null){
                    cidade = local.getNome();
                    estado = local.getUf().getSigla();
                }
                
                PdfPCell cell1 = new PdfPCell(new Paragraph(""+index+" "+nome+" "+sobrenome));
                cell1.setColspan(2);
                cell1.setFixedHeight(30f);
                
                PdfPCell cell2 = new PdfPCell(new Paragraph(" "+email));
                cell2.setColspan(2);
                cell2.setFixedHeight(30f);
                
                PdfPCell cell3 = new PdfPCell(new Paragraph(" "+cidade+"-"+estado));
                cell3.setColspan(2);
                cell3.setFixedHeight(30f);
                
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                index++;
            }
            
            document.add(table);
            
            
            document.close();
            output.flush();
            output.close();
            return new DefaultStreamedContent(new ByteArrayInputStream(output.toByteArray()), "application/pdf", "ID_" + current.getId() +"_ATA"+".pdf");  
        }
        catch (Exception e) {  
            e.printStackTrace(); 
        }
        return null;
    }
    
    
    private String chooseHeaderDocumentTitle(Atividade atv)
    {
        int status = atv.getStatus().getId();
        
        switch(status)
        {
            case 1 :
                return "Comprovante de Solicitação de Atividade";
            case 2 :
                return "Comprovante de Deferimento de Atividade";
            case 3 :
                return "Comprovante de Indeferimento de Atividade";
            case 4 :
                return "Comprovante de Realização de Atividade";
            case 5 :
                return "Comprovante de Cancelamento de Atividade";    
            default :
                return "";
        }
    }
    
    private void sendCert(Atividade atv){
        if(enviarCert){
            cert = new Certificados();
            cert.setAtividade(atv);
            try {
                ejbCerts.create(cert);
                JsfUtil.addSuccessMessage("Certificado será emitido para esta atividade!");
            }
            catch(Exception ex){
                JsfUtil.addErrorMessage("Houve erro ao tentar cadastrar Certificado para esta atividade!");
            }
        }
    }
}
