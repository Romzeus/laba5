package labs.util.io;

import labs.send.ServerMessage;
import labs.util.serial.GsonDeserializer;

public class Receiver {
    private static Scanner scanner;
    private static final GsonDeserializer<ServerMessage> deserializer = new GsonDeserializer<>();
    public static void setScanner(Scanner scanner) {
        Receiver.scanner = scanner;
    }
    public static String getArgument() {
        return scanner.scan();
    }
    public static ServerMessage getServerMessage() {
        return deserializer.deserialize(getArgument());
    }
}
