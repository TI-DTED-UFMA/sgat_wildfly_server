package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cbo.class)
public abstract class Cbo_ {

	public static volatile SingularAttribute<Cbo, String> codigo;
	public static volatile ListAttribute<Cbo, Profissional> profissionalList;
	public static volatile SingularAttribute<Cbo, String> nome;
	public static volatile ListAttribute<Cbo, ProfGeral> profGeralList;

}

