package labs.commands;
import labs.structures.Route;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

import java.util.Arrays;

public class PrintDescending extends Command{
    private Printer printer;
    public PrintDescending(Printer printer) {
        super("print_descending", "Выводит элементы коллекции в порядке убывания");
        this.printer = printer;
    }
    @Override
    public void execute() {
        Route[] routes = ArrayDequeManager.getArrayDeque().toArray(new Route[0]);
        Arrays.sort(routes);
        for(int i = routes.length - 1; i >= 0; i--) {
            printer.print(routes[i].toString());
        }
    }
}
