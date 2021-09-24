package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Instituicao.class)
public abstract class Instituicao_ {

	public static volatile ListAttribute<Instituicao, Funcionario> funcionarioList;
	public static volatile ListAttribute<Instituicao, ParticipacaoInstituicao> participacaoInstituicaoList;
	public static volatile SingularAttribute<Instituicao, String> sigla;
	public static volatile SingularAttribute<Instituicao, Integer> id;
	public static volatile SingularAttribute<Instituicao, String> descricao;

}

