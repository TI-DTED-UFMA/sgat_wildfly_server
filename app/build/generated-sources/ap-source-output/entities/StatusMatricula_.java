package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StatusMatricula.class)
public abstract class StatusMatricula_ {

	public static volatile ListAttribute<StatusMatricula, Aluno> alunoList;
	public static volatile SingularAttribute<StatusMatricula, Integer> id;
	public static volatile SingularAttribute<StatusMatricula, String> descricao;

}

