package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;
import java.util.Iterator;

/**
 * Class of filter_starts_with_name command
 */
public class StartsWith extends Command{
    private Printer printer;
    private ArgumentProvider argumentProvider;
    /**
     * Constructor of StartsWith object
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments
     * @param printer Object of Printer interface
     */
    public StartsWith(ArgumentProvider argumentProvider, Printer printer) {
        super("filter_starts_with_name", "filter_starts_with_name description");
        this.printer = printer;
        this.argumentProvider = argumentProvider;
    }
    @Override
    public void execute() {
        String name = argumentProvider.getArgument();
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.getName().startsWith(name))
                printer.print(current.toString());
        }
    }
}
