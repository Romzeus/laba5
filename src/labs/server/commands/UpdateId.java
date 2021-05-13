package labs.server.commands;

import labs.commands.Executable;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import java.util.stream.Stream;

public class UpdateId implements Executable {
    private final ArgumentProvider<Object> provider;
    public UpdateId(ArgumentProvider<Object> provider) {
        this.provider = provider;
    }
    @Override
    public void execute() {
        int id = (Integer) provider.getArgument();
        Route route = (Route) provider.getArgument();
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        ArrayDequeManager.clear();
        stream.map(x -> x.getId() == id ? route : x).forEach(ArrayDequeManager::addElement);
    }
}
