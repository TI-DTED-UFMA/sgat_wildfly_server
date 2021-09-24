package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Problema.class)
public abstract class Problema_ {

	public static volatile ListAttribute<Problema, AtividadeProblema> atividadeProblemaList;
	public static volatile SingularAttribute<Problema, Integer> id;
	public static volatile SingularAttribute<Problema, String> descricao;

}

