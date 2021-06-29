package labs.server;

import labs.server.commands.*;
import labs.util.io.*;
import java.io.IOException;
import java.net.Socket;


public class ServerApp {
    private Socket socket;
    private ServerPrinter printer;
    private final ServerInvoker invoker = new ServerInvoker();
    private ObjectProvider provider;
    public ServerApp(Socket socket) {
        this.socket = socket;
    }
    private void initIO() throws IOException {
        printer = new ServerPrinter(socket);
        provider = new ObjectProvider(new ServerScanner(socket));
    }
    private void initCommands() {
        invoker.addCommand("add", new Add(provider));
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("filter_less_than_distance", new FilterDistance(provider, printer));
        invoker.addCommand("get_id", new GetId(printer));
        invoker.addCommand("head", new Head(printer));
        invoker.addCommand("info", new Info(printer));
        invoker.addCommand("print_descending", new PrintDescending(printer));
        invoker.addCommand("remove", new RemoveId(provider, printer));
        invoker.addCommand("remove_lower", new RemoveLower(provider));
        invoker.addCommand("show", new Show(printer));
        invoker.addCommand("filter_starts_with_name", new StartsWith(provider, printer));
        invoker.addCommand("update", new UpdateId(provider));
    }
    public void run() {
        try {
            initIO();
        } catch(IOException exception) {
            socket = null;
        }
        initCommands();
        if(socket != null) {
            while(true) {
                try {
                    String command = (String)provider.getArgument();
                    System.out.println(command);
                    invoker.activate(command);
                } catch(NullPointerException exception) {
                    Sender.print("Incorrect_command");
                }
            }
        }
    }
}
