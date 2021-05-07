package labs.commands;

import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

/**
 * Class of head command
 * @author Romzeus
 */
public class Head extends Command{
    private final Printer printer;

    /**
     * Constructor of Head object
     * @param printer Object of Printer interface
     */
    public Head(Printer printer) {
        super("head", "head description");
        this.printer = printer;
    }
    @Override
    public void execute() {
        if(ArrayDequeManager.getArrayDeque().isEmpty())
            return;
        printer.print(ArrayDequeManager.getArrayDeque().getFirst().toString());
    }
}
