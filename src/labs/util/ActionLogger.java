package labs.util;
import java.util.ArrayDeque;
import java.util.Deque;

public class ActionLogger {
    private static Deque<String> history;
    public static void log(String action) {
        if(history.size() == 15)
            history.poll();
        history.add(action);
    }
    public static Deque<String> getHistory() {
        return history;
    }
    static {
        history = new ArrayDeque<>();
    }
}
