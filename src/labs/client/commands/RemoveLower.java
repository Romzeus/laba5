package labs.client.commands;

import labs.send.ServerMessage;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class RemoveLower extends labs.commands.RemoveLower {
    private final Printer netPrinter;
    public RemoveLower(ArgumentProvider<String> argumentProvider, Printer netPrinter) {
        super(argumentProvider);
        this.netPrinter = netPrinter;
    }
    @Override
    public void execute() {
        Route route = new RouteMaker(argumentProvider, new ConsolePrinter()).make();
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("remove_lower").setRoute(route)));
    }
}
