package labs.commands;

import labs.util.ArrayDequeLoader;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

public class Info extends Command{
    private Printer printer;
    public Info(Printer printer) {
        super("info", "Выводит информацию о коллекции");
        this.printer = printer;
    }
    @Override
    public void execute() {
        printer.print("Тип коллекции: " + ArrayDequeManager.getArrayDeque().getClass().toString());
        printer.print("Тип элементов коллекции: ");
        if(ArrayDequeManager.getArrayDeque().isEmpty())
            printer.print("Нет элементов");
        else
            printer.print(ArrayDequeManager.getArrayDeque().getFirst().getClass().toString());
        printer.print("Время инициализации: " + ArrayDequeLoader.getInitTime());
    }
}
