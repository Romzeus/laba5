package labs.commands;
import java.util.HashMap;
import java.util.Map;
import labs.util.ActionLogger;

/**
 * Class of invoker
 * @author Romzeus
 */
public class Invoker implements Executor{
    private final HashMap<String, Executable> commands = new HashMap<>();

    /**
     *Method for activating executable command
     * @param commandName Name of executable command
     */
    public void activate(String commandName) {
        if (commands.containsKey(commandName)){
            commands.get(commandName).execute();
            ActionLogger.log(commandName);
        }
        else
            throw new IllegalArgumentException();
    }

    /**
     *Method for adding new commands
     * @param name Name of command
     * @param executable object of command
     */
    public void addCommand(String name, Executable executable) {
        commands.put(name, executable);
    }

    /**
     * Method, returning map of commands and their names
     * @return map with name-command pairs
     */
    public Map<String, Executable> getCommands() {
        return commands;
    }
}
