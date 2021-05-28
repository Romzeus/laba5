package labs.commands;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;

/**
 * Class for add command
 * @author Romzeus
 */
public class Add extends Command{
    protected final ArgumentProvider<String> argumentProvider;

    /**
     * Constructor of Add class
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments for creating Route object
     */
    public Add(ArgumentProvider<String> argumentProvider) {
        super("add", "add description");
        this.argumentProvider = argumentProvider;
    }
    @Override
    public void execute() {
        ArrayDequeManager.addElement(new RouteMaker(argumentProvider, new ConsolePrinter()).make());
    }
}
