package smgt.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CidadeCoordenadas.class)
public abstract class CidadeCoordenadas_ {

	public static volatile SingularAttribute<CidadeCoordenadas, String> uf;
	public static volatile SingularAttribute<CidadeCoordenadas, String> sigla;
	public static volatile SingularAttribute<CidadeCoordenadas, Integer> ibge;
	public static volatile SingularAttribute<CidadeCoordenadas, String> municipio;
	public static volatile SingularAttribute<CidadeCoordenadas, BigDecimal> latitude;
	public static volatile SingularAttribute<CidadeCoordenadas, Integer> ufId;
	public static volatile SingularAttribute<CidadeCoordenadas, String> longitude;

}

