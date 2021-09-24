package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Viagem.class)
public abstract class Viagem_ {

	public static volatile SingularAttribute<Viagem, Atividade> atividade;
	public static volatile ListAttribute<Viagem, ParticipacaoViagem> participacaoViagemList;
	public static volatile SingularAttribute<Viagem, String> motivo;
	public static volatile SingularAttribute<Viagem, String> percurso;
	public static volatile SingularAttribute<Viagem, Date> dtSaida;
	public static volatile SingularAttribute<Viagem, Integer> id;
	public static volatile SingularAttribute<Viagem, Date> dtChegada;
	public static volatile SingularAttribute<Viagem, Date> dtPreenchimento;

}

