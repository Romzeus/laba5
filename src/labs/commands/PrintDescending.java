package labs.commands;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;
import java.util.Arrays;

/**
 * Class for print_descending command
 * @author Romzeus
 */
public class PrintDescending extends Command{
    protected final Printer printer;

    /**
     * Constructor of PrintDescending object
     * @param printer Object of Printer interface
     */
    public PrintDescending(Printer printer) {
        super("print_descending", "print_descending_description");
        this.printer = printer;
    }
    @Override
    public void execute() {
        Route[] routes = ArrayDequeManager.getArrayDeque().toArray(new Route[0]);
        Arrays.sort(routes);
        for(int i = routes.length - 1; i >= 0; i--) {
            printer.print(routes[i].toString());
        }
    }
}
