package labs;
import labs.commands.*;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeLoader;
import labs.util.io.ConsolePrinter;
import labs.util.io.ConsoleScanner;
import labs.util.io.FilePrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConsoleScanner consoleScanner = new ConsoleScanner();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Invoker invoker = new Invoker();
        invoker.addCommand("exit", new Exit());
        invoker.addCommand("add", new Add());
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("show", new Show(consolePrinter));
        invoker.addCommand("print_descending", new PrintDescending());
        invoker.addCommand("remove_by_id", new RemoveId());
        invoker.addCommand("head", new Head());
        invoker.addCommand("history", new History());
        invoker.addCommand("execute_script", new ExecuteScript(invoker));
        invoker.addCommand("info", new Info());
        invoker.addCommand("remove_lower", new RemoveLower());
        invoker.addCommand("filter_starts_with_name", new StartsWith(consolePrinter));
        invoker.addCommand("filter_less_than_distance", new FilterDistance());
        ArgumentParser.setScanner(consoleScanner);
        ArgumentParser.setPrinter(consolePrinter);
        FilePrinter filePrinter = new FilePrinter(consolePrinter, System.getenv("SERIALIZED_COLLECTION").replace("\\", "\\\\"));
        invoker.addCommand("save", new Save(filePrinter));
        invoker.addCommand("help", new Help(invoker.getCommands().values()));
        ArrayDequeLoader.setPrinter(consolePrinter);
        ArrayDequeLoader.load();
        while(true) {
            ArgumentParser.prepare();
            try {
                invoker.activate(ArgumentParser.getArgument());
            } catch(IllegalArgumentException exception) {
                System.out.println("Некорректная команда");
            }
        }
    }
}
