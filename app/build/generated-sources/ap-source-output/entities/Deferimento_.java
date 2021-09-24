package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Deferimento.class)
public abstract class Deferimento_ {

	public static volatile SingularAttribute<Deferimento, Solicitacao> solicitacao;
	public static volatile SingularAttribute<Deferimento, Date> dtHr;
	public static volatile SingularAttribute<Deferimento, Usuario> usuario;
	public static volatile SingularAttribute<Deferimento, Integer> id;

}

