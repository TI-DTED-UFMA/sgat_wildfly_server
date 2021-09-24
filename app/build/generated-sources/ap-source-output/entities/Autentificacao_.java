package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autentificacao.class)
public abstract class Autentificacao_ {

	public static volatile SingularAttribute<Autentificacao, Atividade> atividade;
	public static volatile SingularAttribute<Autentificacao, String> codigo;
	public static volatile SingularAttribute<Autentificacao, Pessoa> pessoa;
	public static volatile SingularAttribute<Autentificacao, Integer> id;

}

