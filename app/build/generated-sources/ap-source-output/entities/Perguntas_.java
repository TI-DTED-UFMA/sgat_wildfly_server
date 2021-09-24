package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perguntas.class)
public abstract class Perguntas_ {

	public static volatile SingularAttribute<Perguntas, String> descricaoId;
	public static volatile ListAttribute<Perguntas, Avaliacoes> avaliacoesList;
	public static volatile SingularAttribute<Perguntas, Integer> id;
	public static volatile SingularAttribute<Perguntas, TipoAvaliacao> tipoAvaliacao;
	public static volatile SingularAttribute<Perguntas, String> descricao;
	public static volatile SingularAttribute<Perguntas, String> tipoInput;

}

