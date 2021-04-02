package labs.commands;

import labs.util.ArrayDequeManager;

public class Head extends Command{
    public Head() {
        super("head", "Выводит первый элемент коллекции");
    }
    @Override
    public void execute() {
        System.out.println(ArrayDequeManager.getArrayDeque().getFirst().toString());
    }
}
