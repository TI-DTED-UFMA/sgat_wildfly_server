package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParticipacaoLocal.class)
public abstract class ParticipacaoLocal_ {

	public static volatile SingularAttribute<ParticipacaoLocal, Ubs> ubs;
	public static volatile SingularAttribute<ParticipacaoLocal, Integer> id;
	public static volatile SingularAttribute<ParticipacaoLocal, ParticipacaoPessoa> participacao;
	public static volatile SingularAttribute<ParticipacaoLocal, Municipio> local;

}

