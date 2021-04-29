package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

import java.util.Iterator;

public class StartsWith extends Command{
    private Printer printer;
    private ArgumentProvider argumentProvider;
    public StartsWith(ArgumentProvider argumentProvider, Printer printer) {
        super("filter_starts_with_name", "Выводит элементы, значение поля name которых начинается с заданной подстроки");
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
