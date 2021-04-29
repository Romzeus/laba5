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
    private ArgumentProvider argumentProvider;

    /**
     * Constructor of Add class
     * @param argumentProvider Object of ArgumentProvider interface, which will provide arguments for creating Route object
     */
    public Add(ArgumentProvider argumentProvider) {
        super("add", "Добавляет в коллекцию новый объект");
        this.argumentProvider = argumentProvider;
    }
    @Override
    public void execute() {
        ArrayDequeManager.addElement(new RouteMaker(argumentProvider, new ConsolePrinter()).make());
    }
}
