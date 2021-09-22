package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Presenca.class)
public abstract class Presenca_ {

	public static volatile SingularAttribute<Presenca, Atividade> atividade;
	public static volatile SingularAttribute<Presenca, Pessoa> pessoa;
	public static volatile SingularAttribute<Presenca, String> ip;
	public static volatile SingularAttribute<Presenca, Ubs> ubs;
	public static volatile SingularAttribute<Presenca, Integer> id;
	public static volatile SingularAttribute<Presenca, Municipio> local;

}

