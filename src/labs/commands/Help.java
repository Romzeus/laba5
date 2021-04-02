package labs.commands;

public class Help extends Command{
    public Help() {
        super("help", "Выводит справку по доступным командам");
    }
    @Override
    public void execute() {
        for(Executable command : Invoker.getCommands().values())
            if(command instanceof Command)
                System.out.println(((Command)command).describe());
    }
}
