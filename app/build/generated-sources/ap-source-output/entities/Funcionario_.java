package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile SingularAttribute<Funcionario, String> setor;
	public static volatile SingularAttribute<Funcionario, Pessoa> pessoa;
	public static volatile ListAttribute<Funcionario, Usuario> usuarioList;
	public static volatile ListAttribute<Funcionario, Conexao> conexaoList;
	public static volatile SingularAttribute<Funcionario, Instituicao> instituicao;
	public static volatile SingularAttribute<Funcionario, Integer> id;
	public static volatile SingularAttribute<Funcionario, String> ramal;

}

