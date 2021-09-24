package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Avaliacoes.class)
public abstract class Avaliacoes_ {

	public static volatile SingularAttribute<Avaliacoes, Presenca> presenca;
	public static volatile SingularAttribute<Avaliacoes, Perguntas> pergunta;
	public static volatile SingularAttribute<Avaliacoes, Date> data;
	public static volatile SingularAttribute<Avaliacoes, String> resposta;
	public static volatile SingularAttribute<Avaliacoes, String> ip;
	public static volatile SingularAttribute<Avaliacoes, Integer> id;

}

