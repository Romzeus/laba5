package labs.client.commands;

import labs.commands.Command;
import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class FilterDistance extends Command {
    private final ArgumentProvider<String> argumentProvider;
    private final Printer printer;
    public FilterDistance(ArgumentProvider<String> argumentProvider, Printer printer) {
        super("filter_less_than_distance", "filter_less_than_distance description");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        float distance = Float.parseFloat(argumentProvider.getArgument());
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("filter_less_than_distance").setDistance(distance)));
        printer.print(Receiver.getArgument());
    }
}
