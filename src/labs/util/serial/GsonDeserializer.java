package labs.util.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GsonDeserializer<T> implements Deserializer<T> {
    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    protected final Type type = new TypeToken<T>(){}.getType();
    public T deserialize(String object) {
        return gson.fromJson(object, type);
    }
}
