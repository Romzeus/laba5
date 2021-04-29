package labs.commands;

import labs.util.ActionLogger;
import labs.util.io.Printer;

import java.util.Iterator;

public class History extends Command{
    private Printer printer;
    public History(Printer printer) {
        super("history", "Выводит последние 15 команд без их аргументов");
        this.printer = printer;
    }
    @Override
    public void execute() {
        Iterator<String> iterator = ActionLogger.getHistory().descendingIterator();
        while(iterator.hasNext()) {
            printer.print(iterator.next());
        }
    }
}
