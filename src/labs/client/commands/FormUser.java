package labs.client.commands;

import labs.commands.Executable;
import labs.send.ServerMessage;
import labs.structures.User;
import labs.util.ArgumentProvider;
import labs.util.io.Printer;
import labs.util.serial.Serializer;

public class FormUser implements Executable {
    private final Printer serverSender;
    private final Printer printer;
    private final ArgumentProvider<String> provider;
    public FormUser(ArgumentProvider<String> provider, Printer printer, Printer server) {
        this.printer = printer;
        this.provider = provider;
        this.serverSender = server;
    }
    @Override
    public void execute() {
        printer.print("Enter login");
        String name = provider.getArgument();
        printer.print("Enter password");
        String password = provider.getArgument();
        User user = new User(name, password);
        serverSender.print(Serializer.serialize(new ServerMessage().setServerToken("check_user").setUser(user)));
    }
}
