package labs.commands;

import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.io.FileScanner;
import labs.util.io.Printer;
import java.io.FileNotFoundException;

/**
 * Class for execute_script command
 * @author Romzeus
 */
public class ExecuteScript extends Command{
    private final Executor invoker;
    private final ArgumentProvider argumentProvider;
    private ArgumentProvider fileArgument;
    private final Printer printer;

    /**
     * Constructor for ExecuteScript object
     * @param executor Instance of executor interface, that will call commands written in file
     * @param argumentProvider Instance of ArgumentProvider interface, which will provide path to the script file
     * @param printer Instance of Printer interface for output of possible exceptions
     */
    public ExecuteScript(Executor executor, ArgumentProvider argumentProvider, Printer printer) {
        super("execute_script", "execute_script description");
        this.invoker = executor;
        this.argumentProvider = argumentProvider;
        this.printer = printer;
    }
    @Override
    public void execute() {
        try {
            String filepath = argumentProvider.getArgument();
            FileScanner fileScanner = new FileScanner(filepath);
            fileArgument = new ArgumentParser(fileScanner);
        } catch(FileNotFoundException exception) {
            printer.print("File not found");
        }
        try{
            argumentProvider.addArguments(fileArgument.getAll());
            while(argumentProvider.hasNext())
                invoker.activate(argumentProvider.getArgument());
        } catch (NullPointerException exception) {
            printer.print("Empty file");
        }
    }
}
