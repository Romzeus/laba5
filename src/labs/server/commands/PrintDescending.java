package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Sender;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintDescending implements Executable {
    @Override
    public void execute() {
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        String routes = stream.sorted(Comparator.reverseOrder()).map(Objects::toString).collect(Collectors.joining("\n"));
        Sender.print(routes);
    }
}
