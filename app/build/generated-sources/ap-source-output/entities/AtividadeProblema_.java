package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtividadeProblema.class)
public abstract class AtividadeProblema_ {

	public static volatile SingularAttribute<AtividadeProblema, Atividade> atividade;
	public static volatile SingularAttribute<AtividadeProblema, String> solucao;
	public static volatile SingularAttribute<AtividadeProblema, Problema> problema;
	public static volatile SingularAttribute<AtividadeProblema, Integer> id;
	public static volatile SingularAttribute<AtividadeProblema, String> descricao;

}

