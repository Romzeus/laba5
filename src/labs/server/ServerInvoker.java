package labs.server;

import labs.commands.Executable;
import labs.commands.Executor;
import java.util.HashMap;

public class ServerInvoker implements Executor {
    private final HashMap<String, Executable> commands = new HashMap<>();
    @Override
    public void activate(String commandName) {
        commands.get(commandName).execute();
    }
    public void addCommand(String name, Executable executable) {
        commands.put(name, executable);
    }
}
