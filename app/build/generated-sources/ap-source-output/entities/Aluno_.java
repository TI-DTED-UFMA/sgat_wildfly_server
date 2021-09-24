package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile SingularAttribute<Aluno, Curso> curso;
	public static volatile SingularAttribute<Aluno, String> cpf;
	public static volatile SingularAttribute<Aluno, Integer> id;
	public static volatile SingularAttribute<Aluno, StatusMatricula> status;

}

