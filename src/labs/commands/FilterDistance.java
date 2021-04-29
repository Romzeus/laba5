package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

import java.util.Iterator;

public class FilterDistance extends Command{
    private ArgumentProvider argumentProvider;
    private Printer printer;
    public FilterDistance(ArgumentProvider argumentProvider, Printer printer) {
        super("filter_less_than_distance", "Выводит элементы, значение поля distance которых меньше заданного");
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
