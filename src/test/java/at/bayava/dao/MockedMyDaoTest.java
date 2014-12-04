package at.bayava.dao;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Simple showcase of how to use mocking of injected objects with cdi-unit
 * Created by pbayer on 10.10.2014.
 */
@RunWith(CdiRunner.class)
public class MockedMyDaoTest {

	public static final String DEFAULT_MOCK_RETURN = "MyMockedDao does stuff!";

	@Inject
	MyDao myDao;

	/**
	 * To have a mock injected, simply annotate the field with {@literal @}Produces (marking it as producer field
	 * and {@literal @}Mock
	 */
	@Produces
	@Mock
	MyDao mockedDao;

	/**
	 * lets tell the mock what to do
	 */
	@Before
	public void setUp() {
		when(mockedDao.doStuff()).thenReturn(DEFAULT_MOCK_RETURN);
	}


	/**
	 * Tests if the mocked object will be injected
	 */
	@Test
	public void testMockInjected() {
		String stuff = myDao.doStuff();
		System.out.println(stuff);

		assertThat(stuff, is(DEFAULT_MOCK_RETURN));
	}

	public void testDefaultDaoNotInjected() {
		String stuff = myDao.doStuff();
		System.out.println(stuff);

		assertThat(stuff, not(MyDao.DEFAULT_DO_STUFF_RETURN));
	}

}
