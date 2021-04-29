package labs.commands;

import labs.util.io.Printer;

import java.util.Collection;
import java.util.Iterator;

public class Help implements Executable{
    private final Collection<Executable> commands;
    private Printer printer;
    public Help(Collection<Executable> commands, Printer printer) {
        this.commands = commands;
        this.printer = printer;
    }
    @Override
    public void execute() {
        Iterator<Executable> iterator = commands.iterator();
        Executable temp;
        while(iterator.hasNext()) {
            temp = iterator.next();
            if (temp instanceof Command){
                printer.print(((Command)temp).describe());
            }
        }
    }
}
