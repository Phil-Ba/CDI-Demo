package at.bayava.dao;

import org.jboss.weld.context.ContextNotActiveException;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.ContextController;
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
	ContextController contextController; //Obtain an instance of the context controller.

	@Inject
	MyRequestDao myRequestDao;

	@Test
	@InRequestScope
	public void test2() {
		String stuff = myRequestDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyRequestDao"));
	}

	@Test(expected = ContextNotActiveException.class)
	public void test() {
		String stuff = myRequestDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyRequestDao"));
	}


}
