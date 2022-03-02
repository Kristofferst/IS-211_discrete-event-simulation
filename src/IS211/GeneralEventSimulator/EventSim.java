package IS211.GeneralEventSimulator;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


/**
 * The core class of the discrete event simulation
 *
 * @author evenal
 */
public class EventSim {
    /**
     * The one and only instance, i.e. this is a singleton class
     */
    private static final EventSim theSim = new EventSim();

    /* The queue of events - those that happen earliest first */
    PriorityQueue<Event> eventQueue;

    // The "current" time
    int clock;

    public Random getRandom() {
        return random;
    }

    Random random;


    public static EventSim getInstance() {
        return theSim;
    }


    public static int getClock() {
        return theSim.clock;
    }


    /**
     * @param min for the random number
     * @param max for the random number
     * @return random number in the interval min-max
     * TODO: Consider removing this wrapping.
     */
    public static int nextInt(int min, int max) {
        return min + theSim.random.nextInt(max - min);
    }


    public EventSim() {
        eventQueue = new PriorityQueue<>(new EventTimeComparator());
        random = new Random(42);
    }


    /**
     * Prepare the simulation
     * @param initialEvents a list of "start" events
     */
    public void setup(List<Event> initialEvents) {
        eventQueue.addAll(initialEvents);
    }


    public void addEvent(Event event) {
        if (null == event)
            return;
        eventQueue.add(event);
    }


    /**
     * Run the simulation. Advances the time (clock) to the time when the next
     * event happens, executes the next event, and repeats until the event queue
     * is empty. You can also rewrite this to stop at a predetermined time (e.g.
     * closing time)
     */
    public void run() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            clock = event.getTimeEventHappens();
            addEvent(event.happen());

            System.err.format("Time %d: %s \n    Event queue:\n", clock, event);
            for (Event queuedEvent : eventQueue)
                System.err.println("     "+ queuedEvent.getTimeEventHappens()+": " + queuedEvent);
        }
    }
}
