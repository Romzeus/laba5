package labs.commands;

import labs.util.ArrayDequeLoader;
import labs.util.ArrayDequeManager;

public class Info extends Command{
    public Info() {
        super("info", "Выводит информацию о коллекции");
    }
    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + ArrayDequeManager.getArrayDeque().getClass().toString());
        System.out.println("Тип элементов коллекции: " + ArrayDequeManager.getArrayDeque().getFirst().getClass().toString());
        System.out.println("Время инициализации: " + ArrayDequeLoader.getInitTime());
    }
}
