package labs.commands;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;
import labs.util.creator.RouteMaker;
import labs.util.io.ConsolePrinter;

public class Add extends Command{
    private ArgumentProvider argumentProvider;
    public Add(ArgumentProvider argumentProvider) {
        super("add", "Добавляет в коллекцию новый объект");
        this.argumentProvider = argumentProvider;
    }
    @Override
    public void execute() {
        ArrayDequeManager.addElement(new RouteMaker(argumentProvider, new ConsolePrinter()).make());
    }
}
