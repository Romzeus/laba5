package labs.server.commands;

import labs.commands.Executable;
import labs.util.ArrayDequeManager;

public class Clear implements Executable {
    @Override
    public void execute() {
        ArrayDequeManager.clear();
    }
}
