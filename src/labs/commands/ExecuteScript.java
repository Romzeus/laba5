package labs.commands;

import labs.exceptions.Recursion;
import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.io.FileScanner;
import labs.util.io.Printer;
import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * Class for execute_script command
 * @author Romzeus
 */
public class ExecuteScript extends Command{
    private final Stack<String> executing = new Stack<>();
    private final Executor invoker;
    private final ArgumentProvider<String> argumentProvider;
    private ArgumentProvider<String> fileArgument;
    private final Printer printer;

    /**
     * Constructor for ExecuteScript object
     * @param executor Instance of executor interface, that will call commands written in file
     * @param argumentProvider Instance of ArgumentProvider interface, which will provide path to the script file
     * @param printer Instance of Printer interface for output of possible exceptions
     */
    public ExecuteScript(Executor executor, ArgumentProvider<String> argumentProvider, Printer printer) {
        super("execute_script", "execute_script_description");
        this.invoker = executor;
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        try {
            String filepath = argumentProvider.getArgument();
            if(executing.contains(filepath)){
                executing.clear();
                throw new Recursion();
            } else
                executing.push(filepath);
            FileScanner fileScanner = new FileScanner(filepath);
            fileArgument = new ArgumentParser(fileScanner);
        } catch(FileNotFoundException exception) {
            printer.print("File not found");
        }
        try{
            argumentProvider.addArguments(fileArgument.getAll());
            while(argumentProvider.hasNext())
                invoker.activate(argumentProvider.getArgument());
        } catch (NullPointerException|IllegalArgumentException exception) {
            if(exception instanceof NullPointerException)
                printer.print("Empty file");
            else printer.print("Incorrect command");
        }
        executing.pop();
    }
}
