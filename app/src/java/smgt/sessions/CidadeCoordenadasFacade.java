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
import smgt.entities.CidadeCoordenadas;

/**
 *
 * @author nigel
 */
@Stateless
public class CidadeCoordenadasFacade extends AbstractFacade<CidadeCoordenadas> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CidadeCoordenadasFacade() {
        super(CidadeCoordenadas.class);
    }
    
    public CidadeCoordenadas findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("CidadeCoordenadas.findByIbge", CidadeCoordenadas.class);
        query.setParameter("ibge", codigo);
        return returnSingleValue(query);
    }
}
