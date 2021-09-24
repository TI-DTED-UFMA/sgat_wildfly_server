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
import smgt.entities.TbSolicitantePessoa;

/**
 *
 * @author nigel
 */
@Stateless
public class TbSolicitantePessoaFacade extends AbstractFacade<TbSolicitantePessoa> {

    @PersistenceContext(unitName = "SGMT_MAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolicitantePessoaFacade() {
        super(TbSolicitantePessoa.class);
    }
    
    public TbSolicitantePessoa findByCodigo(int codigo)
    {
        TypedQuery query = em.createNamedQuery("TbSolicitantePessoa.findByCodigo", TbSolicitantePessoa.class);
        query.setParameter("codigo", codigo);
        return returnSingleValue(query);
    }
    
    public TbSolicitantePessoa findByCpf(String value){
        TypedQuery query = em.createNamedQuery("TbSolicitantePessoa.findByCpf", TbSolicitantePessoa.class);
        query.setParameter("cpf", value);
        return (TbSolicitantePessoa)returnSingleValue(query);
    }
}
