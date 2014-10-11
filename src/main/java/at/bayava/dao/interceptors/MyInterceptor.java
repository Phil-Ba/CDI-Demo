package at.bayava.dao.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by pbayer on 10.10.2014.
 */
@Interceptor
@MyAnnotation
public class MyInterceptor {

	@AroundInvoke
	Object aroundInvoke(InvocationContext ctx) throws Exception {
		Object result = ctx.proceed();
		if(result instanceof  String)
		{
			return (String)result + " intercepted";
		}
		return result;
	}

}
