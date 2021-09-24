/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smgt.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import smgt.entities.TbSolicitacaoResposta;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitacaoRespostaFacade extends AbstractFacade<TbSolicitacaoResposta> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitacaoRespostaFacade() {
        super(TbSolicitacaoResposta.class);
    }
    
    public TbSolicitacaoResposta findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitacaoResposta.findByCodigo", TbSolicitacaoResposta.class);
        query.setParameter("codigo", codigo);
        return returnSingleValue(query);
    }
}
