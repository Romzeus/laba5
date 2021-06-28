package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Printer;
import labs.util.io.Printer;
import labs.structures.Route;
import labs.util.ArrayDequeManager;

public class Head implements Executable {
    private Printer printer;
    public Head(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void execute() {
        Route head = ArrayDequeManager.getArrayDeque().peek();
        String message;
        if(head != null)
            message = head.toString();
        else
            message = "No elements";
        printer.print(message);
    }
}
