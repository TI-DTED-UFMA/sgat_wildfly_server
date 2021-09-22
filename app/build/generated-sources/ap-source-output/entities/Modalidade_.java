package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modalidade.class)
public abstract class Modalidade_ {

	public static volatile ListAttribute<Modalidade, Atividade> atividadeList;
	public static volatile SingularAttribute<Modalidade, Integer> id;
	public static volatile SingularAttribute<Modalidade, String> descricao;

}

