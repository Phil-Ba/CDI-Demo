package at.bayava.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by pbayer on 10.10.2014.
 */
@Interceptor
@MyInterceptorAnnotation
public class MyInterceptor {

	@AroundInvoke
	Object aroundInvoke(InvocationContext ctx) throws Exception {
		Object result = ctx.proceed();
		if(result instanceof  String)
		{
			return result + " intercepted";
		}
		return result;
	}

}
