package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoAvaliacao.class)
public abstract class TipoAvaliacao_ {

	public static volatile ListAttribute<TipoAvaliacao, Perguntas> perguntasList;
	public static volatile SingularAttribute<TipoAvaliacao, Integer> id;
	public static volatile SingularAttribute<TipoAvaliacao, String> descricao;

}

