package at.bayava.interceptors.at.bayava.controllers;

import at.bayava.dao.MyDao;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.ProducesAlternative;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(CdiRunner.class)
public class MyControllerTestWithAlternative {

	public static final String TESTSTRING = "fooboar";

	@Inject
	MyController controller;

	@Produces
	@ProducesAlternative
	MyTestDao dao = new MyTestDao();

	@Before
	public void setup() {
		dao.setStuffString(TESTSTRING);
	}

	@Test
	public void testMyControllerMyTestDaoInjected() throws Exception {
		assertThat(controller.makeDaoDoStuff(), is(TESTSTRING));
	}

	@Test
	public void testSetupCalledBeforeInjection() throws Exception {
		assertThat(controller.makeDaoDoStuff(), not(MyTestDao.MY_TEST_DAO_DEFAULT_STRING));
	}

	class MyTestDao extends MyDao {

		public static final String MY_TEST_DAO_DEFAULT_STRING = "notTestString";

		private String stuffString = MY_TEST_DAO_DEFAULT_STRING;

		@Override
		public String doStuff() {
			return stuffString;
		}

		public void setStuffString(String stuffString) {
			this.stuffString = stuffString;
		}
	}
}