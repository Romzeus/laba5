package labs.util.serial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import labs.send.ServerMessage;

import java.lang.reflect.Type;

public class GsonDeserializer implements Deserializer<ServerMessage> {
    protected final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    protected final Type type = new TypeToken<ServerMessage>(){}.getType();
    public ServerMessage deserialize(String object) {
        return gson.fromJson(object, type);
    }
}
