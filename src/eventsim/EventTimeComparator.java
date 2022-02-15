package eventsim;

import java.util.Comparator;


/**
 * This is used by the priority queue to compare events
 *
 * @author evenal
 */
public class EventTimeComparator
        implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
        return e1.timeEventHappens - e2.timeEventHappens;
    }

}
