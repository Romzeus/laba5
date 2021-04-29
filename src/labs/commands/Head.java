package labs.commands;

import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

public class Head extends Command{
    private Printer printer;
    public Head(Printer printer) {
        super("head", "Выводит первый элемент коллекции");
        this.printer = printer;
    }
    @Override
    public void execute() {
        if(ArrayDequeManager.getArrayDeque().isEmpty())
            return;
        printer.print(ArrayDequeManager.getArrayDeque().getFirst().toString());
    }
}
