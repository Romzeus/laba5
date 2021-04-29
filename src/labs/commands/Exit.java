package labs.commands;

/**
 * Class for exit command
 * @author Romzeus
 */
public class Exit extends Command{
    public Exit() {
        super("exit", "exit description");
    }
    @Override
    public void execute() {
        System.exit(0);
    }
}
