package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Municipio.class)
public abstract class Municipio_ {

	public static volatile ListAttribute<Municipio, Endereco> enderecoList;
	public static volatile SingularAttribute<Municipio, Estado> uf;
	public static volatile ListAttribute<Municipio, Presenca> presencaList;
	public static volatile ListAttribute<Municipio, ParticipacaoLocal> participacaoLocalList;
	public static volatile SingularAttribute<Municipio, Integer> ibge;
	public static volatile ListAttribute<Municipio, Profissional> profissionalList;
	public static volatile SingularAttribute<Municipio, String> nome;
	public static volatile ListAttribute<Municipio, ProfGeral> profGeralList;

}

