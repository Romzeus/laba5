package labs.commands;

/**
 * Class for exit command
 * @author Romzeus
 */
public class Exit extends Command{
    public Exit() {
        super("exit", "Завершает работу программы (без сохранения)");
    }
    @Override
    public void execute() {
        System.exit(0);
    }
}
