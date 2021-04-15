package labs.commands;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

public class Show extends Command{
    private Printer printer;
    public Show(Printer printer) {
        super("show", "Выводит элементы коллекции в строковом представлении");
        this.printer = printer;
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
