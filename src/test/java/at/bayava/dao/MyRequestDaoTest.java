package at.bayava.dao;

import org.jboss.weld.context.ContextNotActiveException;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.InRequestScope;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by pbayer on 10.10.2014.
 */
@RunWith(CdiRunner.class)
public class MyRequestDaoTest {

	@Inject
	//this dao is request scoped
			MyRequestDao myRequestDao;

	@Test
	@InRequestScope
	//This test should work, since the InRequestScope annotation ensures that the test takes place in a request
	public void testInjectionWithRequest() {
		String stuff = myRequestDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyRequestDao"));
	}

	@Test(expected = ContextNotActiveException.class)
	//Without the InRequestScope annotation  this test should throw an exception,
	// since no request is active and the object to be injected is request scoped
	public void testInjectionWithoutRequest() {
		String stuff = myRequestDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyRequestDao"));
	}

}
