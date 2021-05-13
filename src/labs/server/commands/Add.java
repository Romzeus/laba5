package labs.server.commands;

import labs.commands.Executable;
import labs.structures.Route;
import labs.util.ArgumentProvider;
import labs.util.ArrayDequeManager;

public class Add implements Executable {
    private final ArgumentProvider<Object> provider;
    public Add(ArgumentProvider<Object> provider) {
        this.provider = provider;
    }
    @Override
    public void execute() {
        ArrayDequeManager.addElement((Route) provider.getArgument());
    }
}
