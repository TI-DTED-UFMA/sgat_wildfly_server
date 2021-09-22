/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author nigellima
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.AbstractFacadeREST.class);
        resources.add(service.AlunoFacadeREST.class);
        resources.add(service.ArtigoAutorFacadeREST.class);
        resources.add(service.ArtigoFacadeREST.class);
        resources.add(service.AtaDigitalizadaFacadeREST.class);
        resources.add(service.AtaNtsFacadeREST.class);
        resources.add(service.AtaReuniaoFacadeREST.class);
        resources.add(service.AtividadeFacadeREST.class);
        resources.add(service.AtividadeProblemaFacadeREST.class);
        resources.add(service.AtividadeTbrFacadeREST.class);
        resources.add(service.AutentificacaoFacadeREST.class);
        resources.add(service.AvaliacoesFacadeREST.class);
        resources.add(service.CboFacadeREST.class);
        resources.add(service.CertificadosFacadeREST.class);
        resources.add(service.CidadeCoordenadasFacadeREST.class);
        resources.add(service.CidadeFacadeREST.class);
        resources.add(service.ConexaoFacadeREST.class);
        resources.add(service.CursoFacadeREST.class);
        resources.add(service.DeferimentoFacadeREST.class);
        resources.add(service.DestinatarioFacadeREST.class);
        resources.add(service.DocumentoOficialFacadeREST.class);
        resources.add(service.EdicaoVideoFacadeREST.class);
        resources.add(service.EnderecoFacadeREST.class);
        resources.add(service.EquipeFacadeREST.class);
        resources.add(service.EstadoFacadeREST.class);
        resources.add(service.FuncionarioFacadeREST.class);
        resources.add(service.InstituicaoFacadeREST.class);
        resources.add(service.LocalFacadeREST.class);
        resources.add(service.MdlCourseCompletionCriteriaFacadeREST.class);
        resources.add(service.MdlCourseFacadeREST.class);
        resources.add(service.MdlEnrolFacadeREST.class);
        resources.add(service.MdlGradeGradesFacadeREST.class);
        resources.add(service.MdlGradeItemsFacadeREST.class);
        resources.add(service.MdlUserEnrolmentsFacadeREST.class);
        resources.add(service.MdlUserFacadeREST.class);
        resources.add(service.ModalidadeFacadeREST.class);
        resources.add(service.MunicipioFacadeREST.class);
        resources.add(service.ObjetoAprendizagemFacadeREST.class);
        resources.add(service.PalestrasFacadeREST.class);
        resources.add(service.ParticipacaoInstituicaoFacadeREST.class);
        resources.add(service.ParticipacaoIpFacadeREST.class);
        resources.add(service.ParticipacaoLocalFacadeREST.class);
        resources.add(service.ParticipacaoPessoaFacadeREST.class);
        resources.add(service.ParticipacaoViagemFacadeREST.class);
        resources.add(service.PerguntasFacadeREST.class);
        resources.add(service.PessoaFacadeREST.class);
        resources.add(service.PresencaFacadeREST.class);
        resources.add(service.PresencaKeysFacadeREST.class);
        resources.add(service.ProblemaFacadeREST.class);
        resources.add(service.ProfGeralFacadeREST.class);
        resources.add(service.ProfSaudeFacadeREST.class);
        resources.add(service.ProfissionalFacadeREST.class);
        resources.add(service.SolicitacaoFacadeREST.class);
        resources.add(service.StatusArtigoFacadeREST.class);
        resources.add(service.StatusFacadeREST.class);
        resources.add(service.StatusMatriculaFacadeREST.class);
        resources.add(service.TbSolicitacaoCiapCidFacadeREST.class);
        resources.add(service.TbSolicitacaoDataTimestampFacadeREST.class);
        resources.add(service.TbSolicitacaoEncaminhamentoFacadeREST.class);
        resources.add(service.TbSolicitacaoFacadeREST.class);
        resources.add(service.TbSolicitacaoRespostaFacadeREST.class);
        resources.add(service.TbSolicitacaoSatisfacaoFacadeREST.class);
        resources.add(service.TbSolicitanteEquipeFacadeREST.class);
        resources.add(service.TbSolicitantePerfilFacadeREST.class);
        resources.add(service.TbSolicitantePessoaFacadeREST.class);
        resources.add(service.TbSolicitanteUnidadeFacadeREST.class);
        resources.add(service.TipoAvaliacaoFacadeREST.class);
        resources.add(service.TipoFacadeREST.class);
        resources.add(service.TipoNt4FacadeREST.class);
        resources.add(service.TipoObjetoAprFacadeREST.class);
        resources.add(service.UbsFacadeREST.class);
        resources.add(service.UsuarioFacadeREST.class);
        resources.add(service.ViagemFacadeREST.class);
    }
    
}
