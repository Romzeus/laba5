package labs.util;
import java.util.ArrayDeque;
import java.util.Deque;

public class ActionLogger {
    private static final Deque<String> history = new ArrayDeque<>();
    public static void log(String action) {
        if(history.size() == 15)
            history.poll();
        history.add(action);
    }
    public static Deque<String> getHistory() {
        return history;
    }
}
