package labs.commands;

import labs.structures.Route;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeManager;

import java.util.Iterator;

public class StartsWith extends Command{
    public StartsWith() {
        super("filter_starts_with_name", "Выводит элементы, значение поля name которых начинается с заданной подстроки");
    }
    @Override
    public void execute() {
        String name = ArgumentParser.getArgument();
        Route current;
        Iterator<Route> iterator = ArrayDequeManager.getArrayDeque().iterator();
        while(iterator.hasNext()) {
            current = iterator.next();
            if(current.getName().startsWith(name))
                System.out.println(current.toString());
        }
    }
}
