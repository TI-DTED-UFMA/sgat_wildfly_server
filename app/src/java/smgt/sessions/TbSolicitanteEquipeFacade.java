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
import smgt.entities.TbSolicitanteEquipe;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitanteEquipeFacade extends AbstractFacade<TbSolicitanteEquipe> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitanteEquipeFacade() {
        super(TbSolicitanteEquipe.class);
    }
    
    public TbSolicitanteEquipe findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitanteEquipe.findByCodigo", TbSolicitanteEquipe.class);
        query.setParameter("codigo", codigo);
        return returnSingleValue(query);
    }
    
    public List<TbSolicitanteEquipe> findByUnidade(int unidade)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitanteEquipe.findByUnidade", TbSolicitanteEquipe.class);
        query.setParameter("unidade", unidade);
        return query.getResultList();
    }
}
