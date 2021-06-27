package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterDistance implements Executable {
    private Printer printer;
    private final ArgumentProvider<Object> provider;
    public FilterDistance(ArgumentProvider<Object> provider, Printer printer) {
        this.provider = provider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        Float distance = (Float) provider.getArgument();
        String routes;
        routes = stream.sorted().filter(x -> x.getDistance() < distance).map(Objects::toString).collect(Collectors.joining("\n"));
        printer.print(routes);
    }
}
