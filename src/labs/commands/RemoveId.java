package labs.commands;

import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;

/**
 * Class of remove_by_id command
 * @author Romzeus
 */
public class RemoveId extends Command{
    protected final ArgumentProvider<String> argumentProvider;
    protected final Printer printer;

    /**
     * Constructor of RemoveId object
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments
     * @param printer Object of Printer interface
     */
    public RemoveId(ArgumentProvider<String> argumentProvider, Printer printer) {
        super("remove_by_id", "remove_by_id_description");
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        int id;
        try {
        id = Integer.parseInt(argumentProvider.getArgument());
        } catch(NullPointerException|NumberFormatException exception) {
            printer.print("Wrong_id_format");
            return;
        }
        try {
        ArrayDequeManager.delete(id);
        } catch(IllegalArgumentException exception) {
            printer.print("No_id");
        }
    }
}
