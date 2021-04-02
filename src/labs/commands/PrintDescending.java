package labs.commands;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import java.util.Arrays;

public class PrintDescending extends Command{
    public PrintDescending() {
        super("print_descending", "Выводит элементы коллекции в порядке убывания");
    }
    @Override
    public void execute() {
        Route[] routes = ArrayDequeManager.getArrayDeque().toArray(new Route[0]);
        Arrays.sort(routes);
        for(int i = routes.length - 1; i >= 0; i--) {
            System.out.println(routes[i]);
        }
    }
}
