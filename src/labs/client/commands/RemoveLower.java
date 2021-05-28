package labs.client.commands;

import labs.send.ServerMessage;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class RemoveLower extends labs.commands.RemoveLower {
    public RemoveLower(ArgumentProvider<String> argumentProvider) {
        super(argumentProvider);
    }
    @Override
    public void execute() {
        Route route = new RouteMaker(argumentProvider, new ConsolePrinter()).make();
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("remove_lower").setRoute(route)));
    }
}
