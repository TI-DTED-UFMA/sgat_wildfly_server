package smgt.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbSolicitanteUnidade.class)
public abstract class TbSolicitanteUnidade_ {

	public static volatile SingularAttribute<TbSolicitanteUnidade, Integer> codigo;
	public static volatile SingularAttribute<TbSolicitanteUnidade, Integer> tipo;
	public static volatile SingularAttribute<TbSolicitanteUnidade, String> telefone;
	public static volatile SingularAttribute<TbSolicitanteUnidade, Integer> ativo;
	public static volatile SingularAttribute<TbSolicitanteUnidade, String> endereco;
	public static volatile SingularAttribute<TbSolicitanteUnidade, Date> dataAtualizacao;
	public static volatile SingularAttribute<TbSolicitanteUnidade, Integer> ibge;
	public static volatile SingularAttribute<TbSolicitanteUnidade, Integer> cnes;
	public static volatile SingularAttribute<TbSolicitanteUnidade, String> nome;

}

