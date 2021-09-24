package moodle.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MdlCourseCompletionCriteria.class)
public abstract class MdlCourseCompletionCriteria_ {

	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigInteger> courseinstance;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigInteger> timeend;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigInteger> role;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, String> module;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, Long> course;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, Long> criteriatype;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigInteger> moduleinstance;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, Long> id;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigDecimal> gradepass;
	public static volatile SingularAttribute<MdlCourseCompletionCriteria, BigInteger> enrolperiod;

}

