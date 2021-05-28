package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.io.Printer;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class Head extends labs.commands.Head {
    public Head(Printer printer) {
        super(printer);
    }
    @Override
    public void execute() {
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("head")));
        printer.print(Receiver.getArgument());
    }
}
