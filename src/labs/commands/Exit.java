package labs.commands;

public class Exit extends Command{
    public Exit() {
        super("exit", "Завершает работу программы (без сохранения)");
    }
    @Override
    public void execute() {
        System.exit(0);
    }
}
