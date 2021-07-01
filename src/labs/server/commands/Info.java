package labs.server.commands;

import labs.commands.Executable;
import labs.send.ClientMessage;
import labs.util.ArrayDequeLoader;
import labs.util.ArrayDequeManager;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class Info implements Executable {
    private final Printer printer;
    public Info(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void execute() {
        String result = "";
        result += ("Collection_type " + ArrayDequeManager.getArrayDeque().getClass().getName() + "\n");
        result += ("Element_type " + (ArrayDequeManager.getArrayDeque().isEmpty() ? "No_elements" : ArrayDequeManager.getArrayDeque().element().getClass().getName()) + "\n");
        result += ("Initialization_time " + ArrayDequeLoader.getInitTime().toString() + "\n");
        String[][] placeholder = {{" ", " ", " ", " ", " ", " ", " ", " "}};
        printer.print(Serializer.serialize(new ClientMessage(true, placeholder).setMessage(result)));
    }
}
