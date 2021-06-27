package labs.server.commands;

import labs.commands.Executable;
import labs.util.io.Printer;
import labs.util.io.Sender;
import labs.util.ArgumentParser;
import labs.util.ArgumentProvider;
import labs.util.io.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;

public class RemoveId implements Executable {
    private final ArgumentProvider<Object> argumentProvider;
    private final labs.commands.RemoveId removeId;
    private final ArgumentParser provider = new ArgumentParser(new Scanner() {
        @Override
        public String scan() {
            return null;
        }
    });
    public RemoveId(ArgumentProvider<Object> argumentProvider, Printer printer) {
        this.argumentProvider = argumentProvider;
        removeId = new labs.commands.RemoveId(provider, printer);
    }
    @Override
    public void execute() {
        provider.addArguments(new ArrayDeque<String>(Arrays.asList(argumentProvider.getArgument().toString())));
        removeId.execute();
        provider.clear();
    }
}
