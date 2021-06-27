package labs.server;

import labs.server.commands.*;
import labs.util.ArrayDequeLoader;
import labs.util.io.Receiver;
import labs.util.io.Sender;
import labs.util.io.ServerPrinter;
import labs.util.io.ServerScanner;
import java.io.IOException;
import java.net.Socket;


public class ServerApp {
    private Socket socket;
    private final ServerInvoker invoker = new ServerInvoker();
    private final ObjectProvider provider = new ObjectProvider();
    public ServerApp(Socket socket) {
        this.socket = socket;
    }
    private void initIO() throws IOException {
        Sender.setPrinter(new ServerPrinter(socket));
        Receiver.setScanner(new ServerScanner(socket));
    }
    private void initCommands() {
        invoker.addCommand("add", new Add(provider));
        invoker.addCommand("clear", new Clear());
        invoker.addCommand("filter_less_than_distance", new FilterDistance(provider));
        invoker.addCommand("get_id", new GetId());
        invoker.addCommand("head", new Head());
        invoker.addCommand("info", new Info());
        invoker.addCommand("print_descending", new PrintDescending());
        invoker.addCommand("remove", new RemoveId(provider));
        invoker.addCommand("remove_lower", new RemoveLower(provider));
        invoker.addCommand("show", new Show());
        invoker.addCommand("filter_starts_with_name", new StartsWith(provider));
        invoker.addCommand("update", new UpdateId(provider));
    }
    public void run() {
        try {
            initIO();
        } catch(IOException exception) {
            socket = null;
        }
        initCommands();
        Sender.print("Connected!");
        ArrayDequeLoader.setPrinter(Sender::print);
        ArrayDequeLoader.load();
        if(socket != null) {
            while(true) {
                try {
                    String command = (String)provider.getArgument();
                    System.out.println(command);
                    invoker.activate(command);
                } catch(NullPointerException exception) {
                    Sender.print("Incorrect command");
                }
            }
        }
    }
}
