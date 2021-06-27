package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.util.IdGenerator;

public class GetId implements Executable {
    private Printer printer;
    public GetId(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void execute() {
        printer.print(Integer.toString(IdGenerator.getId()));
    }
}
