package labs.commands;

import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;

import java.util.Iterator;

public class RemoveLower extends Command{
    public RemoveLower() {
        super("remove_lower", "Удаляет из коллекции элементы, меньшие заданного");
    }
    @Override
    public void execute() {
        Route route = new RouteMaker().make();
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.compareTo(route) < 0)
                ArrayDequeManager.delete(current.getId());
        }
    }
}
