package labs.util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import labs.structures.Route;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.time.LocalDate;

public class ArrayDequeLoader {
    public static final String filepath = System.getenv("SERIALIZED_COLLECTION").replace("\\", "\\\\");
    private static LocalDate initTime;
    private static class Deserializer {
        static Gson gson = new Gson();
        static ArrayDeque<Route> deserialize(InputStreamReader in) {
            Type type = new TypeToken<ArrayDeque<Route>>(){}.getType();
            return gson.fromJson(in, type);
        }
    }
    public static void load() {
        try(InputStreamReader in = new InputStreamReader(new FileInputStream(filepath))) {
            ArrayDeque<Route> arrayDeque = Deserializer.deserialize(in);
            for(Route route : arrayDeque)
                ArrayDequeManager.addElement(route);
        } catch(IOException e) {
            System.err.println(e.toString());
        } finally {
            initTime = LocalDate.now();
        }
    }
    public static LocalDate getInitTime() {
        return initTime;
    }
}

