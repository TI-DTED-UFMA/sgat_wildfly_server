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
import smgt.entities.TbSolicitacao;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitacaoFacade extends AbstractFacade<TbSolicitacao> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitacaoFacade() {
        super(TbSolicitacao.class);
    }
    
    //TbSolicitacao.findByCodigo
    public TbSolicitacao findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitacao.findByCodigo", TbSolicitacao.class);
        query.setParameter("codigo", codigo);
        return returnSingleValue(query);
    }
}
