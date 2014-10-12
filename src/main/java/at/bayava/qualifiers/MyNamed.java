package at.bayava.qualifiers;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by pbayer.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MyNamed {

	/**
	 * value is nonbinding, so it will be ignored when determining injection point.
	 * This is useful if you want to pass a value (ie. to an interceptor)
	 *
	 * @return
	 */
	@Nonbinding String value() default "";
}
