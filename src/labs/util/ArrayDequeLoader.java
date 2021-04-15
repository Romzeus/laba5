package labs.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import labs.structures.Route;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.time.LocalDate;

public class ArrayDequeLoader {
    public static final String filepath = System.getenv("SERIALIZED_COLLECTION").replace("\\", "\\\\");
    private static LocalDate initTime;
    private static ArrayDeque<Route> deserialize(InputStreamReader in) {
        Type type = new TypeToken<ArrayDeque<Route>>(){}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(in, type);
    }
    public static void load() {
        try(InputStreamReader in = new InputStreamReader(new FileInputStream(filepath))) {
            ArrayDeque<Route> arrayDeque = deserialize(in);
            for (Route route : arrayDeque) {
                ArrayDequeManager.addElement(route);
            }
        } catch(IOException|NullPointerException e) {
            System.err.println(e.toString());
        } finally {
            initTime = LocalDate.now();
        }
    }
    public static LocalDate getInitTime() {
        return initTime;
    }
}

