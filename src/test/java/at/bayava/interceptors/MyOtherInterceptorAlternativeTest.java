package at.bayava.interceptors;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test for chained interceptors
 * Created by pbayer.
 */
@RunWith(CdiRunner.class)
//We need to tell cdi-unit about these classes, since they arent directly referenced in the test.
//The order als determines the order of interception(analog to beans.xml)
@AdditionalClasses({MyOtherInterceptorAlternative.class, MyInterceptor.class})
public class MyOtherInterceptorAlternativeTest {

	@Inject
	TestClass testClass;

	/**
	 * Assert that the return value is modified by both interceptor
	 */
	@Test
	public void testChainedInterception() {
		String result = testClass.testInterceptedMethod();
		System.out.println(result);
		assertThat(result, allOf(containsString("intercepted"), containsString("alternative otherInterceptor")));
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
		@MyOtherInterceptorAnnotationAlternative
		public String testInterceptedMethod() {
			return "testReturnValue";
		}

		//this method should not be intercepted
		public String testNotInterceptedMethod() {
			return "testReturnValue";
		}

	}

}
