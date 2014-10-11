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
	@Nonbinding String value() default "";
}
