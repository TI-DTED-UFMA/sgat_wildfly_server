package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ {

	public static volatile ListAttribute<Curso, Aluno> alunoList;
	public static volatile SingularAttribute<Curso, String> tema;
	public static volatile SingularAttribute<Curso, Integer> vagasOfertadas;
	public static volatile SingularAttribute<Curso, Date> dataTermino;
	public static volatile SingularAttribute<Curso, Integer> id;
	public static volatile SingularAttribute<Curso, Date> dataInicio;
	public static volatile SingularAttribute<Curso, String> codDecs;
	public static volatile SingularAttribute<Curso, Integer> avaCursoId;
	public static volatile SingularAttribute<Curso, Integer> cargaHoraria;

}

