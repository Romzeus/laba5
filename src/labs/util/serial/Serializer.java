package labs.util.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serializer{
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static String serialize(Object object) {
        return gson.toJson(object);
    }
}
