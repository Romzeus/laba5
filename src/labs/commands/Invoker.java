package labs.commands;
import java.util.HashMap;
import java.util.Map;
import labs.util.ActionLogger;
import labs.util.io.Printer;
import labs.util.io.Scanner;

public class Invoker {
    private final Printer logger;
    private final Scanner scanner;
    private static final HashMap<String, Executable> commands;
    public Invoker(Printer logger, Scanner scanner) {
        this.logger = logger;
        this.scanner = scanner;
    }
    public static void activate(String commandName) {
        if (commands.containsKey(commandName)){
            commands.get(commandName).execute();
            ActionLogger.log(commandName);
        }
        else
            throw new IllegalArgumentException();
    }
    public static Map<String, Executable> getCommands() {
        return commands;
    }
    static {
        commands = new HashMap<>();
        commands.put("exit", new Exit());
        commands.put("add", new Add());
        commands.put("clear", new Clear());
        commands.put("show", new Show());
        commands.put("print_descending", new PrintDescending());
        commands.put("save", new Save());
        commands.put("help", new Help());
        commands.put("remove_by_id", new RemoveId());
        commands.put("head", new Head());
        commands.put("history", new History());
        commands.put("execute_script", new ExecuteScript());
        commands.put("info", new Info());
        commands.put("remove_lower", new RemoveLower());
        commands.put("filter_starts_with_name", new StartsWith());
        commands.put("filter_less_than_distance", new FilterDistance());
    }
}
