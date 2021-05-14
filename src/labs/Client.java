package labs;
import labs.commands.*;
import labs.util.ArgumentParser;
import labs.util.ArrayDequeLoader;
import labs.util.io.*;
import labs.util.locale.RussianLocalization;

public class Client {
    public static void main(String[] args) {
        ConsoleScanner consoleScanner = new ConsoleScanner();
        TranslatorPrinter consolePrinter = new TranslatorPrinter(new ConsolePrinter(), new RussianLocalization());
        Invoker invoker = new Invoker();
        ArgumentParser argumentParser = new ArgumentParser(consoleScanner);
        invoker.addCommand("exit", new Exit());
        invoker.addCommand("add", new Add(argumentParser));
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("show", new Show(consolePrinter));
        invoker.addCommand("print_descending", new PrintDescending(consolePrinter));
        invoker.addCommand("remove_by_id", new RemoveId(argumentParser, consolePrinter));
        invoker.addCommand("head", new Head(consolePrinter));
        invoker.addCommand("history", new History(consolePrinter));
        invoker.addCommand("execute_script", new ExecuteScript(invoker, argumentParser, consolePrinter));
        invoker.addCommand("info", new Info(consolePrinter));
        invoker.addCommand("remove_lower", new RemoveLower(argumentParser));
        invoker.addCommand("filter_starts_with_name", new StartsWith(argumentParser, consolePrinter));
        invoker.addCommand("filter_less_than_distance", new FilterDistance(argumentParser, consolePrinter));
        invoker.addCommand("update", new UpdateId(argumentParser, consolePrinter));
        FilePrinter filePrinter = new FilePrinter(consolePrinter, System.getenv("SERIALIZED_COLLECTION").replace("\\", "\\\\"));
        invoker.addCommand("help", new Help(invoker.getCommands().values(), consolePrinter));
        ArrayDequeLoader.setPrinter(consolePrinter);
        ArrayDequeLoader.load();
        while(true) {
            try {
                invoker.activate(argumentParser.getArgument());
            } catch(IllegalArgumentException exception) {
                consolePrinter.print("Incorrect command");
            }
        }
    }
}
