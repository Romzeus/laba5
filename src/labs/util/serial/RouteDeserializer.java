package labs.util.serial;

import com.google.gson.reflect.TypeToken;
import labs.structures.Route;
import java.lang.reflect.Type;

public class RouteDeserializer extends AbstractDeserializer<Route> {
    private final Type type = new TypeToken<Route>(){}.getType();
    @Override
    public Route deserialize(String serializedObject) {
        return gson.fromJson(serializedObject, type);
    }
}
