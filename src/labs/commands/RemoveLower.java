package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;
import java.util.Iterator;

/**
 * Class of remove_lower command
 * @author Romzeus
 */
public class RemoveLower extends Command{
    private final ArgumentProvider argumentProvider;

    /**
     * Constructor of RemoveLower object
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments
     */
    public RemoveLower(ArgumentProvider argumentProvider) {
        super("remove_lower", "remove_lower description");
        this.argumentProvider = argumentProvider;
    }
    @Override
    public void execute() {
        Route route = new RouteMaker(argumentProvider, new ConsolePrinter()).make();
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.compareTo(route) < 0)
                ArrayDequeManager.delete(current.getId());
        }
    }
}
