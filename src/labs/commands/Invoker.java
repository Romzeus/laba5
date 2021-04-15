package labs.commands;
import java.util.HashMap;
import java.util.Map;
import labs.util.ActionLogger;

public class Invoker {
    private HashMap<String, Executable> commands = new HashMap<>();
    public void activate(String commandName) {
        if (commands.containsKey(commandName)){
            commands.get(commandName).execute();
            ActionLogger.log(commandName);
        }
        else
            throw new IllegalArgumentException();
    }
    public void addCommand(String name, Executable executable) {
        commands.put(name, executable);
    }
    public Map<String, Executable> getCommands() {
        return commands;
    }
}
