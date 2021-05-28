package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class RemoveId extends labs.commands.RemoveId {
    public RemoveId(ArgumentProvider<String> argumentProvider, Printer printer) {
        super(argumentProvider, printer);
    }
    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("remove").setId(id)));
    }
}
