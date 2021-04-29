package labs.commands;

import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

public class RemoveId extends Command{
    private ArgumentProvider argumentProvider;
    private Printer printer;
    public RemoveId(ArgumentProvider argumentProvider, Printer printer) {
        super("remove_by_id", "удаляет элемент из коллекции по id");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        int id;
        try {
        id = Integer.parseInt(argumentProvider.getArgument());
        } catch(NullPointerException|NumberFormatException exception) {
            printer.print("Неправильный формат ввода id");
            return;
        }
        try {
        ArrayDequeManager.delete(id);
        } catch(IllegalArgumentException exception) {
            printer.print("Нет элемента с таким id");
        }
    }
}
