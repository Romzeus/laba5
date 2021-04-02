package labs.commands;
import labs.util.ArrayDequeManager;

public class Clear extends Command{
    public Clear() {
        super("clear", "Удаляет все элементы коллекции");
    }
    @Override
    public void execute() {
        ArrayDequeManager.clear();
    }
}
