package labs.server.commands;

import labs.commands.Executable;
import labs.server.Sender;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartsWith implements Executable {
    private final ArgumentProvider<Object> provider;
    public StartsWith(ArgumentProvider<Object> provider) {
        this.provider = provider;
    }

    @Override
    public void execute() {
        String starter = (String) provider.getArgument();
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        String result = stream.filter(x -> x.getName().startsWith(starter)).map(Objects::toString).collect(Collectors.joining());
        Sender.print(result);
    }
}
