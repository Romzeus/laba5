package labs.server.commands;

import labs.commands.Executable;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveLower implements Executable {
    private ArgumentProvider<Object> provider;
    public RemoveLower(ArgumentProvider<Object> provider) {
        this.provider = provider;
    }

    @Override
    public void execute() {
        Route route = (Route) provider.getArgument();
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        ArrayDeque<Route> routes = stream.filter(x -> (x.compareTo(route) >= 0)).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDequeManager.clear();
        for(Route r : routes)
            ArrayDequeManager.addElement(r);
    }
}
