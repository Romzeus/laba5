package labs.commands;

import labs.util.ArgumentParser;
import labs.util.ArrayDequeManager;

public class RemoveId extends Command{
    public RemoveId() {
        super("remove_by_id", "удаляет элемент из коллекции по id");
    }
    @Override
    public void execute() {
        int id;
        try {
        id = Integer.parseInt(ArgumentParser.getArgument());
        } catch(NullPointerException|NumberFormatException exception) {
            System.out.println("Неправильный формат ввода id");
            return;
        }
        try {
        ArrayDequeManager.delete(id);
        } catch(IllegalArgumentException exception) {
            System.out.println("Нет элемента с таким id");
        }
    }
}
