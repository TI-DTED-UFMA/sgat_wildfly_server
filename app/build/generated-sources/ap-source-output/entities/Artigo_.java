package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Artigo.class)
public abstract class Artigo_ {

	public static volatile SingularAttribute<Artigo, Date> data;
	public static volatile SingularAttribute<Artigo, String> pdfPath;
	public static volatile SingularAttribute<Artigo, String> link;
	public static volatile SingularAttribute<Artigo, String> localPub;
	public static volatile SingularAttribute<Artigo, Abstract> resumo;
	public static volatile SingularAttribute<Artigo, Integer> id;
	public static volatile SingularAttribute<Artigo, Abstract> abstract1;
	public static volatile ListAttribute<Artigo, ArtigoAutor> artigoAutorList;
	public static volatile SingularAttribute<Artigo, StatusArtigo> status;

}

