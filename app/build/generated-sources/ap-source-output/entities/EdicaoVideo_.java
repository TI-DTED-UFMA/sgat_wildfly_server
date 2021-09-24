package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EdicaoVideo.class)
public abstract class EdicaoVideo_ {

	public static volatile SingularAttribute<EdicaoVideo, Date> dataYoutube;
	public static volatile SingularAttribute<EdicaoVideo, String> urlYoutube;
	public static volatile SingularAttribute<EdicaoVideo, Pessoa> revisor;
	public static volatile SingularAttribute<EdicaoVideo, Atividade> atividade;
	public static volatile SingularAttribute<EdicaoVideo, Pessoa> editor;
	public static volatile SingularAttribute<EdicaoVideo, Date> dataAres;
	public static volatile SingularAttribute<EdicaoVideo, Pessoa> apoioTecnico;
	public static volatile SingularAttribute<EdicaoVideo, Integer> id;
	public static volatile SingularAttribute<EdicaoVideo, String> urlAres;

}

