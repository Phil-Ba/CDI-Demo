package at.bayava.dao;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by pbayer on 10.10.2014.
 */
@RunWith(CdiRunner.class)
public class MockedMyDaoTest {

	@Inject
	MyDao myDao;

	@Produces
	@Mock
	MyDao mockedDao;

	@Before
	public void setUp() {
		when(mockedDao.doStuff()).thenReturn("MyMockedDao does stuff!");
	}


	@Test
	public void test() {
		String stuff = myDao.doStuff();
		System.out.println(stuff);
		assertThat(stuff, containsString("MyMockedDao"));
	}


}
