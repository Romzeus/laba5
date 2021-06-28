package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class RemoveId extends labs.commands.RemoveId {
    private final Printer netPrinter;
    public RemoveId(ArgumentProvider<String> argumentProvider, Printer printer, Printer netPrinter) {
        super(argumentProvider, printer);
        this.netPrinter = netPrinter;
    }
    @Override
    public void execute() {
        int id = Integer.parseInt(argumentProvider.getArgument());
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("remove").setId(id)));
    }
}
