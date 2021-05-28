package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.io.Printer;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class Show extends labs.commands.Show {
    public Show(Printer printer) {
        super(printer);
    }
    @Override
    public void execute() {
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("show")));
        printer.print(Receiver.getArgument());
    }
}
