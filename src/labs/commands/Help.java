package labs.commands;

import java.util.Collection;
import java.util.Iterator;

public class Help extends Command{
    private final Collection<Executable> commands;
    public Help(Collection<Executable> commands) {
        super("help", "Выводит справку по доступным командам");
        this.commands = commands;
    }
    @Override
    public void execute() {
        Iterator<Executable> iterator = commands.iterator();
        Executable temp;
        while(iterator.hasNext()) {
            temp = iterator.next();
            if(temp instanceof Command)
                System.out.println(((Command)iterator.next()).describe());
        }
    }
}
