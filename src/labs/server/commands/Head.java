package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Sender;
import labs.structures.Route;
import labs.util.ArrayDequeManager;

public class Head implements Executable {
    @Override
    public void execute() {
        Route head = ArrayDequeManager.getArrayDeque().peek();
        String message;
        if(head != null)
            message = head.toString();
        else
            message = "No elements";
        Sender.print(message);
    }
}
