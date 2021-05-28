package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.io.Printer;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.serial.Serializer;

public class PrintDescending extends labs.commands.PrintDescending {
    public PrintDescending(Printer printer) {
        super(printer);
    }
    @Override
    public void execute() {
        Sender.print(Serializer.serialize(new ServerMessage().setServerToken("print_descending")));
        printer.print(Receiver.getArgument());
    }
}
