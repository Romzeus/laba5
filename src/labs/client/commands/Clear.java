package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class Clear extends labs.commands.Clear {
    private final Printer printer;
    public Clear(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void execute() {
        printer.print(Serializer.serialize(new ServerMessage().setServerToken("clear")));
    }
}
