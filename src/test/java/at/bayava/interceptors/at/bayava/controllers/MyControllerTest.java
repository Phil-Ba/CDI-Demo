package at.bayava.interceptors.at.bayava.controllers;

import at.bayava.dao.MyDao;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(CdiRunner.class)
public class MyControllerTest {

	@Inject
	MyController controller;

	@Test
	public void testMyControllerInjectedWithDefaultClass() throws Exception {
		assertThat(controller.makeDaoDoStuff(), is(MyDao.DEFAULT_DO_STUFF_RETURN));
	}

}