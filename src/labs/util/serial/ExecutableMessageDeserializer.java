package labs.util.serial;

import com.google.gson.reflect.TypeToken;
import labs.commands.send.ExecutableMessage;
import java.lang.reflect.Type;

public class ExecutableMessageDeserializer extends AbstractDeserializer<ExecutableMessage> {
    private final Type type = new TypeToken<ExecutableMessage>(){}.getType();
    @Override
    public ExecutableMessage deserialize(String serializedObject) {
        return gson.fromJson(serializedObject, type);
    }
}
