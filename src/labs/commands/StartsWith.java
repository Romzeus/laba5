package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

import java.util.Iterator;

public class StartsWith extends Command{
    private Printer printer;
    public StartsWith(Printer printer) {
        super("filter_starts_with_name", "Выводит элементы, значение поля name которых начинается с заданной подстроки");
        this.printer = printer;
    }
    @Override
    public void execute() {
        String name = ArgumentParser.getArgument();
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.getName().startsWith(name))
                printer.print(current.toString());
        }
    }
}
