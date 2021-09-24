package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Solicitacao.class)
public abstract class Solicitacao_ {

	public static volatile SingularAttribute<Solicitacao, Integer> qtdLugares;
	public static volatile SingularAttribute<Solicitacao, Atividade> atividade;
	public static volatile SingularAttribute<Solicitacao, Date> data;
	public static volatile ListAttribute<Solicitacao, Deferimento> deferimentoList;
	public static volatile SingularAttribute<Solicitacao, Usuario> usuario;
	public static volatile SingularAttribute<Solicitacao, Integer> id;
	public static volatile SingularAttribute<Solicitacao, Pessoa> responsavel;

}

