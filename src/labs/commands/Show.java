package labs.commands;
import labs.structures.Route;
import labs.util.ArrayDequeManager;

public class Show extends Command{
    public Show() {
        super("show", "Выводит элементы коллекции в строковом представлении");
    }
    @Override
    public void execute() {
        try {
            for (Route route : ArrayDequeManager.getArrayDeque()) {
                System.out.println(route.toString());
            }
        } catch(NullPointerException e) {
            System.err.println(e.toString());
        }
    }
}
