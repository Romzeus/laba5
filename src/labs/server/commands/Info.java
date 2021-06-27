package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Printer;
import labs.util.io.Sender;

public class Info implements Executable {
    private final labs.commands.Info info;
    public Info(Printer printer) {
        info = new labs.commands.Info(printer);
    }
    @Override
    public void execute() {
        info.execute();
    }
}
