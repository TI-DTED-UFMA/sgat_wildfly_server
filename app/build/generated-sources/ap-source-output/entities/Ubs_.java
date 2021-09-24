package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ubs.class)
public abstract class Ubs_ {

	public static volatile ListAttribute<Ubs, ProfSaude> profSaudeList;
	public static volatile SingularAttribute<Ubs, Endereco> endereco;
	public static volatile ListAttribute<Ubs, ParticipacaoLocal> participacaoLocalList;
	public static volatile SingularAttribute<Ubs, Integer> cnes;
	public static volatile ListAttribute<Ubs, Profissional> profissionalList;
	public static volatile SingularAttribute<Ubs, String> nome;
	public static volatile ListAttribute<Ubs, Equipe> equipeList;

}

