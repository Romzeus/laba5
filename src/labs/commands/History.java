package labs.commands;

import labs.util.ActionLogger;

import java.util.Iterator;

public class History extends Command{
    public History() {
        super("history", "Выводит последние 15 команд без их аргументов");
    }
    @Override
    public void execute() {
        Iterator<String> iterator = ActionLogger.getHistory().descendingIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
