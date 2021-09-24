package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipo.class)
public abstract class Tipo_ {

	public static volatile ListAttribute<Tipo, Atividade> atividadeList;
	public static volatile SingularAttribute<Tipo, TipoNt4> tipoNt4;
	public static volatile SingularAttribute<Tipo, Integer> id;
	public static volatile SingularAttribute<Tipo, String> descricao;

}

