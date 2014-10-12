package at.bayava.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This interceptor binding combines multiple interceptors. The order of the interceptors is determined by the order of
 * interceptors in the beans.xml.
 * Created by pbayer on 10.10.2014.
 */
@MyInterceptorAnnotation
@MyInceptionAnnotation
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface MyChainedInterceptorAnnotation {

}
