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
	@MyNamed("whatverIdontCare")
	Event<String> johnMyNamedEvent;

	@Test
	public void testObserveString() throws Exception {
		unnamedEvent.fire("unnamedEvent");
		assertThat(myObserver.getObservedEvent(), is("unnamedEvent"));
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
		assertThat(myObserver.getObservedJohnEvent(), nullValue());
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	@Test
	public void testObservesAnneNamedString() throws Exception {
		anneEvent.fire("anneEvent");
		assertThat(myObserver.getObservedEvent(), is("anneEvent"));
		assertThat(myObserver.getObservedAnneEvent(), is("anneEvent"));
		assertThat(myObserver.getObservedJohnEvent(), nullValue());
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	@Test
	public void testObservesJohnNamedString() throws Exception {
		johnEvent.fire("johnEvent");
		assertThat(myObserver.getObservedEvent(), is("johnEvent"));
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
		assertThat(myObserver.getObservedJohnEvent(), is("johnEvent"));
		assertThat(myObserver.getObservedJohnMyNamedEvent(), nullValue());
	}

	@Test
	public void testObservesJohnMyNamedString() throws Exception {
		johnMyNamedEvent.fire("johnMyNamedEvent");
		assertThat(myObserver.getObservedEvent(), is("johnMyNamedEvent"));
		assertThat(myObserver.getObservedAnneEvent(), nullValue());
		assertThat(myObserver.getObservedJohnEvent(), is("johnMyNamedEvent"));
		assertThat(myObserver.getObservedJohnMyNamedEvent(), is("johnMyNamedEvent"));
	}
}