package labs.client.commands;

import labs.send.ServerMessage;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class UpdateId extends labs.commands.UpdateId {
    public UpdateId(ArgumentProvider<String> argumentProvider, Printer printer) {
        super(argumentProvider, printer);
    }

    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        Route route = new RouteMaker(argumentProvider, printer).make();
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("update").setId(id).setRoute(route)));
    }
}
