package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class Head extends labs.commands.Head {
    private Printer netPrinter;
    private ArgumentProvider<String> netProvider;
    public Head(Printer printer, Printer netPrinter, ArgumentProvider<String> netProvider) {
        super(printer);
        this.netPrinter = netPrinter;
        this.netProvider = netProvider;
    }
    @Override
    public void execute() {
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("head")));
        printer.print(netProvider.getArgument());
    }
}
