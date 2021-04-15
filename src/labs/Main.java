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
        Invoker invoker = new Invoker();
        invoker.addCommand("exit", new Exit());
        invoker.addCommand("add", new Add());
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("show", new Show());
        invoker.addCommand("print_descending", new PrintDescending());
        invoker.addCommand("save", new Save(new FilePrinter(new ConsolePrinter())));
        invoker.addCommand("remove_by_id", new RemoveId());
        invoker.addCommand("head", new Head());
        invoker.addCommand("history", new History());
        invoker.addCommand("execute_script", new ExecuteScript());
        invoker.addCommand("info", new Info());
        invoker.addCommand("remove_lower", new RemoveLower());
        invoker.addCommand("filter_starts_with_name", new StartsWith());
        invoker.addCommand("filter_less_than_distance", new FilterDistance());
        invoker.addCommand("help", new Help(invoker.getCommands().values()));
        ConsoleScanner consoleScanner = new ConsoleScanner();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        FilePrinter filePrinter = new FilePrinter(consolePrinter);
        int flag = 0;
        while(flag == 0) {
            consolePrinter.print("Введите название переменной среды: ");
            flag = 1;
            try {
                filePrinter.changeFile(System.getenv(consoleScanner.scan().toUpperCase()).replace("\\", "\\\\"));
            } catch(IOException exception) {
                consolePrinter.print(exception.getMessage());
                flag = 0;
            }
        }
        ArrayDequeLoader.load();
        while(true) {
            ArgumentParser.parse();
            try {
                invoker.activate(ArgumentParser.getArgument());
            } catch(IllegalArgumentException exception) {
                System.out.println("Некорректная команда");
            }
        }
    }
}
