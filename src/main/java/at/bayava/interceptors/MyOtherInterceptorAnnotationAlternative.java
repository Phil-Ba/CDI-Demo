package at.bayava.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A simple annotation for interceptor chaining.
 * To bind an interceptor to this annotation, just annotate it with this class.
 * This class is also annotated with another interceptor binding annotation,
 * which causes the interceptor bound to that annotation to also execute.
 * Created by pbayer
 */
@InterceptorBinding
@MyInterceptorAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOtherInterceptorAnnotationAlternative {

}
