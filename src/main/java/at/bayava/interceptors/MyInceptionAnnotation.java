package at.bayava.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A simple annotation for interceptor chaining.
 * To bind an interceptor to this annotation, just annotate it with this class
 * Created by pbayer on 10.10.2014.
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInceptionAnnotation {

}
