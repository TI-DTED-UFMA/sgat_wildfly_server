package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile ListAttribute<Pessoa, Autentificacao> autentificacaoList;
	public static volatile ListAttribute<Pessoa, Funcionario> funcionarioList;
	public static volatile ListAttribute<Pessoa, Atividade> atividadeList;
	public static volatile ListAttribute<Pessoa, Presenca> presencaList;
	public static volatile ListAttribute<Pessoa, ProfSaude> profSaudeList;
	public static volatile CollectionAttribute<Pessoa, EdicaoVideo> edicaoVideoCollection1;
	public static volatile ListAttribute<Pessoa, ParticipacaoPessoa> participacaoPessoaList;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile ListAttribute<Pessoa, ProfGeral> profGeralList;
	public static volatile CollectionAttribute<Pessoa, EdicaoVideo> edicaoVideoCollection;
	public static volatile ListAttribute<Pessoa, ParticipacaoViagem> participacaoViagemList;
	public static volatile ListAttribute<Pessoa, Solicitacao> solicitacaoList;
	public static volatile ListAttribute<Pessoa, Palestras> palestrasList;
	public static volatile SingularAttribute<Pessoa, String> cpf;
	public static volatile ListAttribute<Pessoa, Profissional> profissionalList;
	public static volatile CollectionAttribute<Pessoa, EdicaoVideo> edicaoVideoCollection2;
	public static volatile SingularAttribute<Pessoa, String> celular;
	public static volatile SingularAttribute<Pessoa, Integer> id;
	public static volatile SingularAttribute<Pessoa, String> sobrenome;
	public static volatile SingularAttribute<Pessoa, String> sexo;
	public static volatile SingularAttribute<Pessoa, String> email;

}

