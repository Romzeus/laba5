package labs.util;

import labs.structures.Route;

/**
 * ID generator for new Route objects
 */
public class IdGenerator {
    private static boolean checkId(int id) {
        for(Route route : ArrayDequeManager.getArrayDeque()) {
            if(route.getId() == id)
                return true;
        }
        return false;
    }

    /**
     * Method that generates new ID
     * @return ID value
     */
    public static int getId() {
        int id = 0;
        while(checkId(id)) {
            id++;
        }
        return id;
    }
}
