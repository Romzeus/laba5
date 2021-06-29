package labs.commands;

import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

/**
 * Class of show command
 * @author Romzeus
 */
public class Show extends Command{
    protected final Printer printer;

    /**
     * Constructor of Show object
     * @param printer Object of Printer interface
     */
    public Show(Printer printer) {
        super("show", "show_description");
        this.printer = printer;
    }
    @Override
    public void execute() {
        try {
            for (Route route : ArrayDequeManager.getArrayDeque()) {
                printer.print(route.toString());
            }
        } catch(NullPointerException e) {
            printer.print(e.toString());
        }
    }
}
