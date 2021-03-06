package labs.util;
import labs.structures.Route;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Class responsible for managing collection of Route instances
 * @author Romzeus
 */
public class ArrayDequeManager {
    private final static ArrayDeque<Route> arrayDeque = new ArrayDeque<>();

    /**
     * Method for adding new Route instances
     * @param route new Route instance
     */
    public static void addElement(Route route) {
        arrayDeque.add(route);
    }

    /**
     * Method for clearing collection
     */
    public static void clear() {
        arrayDeque.clear();
    }

    /**
     * Method that returns collection in current state
     * @return ArrayDeque of Route instances
     */
    public static ArrayDeque<Route> getArrayDeque() {
        return arrayDeque;
    }

    /**
     * Method that allows to delete Route instances from collection by their id
     * @param id id value of Route instance to delete
     */
    public static void delete(int id) {
        Route route;
        Iterator<Route> iterator = arrayDeque.iterator();
        while(iterator.hasNext()) {
            route = iterator.next();
            if(route.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
