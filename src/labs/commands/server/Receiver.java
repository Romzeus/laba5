package labs.commands.server;

import labs.commands.send.ExecutableMessage;
import labs.commands.send.MessageRoute;
import labs.util.io.Scanner;
import labs.util.serial.ExecutableMessageDeserializer;
import labs.util.serial.MessageRouteDeserializer;

public class Receiver {
    private final Scanner scanner;
    private final MessageRouteDeserializer messageRouteDeserializer = new MessageRouteDeserializer();
    private final ExecutableMessageDeserializer executableMessageDeserializer = new ExecutableMessageDeserializer();
    public Receiver(Scanner scanner) {
        this.scanner = scanner;
    }
    public String getArgument() {
        return scanner.scan();
    }
    public MessageRoute getMessageRoute() {
        return messageRouteDeserializer.deserialize(getArgument());
    }
    public ExecutableMessage getExecutableMessage() {
        return executableMessageDeserializer.deserialize(getArgument());
    }
}
