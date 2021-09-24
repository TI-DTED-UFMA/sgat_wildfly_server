package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile ListAttribute<Status, Atividade> atividadeList;
	public static volatile SingularAttribute<Status, Integer> id;
	public static volatile SingularAttribute<Status, String> descricao;

}

