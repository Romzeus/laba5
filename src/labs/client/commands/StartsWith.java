package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class StartsWith extends labs.commands.StartsWith {
    private final Printer netPrinter;
    private final ArgumentProvider<String> netProvider;
    public StartsWith(ArgumentProvider<String> argumentProvider, Printer printer, Printer netPrinter, ArgumentProvider<String> netProvider) {
        super(argumentProvider, printer);
        this.netPrinter = netPrinter;
        this.netProvider = netProvider;
    }
    @Override
    public void execute() {
        String name = argumentProvider.getArgument();
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("filter_starts_with_name").setName(name)));
        printer.print(netProvider.getArgument());
    }
}
