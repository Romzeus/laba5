package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class Add extends labs.commands.Add {
    private final Printer printer;
    public Add(ArgumentProvider<String> argumentProvider, Printer printer) {
        super(argumentProvider);
        this.printer = printer;
    }
    @Override
    public void execute() {
        printer.print(Serializer.serialize(new ServerMessage().setServerToken("add").setRoute(new RouteMaker(argumentProvider, new ConsolePrinter()).make())));
    }
}
