package labs.util.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractDeserializer<T> implements Deserializer<T> {
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();
}
