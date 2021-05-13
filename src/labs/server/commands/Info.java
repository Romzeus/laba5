package labs.server.commands;

import labs.commands.Executable;
import labs.server.Sender;

public class Info implements Executable {
    private final labs.commands.Info info = new labs.commands.Info(Sender::print);
    @Override
    public void execute() {
        info.execute();
    }
}
