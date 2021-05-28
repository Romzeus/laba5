package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class Add extends labs.commands.Add {
    public Add(ArgumentProvider<String> argumentProvider) {
        super(argumentProvider);
    }
    @Override
    public void execute() {
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("add").setRoute(new RouteMaker(argumentProvider, new ConsolePrinter()).make())));
    }
}
