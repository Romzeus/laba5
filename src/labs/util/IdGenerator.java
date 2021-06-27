package labs.util;

import labs.send.ServerMessage;
import labs.structures.Route;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

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
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("get_id")));
        return Integer.parseInt(Receiver.getArgument());
    }
}
