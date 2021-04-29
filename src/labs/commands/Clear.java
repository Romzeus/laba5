package labs.commands;
import labs.util.ArrayDequeManager;

/**
 *Class for clear command
 * @author Romzeus
 */
public class Clear extends Command{
    public Clear() {
        super("clear", "clear description");
    }
    @Override
    public void execute() {
        ArrayDequeManager.clear();
    }
}
