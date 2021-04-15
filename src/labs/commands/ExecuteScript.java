package labs.commands;

import labs.util.ArgumentParser;

import java.io.IOException;

public class ExecuteScript extends Command{
    private final Invoker invoker;
    public ExecuteScript(Invoker invoker) {
        super("execute_script", "Считывает и исполняет скрипт из файла");
        this.invoker = invoker;
    }
    @Override
    public void execute() {
        try {
            String filepath = ArgumentParser.getArgument();
            ArgumentParser.parseFile(filepath);
        } catch(IOException e) {
            System.out.println(e.toString());
            ArgumentParser.clear();
        } finally {
            while(ArgumentParser.hasNext()) {
                invoker.activate(ArgumentParser.getArgument());
            }
        }
    }
}
