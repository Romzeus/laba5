package labs.commands;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;

public class Add extends Command{
    public Add() {
        super("add", "Добавляет в коллекцию новый объект");
    }
    @Override
    public void execute() {
        ArrayDequeManager.addElement(new RouteMaker().make());
    }
}
