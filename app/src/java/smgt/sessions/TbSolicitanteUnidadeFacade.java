/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smgt.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import smgt.entities.TbSolicitanteUnidade;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitanteUnidadeFacade extends AbstractFacade<TbSolicitanteUnidade> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitanteUnidadeFacade() {
        super(TbSolicitanteUnidade.class);
    }
    
    public TbSolicitanteUnidade findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitanteUnidade.findByCodigo", TbSolicitanteUnidade.class);
        query.setParameter("codigo", codigo);
        return returnSingleValue(query);
    }
    
    public List<TbSolicitanteUnidade> findByIBGE(int ibge)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitanteUnidade.findByIbge", TbSolicitanteUnidade.class);
        query.setParameter("ibge", ibge);
        return query.getResultList();
    }
}
