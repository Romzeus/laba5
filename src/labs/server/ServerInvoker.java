package labs.server;

import labs.commands.Executable;
import labs.commands.Executor;
import labs.tokens.ServerToken;
import java.util.HashMap;

public class ServerInvoker implements Executor {
    private final HashMap<String, Executable> commands = new HashMap<>();
    @Override
    public void activate(String commandName) {
        if (commands.containsKey(commandName)){
            commands.get(commandName).execute();
        }
        else
            throw new IllegalArgumentException();
    }
    public void activate(ServerToken token) {
        this.activate(token.toString());
    }
    public void addCommand(String name, Executable executable) {
        commands.put(name, executable);
    }
}
