package labs.client.commands;

import labs.send.ServerMessage;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class PrintDescending extends labs.commands.PrintDescending {
    private final Printer netPrinter;
    private final ArgumentProvider<String> netProvider;
    public PrintDescending(Printer printer, Printer netPrinter, ArgumentProvider<String> netProvider) {
        super(printer);
        this.netPrinter = netPrinter;
        this.netProvider = netProvider;
    }
    @Override
    public void execute() {
        netPrinter.print(Serializer.serialize(new ServerMessage().setServerToken("print_descending")));
        printer.print(netProvider.getArgument());
    }
}
