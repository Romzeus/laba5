package labs.util;
import labs.structures.Route;
import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeManager {
    private static ArrayDeque<Route> arrayDeque = new ArrayDeque<>();
    public static void addElement(Route route) {
        arrayDeque.add(route);
    }
    public static void clear() {
        arrayDeque.clear();
    }
    public static ArrayDeque<Route> getArrayDeque() {
        return arrayDeque;
    }
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
