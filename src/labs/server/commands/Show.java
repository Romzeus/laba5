package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Sender;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Show implements Executable {
    @Override
    public void execute() {
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        String result = stream.map(Objects::toString).collect(Collectors.joining("\n"));
        Sender.print(result);
    }
}
