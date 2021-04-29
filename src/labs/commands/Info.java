package labs.commands;

import labs.util.ArrayDequeLoader;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

/**
 * Class of info command
 * @author Romzeus
 */
public class Info extends Command{
    private final Printer printer;

    /**
     * Constructor of Info class
     * @param printer Object of Printer interface
     */
    public Info(Printer printer) {
        super("info", "info description");
        this.printer = printer;
    }
    @Override
    public void execute() {
        printer.print("Collection type");
        printer.print(ArrayDequeManager.getArrayDeque().getClass().toString());
        printer.print("Collection element type");
        if(ArrayDequeManager.getArrayDeque().isEmpty())
            printer.print("No elements");
        else
            printer.print(ArrayDequeManager.getArrayDeque().getFirst().getClass().toString());
        printer.print("Init time");
        printer.print(ArrayDequeLoader.getInitTime().toString());
    }
}
