package labs.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import labs.send.ClientMessage;
import labs.util.io.Receiver;
import labs.util.serial.Deserializer;
import java.lang.reflect.Type;
import java.util.ArrayDeque;

public class MessageReceiver {
    private static ArrayDeque<ClientMessage> arguments = new ArrayDeque<>();
    private static Deserializer<ClientMessage> deserializer = new Deserializer<ClientMessage>() {
        private final Type type = new TypeToken<ClientMessage>(){}.getType();
        private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        @Override
        public ClientMessage deserialize(String serializedObject) {
            return gson.fromJson(serializedObject, type);
        }
    };
    private static void prepare() {
        arguments.add(deserializer.deserialize(Receiver.getArgument()));
    }
    public static ClientMessage scan() {
        return arguments.poll();
    }
}
