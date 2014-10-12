package at.bayava.interceptors;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests to see if interception is happening
 * Created by pbayer.
 */
@RunWith(CdiRunner.class)
//We need to tell cdi-unit about this class, since it isnt directly referenced
@AdditionalClasses(MyInterceptor.class)
public class MyInterceptorTest {

	@Inject
	TestClass testClass;

	/**
	 * Assert that the return value is modified by the interceptor
	 */
	@Test
	public void testInterception() {
		String result = testClass.testInterceptedMethod();
		System.out.println(result);
		assertThat(result, containsString("intercepted"));
	}

	/**
	 * Assert that the return value is not modified by the interceptor
	 */
	@Test
	public void testInterceptionNotHappening() {
		String result = testClass.testNotInterceptedMethod();
		System.out.println(result);
		assertThat(result, is("testReturnValue"));
	}

	/**
	 * Inner class for interceptor testing
	 */
	static class TestClass {

		//this method should be intercepted since its annotated with an interceptor binding annotation
		@MyInterceptorAnnotation
		public String testInterceptedMethod() {
			return "testReturnValue";
		}

		//this method should not be intercepted
		public String testNotInterceptedMethod() {
			return "testReturnValue";
		}

	}

}
