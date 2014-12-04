package at.bayava.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * A simple interceptor
 * Created by pbayer on 10.10.2014.
 */
@Interceptor
//this is the annotation, which marks methods/classes which should be intercepted
//(the annotation must be annotated with @Interceptorbinding)
@MyOtherInterceptorAnnotation
public class MyOtherInterceptor {

	/**
	 * @param ctx invocationContext, ie. the method that is being intercepted
	 * @return a modified string
	 * @throws Exception
	 */
	@AroundInvoke
	Object aroundInvoke(InvocationContext ctx) throws Exception {
		//tell the method the proceed, and get the return value
		Object result = ctx.proceed();
		//if its a string, lets modify it
		if (result instanceof String) {
			result = result + ". This otherInterceptor speaking!";
		}
		return result;
	}

}
