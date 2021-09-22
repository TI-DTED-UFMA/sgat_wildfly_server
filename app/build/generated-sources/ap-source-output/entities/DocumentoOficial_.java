package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DocumentoOficial.class)
public abstract class DocumentoOficial_ {

	public static volatile SingularAttribute<DocumentoOficial, Destinatario> setor;
	public static volatile SingularAttribute<DocumentoOficial, Integer> tipo;
	public static volatile SingularAttribute<DocumentoOficial, String> corpo;
	public static volatile SingularAttribute<DocumentoOficial, Integer> num;
	public static volatile SingularAttribute<DocumentoOficial, Integer> id;
	public static volatile SingularAttribute<DocumentoOficial, Date> dtDoc;

}

