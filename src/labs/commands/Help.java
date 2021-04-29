package labs.commands;

import labs.util.io.Printer;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class of help command
 * @author Romzeus
 */
public class Help implements Executable{
    private final Collection<Executable> commands;
    private Printer printer;

    /**
     * Constructor of Help object
     * @param commands Collection of commands, provided by invoker class
     * @param printer Object of Printer interface
     */
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
