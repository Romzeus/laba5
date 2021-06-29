package labs.commands;

import labs.util.ActionLogger;
import labs.util.io.Printer;
import java.util.Iterator;

/**
 * Class of history command
 * @author Romzeus
 */
public class History extends Command{
    private final Printer printer;

    /**
     * Constructor of History object
     * @param printer Object of Printer interface
     */
    public History(Printer printer) {
        super("history", "history_description");
        this.printer = printer;
    }
    @Override
    public void execute() {
        Iterator<String> iterator = ActionLogger.getHistory().descendingIterator();
        while(iterator.hasNext()) {
            printer.print(iterator.next());
        }
    }
}
