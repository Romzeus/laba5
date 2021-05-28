package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Sender;
import labs.util.IdGenerator;

public class GetId implements Executable {
    @Override
    public void execute() {
        Sender.print(Integer.toString(IdGenerator.getId()));
    }
}
