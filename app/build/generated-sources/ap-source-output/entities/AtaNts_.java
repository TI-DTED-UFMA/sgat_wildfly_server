package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtaNts.class)
public abstract class AtaNts_ {

	public static volatile SingularAttribute<AtaNts, Atividade> atividade;
	public static volatile SingularAttribute<AtaNts, Integer> qtdPresentes;
	public static volatile SingularAttribute<AtaNts, Integer> qtdPontos;
	public static volatile SingularAttribute<AtaNts, Integer> id;
	public static volatile ListAttribute<AtaNts, AtaDigitalizada> ataDigitalizadaList;
	public static volatile SingularAttribute<AtaNts, String> maisInfo;

}

