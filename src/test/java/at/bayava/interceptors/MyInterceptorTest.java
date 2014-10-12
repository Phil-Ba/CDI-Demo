package at.bayava.interceptors;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by pbayer.
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(MyInterceptor.class)
public class MyInterceptorTest {

	@Inject
	TestClass testClass;

	@Test
	public void testInterception() {
		String result = testClass.testMethod();
		System.out.println(result);
		assertThat(result, containsString("intercepted"));
	}

	static class TestClass {

		@MyInterceptorAnnotation
		public String testMethod() {
			return "testMethod";
		}

	}

}
