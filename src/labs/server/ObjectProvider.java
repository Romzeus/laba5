package labs.server;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Receiver;
import java.util.ArrayDeque;
import java.util.Deque;

public class ObjectProvider implements ArgumentProvider<Object> {
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
            ServerMessage message = Receiver.getServerMessage();
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
