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

	/**
	 * This method has no qualifier. Thus it should receive all string events(Event<String>), even those with qualifier.
	 *
	 * @param event the observed event
	 */
	void observeString(@Observes String event) {
		observedEvent = event;
	}

	/**
	 * This method has the @Named qualifier. Only string events where the @Named value is "Anne" will be received.
	 *
	 * @param event the observed event
	 */
	void observesAnneNamedString(@Observes @Named("Anne") String event) {
		observedAnneEvent = event;
	}

	/**
	 * This method has the @Named qualifier. Only string events where the @Named value is "John" will be received.
	 *
	 * @param event the observed event
	 */
	void observesJohnNamedString(@Observes @Named("John") String event) {
		observedJohnEvent = event;
	}

	/**
	 * This method has the @Named and @MyNamed qualifier. Only string events where the @Named value is "John" will be received.
	 * Note, that the @MyNamed annotation must be present on the firing event, but its value doesnt matter. This is because the
	 * value of @MyNamed annotation is marked with @Nonbinding.
	 * Events received by this method should also be received by the observesJohnNamedString method, since it also has a matching
	 * {@literal @}Named qualifier.
	 *
	 * @param event the observed event
	 */
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
