package labs.server.commands;

import labs.commands.Executable;
import labs.send.ClientMessage;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.serial.Serializer;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintDescending implements Executable {
    private final Printer printer;
    public PrintDescending(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void execute() {
        Stream<Route> stream = ArrayDequeManager.getArrayDeque().stream();
        String[][] result = (String[][])(stream.sorted(Comparator.reverseOrder()).map(this::unfold).toArray());
        printer.print(Serializer.serialize(new ClientMessage(true, result)));
    }
    private String[] unfold(Route route) {
        return new String[]{route.getName(), route.getCreationDate().toString(), String.valueOf(route.getDistance()),
                String.valueOf(route.getCoordinates().getX()), String.valueOf(route.getCoordinates().getY()),
                route.getLocation().getName(), String.valueOf(route.getLocation().getX()), String.valueOf(route.getLocation().getY())};
    }
}
