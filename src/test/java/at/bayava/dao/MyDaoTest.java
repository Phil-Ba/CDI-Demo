package at.bayava.dao;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Simple Cdi-Unit showcase
 * Created by pbayer on 10.10.2014.
 */

@RunWith(CdiRunner.class)
public class MyDaoTest {

	@Inject
	MyDao myDao;

	@Test
	//Lets make sure CdiRuner works
	public void test() {
		String stuff = myDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyDao"));
	}

}
