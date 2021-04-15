package labs.commands;

import labs.util.io.FilePrinter;

import java.io.IOException;

public class Exit extends Command{
    public Exit() {
        super("exit", "Завершает работу программы (без сохранения)");
    }
    @Override
    public void execute() {
        System.exit(0);
    }
}
