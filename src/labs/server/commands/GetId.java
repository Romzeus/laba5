package labs.server.commands;

import labs.commands.Executable;
import labs.server.Sender;
import labs.util.IdGenerator;

public class GetId implements Executable {
    @Override
    public void execute() {
        Sender.print(Integer.toString(IdGenerator.getId()));
    }
}
