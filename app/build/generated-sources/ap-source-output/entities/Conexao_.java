package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conexao.class)
public abstract class Conexao_ {

	public static volatile SingularAttribute<Conexao, Atividade> atividade;
	public static volatile SingularAttribute<Conexao, String> sala;
	public static volatile SingularAttribute<Conexao, Integer> id;
	public static volatile SingularAttribute<Conexao, Funcionario> responsavel;
	public static volatile SingularAttribute<Conexao, String> descricao;

}

