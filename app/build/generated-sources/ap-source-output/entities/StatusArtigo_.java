package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StatusArtigo.class)
public abstract class StatusArtigo_ {

	public static volatile SingularAttribute<StatusArtigo, Integer> id;
	public static volatile ListAttribute<StatusArtigo, Artigo> artigoList;
	public static volatile SingularAttribute<StatusArtigo, String> descricao;

}

