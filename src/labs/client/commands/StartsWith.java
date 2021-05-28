package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class StartsWith extends labs.commands.StartsWith {
    public StartsWith(ArgumentProvider<String> argumentProvider, Printer printer) {
        super(argumentProvider, printer);
    }

    @Override
    public void execute() {
        String name = argumentProvider.getArgument();
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("filter_starts_with_name").setName(name)));
        printer.print(Receiver.getArgument());
    }
}
