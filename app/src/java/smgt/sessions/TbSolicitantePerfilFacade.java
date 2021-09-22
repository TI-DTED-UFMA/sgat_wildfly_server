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
import smgt.entities.TbSolicitantePerfil;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitantePerfilFacade extends AbstractFacade<TbSolicitantePerfil> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitantePerfilFacade() {
        super(TbSolicitantePerfil.class);
    }
    
    public TbSolicitantePerfil findByPessoa(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitantePerfil.findByPessoa", TbSolicitantePerfil.class);
        query.setParameter("pessoa", codigo);
        return returnSingleValue(query);
    }
    
    public List<TbSolicitantePerfil> findByEquipe(int equipe)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitantePerfil.findByEquipe", TbSolicitantePerfil.class);
        query.setParameter("equipe", equipe);
        return query.getResultList();
    }
    
    public List<TbSolicitantePerfil> findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitantePerfil.findByCodigo", TbSolicitantePerfil.class);
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
}
