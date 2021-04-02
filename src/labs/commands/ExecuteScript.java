package labs.commands;

import labs.util.ArgumentParser;

import java.io.IOException;

public class ExecuteScript extends Command{
    public ExecuteScript() {
        super("execute_script", "Считывает и исполняет скрипт из файла");
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
                Invoker.activate(ArgumentParser.getArgument());
            }
        }
    }
}
