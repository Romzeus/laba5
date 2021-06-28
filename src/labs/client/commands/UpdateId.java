package labs.client.commands;

import labs.send.ServerMessage;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class UpdateId extends labs.commands.UpdateId {
    private final Printer netPrinter;
    public UpdateId(ArgumentProvider<String> argumentProvider, Printer printer, Printer netPrinter) {
        super(argumentProvider, printer);
        this.netPrinter = netPrinter;
    }
    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        Route route = new RouteMaker(argumentProvider, printer).make();
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("update").setId(id).setRoute(route)));
    }
}
