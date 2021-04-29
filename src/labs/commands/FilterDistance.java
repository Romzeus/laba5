package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;
import java.util.Iterator;

/**
 * Class for filter_less_than_distance command
 * @author Romzeus
 */
public class FilterDistance extends Command{
    private ArgumentProvider argumentProvider;
    private Printer printer;

    /**
     *Constructor of FilterDistance object
     * @param argumentProvider Object of ArgumentProvider interface
     * @param printer Object of Printer interface
     */
    public FilterDistance(ArgumentProvider argumentProvider, Printer printer) {
        super("filter_less_than_distance", "filter_less_than_distance description");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        float distance = Float.parseFloat(argumentProvider.getArgument());
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.getDistance() < distance)
                printer.print(current.toString());
        }
    }
}
