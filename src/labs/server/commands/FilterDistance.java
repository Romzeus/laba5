package labs.server.commands;

import labs.commands.Executable;
import labs.send.ClientMessage;
import labs.util.io.Printer;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.serial.Serializer;
import java.util.stream.Stream;

public class FilterDistance implements Executable {
    private final Printer printer;
    private final ArgumentProvider<Object> provider;
    public FilterDistance(ArgumentProvider<Object> provider, Printer printer) {
        this.provider = provider;
        this.printer = printer;
    }
    private String[] unfold(Route route) {
        return new String[]{route.getName(), route.getCreationDate().toString(), String.valueOf(route.getDistance()),
        String.valueOf(route.getCoordinates().getX()), String.valueOf(route.getCoordinates().getY()),
        route.getLocation().getName(), String.valueOf(route.getLocation().getX()), String.valueOf(route.getLocation().getY())};
    }
    @Override
    public void execute() {
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        Float distance = (Float) provider.getArgument();
        String[][] result = (String[][])(stream.sorted().filter(x -> x.getDistance() < distance).map(this::unfold).toArray());
        printer.print(Serializer.serialize(new ClientMessage(true, result)));
    }
}
