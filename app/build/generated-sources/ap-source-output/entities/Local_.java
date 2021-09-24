package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Local.class)
public abstract class Local_ {

	public static volatile SingularAttribute<Local, Cidade> cidade;
	public static volatile ListAttribute<Local, Atividade> atividadeList;
	public static volatile SingularAttribute<Local, Integer> id;
	public static volatile SingularAttribute<Local, String> descricao;

}

