package labs.util.serial;

import com.google.gson.reflect.TypeToken;
import labs.send.MessageRoute;
import java.lang.reflect.Type;

public class MessageRouteDeserializer extends GsonDeserializer<MessageRoute> {
    private final Type type = new TypeToken<MessageRoute>(){}.getType();
    @Override
    public MessageRoute deserialize(String serializedObject) {
        return gson.fromJson(serializedObject, type);
    }
}
