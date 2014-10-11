package at.bayava.dao.at.bayava.oberservers;

import at.bayava.qualifiers.MyNamed;

import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pbayer.
 */
@Singleton
public class MyObserver {

	String observedEvent;

	String observedJohnEvent;

	String observedAnneEvent;

	String observedJohnMyNamedEvent;

	void observeString(@Observes String event) {
		observedEvent = event;
	}

	void observesAnneNamedString(@Observes @Named("Anne") String event) {
		observedAnneEvent = event;
	}

	void observesJohnNamedString(@Observes @Named("John") String event) {
		observedJohnEvent = event;
	}

	void observesJohnAnneNamedString(@Observes @Named("John") @MyNamed("xxx") String event) {
		observedJohnMyNamedEvent = event;
	}

	public String getObservedEvent() {
		return observedEvent;
	}

	public String getObservedAnneEvent() {
		return observedAnneEvent;
	}

	public String getObservedJohnEvent() {
		return observedJohnEvent;
	}

	public String getObservedJohnMyNamedEvent() {
		return observedJohnMyNamedEvent;
	}
}
