package oberservers;

import at.bayava.dao.at.bayava.oberservers.MyObserver;
import at.bayava.qualifiers.MyNamed;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(CdiRunner.class)
public class MyObserverTest {

	@Inject
	MyObserver myObserver;

	@Inject
	Event<String> unnamedEvent;

	@Inject
	@Named("Anne")
	Event<String> anneEvent;

	@Inject
	@Named("John")
	Event<String> johnEvent;

	@Inject
	@Named("John")
	//note how the value is different from the observer method
	@MyNamed("whatverIdontCare")
	Event<String> johnMyNamedEvent;

	/**
	 * Tests if only the appropriate methods received the event.
	 *
	 * @throws Exception
	 */
	@Test
	public void testObserveString() throws Exception {
		unnamedEvent.fire("unnamedEvent");
		//Default receiver for string events, should always be fired
		assertThat(myObserver.getObservedEvent(), is("unnamedEvent"));
		//no other event should have been fired
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
		assertThat(myObserver.getObservedJohnEvent(), nullValue());
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	/**
	 * Tests if only the appropriate methods received the event.
	 *
	 * @throws Exception
	 */
	@Test
	public void testObservesAnneNamedString() throws Exception {
		anneEvent.fire("anneEvent");
		//Default receiver for string events, should always be fired
		assertThat(myObserver.getObservedEvent(), is("anneEvent"));
		assertThat(myObserver.getObservedAnneEvent(), is("anneEvent"));
		//no other event should have been fired
		assertThat(myObserver.getObservedJohnEvent(), nullValue());
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	/**
	 * Tests if only the appropriate methods received the event.
	 *
	 * @throws Exception
	 */
	@Test
	public void testObservesJohnNamedString() throws Exception {
		johnEvent.fire("johnEvent");
		//Default receiver for string events, should always be fired
		assertThat(myObserver.getObservedEvent(), is("johnEvent"));
		assertThat(myObserver.getObservedJohnEvent(), is("johnEvent"));
		//no other event should have been fired
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	/**
	 * Tests if only the appropriate methods received the event.
	 *
	 * @throws Exception
	 */
	@Test
	public void testObservesJohnMyNamedString() throws Exception {
		johnMyNamedEvent.fire("johnMyNamedEvent");
		//Default receiver for string events, should always be fired
		assertThat(myObserver.getObservedEvent(), is("johnMyNamedEvent"));
		//test if the event was fired, even though the @MyNamed value doesnt match
		assertThat(myObserver.getObservedJohnMyNamedEvent(), is("johnMyNamedEvent"));
		//John event should also have been fired, since the @Named value matches
		assertThat(myObserver.getObservedJohnEvent(), is("johnMyNamedEvent"));
		//no other event should have been fired
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
	}
}