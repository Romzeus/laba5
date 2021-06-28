package labs.client.commands;

import labs.commands.Command;
import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class FilterDistance extends Command {
    private final ArgumentProvider<String> argumentProvider;
    private final Printer printer;
    private final Printer netPrinter;
    private final ArgumentProvider<String> netProvider;
    public FilterDistance(ArgumentProvider<String> argumentProvider, Printer printer, Printer netPrinter, ArgumentProvider<String> netProvider) {
        super("filter_less_than_distance", "filter_less_than_distance description");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
        this.netPrinter = netPrinter;
        this.netProvider = netProvider;
    }
    @Override
    public void execute() {
        float distance = Float.parseFloat(argumentProvider.getArgument());
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("filter_less_than_distance").setDistance(distance)));
        printer.print(netProvider.getArgument());
    }
}
