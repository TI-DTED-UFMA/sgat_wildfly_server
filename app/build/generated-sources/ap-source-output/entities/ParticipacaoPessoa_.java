package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParticipacaoPessoa.class)
public abstract class ParticipacaoPessoa_ {

	public static volatile SingularAttribute<ParticipacaoPessoa, Atividade> atividade;
	public static volatile SingularAttribute<ParticipacaoPessoa, Pessoa> pessoa;
	public static volatile ListAttribute<ParticipacaoPessoa, ParticipacaoIp> participacaoIpList;
	public static volatile ListAttribute<ParticipacaoPessoa, ParticipacaoLocal> participacaoLocalList;
	public static volatile SingularAttribute<ParticipacaoPessoa, Integer> id;

}

