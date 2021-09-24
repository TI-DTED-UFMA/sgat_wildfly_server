package smgt.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbSolicitacao.class)
public abstract class TbSolicitacao_ {

	public static volatile SingularAttribute<TbSolicitacao, String> solcitacao;
	public static volatile SingularAttribute<TbSolicitacao, Integer> codigo;
	public static volatile SingularAttribute<TbSolicitacao, Integer> codigoSolicitante;
	public static volatile SingularAttribute<TbSolicitacao, Integer> pacienteAtivo;
	public static volatile SingularAttribute<TbSolicitacao, Integer> solicitacaoAtivo;
	public static volatile SingularAttribute<TbSolicitacao, Integer> solicitacaoTipo;

}

