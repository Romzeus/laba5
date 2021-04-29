package labs.commands;

import labs.util.ArgumentProvider;
import labs.util.FileArgumentParser;
import labs.util.io.ConsolePrinter;
import labs.util.io.FileScanner;
import java.io.IOException;

public class ExecuteScript extends Command{
    private final Executor invoker;
    private ArgumentProvider argumentProvider;
    public ExecuteScript(Executor executor) {
        super("execute_script", "Считывает и исполняет скрипт из файла");
        this.invoker = executor;
    }
    @Override
    public void execute() {
        try {
            String filepath = argumentProvider.getArgument();
            FileScanner fileScanner = new FileScanner(filepath);
            argumentProvider = new FileArgumentParser(new ConsolePrinter(), fileScanner);
        } catch(IOException e) {
            System.out.println(e.toString());
        } finally {
            while(argumentProvider.hasNext()) {
                invoker.activate(argumentProvider.getArgument());
            }
        }
    }
}
