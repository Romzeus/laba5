package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeManager;

import java.util.Iterator;

public class FilterDistance extends Command{
    public FilterDistance() {
        super("filter_less_than_distance", "Выводит элементы, значение поля distance которых меньше заданного");
    }
    @Override
    public void execute() {
        float distance = Float.parseFloat(ArgumentParser.getArgument());
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.getDistance() < distance)
                System.out.println(current.toString());
        }
    }
}
