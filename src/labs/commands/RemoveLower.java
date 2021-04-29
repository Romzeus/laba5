package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;

import java.util.Iterator;

public class RemoveLower extends Command{
    private ArgumentProvider argumentProvider;
    public RemoveLower(ArgumentProvider argumentProvider) {
        super("remove_lower", "Удаляет из коллекции элементы, меньшие заданного");
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
