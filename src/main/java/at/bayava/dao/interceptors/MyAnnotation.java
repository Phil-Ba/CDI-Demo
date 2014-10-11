package at.bayava.dao.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by pbayer on 10.10.2014.
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}
