package labs.util;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Logger of user actions
 * @author Romzeus
 */
public class ActionLogger {
    private static final Deque<String> history = new ArrayDeque<>();

    /**
     * Method that logs actions
     * @param action String representative of action
     */
    public static void log(String action) {
        if(history.size() == 15)
            history.poll();
        history.add(action);
    }

    /**
     * Method that provides history of actions
     * @return String Deque containing String representatives of last 15 actions
     */
    public static Deque<String> getHistory() {
        return history;
    }
}
