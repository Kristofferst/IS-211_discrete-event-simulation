package eventsim;


/**
 * BAse class for events
 *
 * @author evenal
 */
public abstract class Event {
    int timeEventHappens;


    public Event(int timeOfEvent) {
        this.timeEventHappens = timeOfEvent;
    }


    public int getTimeEventHappens() {
        return timeEventHappens;
    }

    /**
     * Make the changes to the simulated supermarket that happens as a
     * consequence of this event.
     *
     * @return an event that will happen later as a consequence of this, or null
     * if it does not cause any event. You can change the return type to a list
     * of events, if an event could cause more than one event to happen later.
     */
    public abstract Event happen();
}
