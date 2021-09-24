package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Destinatario.class)
public abstract class Destinatario_ {

	public static volatile ListAttribute<Destinatario, DocumentoOficial> documentoOficialList;
	public static volatile SingularAttribute<Destinatario, String> nome;
	public static volatile SingularAttribute<Destinatario, Integer> id;

}

