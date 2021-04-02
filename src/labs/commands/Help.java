package labs.commands;

public class Help extends Command{
    public Help() {
        super("help", "Выводит справку по доступным командам");
    }
    @Override
    public void execute() {
        for(Command command : Invoker.getCommands().values())
            System.out.println(command.describe());
    }
}
