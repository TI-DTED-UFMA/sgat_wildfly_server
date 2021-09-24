package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Atividade.class)
public abstract class Atividade_ {

	public static volatile ListAttribute<Atividade, Autentificacao> autentificacaoList;
	public static volatile SingularAttribute<Atividade, Tipo> tipo;
	public static volatile ListAttribute<Atividade, Presenca> presencaList;
	public static volatile ListAttribute<Atividade, AtaNts> ataNtsList;
	public static volatile CollectionAttribute<Atividade, EdicaoVideo> edicaoVideoCollection;
	public static volatile SingularAttribute<Atividade, Local> local;
	public static volatile SingularAttribute<Atividade, Date> dt;
	public static volatile ListAttribute<Atividade, Palestras> palestrasList;
	public static volatile ListAttribute<Atividade, Conexao> conexaoList;
	public static volatile SingularAttribute<Atividade, Integer> id;
	public static volatile SingularAttribute<Atividade, String> codDecs;
	public static volatile SingularAttribute<Atividade, Date> hrInicio;
	public static volatile ListAttribute<Atividade, ObjetoAprendizagem> objetoAprendizagemList;
	public static volatile ListAttribute<Atividade, Viagem> viagemList;
	public static volatile SingularAttribute<Atividade, Date> hrTermino;
	public static volatile ListAttribute<Atividade, ParticipacaoPessoa> participacaoPessoaList;
	public static volatile ListAttribute<Atividade, AtividadeTbr> atividadeTbrList;
	public static volatile SingularAttribute<Atividade, String> descricao;
	public static volatile ListAttribute<Atividade, Solicitacao> solicitacaoList;
	public static volatile ListAttribute<Atividade, Certificados> certificadosList;
	public static volatile ListAttribute<Atividade, ParticipacaoInstituicao> participacaoInstituicaoList;
	public static volatile SingularAttribute<Atividade, String> tema;
	public static volatile ListAttribute<Atividade, AtaReuniao> ataReuniaoList;
	public static volatile SingularAttribute<Atividade, Pessoa> moderador;
	public static volatile ListAttribute<Atividade, AtividadeProblema> atividadeProblemaList;
	public static volatile SingularAttribute<Atividade, Status> status;
	public static volatile SingularAttribute<Atividade, Modalidade> modalidade;

}

