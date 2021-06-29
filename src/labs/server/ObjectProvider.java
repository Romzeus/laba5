package labs.server;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Receiver;
import labs.util.io.Scanner;
import labs.util.serial.GsonDeserializer;

import java.util.ArrayDeque;
import java.util.Deque;

public class ObjectProvider implements ArgumentProvider<Object> {
    private final Scanner netScanner;
    private final GsonDeserializer deserializer = new GsonDeserializer();
    public ObjectProvider(Scanner netScanner) {
        this.netScanner = netScanner;
    }
    private final Deque<Object> arguments = new ArrayDeque<>();
    @Override
    public Object getArgument() {
        prepare();
        return arguments.poll();
    }
    @Override
    public boolean hasNext() {
        return !arguments.isEmpty();
    }
    @Override
    public Deque<Object> getAll() {
        prepare();
        return arguments;
    }
    @Override
    public void addArguments(Deque<Object> arguments) {
        this.arguments.addLast(arguments);
    }
    public void prepare() {
        if(arguments.isEmpty()) {
            ServerMessage message = deserializer.deserialize(netScanner.scan());
            arguments.add(message.getToken());
            if(message.getId() != null)
                arguments.add(message.getId());
            if(message.getDistance() != null)
                arguments.add(message.getDistance());
            if(message.getName() != null)
                arguments.add(message.getName());
            if(message.getRoute() != null)
                arguments.add(message.getRoute());
        }
    }
}
